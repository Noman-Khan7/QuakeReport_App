package com.example.android.quakereport;

/**
 * Created by Noman on 03-05-2018.
 */

public class Earthquake {
    private String mMagnitude;
    private String mLocation;
    private String mDate;
    private String mURL;

    public Earthquake(String mag,String loc,String date,String url)
    {
        mMagnitude=mag;
        mLocation=loc;
        mDate=date;
        mURL=url;
    }
    public String getMagnitude()
    {
        return mMagnitude;
    }
    public String getLocation()
    {
        return  mLocation;
    }
    public String getDate()
    {
        return mDate;
    }
    public String getUrl() {
        return mURL;
    }
}
