package com.examplea.prageet.myapplication.mListView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Contact_Data;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapterContacts extends BaseAdapter {

    Context c;
    ArrayList<Contact_Data> arrayContacts;
    LayoutInflater inflater;

    public CustomAdapterContacts(Context c, ArrayList<Contact_Data> arrayContacts) {
        this.c = c;
        this.arrayContacts = arrayContacts;
    }

    @Override
    public int getCount() {
        return arrayContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.demo1, viewGroup, false);

        }
        TextView nametxt = (TextView) view.findViewById(R.id.name);
        ImageView img1 = (ImageView) view.findViewById(R.id.contact);
        TextView numbertxt = (TextView) view.findViewById(R.id.number);
        ImageView img2 = (ImageView) view.findViewById(R.id.phone);


        final String name = arrayContacts.get(i).getName();
        final String number = arrayContacts.get(i).getNumber();
        int image1 = arrayContacts.get(i).getImage1();
        int image2 = arrayContacts.get(i).getImage2();

        nametxt.setText(name);
        numbertxt.setText(number);
        img1.setImageResource(image1);
        img2.setImageResource(image2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"+91"+number));
                try {
                    c.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(c, "Could not Load Number to place the call.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
