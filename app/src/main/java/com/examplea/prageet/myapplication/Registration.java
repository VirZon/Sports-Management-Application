package com.examplea.prageet.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.examplea.prageet.myapplication.mEvents.Handball;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends Activity {
    private String game_id;
    private String email;
    private String player_name;
    private String team_name;
    private String captain_name;
    private String roll_no;
    private String branch;
    private String sem;
    private String contact_no;

    DatabaseReference databasegames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void onStart()
    {
        super.onStart();
      /*  setContentView(R.layout.register);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Registration.this);
        builder1.setMessage("Enter Single for Team name and Captain name in case of Singles");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OKAY!!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        EditText team_name1 = ((EditText)findViewById(R.id.team_name));
        team_name1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                team_name = s.toString().replace('.',',');
                // we test it here (assuming your main Activity is called "MainActivity"
                //   Toast.makeText(MainActivity.this, t, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        final EditText captain_name1= ((EditText) findViewById(R.id.captain_name));
        captain_name1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                captain_name = s.toString();
                // we test it here (assuming your main Activity is called "MainActivity"
                //Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        EditText player_name1= ((EditText) findViewById(R.id.player_name));
        player_name1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                player_name = s.toString();
                // we test it here (assuming your main Activity is called "MainActivity"
                //Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        EditText roll_no1 = ( (EditText)findViewById(R.id.roll_no));
        roll_no1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                roll_no = s.toString();
                // we test it here (assuming your main Activity is called "MainActivity"
                // Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        EditText contact_no1 = ( (EditText)findViewById(R.id.contact_no));
        contact_no1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                contact_no = s.toString();
                // we test it here (assuming your main Activity is called "MainActivity"
                //Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        EditText email1 = ( (EditText)findViewById(R.id.email));
        email1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // we assign "theText" a value here
                email = s.toString().replace('.',',');
                // we test it here (assuming your main Activity is called "MainActivity"
                //     Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
                // you can do whatever with the value here directly (like call "do_search"),
                // or launch a background Thread to do it from here
            }
        });
        final Spinner sp1 = (Spinner)findViewById(R.id.branch);
        final Spinner sp2 = (Spinner)findViewById(R.id.sem);
        final Spinner sp3 = (Spinner)findViewById(R.id.game_id);

        databasegames = FirebaseDatabase.getInstance().getReference("Game");
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                branch = sp1.getSelectedItem().toString();
                sem = sp2.getSelectedItem().toString();
                game_id = sp3.getSelectedItem().toString();
                add();

            }
        });
    }
    public void add(){
        //Toast.makeText(this, captain_name, Toast.LENGTH_LONG).show();

        if (!TextUtils.isEmpty(player_name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
*/
            //creating an Artist Object
             databasegames = FirebaseDatabase.getInstance().getReference("Game");
            SharedPreferences preferences = getSharedPreferences("testapp", MODE_PRIVATE);
            final SharedPreferences.Editor editor = preferences.edit();
            Game artist = new Game(game_id,preferences.getString("Email",null),
                    preferences.getString("Name",null),
                    team_name,
                    captain_name,
                    preferences.getString("RollNo",null),
                    preferences.getString("Branch",null),
                    preferences.getString("Sem",null),
                    preferences.getString("Contact",null));

            //Saving the Artist
            databasegames.child(game_id).child(email+" "+player_name).setValue(artist);



            //displaying a success toast
            Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();
            finish();
        }



    public void values()
    {
        SharedPreferences preferences = getSharedPreferences("testapp", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);
        Toast.makeText(this,preferences.getString("Name",null),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Email",null),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Contact",null),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("RollNo",null),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Sem",null),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Branch",null),Toast.LENGTH_SHORT).show();

    }
}
