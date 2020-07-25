package com.example.marvelgeek.models;

public class Comics extends Marvel{
    private int comicId;
    private String comicTitle;
    private String comicDescription;


    public Comics(int mId, String mName, String mDescription, String mImageUrl) {
        super(mId, mName, mDescription, mImageUrl);
    }
}
