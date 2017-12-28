package com.examplea.prageet.myapplication;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by prage on 10/28/2017.
 */

public class GameAndTeamList extends AppCompatActivity {
    ArrayList<Game> a;
    ArrayList<String> gamelist,team;
    DatabaseReference databasegames;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = new ArrayList<>();
        gamelist=new ArrayList<>();
        team=new ArrayList<>();
        Toast.makeText(this,"Google1",Toast.LENGTH_SHORT).show();
        databasegames = FirebaseDatabase.getInstance().getReference("Game");
        databasegames.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(GameAndTeamList.this,"Google2",Toast.LENGTH_SHORT).show();
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                        Game gg = childEventSnapshot.getValue(Game.class);
                        String ss = gg.contact_no;
                        String ss1 = gg.email;
                        //    Toast.makeText(myactivity.this,ss+":::"+ss1,Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences = getSharedPreferences("testapp", MODE_PRIVATE);
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

                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
