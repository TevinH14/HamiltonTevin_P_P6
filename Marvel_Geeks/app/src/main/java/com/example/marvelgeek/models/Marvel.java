package com.example.marvelgeek.models;

import java.io.Serializable;

public class Marvel implements Serializable {
    private int mId;
    private String mName;
    private String mDescription;
    private String mImageUrl;

    public Marvel(int mId, String mName, String mDescription,String mImageUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImageUrl = mImageUrl;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
