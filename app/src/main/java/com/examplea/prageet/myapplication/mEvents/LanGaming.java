package com.examplea.prageet.myapplication.mEvents;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.ContactArray;
import com.examplea.prageet.myapplication.Game;
import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.Registration;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LanGaming extends AppCompatActivity {
    ArrayList<Game> a;
    static HSSFSheet sheet;
    HSSFWorkbook workbook;
    String team_name,captain_name,game_id="";
    DatabaseReference databasegames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> arrayList = new ContactArray().getArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langaming);
        Button reg = (Button)findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"Counter Strike: GO" , "Need For Speed : MW" , "Mini Militia" , "Pocket Tanks","Ludo King","Fifa 17"};
                final int[] csgo = {0};
                final int[] nfs = {0};
                final int[] mini = {0};
                final int[] pocket = {0};
                final int[] ludo = {0};
                final int[] fifa = {0};

// arraylist to keep the selected items
                final ArrayList seletedItems=new ArrayList();

                AlertDialog dialog = new AlertDialog.Builder(LanGaming.this)
                        .setTitle("Select The Sport")
                        .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    if(indexSelected==0)
                                        csgo[0] =1;
                                    if(indexSelected==1)
                                        nfs[0] = 1;
                                    if(indexSelected==2)
                                        mini[0] = 1;
                                    if(indexSelected==3)
                                        pocket[0] = 1;
                                    if(indexSelected==4)
                                        ludo[0] = 1;
                                    if(indexSelected==5)
                                        fifa[0] = 1;

                                    // If the user checked the item, add it to the selected items
                                  //  Toast.makeText(LanGaming.this,""+indexSelected,Toast.LENGTH_SHORT).show();
                                    seletedItems.add(indexSelected);
                                } else if (seletedItems.contains(indexSelected)) {
                                    csgo[0] =0;
                                    nfs[0] = 0;
                                    mini[0] = 0;
                                    pocket[0] = 0;
                                    ludo[0] = 0;
                                    fifa[0] = 0;
                                 //   Toast.makeText(LanGaming.this,"NICE",Toast.LENGTH_SHORT).show();
                                    // Else, if the item is already in the array, remove it
                                    seletedItems.remove(Integer.valueOf(indexSelected));
                                }

                            }
                        }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                if(csgo[0]==1)
                                {
                                    LayoutInflater factory = LayoutInflater.from(LanGaming.this);
                                    final View textEntryView = factory.inflate(R.layout.text_edit, null);
//text_entry is an Layout XML file containing two text field to display in alert dialog
                                    final EditText input1 = (EditText) textEntryView.findViewById(R.id.EditText1);
                                    final EditText input2 = (EditText) textEntryView.findViewById(R.id.EditText2);
                                    input1.setText("", TextView.BufferType.EDITABLE);
                                    input2.setText("", TextView.BufferType.EDITABLE);
                                    final AlertDialog.Builder alert = new AlertDialog.Builder(LanGaming.this);

                                    alert.setTitle("Enter the Details for CS:GO")
                                            .setView(textEntryView)
                                            .setPositiveButton("Submit",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int whichButton) {
                                                            game_id="CS GO";
                                                            team_name = input1.getText().toString();
                                                            captain_name = input2.getText().toString();
                                                            if(team_name.equals(""))
                                                            {
                                                                Toast.makeText(LanGaming.this,"Enter the Value in Team Name",Toast.LENGTH_SHORT).show();
                                                            }
                                                            else{
                                                                set();
                                                            };
                                                            /* User clicked OK so do some stuff */
                                                        }
                                                    })
                                            .setNegativeButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog,
                                                                            int whichButton) {
                                                        }
                                                    });
                                    alert.show();

                                }

                                if(mini[0]==1)
                                {
                                    LayoutInflater factory = LayoutInflater.from(LanGaming.this);
                                    final View textEntryView = factory.inflate(R.layout.text_edit, null);
//text_entry is an Layout XML file containing two text field to display in alert dialog
                                    final EditText input1 = (EditText) textEntryView.findViewById(R.id.EditText1);
                                    final EditText input2 = (EditText) textEntryView.findViewById(R.id.EditText2);
                                    input1.setText("", TextView.BufferType.EDITABLE);
                                    input2.setText("", TextView.BufferType.EDITABLE);
                                    final AlertDialog.Builder alert = new AlertDialog.Builder(LanGaming.this);


                                    alert.setTitle("Enter the Details for Mini Militia")
                                            .setView(textEntryView)
                                            .setPositiveButton("Submit",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int whichButton) {
                                                            game_id="Mini Militia";
                                                            team_name = input1.getText().toString();
                                                            captain_name = input2.getText().toString();
                                                            if(team_name.equals(""))
                                                            {
                                                                Toast.makeText(LanGaming.this,"Enter the Value in Team Name",Toast.LENGTH_SHORT).show();
                                                            }
                                                            else{
                                                                set();
                                                            };/* User clicked OK so do some stuff */
                                                        }
                                                    })
                                            .setNegativeButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog,
                                                                            int whichButton) {
                                                        }
                                                    });
                                    alert.show();

                                }

                                if(nfs[0]==1)
                                {
                                    game_id="NFS";
                                    team_name = "Singles";
                                    captain_name = "Singles";
                                    set();
                                }

                                if(fifa[0]==1)
                                {
                                    game_id="FIFA";
                                    team_name = "Singles";
                                    captain_name = "Singles";
                                    set();
                                }

                                if(ludo[0]==1)
                                {
                                    game_id="Ludo King";
                                    team_name = "Singles";
                                    captain_name = "Singles";
                                    set();
                                }

                                if(pocket[0]==1)
                                {
                                    game_id="Pocket Tanks";
                                    team_name = "Singles";
                                    captain_name = "Singles";
                                    set();
                                }


                                else
                                    {
                                    Toast.makeText(LanGaming.this, "Please Select a Value", Toast.LENGTH_SHORT).show();
                                }
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                //  Your code when user clicked on Cancel
                            }
                        }).create();
                dialog.show();
            }
        });

        Button down = (Button)findViewById(R.id.down);
        SharedPreferences preferences = getSharedPreferences("testapp", MODE_PRIVATE);

        if(arrayList.contains(preferences.getString("Contact",null)))
        {
            down.setVisibility(View.VISIBLE);
        }

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                HSSFRow rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");
                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("NFS"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "NFS.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                 rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");

                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("FIFA"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "FIFA.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");

                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("Ludo King"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "Ludo King.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");

                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("Pocket Tanks"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "Pocket Tanks.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");

                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("CS GO"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "CS GO.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("FirstSheet");
                rowhead = sheet.createRow((short) 0);
                rowhead.createCell((short) 0).setCellValue("No.");
                rowhead.createCell((short) 1).setCellValue("Team name");
                rowhead.createCell((short) 2).setCellValue("Captain name");
                rowhead.createCell((short) 3).setCellValue("Name");
                rowhead.createCell((short) 4).setCellValue("Rollno");
                rowhead.createCell((short) 5).setCellValue("Sem");
                rowhead.createCell((short) 6).setCellValue("Branch");
                rowhead.createCell((short) 7).setCellValue("Email");
                rowhead.createCell((short) 8).setCellValue("Contact");
                a = new ArrayList<>();
                databasegames=FirebaseDatabase.getInstance().getReference("Game");

                databasegames.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {


                            if (eventSnapshot.getKey().toString().equals("Mini Militia"))
                                for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                                    Game gg = childEventSnapshot.getValue(Game.class);
                                    a.add(gg);
                                }

                        }


                        int i = 1;
                        for (Game s : a) {
                            HSSFRow row = sheet.createRow((short) i);
                            System.out.println(s.player_name);
                            row.createCell((short) 0).setCellValue(i++);
                            row.createCell((short) 1).setCellValue(s.team_name);
                            row.createCell((short) 2).setCellValue(s.captain_name);
                            row.createCell((short) 3).setCellValue(s.player_name);
                            row.createCell((short) 4).setCellValue(s.roll_no);
                            row.createCell((short) 5).setCellValue(s.sem);
                            row.createCell((short) 6).setCellValue(s.branch);
                            row.createCell((short) 7).setCellValue(s.email.replace(',', '.'));
                            row.createCell((short) 8).setCellValue(s.contact_no);

                        }

                        File file = new File(LanGaming.this.getExternalFilesDir(null), "Mini Militia.xls");
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            workbook.write(os);
                            //         Log.w("FileUtils", "Writing file" + file);
                            Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            //          Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //          Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                //        Toast.makeText(Badminton.this,"Downloaded",Toast.LENGTH_SHORT).show();
            }
        });


        final TextView tv1 = (TextView)findViewById(R.id.con_num1);
        final TextView tv2 = (TextView)findViewById(R.id.con_num2);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"+91"+tv1.getText().toString()));
                try {
                    LanGaming.this.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(LanGaming.this, "Could not Load Number to place the call.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"+91"+tv2.getText().toString()));
                try {
                    LanGaming.this.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(LanGaming.this, "Could not Load Number to place the call.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        final TextView tv3 = (TextView)findViewById(R.id.con_num3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"+91"+tv3.getText().toString()));
                try {
                    LanGaming.this.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(LanGaming.this, "Could not Load Number to place the call.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void set()
    {
        databasegames= FirebaseDatabase.getInstance().getReference("Game");
        SharedPreferences preferences = getSharedPreferences("testapp", MODE_PRIVATE);

        final SharedPreferences.Editor editor = preferences.edit();
        Game artist = new Game(game_id,preferences.getString("Email",null).replace('.',','),
                preferences.getString("Name",null),
                team_name,
                captain_name,
                preferences.getString("RollNo",null),
                preferences.getString("Branch",null),
                preferences.getString("Sem",null),
                preferences.getString("Contact",null));

        //   Game artist = new Game("Handball", "a@g,com", "aaa", "Aaaaa", "aaaa", "aaaaaaaaaa", "aaaaaaaaaaa", "aaa", "aaaaaaa");
        //Saving the Artist
        try {
            databasegames.child(game_id).child(preferences.getString("Email",null).replace('.',',')+
                    " "+
                    preferences.getString("Name",null).replace('.',',')+" "+team_name.replace('.',',')).setValue(artist);
            Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
