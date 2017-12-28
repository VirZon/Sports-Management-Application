package com.examplea.prageet.myapplication.mListView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Games;
import com.examplea.prageet.myapplication.mEvents.Athletics;
import com.examplea.prageet.myapplication.mEvents.Badminton;
import com.examplea.prageet.myapplication.mEvents.Basketball;
import com.examplea.prageet.myapplication.mEvents.Carrom;
import com.examplea.prageet.myapplication.mEvents.Chess;
import com.examplea.prageet.myapplication.mEvents.Cricket;
import com.examplea.prageet.myapplication.mEvents.GullyCricket;
import com.examplea.prageet.myapplication.mEvents.Handball;
import com.examplea.prageet.myapplication.mEvents.Kabaddi;
import com.examplea.prageet.myapplication.mEvents.KhoKho;
import com.examplea.prageet.myapplication.mEvents.LanGaming;
import com.examplea.prageet.myapplication.mEvents.StreetSoccer;
import com.examplea.prageet.myapplication.mEvents.TableTennid;
import com.examplea.prageet.myapplication.mEvents.TugOfWar;
import com.examplea.prageet.myapplication.mEvents.VolleyBall;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Games> games;
    LayoutInflater inflater;

    public CustomAdapter(Context c , ArrayList<Games> games)
    {
        this.c = c;
        this.games = games;
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int i) {
        return games.get(i);
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
            view = inflater.inflate(R.layout.demo,viewGroup,false);

        }
        TextView nametxt= (TextView)view.findViewById(R.id.eventtextview);
        ImageView img = (ImageView) view.findViewById(R.id.eventImage);

        final String name = games.get(i).getName();
        int image = games.get(i).getImage();

        nametxt.setText(name);
        img.setImageResource(image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.equalsIgnoreCase("badminton"))
                {
                    Intent intent = new Intent(c,Badminton.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("basketball"))
                {
                    Intent intent = new Intent(c,Basketball.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("cricket"))
                {
                    Intent intent = new Intent(c,Cricket.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("carrom"))
                {
                    Intent intent = new Intent(c,Carrom.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("handball"))
                {
                    Intent intent = new Intent(c,Handball.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("kabaddi"))
                {
                    Intent intent = new Intent(c,Kabaddi.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("gully cricket"))
                {
                    Intent intent = new Intent(c,GullyCricket.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("kho kho"))
                {
                    Intent intent = new Intent(c,KhoKho.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("chess"))
                {
                    Intent intent = new Intent(c,Chess.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("street soccer"))
                {
                    Intent intent = new Intent(c,StreetSoccer.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("volley ball"))
                {
                    Intent intent = new Intent(c,VolleyBall.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("tug of war"))
                {
                    Intent intent = new Intent(c,TugOfWar.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("table tennis"))
                {
                    Intent intent = new Intent(c,TableTennid.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("badminton"))
                {
                    Intent intent = new Intent(c,Badminton.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("lan gaming"))
                {
                    Intent intent = new Intent(c,LanGaming.class);
                    c.startActivity(intent);
                }
                if(name.equalsIgnoreCase("athletics"))
                {
                    Intent intent = new Intent(c,Athletics.class);
                    c.startActivity(intent);
                }

            }

        });




        return view;
    }
}
