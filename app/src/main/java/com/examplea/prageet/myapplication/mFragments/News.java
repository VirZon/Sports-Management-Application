package com.examplea.prageet.myapplication.mFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.Game;
import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Games;
import com.examplea.prageet.myapplication.mData.MyActivity_Data;
import com.examplea.prageet.myapplication.mData.News_Data;
import com.examplea.prageet.myapplication.mEvents.Handball;
import com.examplea.prageet.myapplication.mEvents.TableTennid;
import com.examplea.prageet.myapplication.mListView.CustomAdapterMyActivity;
import com.examplea.prageet.myapplication.mListView.CustomAdapterNews;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.examplea.prageet.myapplication.R.id.heading;
import static com.examplea.prageet.myapplication.R.id.team_name;

/**
 * Created by prage on 11/1/2017.
 */

public class News extends Fragment {
    Button add;
    ArrayList<News_Data> a = new ArrayList<>();
    ArrayList<String> newsHead = new ArrayList<>();
    ArrayList<String> newsContent = new ArrayList<>();
    String field1, field2;
    String head, content;
    DatabaseReference databasenews;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {


        Toast.makeText(getActivity(),"News",Toast.LENGTH_SHORT).show();
        View rootView = inflater.inflate(R.layout.news_fragment,container,false);
        LinearLayout ll = (LinearLayout)rootView.findViewById(R.id.linear);
        ListView lv = (ListView) rootView.findViewById(R.id.frag1list);

        lv.setAdapter(null);


        CustomAdapterNews adapter = new CustomAdapterNews(this.getActivity(),a);
        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Working",Toast.LENGTH_SHORT).show();
                addnews();
            }
        });

        getnews();
        lv.setAdapter(adapter);


        return rootView;

    }

    private ArrayList<Games> getNews()
    {
        ArrayList<Games> arrayGames = new ArrayList<>();

        String heading="" , content="";
        News news = new News();




        return arrayGames;

    }

    public String toString()
    {
        String title = "News";
        return title;
    }
            //addnews will be called when user enters + button
    public void addnews() {

        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View textEntryView = factory.inflate(R.layout.text_edit1, null);
//text_entry is an Layout XML file containing two text field to display in alert dialog
        final EditText input1 = (EditText) textEntryView.findViewById(R.id.EditText1);
        final EditText input2 = (EditText) textEntryView.findViewById(R.id.EditText2);
        input1.setText("", TextView.BufferType.EDITABLE);
        input2.setText("", TextView.BufferType.EDITABLE);
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());


        alert.setTitle("Enter the Details")
                .setView(textEntryView)
                .setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                head = input1.getText().toString();
                                content = input2.getText().toString();
                                if(head.equals("") || content.equals(""))
                                {
                                    Toast.makeText(getActivity(),"Enter the Value",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getActivity(),"Done",Toast.LENGTH_SHORT).show();
                                    databasenews = FirebaseDatabase.getInstance().getReference("Game");
                                    News_Data n = new News_Data(head.replace('.',','), content.replace('.',','));
                                    String key = databasenews.push().getKey();
                                    databasenews.child("News").child(key).setValue(n);

                                };

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                            }
                        });
        alert.show();

       /* AlertDialog ad = new AlertDialog.Builder(getActivity())
                .create();
        ad.setCancelable(false);
        ad.setTitle("Hello");
        ad.setMessage("nice");
        ad.setButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad.show();*/

    }

    public void getnews() {

        Log.d("tag:","herrrreeee");
        Toast.makeText(getActivity(),"here",Toast.LENGTH_SHORT).show();
        databasenews = FirebaseDatabase.getInstance().getReference("Game");

        databasenews.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {

                    if (eventSnapshot.getKey().toString().equals("News")){
                        for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {

              //              News_Data g = childEventSnapshot.getValue(News_Data.class);
                        //   Toast.makeText(getActivity(),childEventSnapshot.getValue().toString(),Toast.LENGTH_SHORT).show();
String s[]=childEventSnapshot.getValue().toString().replace("{","").replace("}","").replace("heading","").replace("=","").split(", content");
              //              Toast.makeText(getActivity(),s[0]+" "+s[1],Toast.LENGTH_SHORT).show();
                            String ss = s[0];
                            String ss1 = s[1];
                            News_Data g=new News_Data(ss,ss1);
                        //    Toast.makeText(getActivity(), ss + ":::" + ss1, Toast.LENGTH_SHORT).show();
                            //   SharedPreferences preferences = getActivity().getSharedPreferences("testapp", MODE_PRIVATE);
                            if (ss != null && ss1 != null) {
                                ss.replace(',', '.');
                                ss1.replace(',', '.');
                                a.add(g);
                            }
                        }

                        }




                    }


                for (News_Data gg : a) {
                    newsHead.add(gg.getHeading());
                    newsContent.add(gg.getContent());

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

