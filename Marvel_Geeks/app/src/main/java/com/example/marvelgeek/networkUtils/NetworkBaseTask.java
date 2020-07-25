package com.example.marvelgeek.networkUtils;

import android.os.AsyncTask;


import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Comics;
import com.example.marvelgeek.models.Marvel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkBaseTask extends AsyncTask<Integer, Integer, ArrayList<Marvel>> {

    final private OnFinished mOnFinishedInterface;

    public NetworkBaseTask(OnFinished mOnFinishedInterface) {
        this.mOnFinishedInterface = mOnFinishedInterface;
    }

    //create a interface to pass and retrieve data to Network Task to download JSON obj
    public interface OnFinished{
        void OnPost(ArrayList<Marvel> marvelArrayList);
    }

    @Override
    protected ArrayList<Marvel> doInBackground(Integer... integers) {
        ArrayList<Marvel> marvelArrayList = null;
        if(integers == null || integers.length <= 0){
            return null;
        }
        String data = null;
        try {
            data = NetworkUtils.getMarvelBaseData(integers[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(data != null) {
            if(integers[0] ==0){
                marvelArrayList = getCharacterData(data);
            }
            else if(integers[0] == 1){
                marvelArrayList = getComicData(data);
            }
            else if(integers[0] == 2){
                marvelArrayList = getCreatorsData(data);
            }
            else if(integers[0] == 3){
                marvelArrayList = getEventData(data);
            }
            else if(integers[0] == 4){
                marvelArrayList = getSeriesData(data);
            }
            else if(integers[0] == 5){
                marvelArrayList = getStoriesData(data);
            }
            return marvelArrayList;
        }

        return null;
    }
    @Override
    protected void onPostExecute(ArrayList<Marvel> characterData) {
        mOnFinishedInterface.OnPost(characterData);
    }

    private ArrayList<Marvel> getCharacterData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

                String charaComicsUri = "";
                JSONObject charaComics = obj.getJSONObject("comics");
                int availableComics = charaComics.getInt("available");
                if(availableComics > 0){
                     charaComicsUri = charaComics.getString("collectionURI");
                }

                String charaSeriesUri = "";
                JSONObject charaSeries = obj.getJSONObject("series");
                int availableSeries = charaSeries.getInt("available");
                if(availableSeries > 0){
                     charaSeriesUri = charaSeries.getString("collectionURI");
                }

                String charaStoriesUri = "";
                JSONObject charaStories = obj.getJSONObject("stories");
                int availableStories = charaStories.getInt("available");
                if(availableStories > 0) {
                     charaStoriesUri = charaStories.getString("collectionURI");
                }

                String charaEventUri ="";
                JSONObject charaEvents = obj.getJSONObject("events");
                int availableEvents = charaEvents.getInt("available");
                if(availableEvents > 0){
                     charaEventUri = charaEvents.getString("collectionURI");
                }


                charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url,
                        availableComics,availableSeries,availableStories,availableEvents,
                        charaComicsUri,charaSeriesUri,charaStoriesUri,charaEventUri));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Marvel> getComicData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

                //charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private  ArrayList<Marvel> getCreatorsData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

               // charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private  ArrayList<Marvel> getEventData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

              //  charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private  ArrayList<Marvel> getStoriesData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

              //  charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private  ArrayList<Marvel> getSeriesData(String data){
        try {

            JSONObject response = new JSONObject(data);

            JSONObject dataJson = response.getJSONObject("data");
            JSONArray resultJSONArray = dataJson.getJSONArray("results");

            ArrayList<Marvel> charactersArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("name");
                String charaDescription = obj.getString("description");
                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String url = thumbnailObj.getString("path");

                //charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
            }
            // Update the UI
            return charactersArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
