package com.examplea.prageet.myapplication.mListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.MyActivity_Data;
import com.examplea.prageet.myapplication.mData.News_Data;
import com.examplea.prageet.myapplication.mFragments.News;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapterNews extends BaseAdapter {

    Context c;
    ArrayList<News_Data> news;
    LayoutInflater inflater;

    public CustomAdapterNews(Context c , ArrayList<News_Data> news)
    {
        this.c = c;
        this.news = news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int i) {
        return news.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (null == convertView) {
            LinearLayout view = (LinearLayout) LinearLayout.inflate(this.c,
                    R.layout.news_fragment, null);
       //     Log.d("SeenDroid", String.format("Get view %d", position));
            TextView title = new TextView(view.getContext());
            title.setText(this.news.get(i).getHeading());
            view.addView(title);
            return view;
        } else {
            LinearLayout view = (LinearLayout) convertView;
            TextView title = (TextView) view.getChildAt(0);
            TextView nametxt= (TextView)convertView.findViewById(R.id.heading);
            TextView detailtxt= (TextView)convertView.findViewById(R.id.content);

            final String heading = news.get(i).getHeading();

            final String content = news.get(i).getContent();

            nametxt.setText(heading);

            detailtxt.setText(content);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //       Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }
    }
}
