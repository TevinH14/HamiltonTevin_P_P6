package com.example.marvelgeek.models;

public class Events extends Marvel {
    private String mStartDate;
    private String mEndDate;
    private String mMarvelUrl;

    private int mAvailableCreators;
    private int mAvailableCharacter;
    private int mAvailableComic;
    private int mAvailableStories;

    private String mCreatorsUri;
    private String mCharacterUri;
    private String mComicUri;
    private String mStoriesUri;

    public Events(int mId, String mName, String mDescription, String mImageUrl, String mStartDate,
                  String mEndDate, String mMarvelUrl, int mAvailableCreators,
                  int mAvailableCharacter, int mAvailableComic, int mAvailableStories,
                  String mCreatorsUri, String mCharacterUri, String mComicUri, String mStoriesUri){
        super(mId, mName, mDescription, mImageUrl);
        this.mStartDate = mStartDate;
        this.mEndDate = mEndDate;
        this.mMarvelUrl = mMarvelUrl;
        this.mAvailableCreators = mAvailableCreators;
        this.mAvailableCharacter = mAvailableCharacter;
        this.mAvailableComic = mAvailableComic;
        this.mAvailableStories = mAvailableStories;
        this.mCreatorsUri = mCreatorsUri;
        this.mCharacterUri = mCharacterUri;
        this.mComicUri = mComicUri;
        this.mStoriesUri = mStoriesUri;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getMarvelUrl() {
        return mMarvelUrl;
    }

    public int getAvailableCreators() {
        return mAvailableCreators;
    }

    public int getAvailableCharacter() {
        return mAvailableCharacter;
    }

    public int getAvailableComic() {
        return mAvailableComic;
    }

    public int getAvailableStories() {
        return mAvailableStories;
    }

    public String getCreatorsUri() {
        return mCreatorsUri;
    }

    public String getCharacterUri() {
        return mCharacterUri;
    }

    public String getComicUri() {
        return mComicUri;
    }

    public String getStoriesUri() {
        return mStoriesUri;
    }
}
