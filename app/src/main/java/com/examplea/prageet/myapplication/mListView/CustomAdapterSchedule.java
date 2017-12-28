package com.examplea.prageet.myapplication.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Schedule_Data;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapterSchedule extends BaseAdapter {

    Context c;
    ArrayList<Schedule_Data> schedule;
    LayoutInflater inflater;

    public CustomAdapterSchedule(Context c , ArrayList<Schedule_Data> schedule)
    {
        this.c = c;
        this.schedule = schedule;
    }

    @Override
    public int getCount() {
        return schedule.size();
    }

    @Override
    public Object getItem(int i) {
        return schedule.get(i);
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
            view = inflater.inflate(R.layout.schedule_model,viewGroup,false);

        }
        TextView nametxt= (TextView)view.findViewById(R.id.scheduletextview);


        final String name = schedule.get(i).getName();

        nametxt.setText(name);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
