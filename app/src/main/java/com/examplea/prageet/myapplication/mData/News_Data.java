package com.examplea.prageet.myapplication.mData;

/**
 * Created by prage on 10/21/2017.
 */

public class News_Data {


    String heading , content;
    public News_Data(String heading,String content)

    {
        this.heading = heading;
        this.content=content;
    }

    public String getHeading() {return heading;}
    public String getContent() {
        return content;
    }

}
