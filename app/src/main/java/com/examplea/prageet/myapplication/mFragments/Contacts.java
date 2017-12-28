package com.examplea.prageet.myapplication.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.examplea.prageet.myapplication.R;
import com.examplea.prageet.myapplication.mData.Contact_Data;
import com.examplea.prageet.myapplication.mListView.CustomAdapterContacts;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class Contacts extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts_fragment,container,false);

        ListView lv = (ListView) rootView.findViewById(R.id.contact_list);
        CustomAdapterContacts adapter = new CustomAdapterContacts(this.getActivity(),getContacts());

        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Contact_Data> getContacts()
    {
        ArrayList<Contact_Data> arrayContacts = new ArrayList<>();

        Contact_Data contact = new Contact_Data("Anuj Jain","9799301038",R.drawable.headcod5,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Siddharth Sharma","8560838537",R.drawable.headcod6,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Aunrag Jarwal","8559998319",R.drawable.headcod1,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Vishwas Chaturvedi","9414572127",R.drawable.headcod4,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Chandrashekhar Yadav","9482872560",R.drawable.icon1,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Devansh Jain","9649237264",R.drawable.headcod7,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Rutushree Agarwal","9529016485",R.drawable.headcod2,R.drawable.phone);
        arrayContacts.add(contact);
        contact = new Contact_Data("Ujjwal Bajaj","9829063727",R.drawable.headcod3,R.drawable.phone);
        arrayContacts.add(contact);



        return arrayContacts;

    }

    public String toString()
    {
        String title = "H.C.";
        return title;
    }
}
