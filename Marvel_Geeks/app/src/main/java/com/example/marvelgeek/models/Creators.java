package com.example.marvelgeek.models;

public class Creators extends Marvel {
    private final String mMarvelLink;
    private final int mAvailableComics;

    public Creators(int mId, String mName, String mDescription, String mImageUrl,String mMarvelLink,
                    int mAvailableComics) {
        super(mId, mName, mDescription, mImageUrl);
        this.mMarvelLink = mMarvelLink;
        this.mAvailableComics = mAvailableComics;
    }

    public String getMarvelLink() {
        return mMarvelLink;
    }

    public int getAvailableComics() {
        return mAvailableComics;
    }
}
