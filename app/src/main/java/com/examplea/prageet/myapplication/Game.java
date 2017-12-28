package com.examplea.prageet.myapplication;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by Karthik on 25-10-2017.
 */

public class Game {
    public String game_id;
    public String email;
    public String player_name;
    public String team_name;
    public String captain_name;
    public String roll_no;
    public String branch;
    public String sem;
    public String contact_no;

    public Game(){}
    public Game(String game_id, String email, String name, String team_name, String captain, String rollno, String branch, String sem, String mobile)
    {
        this.game_id=game_id;
        this.email=email;
        this.team_name=team_name;
        this.player_name=name;
        this.captain_name=captain;
        this.roll_no=rollno;
        this.branch=branch;
        this.sem=sem;
        this.contact_no=mobile;
    }
    public String getteam(){
        return team_name;
    }

    public static Comparator<Game> s=new Comparator<Game>() {
        @Override
        public int compare(Game g, Game t1) {
           String s=g.getteam().toUpperCase();
            String s1=t1.getteam().toUpperCase();
return s.compareTo(s1);
        }
    };
}
