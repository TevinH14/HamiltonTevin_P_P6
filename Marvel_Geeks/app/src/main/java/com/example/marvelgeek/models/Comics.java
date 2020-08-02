package com.example.marvelgeek.models;

public class Comics extends Marvel{
    private String mComicUrl;
    private String mSeriesUri;
    private String mSeriesName;
    private double mPrice;
    private int mIssueNum;

    private String mCreatorsUri;
    private String mCharacterUri;
    private String mStoriesUri;
    private String mEventUri;

    private int mAvailableCreators;
    private int mAvailableCharacters;
    private int mAvailableStories;
    private int mAvailableEvents;


    public Comics(int mId, String mName, String mDescription, String mImageUrl, String mComicUrl,
                  String mSeriesUri, String mSeriesName, double mPrice, int mIssueNum,
                  String mCreatorsUri, String mCharacterUri, String mStoriesUri, String mEventUri,
                  int mAvailableCreators, int mAvailableCharacters, int mAvailableStories,
                  int mAvailableEvents) {

        super(mId, mName, mDescription, mImageUrl);
        this.mComicUrl = mComicUrl;
        this.mSeriesUri = mSeriesUri;
        this.mSeriesName = mSeriesName;
        this.mPrice = mPrice;
        this.mIssueNum = mIssueNum;
        this.mCreatorsUri = mCreatorsUri;
        this.mCharacterUri = mCharacterUri;
        this.mStoriesUri = mStoriesUri;
        this.mEventUri = mEventUri;
        this.mAvailableCreators = mAvailableCreators;
        this.mAvailableCharacters = mAvailableCharacters;
        this.mAvailableStories = mAvailableStories;
        this.mAvailableEvents = mAvailableEvents;
    }

    public String getComicUrl() {
        return mComicUrl;
    }

    public String getSeriesUri() {
        return mSeriesUri;
    }

    public String getSeriesName() {
        return mSeriesName;
    }

    public double getPrice() {
        return mPrice;
    }

    public int getIssueNum() {
        return mIssueNum;
    }

    public String getCreatorsUri() {
        return mCreatorsUri;
    }

    public String getCharacterUri() {
        return mCharacterUri;
    }

    public String getStoriesUri() {
        return mStoriesUri;
    }

    public String getEventUri() {
        return mEventUri;
    }

    public int getAvailableCreators() {
        return mAvailableCreators;
    }

    public int getAvailableCharacters() {
        return mAvailableCharacters;
    }

    public int getAvailableStories() {
        return mAvailableStories;
    }

    public int getAvailableEvents() {
        return mAvailableEvents;
    }


}
