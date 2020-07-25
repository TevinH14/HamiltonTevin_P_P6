package com.example.marvelgeek.networkUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NetworkUtils {
	private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";
	private static final String PUBLIC_KEY = "c0ab0ec8c52f9426348491889b718c0b";
	private static final String PRIVATE_KEY = "25313ed28bf2fc8bf2de829de356fe2d0b0c25ba";
	private static final String[] MARVEL_ACTIONS = {
			"characters",
			"comics",
			"creators",
			"events",
			"series",
			"stories"};
	
	public static boolean isConnected(Context _context) {
		
		ConnectivityManager mgr = (ConnectivityManager)_context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if(mgr != null) {
			NetworkInfo info = mgr.getActiveNetworkInfo();

			if(info != null) {
				return info.isConnected();
			}
		}

		return false;
	}
	
	public static String getMarvelBaseData(int _actionRequest) {
		String urlString = null;
		String ts = getTimeStamp();
		 urlString = BASE_URL
				+MARVEL_ACTIONS[_actionRequest]
				+"?ts="
				+ts
				+"&apikey="
				+PUBLIC_KEY
				+"&hash="
				+createHash(ts+PRIVATE_KEY+PUBLIC_KEY);

		if(urlString == null){
			return null;
		}

		HttpURLConnection connection = null;
		String data = null;
		URL url;

		try {
			url = new URL(urlString);

			connection = (HttpURLConnection)url.openConnection();

			connection.connect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream is = null;
		try{
			if(connection != null){
				is = connection.getInputStream();
				data = IOUtils.toString(is, "UTF_8");
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			if(connection != null){
				if(is != null){
					try{
						is.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					connection.disconnect();

				}
			}
		}
		
		return data;
	}

	private static String getTimeStamp(){
		String ts;
		long tsLong = System.currentTimeMillis()/1000;
		ts = Long.toString(tsLong);
		return ts;
	}

	private static String createHash(String message){

		String digest = null;


		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8"));
			//converting byte array to Hexadecimal String
			StringBuilder sb = new StringBuilder(2*hash.length);
			for(byte b : hash){
				sb.append(String.format("%02x", b&0xff));
			}
			digest = sb.toString();
		}catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return digest;
	}
}