package com.examplea.prageet.myapplication.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Games;
import com.examplea.prageet.myapplication.mListView.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class Events extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment1,container,false);

        ListView lv = (ListView) rootView.findViewById(R.id.frag1list);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(),getGames());

        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Games> getGames()
    {
        ArrayList<Games> arrayGames = new ArrayList<>();

        Games games = new Games("Athletics",R.drawable.highjump);
        arrayGames.add(games);

         games = new Games("Badminton",R.drawable.badminton3);
        arrayGames.add(games);

        games = new Games("BasketBall",R.drawable.basketball);
        arrayGames.add(games);

        games = new Games("Carrom",R.drawable.carrom);
        arrayGames.add(games);

        games = new Games("Chess",R.drawable.chess);
        arrayGames.add(games);

        games = new Games("Cricket",R.drawable.cricket);
        arrayGames.add(games);

        games = new Games("Gully Cricket",R.drawable.gullycricket);
        arrayGames.add(games);

        games = new Games("Handball",R.drawable.handball);
        arrayGames.add(games);

        games = new Games("Kabaddi",R.drawable.kabaddi);
        arrayGames.add(games);

        games = new Games("Kho Kho",R.drawable.khokho);
        arrayGames.add(games);

        games = new Games("Lan Gaming",R.drawable.langaming);
        arrayGames.add(games);

        games = new Games("Street Soccer",R.drawable.football);
        arrayGames.add(games);

        games = new Games("Table Tennis",R.drawable.tabletennis);
        arrayGames.add(games);

        games = new Games("Tug of War",R.drawable.tugofwar);
        arrayGames.add(games);

        games = new Games("Volley Ball",R.drawable.volleyball);
        arrayGames.add(games);



        return arrayGames;

    }

    public String toString()
    {
        String title = "Events";
        return title;
    }
}
