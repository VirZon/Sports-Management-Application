package com.examplea.prageet.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.examplea.prageet.myapplication.mData.MyActivity_Data;
import com.examplea.prageet.myapplication.mFragments.Contacts;
import com.examplea.prageet.myapplication.mFragments.Events;
import com.examplea.prageet.myapplication.mFragments.MyActivity;
import com.examplea.prageet.myapplication.mFragments.MyPagerAdapter;
import com.examplea.prageet.myapplication.mFragments.News;
import com.examplea.prageet.myapplication.mFragments.Schedule;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener  {

    ArrayList<MyActivity_Data> hisab = new ArrayList<>();
    ViewPager vp;
    TabLayout tabLayout;
 //   EditText Name , Email , Contact , Rollno , Sem , Branch ;
//    public final String name=null,email=null , contact=null , rollno=null , sem=null , branch=null
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

        SharedPreferences preferences = getSharedPreferences("testapp6", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("long1",false).apply();
        editor.putBoolean("badmintonSingle",false).apply();
        editor.putBoolean("badmintonDouble",false).apply();
        editor.putBoolean("basketball1",false).apply();
        editor.putBoolean("gully1",false).apply();
       editor.putBoolean("carromSingles",false).apply();
        editor.putBoolean("carromDoubles",false).apply();
        editor.putBoolean("chess1",false).apply();
        editor.putBoolean("football1",false).apply();
        editor.putBoolean("handball1",false).apply();
        editor.putBoolean("kabaddi1",false).apply();
        editor.putBoolean("khokho1",false).apply();
        editor.putBoolean("tugofwar1",false).apply();
        editor.putBoolean("volleyball1",false).apply();
        editor.putBoolean("tableS",false).apply();
        editor.putBoolean("tableD",false).apply();
        editor.putBoolean("relay1",false).apply();
        editor.putBoolean("shot1",false).apply();
        editor.putBoolean("race1",false).apply();
        editor.putBoolean("csgo1",false).apply();
        editor.putBoolean("mini1",false).apply();
        editor.putBoolean("kabaddi1",false).apply();
        editor.putBoolean("fifa1",false).apply();
        editor.putBoolean("ludo1",false).apply();
        editor.putBoolean("tank1",false).apply();

            vp = (ViewPager) findViewById(R.id.viewPager);
            this.addPages();
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setupWithViewPager(vp);
            tabLayout.setOnTabSelectedListener(this);
    //    DatabaseReference mRef= FirebaseDatabase.getInstance().getReference("Game");
            //app open directly



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    /*public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId(){
            case R.id.action_settings :
                Toast.makeText(this,"About us",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings1:
                Toast.makeText(this,"About us",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
    private void addPages()
    {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new MyActivity());
        pagerAdapter.addFragment(new Events());
        pagerAdapter.addFragment(new Schedule());
        pagerAdapter.addFragment(new Contacts());
         pagerAdapter.addFragment(new News());
        vp.setAdapter(pagerAdapter);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Intent it = new Intent(this,Aboutus.class);
            startActivity(it);
        }
        else if(id == R.id.action_settings1)
        {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.examplea.prageet.myapplication");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
