package com.example.marvelgeek.models;

import java.io.Serializable;

public class Characters extends Marvel implements Serializable {


    public Characters(int mId, String mName, String mDescription, String mImageUrl) {
        super(mId, mName, mDescription, mImageUrl);
    }

}
