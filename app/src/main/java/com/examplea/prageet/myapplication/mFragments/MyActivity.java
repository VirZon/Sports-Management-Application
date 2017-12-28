package com.examplea.prageet.myapplication.mFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.Game;
import com.examplea.prageet.myapplication.GameAndTeamList;
import com.examplea.prageet.myapplication.MyApplication;
import com.examplea.prageet.myapplication.mEvents.GullyCricket;
import  com.examplea.prageet.myapplication.myactivity;
import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.MyActivity_Data;
import com.examplea.prageet.myapplication.mListView.CustomAdapterMyActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by prage on 10/21/2017.
 */

public class MyActivity extends Fragment{
    ArrayList<Game> a;
    ArrayList<String> gamelist ;
    DatabaseReference databasegames;

    ArrayList<MyActivity_Data> game = new ArrayList<>();
    ArrayList<String> team = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        a = new ArrayList<>();
        gamelist=new ArrayList<>();
        team=new ArrayList<>();



        Toast.makeText(getContext(),"Loading Might Take Some Time \nMake Sure You are Connected To Internet",Toast.LENGTH_SHORT).show();
        databasegames = FirebaseDatabase.getInstance().getReference("Game");
        databasegames.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
      //          Toast.makeText(getContext(),"Google2",Toast.LENGTH_SHORT).show();
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                        Game gg = childEventSnapshot.getValue(Game.class);
                        String ss = gg.contact_no;
                        String ss1 = gg.email;
                        //    Toast.makeText(myactivity.this,ss+":::"+ss1,Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences = getActivity().getSharedPreferences("testapp", MODE_PRIVATE);
                        if (ss!=null && ss1 != null && ss.equals(preferences.getString("Contact",null)) && ss1.equalsIgnoreCase(preferences.getString("Email",null).replace('.', ','))
                                )
                        {
                            a.add(gg);
                        }
                    }

                }

                for(Game g:a){
                    gamelist.add(g.game_id);
                    team.add(g.team_name);
                    across(g.game_id , g.team_name);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        View rootView = inflater.inflate(R.layout.myactivity_fragment,container,false);

      ListView lv = (ListView) rootView.findViewById(R.id.myactivity_list);
        CustomAdapterMyActivity adapter = new CustomAdapterMyActivity(this.getActivity(),game);


       lv.setAdapter(adapter);


        return rootView;
    }

    private void across(String a  , String b)
    {
        SharedPreferences preferences = getActivity().getSharedPreferences("testapp6", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        Log.d("HELL", String.valueOf(preferences.getBoolean("long1",false)));
        MyActivity_Data games;
        MyActivity_Data Gully = new MyActivity_Data("Gully Cricket", "You are a participant of this Event", R.drawable.vollyball);;
        if(a.equalsIgnoreCase("gully cricket") && !game.contains(Gully) && !(preferences.getBoolean("gully1",false)))
        {
            editor.putBoolean("gully1",true).apply();
            games = new MyActivity_Data("Gully Cricket", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);


        }
        if(a.equalsIgnoreCase("long jump") && !(preferences.getBoolean("long1",false)))
        {
            editor.putBoolean("long1",true).apply();
            games = new MyActivity_Data("Long Jump", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);


        }
        if(a.equalsIgnoreCase("badminton") && !(preferences.getBoolean("badmintonSingle",false)) && b.equalsIgnoreCase("singles"))
        {
            editor.putBoolean("badmintonSingle",true).apply();
            games = new MyActivity_Data("Badminton", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);

        }
        if(a.equalsIgnoreCase("badminton") && !(preferences.getBoolean("badmintonDouble",false))&&!b.equalsIgnoreCase("singles"))
        {
            editor.putBoolean("badmintonDouble",true).apply();
            games = new MyActivity_Data("Badminton", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);

        }

        if(a.equalsIgnoreCase("basketball") && !(preferences.getBoolean("basketball1",false)))
        {
            editor.putBoolean("basketball1",true).apply();
            games = new MyActivity_Data("Basketball", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("carrom") && !(preferences.getBoolean("carromSingles",false)))
        {
            editor.putBoolean("carromSingles",true).apply();
            games = new MyActivity_Data("Carrom", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("carrom") && !(preferences.getBoolean("carromDoubles",false))&&!b.equalsIgnoreCase("singles"))
        {
            editor.putBoolean("carromDoubles",true).apply();
            games = new MyActivity_Data("Carrom", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("cricket") && !(preferences.getBoolean("cricket",false)))
        {
            editor.putBoolean("cricket",true).apply();
            games = new MyActivity_Data("Cricket", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }


        if(a.equalsIgnoreCase("chess") && !(preferences.getBoolean("chess1",false)))
        {
            editor.putBoolean("chess1",true).apply();
            games = new MyActivity_Data("Chess", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("football") && !(preferences.getBoolean("football1",false)))
        {
            editor.putBoolean("football1",true).apply();
            games = new MyActivity_Data("Football", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("handball") && !(preferences.getBoolean("handball1",false)))
        {
            editor.putBoolean("handball1",true).apply();
            games = new MyActivity_Data("Handball", "You are a participant of this Event as "+ b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("kabaddi") && !(preferences.getBoolean("kabaddi1",false)))
        {
            editor.putBoolean("kabaddi1",true).apply();
            games = new MyActivity_Data("Kabaddi", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("khokho") && !(preferences.getBoolean("khokho1",false)))
        {
            editor.putBoolean("khokho1",true).apply();
            games = new MyActivity_Data("Kho Kho", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("tug of war") && !(preferences.getBoolean("tugofwar1",false)))
        {
            editor.putBoolean("tugofwar1",true).apply();
            games = new MyActivity_Data("Tug of War", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("volleyball") && !(preferences.getBoolean("volleyball1",false)))
        {
            editor.putBoolean("volleyball1",true).apply();
            games = new MyActivity_Data("Volleyball", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("table tennis") && !(preferences.getBoolean("tableS",false))&& !b.equalsIgnoreCase("singles"))
        {
            editor.putBoolean("tableS",true).apply();
            games = new MyActivity_Data("Table Tennis", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("table tennis") && !(preferences.getBoolean("tableD",false)) && b.equalsIgnoreCase("singles"))
        {
            editor.putBoolean("tableD",true).apply();
            games = new MyActivity_Data("Table Tennis", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("relay race") && !(preferences.getBoolean("relay1",false)))
        {
            editor.putBoolean("relay1",true).apply();
            games = new MyActivity_Data("Relay Race", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("high jump") && !(preferences.getBoolean("highjump",false)))
        {
            editor.putBoolean("highjump",true).apply();
            games = new MyActivity_Data("High Jump", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("shot put") && !(preferences.getBoolean("shot1",false)))
        {
            editor.putBoolean("shot1",true).apply();
            games = new MyActivity_Data("Shot Put", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("100m race") && !(preferences.getBoolean("race1",false)))
        {
            editor.putBoolean("race1",true).apply();
            games = new MyActivity_Data("100m Race", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("cs go") && !(preferences.getBoolean("csgo1",false)))
        {
            editor.putBoolean("csgo1",true).apply();
            games = new MyActivity_Data("CS GO", "You are a participant of this Event as " + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("mini militia") && !(preferences.getBoolean("mini1",false)))
        {
            editor.putBoolean("mini1",true).apply();
            games = new MyActivity_Data("Mini Militia", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }

        if(a.equalsIgnoreCase("nfs") && !(preferences.getBoolean("nfs1",false)))
        {
            editor.putBoolean("nfs1",true).apply();
            games = new MyActivity_Data("Need For Speed", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("fifa") && !(preferences.getBoolean("fifa1",false)))
        {
            editor.putBoolean("fifa1",true).apply();
            games = new MyActivity_Data("Fifa", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("ludo king") && !(preferences.getBoolean("ludo1",false)))
        {
            editor.putBoolean("ludo1",true).apply();
            games = new MyActivity_Data("Ludo King", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }
        if(a.equalsIgnoreCase("pocket tanks") && !(preferences.getBoolean("tank1",false)))
        {
            editor.putBoolean("tank1",true).apply();
            games = new MyActivity_Data("Pocket Tanks", "You are a participant of this Event as "  + b, R.drawable.vollyball); ;
            game.add(games);
            team.add(a);
        }



    }

    private ArrayList<MyActivity_Data> getMyActivity()
    {

        ArrayList<MyActivity_Data> arrayMyActivity = new ArrayList<>();

        MyActivity_Data games;
        for(String s : gamelist)
        {
          //  Toast.makeText(getContext(),s+"func",Toast.LENGTH_SHORT).show();
        }
        if(gamelist.contains("Gully Cricket")) {
            games = new MyActivity_Data("Gully Cricket", "You are a participant of this Event", R.drawable.vollyball);
            arrayMyActivity.add(games);
        }

        return arrayMyActivity;

    }

    public String toString()
    {
        String title = "My Activity";
        return title;
    }
}
