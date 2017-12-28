package com.examplea.prageet.myapplication.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Schedule_Data;
import com.examplea.prageet.myapplication.mListView.CustomAdapterSchedule;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class Schedule extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.schedule_fragment,container,false);

      //  ListView lv = (ListView) rootView.findViewById(R.id.schedule_list);
        //CustomAdapterSchedule adapter = new CustomAdapterSchedule(this.getActivity(),getSchedule());





        return rootView;
    }

    private ArrayList<Schedule_Data> getSchedule()
    {
        ArrayList<Schedule_Data> arraySchedule = new ArrayList<>();

        Schedule_Data schedule = new Schedule_Data("November 2");
        arraySchedule.add(schedule);
        schedule = new Schedule_Data("November 3");
        arraySchedule.add(schedule);
        schedule = new Schedule_Data("November 4");
        arraySchedule.add(schedule);
        return arraySchedule;

    }

    public String toString()
    {
        String title = "Schedule";
        return title;
    }
}
