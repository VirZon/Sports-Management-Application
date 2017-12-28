package com.examplea.prageet.myapplication.mData;

/**
 * Created by prage on 10/21/2017.
 */

public class MyActivity_Data {
    String name,detail;
    int image1;

    public MyActivity_Data(String name,String detail , int image1)
    {
        this.name = name;
        this.detail=detail;
        this.image1=image1;
    }



    public String getName()
    {
        return name;
    }
    public int getImage1()
    {
        return image1;
    }
    public String getDetail(){ return detail;}

}
