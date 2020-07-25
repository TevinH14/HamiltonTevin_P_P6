package com.example.marvelgeek.models;

public class Comics extends Marvel{
  private int mIssueNum;
  private double mPrice;
  


    public Comics(int mId, String mName, String mDescription, String mImageUrl) {
        super(mId, mName, mDescription, mImageUrl);
    }
}
