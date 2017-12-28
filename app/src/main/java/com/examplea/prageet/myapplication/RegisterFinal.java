package com.examplea.prageet.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.examplea.prageet.myapplication.mFragments.MyActivity;

public class RegisterFinal extends AppCompatActivity implements View.OnClickListener {


    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText Name, Email, Contact, Rollno;
        Spinner sp1, sp2;
        String name = null;
        String email = null;
        String contact = null;
        String rollno = null;
        String sem = null;
        String branch = null;
        SharedPreferences app_preferences = getSharedPreferences("testapp", MODE_PRIVATE);
        Boolean isFirstTime;

        setContentView(R.layout.activity_register_final);
        register = (Button) findViewById(R.id.register11);

        Name = (EditText) findViewById(R.id.name11);
        Email = (EditText) findViewById(R.id.email1);
        Contact = (EditText) findViewById(R.id.contact1);
        Rollno = (EditText) findViewById(R.id.roll_no1);
        name = Name.getText().toString();
        email = Email.getText().toString();
        contact = Contact.getText().toString();
        rollno = Rollno.getText().toString();
        sp1 = (Spinner) findViewById(R.id.branch1);
        branch = sp1.getSelectedItem().toString();
        sp2 = (Spinner) findViewById(R.id.sem1);
        sem = sp2.getSelectedItem().toString();
        final SharedPreferences.Editor editor = app_preferences.edit();
        isFirstTime = app_preferences.getBoolean("isFirstTime", true);
        if (isFirstTime) {
            setContentView(R.layout.activity_register_final);
            final String finalName = name;
            final String finalEmail = email;
            final String finalContact = contact;
            final String finalRollno = rollno;
            final String finalSem = sem;
            final String finalBranch = branch;
            register.setOnClickListener(this);
          /*  register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(RegisterFinal.this, "Registered", Toast.LENGTH_SHORT).show();
             /*       editor.putString("Name", finalName);
                    editor.putString("Email", finalEmail);
                    editor.putString("Contact", finalContact);
                    editor.putString("RollNo", finalRollno);
                    editor.putString("Sem", finalSem);
                    editor.putString("Branch", finalBranch);
                    editor.putBoolean("isFirstTime", true);
                    editor.commit();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterFinal.this);
                    alertDialogBuilder.setMessage("Information Once Stored Cannot be Changed");
                            alertDialogBuilder.setPositiveButton("yes",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            Toast.makeText(RegisterFinal.this,"Registerd",Toast.LENGTH_LONG).show();
                                            Intent intt = new Intent(RegisterFinal.this, MainActivity.class);
                                            startActivity(intt);
                                        }
                                    });
                    alertDialogBuilder.show();*/

        }
    }

    @Override
    public void onClick(View view) {
        EditText Name, Email, Contact, Rollno;
        Spinner sp1, sp2;
        String name = null;
        String email = null;
        String contact = null;
        String rollno = null;
        String sem = null;
        String branch = null;
        SharedPreferences app_preferences = getSharedPreferences("testapp", MODE_PRIVATE);
        Boolean isFirstTime;
        Name = (EditText) findViewById(R.id.name11);
        Email = (EditText) findViewById(R.id.email1);
        Contact = (EditText) findViewById(R.id.contact1);
        Rollno = (EditText) findViewById(R.id.roll_no1);
        name = Name.getText().toString();
        email = Email.getText().toString();
        contact = Contact.getText().toString();
        rollno = Rollno.getText().toString();
        sp1 = (Spinner) findViewById(R.id.branch1);
        branch = sp1.getSelectedItem().toString();
        sp2 = (Spinner) findViewById(R.id.sem1);
        sem = sp2.getSelectedItem().toString();
        final SharedPreferences.Editor editor = app_preferences.edit();
        isFirstTime = app_preferences.getBoolean("isFirstTime", true);

        setContentView(R.layout.activity_register_final);
        final String finalName = name;
        final String finalEmail = email;
        final String finalContact = contact;
        final String finalRollno = rollno;
        final String finalSem = sem;
        final String finalBranch = branch;

        editor.putString("Name", finalName);
        editor.putString("Email", finalEmail);
        editor.putString("Contact", finalContact);
        editor.putString("RollNo", finalRollno);
        editor.putString("Sem", finalSem);
        editor.putString("Branch", finalBranch);
        editor.putBoolean("hasLoggedIn", true).apply();
        boolean logged = app_preferences.getBoolean("hasLoggedIn",false);

        editor.commit();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterFinal.this);
        alertDialogBuilder.setMessage("Information Once Stored Cannot be Changed");
        alertDialogBuilder.setPositiveButton("SUMBIT",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if(finalName.equalsIgnoreCase("")||finalEmail.equalsIgnoreCase("")||finalContact.equalsIgnoreCase("")||finalRollno.equalsIgnoreCase(""))
                        {
                            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(RegisterFinal.this);
                            alertDialogBuilder1.setMessage("YOU SKIPPED SOMETHING");
                            alertDialogBuilder1.setNegativeButton("SORRY",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {//        Toast.makeText(RegisterFinal.this, "Registerd", Toast.LENGTH_LONG).show();

                                        }
                                    });
                            alertDialogBuilder1.show();
                        }
                        else {

                            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(RegisterFinal.this);
                            alertDialogBuilder1.setMessage("IF YOUR REGISTERED EVENTS ARE NOT SHOWN, YOUR REGISTRATION WAS UNSUCCESSFUL.\nPLEASE REGISTER AGAIN");
                            alertDialogBuilder1.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {//        Toast.makeText(RegisterFinal.this, "Registerd", Toast.LENGTH_LONG).show();
                                            Intent intt = new Intent(RegisterFinal.this, MainActivity.class);
                                            startActivity(intt);
                                        }
                                    });
                            alertDialogBuilder1.show();

                            //        Toast.makeText(RegisterFinal.this, "Registerd", Toast.LENGTH_LONG).show();

                        }
                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                    }
                });
        alertDialogBuilder.show();


        String str_name = app_preferences.getString("Name",null);
        String str_email = app_preferences.getString("Email",null);
        String str_contact = app_preferences.getString("Contact",null);
        String str_rollno = app_preferences.getString("RollNo",null);
        String str_sem = app_preferences.getString("Sem",null);
        String str_branch = app_preferences.getString("Branch",null);

        Fetch go = new Fetch(str_name,str_email,str_contact,str_rollno,str_sem,str_branch);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onResume()
    {
        super.onResume();
    }
}




