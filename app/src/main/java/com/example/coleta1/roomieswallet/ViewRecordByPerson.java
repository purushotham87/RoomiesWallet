package com.example.coleta1.roomieswallet;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coleta1 on 6/5/15.
 */
public class ViewRecordByPerson extends ActionBarActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ByPerson> persons;
    static View.OnClickListener myOnClickListener;

    DBAdapter db = new DBAdapter(this);

    private Button Date,Description,Person,Amount;
    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_records_byperson);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.drawable.icon1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e353f")));
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        //actionBar.setIcon(R.drawable.icon1);


        Date =(Button)findViewById(R.id.date);
        Description =(Button)findViewById(R.id.description);
        Person =(Button)findViewById(R.id.person);
        Amount =(Button)findViewById(R.id.amount);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Date.setTypeface(font);
        Description.setTypeface(font);
        Person.setTypeface(font);
        Amount.setTypeface(font);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        persons = new ArrayList<ByPerson>();
        List<RoomieWallet> cards = db.getAllDetailsByPerson();
        for (RoomieWallet roomieWallet : cards) {


            String date = roomieWallet.getDate();

            String description = roomieWallet.getDescription();

            String person = roomieWallet.getPerson();


            String person_amount = roomieWallet.getPerson_amount();



            persons.add(new ByPerson(date, description, person,person_amount));
            count++;
        }
        if(count==0)
        {
            Toast.makeText(getApplicationContext(), "Please add atleast one Item..!!", Toast.LENGTH_LONG).show();
            finish();

        }

        adapter = new MyAdapterByPerson(persons);
        recyclerView.setAdapter(adapter);
    }
}