package com.example.marvelgeek.models;

public class Series extends Marvel {

    private final int mStartYear;
    private final int mEndYear;
    private final String mRating;
    private final String mEventType;
    private final String mMarvelLink;

    private final int mAvailableCreators;
    private final int mAvailableCharacter;
    private final int mAvailableComic;
    private final int mAvailableStories;

    private final String mCreatorsUri;
    private final String mCharacterUri;
    private final String mComicUri;
    private final String mStoriesUri;

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
