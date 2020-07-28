package com.example.marvelgeek.models;

public class Series extends Marvel {

    private int mStartYear;
    private int mEndYear;
    private String mRating;
    private String mEventType;
    private String mMarvelLink;

    private int mAvailableCreators;
    private int mAvailableCharacter;
    private int mAvailableComic;
    private int mAvailableStories;

    private String mCreatorsUri;
    private String mCharacterUri;
    private String mComicUri;
    private String mStoriesUri;

    public Series(int mId, String mName, String mDescription, String mImageUrl, int mStartYear,
                  int mEndYear, String mRating, String mEventType, String mMarvelLink,
                  int mAvailableCreators, int mAvailableCharacter, int mAvailableComic,
                  int mAvailableStories, String mCreatorsUri, String mCharacterUri,String mComicUri,
                  String mStoriesUri) {
        super(mId, mName, mDescription, mImageUrl);
        this.mStartYear = mStartYear;
        this.mEndYear = mEndYear;
        this.mRating = mRating;
        this.mEventType = mEventType;
        this.mMarvelLink = mMarvelLink;
        this.mAvailableCreators = mAvailableCreators;
        this.mAvailableCharacter = mAvailableCharacter;
        this.mAvailableComic = mAvailableComic;
        this.mAvailableStories = mAvailableStories;
        this.mCreatorsUri = mCreatorsUri;
        this.mCharacterUri = mCharacterUri;
        this.mComicUri = mComicUri;
        this.mStoriesUri = mStoriesUri;
    }

    public int getStartYear() {
        return mStartYear;
    }

    public int getEndYear() {
        return mEndYear;
    }

    public String getRating() {
        return mRating;
    }

    public String getEventType() {
        return mEventType;
    }

    public String getMarvelLink() {
        return mMarvelLink;
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
