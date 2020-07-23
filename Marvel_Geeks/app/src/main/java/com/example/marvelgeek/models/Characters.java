package com.example.marvelgeek.models;

import java.io.Serializable;

public class Characters implements Serializable {
    public  int mCharacterId;
    private String mCharacterName;
    private String mCharacterUrl;
    private String mDescription;

    public Characters(int mCharacterId, String mCharacterName,String mDescription, String mCharacterUrl) {
        this.mCharacterId = mCharacterId;
        this.mCharacterName = mCharacterName;
        this.mCharacterUrl = mCharacterUrl;
        this.mDescription = mDescription;
    }

    public int getCharacterId() {
        return mCharacterId;
    }

    public String getCharacterName() {
        return mCharacterName;
    }

    public String getCharacterUrl() {
        return mCharacterUrl;
    }

    public String getmDescription() {
        return mDescription;
    }
}
