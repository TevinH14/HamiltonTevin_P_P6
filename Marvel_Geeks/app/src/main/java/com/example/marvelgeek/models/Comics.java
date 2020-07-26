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


    public Comics(int mId, String mName, String mDescription, String mImageUrl, String mComicUrl,
                  String mSeriesUri, String mSeriesName, double mPrice, int mIssueNum,
                  String mCreatorsUri, String mCharacterUri, String mStoriesUri, String mEventUri){
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
    }
}
