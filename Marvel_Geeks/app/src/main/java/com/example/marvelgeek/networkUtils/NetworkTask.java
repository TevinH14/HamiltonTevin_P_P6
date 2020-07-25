package com.example.marvelgeek.networkUtils;

import android.os.AsyncTask;


import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Marvel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, Integer, ArrayList<Marvel>> {

    final private OnFinished mOnFinishedInterface;

    public NetworkTask(OnFinished mOnFinishedInterface) {
        this.mOnFinishedInterface = mOnFinishedInterface;
    }

    //create a interface to pass and retrieve data to Network Task to download JSON obj
    public interface OnFinished{
        void OnPost(ArrayList<Marvel> charactersArrayList);
    }

    @Override
    protected ArrayList<Marvel> doInBackground(Integer... integers) {

        if(integers == null || integers.length <= 0){
            return null;
        }
        String data = null;
        try {
            data = NetworkUtils.getNetworkData(integers[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(data != null) {
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

                    charactersArrayList.add(new Characters(charaId, charaName, charaDescription,url));
                }
                // Update the UI
                return charactersArrayList;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    @Override
    protected void onPostExecute(ArrayList<Marvel> characterData) {
        mOnFinishedInterface.OnPost(characterData);
    }
}
