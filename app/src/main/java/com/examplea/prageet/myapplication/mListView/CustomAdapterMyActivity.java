package com.examplea.prageet.myapplication.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.MyActivity_Data;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapterMyActivity extends BaseAdapter {

    Context c;
    ArrayList<MyActivity_Data> myactivity;
    LayoutInflater inflater;

    public CustomAdapterMyActivity(Context c , ArrayList<MyActivity_Data> myactivity)
    {
        this.c = c;
        this.myactivity = myactivity;
    }

    @Override
    public int getCount() {
        return myactivity.size();
    }

    @Override
    public Object getItem(int i) {
        return myactivity.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view==null)
        {
            view = inflater.inflate(R.layout.myactivity_model,viewGroup,false);

        }
        TextView nametxt= (TextView)view.findViewById(R.id.myactivity_game);
        ImageView img = (ImageView) view.findViewById(R.id.myactivity_image);
        TextView detailtxt= (TextView)view.findViewById(R.id.myactivity_detail);

        final String name = myactivity.get(i).getName();
        int image = myactivity.get(i).getImage1();
        final String detail = myactivity.get(i).getDetail();

        nametxt.setText(name);
        img.setImageResource(image);
        detailtxt.setText(detail);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
