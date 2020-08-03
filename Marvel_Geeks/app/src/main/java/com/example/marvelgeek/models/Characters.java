package com.example.marvelgeek.models;

public class Characters extends Marvel {
    private final int mAvailableComics;
    private final int mAvailableSeries;
    private final int mAvailableStories;
    private final int mAvailableEvents;

    private final String mComicUri;
    private final String mSeriesUri;
    private final String mStoriesUri;
    private final String mEventUri;

    private final String[] mLinkType;
    private final String[] mLinkUrls;

    public Characters(int mId, String mName, String mDescription, String mImageUrl,
                      int mAvailableComics, int mAvailableSeries, int mAvailableStories,
                      int mAvailableEvents, String mComicUri, String mSeriesUri, String mStoriesUri,
                      String mEventUri,String[] mLinkType,String[] mLinkUrls) {

        super(mId, mName, mDescription, mImageUrl);
        this.mAvailableComics = mAvailableComics;
        this.mAvailableSeries = mAvailableSeries;
        this.mAvailableStories = mAvailableStories;
        this.mAvailableEvents = mAvailableEvents;
        this.mComicUri = mComicUri;
        this.mSeriesUri = mSeriesUri;
        this.mStoriesUri = mStoriesUri;
        this.mEventUri = mEventUri;
        this.mLinkType = mLinkType;
        this.mLinkUrls = mLinkUrls;
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

    public String[] getLinkType() {
        return mLinkType;
    }

    public String[] getLinkUrls() {
        return mLinkUrls;
    }

}
