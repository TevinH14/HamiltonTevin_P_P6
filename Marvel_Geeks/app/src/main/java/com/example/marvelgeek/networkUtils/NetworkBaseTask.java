package com.example.marvelgeek.networkUtils;

import android.os.AsyncTask;


import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Comics;
import com.example.marvelgeek.models.Creators;
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
                String urlImage = thumbnailObj.getString("path");

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
                String[] urlTypeArray = new String[2];
                String[] urlLinkArray = new String[2];
                JSONArray urlArrayObj = obj.getJSONArray("urls");
                for (int j = 0; j < urlArrayObj.length(); j++) {
                    JSONObject urlObject = urlArrayObj.getJSONObject(j);
                    String linkType = urlObject.getString("type");
                    String urlLink = urlObject.getString("url");
                    if(linkType.matches("detail") || linkType.matches("wiki")){
                        urlTypeArray[j] = linkType;
                        urlLinkArray[j] = urlLink;
                    }
                }


                charactersArrayList.add(new Characters(charaId, charaName, charaDescription,
                        urlImage,availableComics,availableSeries,availableStories,availableEvents,
                        charaComicsUri,charaSeriesUri,charaStoriesUri,charaEventUri,urlTypeArray,urlLinkArray));
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

            ArrayList<Marvel> marvelArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int id = obj.getInt("id");
                String title = obj.getString("title");
                int issueNum = obj.getInt("issueNumber");
                String description = obj.getString("description");

                JSONArray urlArray = obj.getJSONArray("urls");
                JSONObject urlObj = urlArray.getJSONObject(0);
                String comicUrl = urlObj.getString("url");

                JSONObject seriesObj = obj.getJSONObject("series");
                String seriesUri = seriesObj.getString("resourceURI");
                String seriesName = seriesObj.getString("name");

                JSONArray priceArray = obj.getJSONArray("prices");
                JSONObject priceObj = priceArray.getJSONObject(0);
                double prices = priceObj.getDouble("price");


                JSONObject thumbnailObj = obj.getJSONObject("thumbnail");
                String urlImage = thumbnailObj.getString("path");

                String creatorsUri = "";
                JSONObject creatorsObj = obj.getJSONObject("creators");
                int availableCreators = creatorsObj.getInt("available");
                if(availableCreators > 0){
                    creatorsUri = creatorsObj.getString("collectionURI");
                }

                String charactersUri = "";
                JSONObject charactersObj = obj.getJSONObject("characters");
                int availableCharacters = charactersObj.getInt("available");
                if(availableCharacters > 0){
                    charactersUri = charactersObj.getString("collectionURI");
                }

                String storiesUri = "";
                JSONObject storiesObj = obj.getJSONObject("stories");
                int availableStories = storiesObj.getInt("available");
                if(availableStories > 0) {
                    storiesUri = storiesObj.getString("collectionURI");
                }

                String eventUri ="";
                JSONObject eventsObj = obj.getJSONObject("events");
                int availableEvents = eventsObj.getInt("available");
                if(availableEvents > 0){
                    eventUri = eventsObj.getString("collectionURI");
                }

                marvelArrayList.add(new Comics(id, title, description,urlImage,comicUrl,
                        seriesUri,seriesName,prices,issueNum,creatorsUri,charactersUri,storiesUri,
                        eventUri));
            }
            // Update the UI
            return marvelArrayList;

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

            ArrayList<Marvel> marvelArrayList = new ArrayList<>();

            for (int i = 0; i < resultJSONArray.length(); i++) {
                JSONObject obj = resultJSONArray.getJSONObject(i);
                int charaId = obj.getInt("id");

                String charaName = obj.getString("fullName");

                String comicsUri = "";
                JSONObject comicsObj = obj.getJSONObject("comics");
                int availableComics = comicsObj.getInt("available");


                JSONArray urlArrayObj = obj.getJSONArray("urls");
                JSONObject urlObj = urlArrayObj.getJSONObject(0);
                String marvelUrl = urlObj.getString("url");

                marvelArrayList.add(new Creators(charaId, charaName, null,
                        null,marvelUrl,availableComics));
            }
            // Update the UI
            return marvelArrayList;

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
