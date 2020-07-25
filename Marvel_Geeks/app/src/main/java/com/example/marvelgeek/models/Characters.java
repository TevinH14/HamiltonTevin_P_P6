package com.example.marvelgeek.models;

import java.io.Serializable;

public class Characters extends Marvel {
    private int mAvailableComics;
    private int mAvailableSeries;
    private int mAvailableStories;
    private int mAvailableEvents;

    private String mComicUri;
    private String mSeriesUri;
    private String mStoriesUri;
    private String mEventUri;

    public Characters(int mId, String mName, String mDescription, String mImageUrl,
                      int mAvailableComics, int mAvailableSeries, int mAvailableStories,
                      int mAvailableEvents, String mComicUri, String mSeriesUri, String mStoriesUri,
                      String mEventUri) {

        super(mId, mName, mDescription, mImageUrl);
        this.mAvailableComics = mAvailableComics;
        this.mAvailableSeries = mAvailableSeries;
        this.mAvailableStories = mAvailableStories;
        this.mAvailableEvents = mAvailableEvents;
        this.mComicUri = mComicUri;
        this.mSeriesUri = mSeriesUri;
        this.mStoriesUri = mStoriesUri;
        this.mEventUri = mEventUri;
    }

    public int getAvailableComics() {
        return mAvailableComics;
    }

    public int getAvailableSeries() {
        return mAvailableSeries;
    }

    public int getAvailableStories() {
        return mAvailableStories;
    }

    public int getAvailableEvents() {
        return mAvailableEvents;
    }

    public String getComicUri() {
        return mComicUri;
    }

    public String getSeriesUri() {
        return mSeriesUri;
    }

    public String getStoriesUri() {
        return mStoriesUri;
    }

    public String getEventUri() {
        return mEventUri;
    }
}
