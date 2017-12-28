package com.examplea.prageet.myapplication.mData;

/**
 * Created by prage on 10/21/2017.
 */

public class Contact_Data {
    String name,number;
    int image1,image2;

    public Contact_Data(String name,String number , int image1 , int image2)
    {
        this.name = name;
        this.number=number;
        this.image1=image1;
        this.image2=image2;
    }

    public String getName() {return name;}
    public int getImage1()
    {
        return image1;
    }
    public String getNumber()
    {
        return number;
    }
    public int getImage2()
    {
        return image2;
    }

}
