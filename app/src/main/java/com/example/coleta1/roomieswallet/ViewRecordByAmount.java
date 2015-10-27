package com.example.coleta1.roomieswallet;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coleta1 on 6/5/15.
 */
public class ViewRecordByAmount extends ActionBarActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ByAmounts> amounts;
    static View.OnClickListener myOnClickListener;

    DBAdapter db = new DBAdapter(this);


    private Button Date,Anji,Kesav,Trinadh,Sujith,Vicky,Chakri;
    public int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_records_byamount);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.drawable.icon1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e353f")));
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        //actionBar.setIcon(R.drawable.icon1);

        Date =(Button)findViewById(R.id.date);
        Anji =(Button)findViewById(R.id.anji_amount);
        Kesav =(Button)findViewById(R.id.kesav_amount);
        Trinadh =(Button)findViewById(R.id.trinadh_amount);
        Sujith =(Button)findViewById(R.id.sujith_amount);
        Vicky =(Button)findViewById(R.id.vicky_amount);
        Chakri =(Button)findViewById(R.id.chakri_amount);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Date.setTypeface(font);
        Anji.setTypeface(font);
        Kesav.setTypeface(font);
        Trinadh.setTypeface(font);
        Sujith.setTypeface(font);
        Vicky.setTypeface(font);
        Chakri.setTypeface(font);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        amounts = new ArrayList<ByAmounts>();
        List<RoomieWallet> cards = db.getAllDetailsByAmount();
        for (RoomieWallet roomieWallet : cards) {


            String date = roomieWallet.getDate();
            String anji_amount = roomieWallet.getAnji_amount();
            String kesav_amount = roomieWallet.getKesav_amount();
            String trinadh_amount = roomieWallet.getTrinadh_amount();
            String sujith_amount = roomieWallet.getSujith_amount();
            String vicky_amount = roomieWallet.getVicky_amount();
            String chakri_amount = roomieWallet.getChakri_amount();




            amounts.add(new ByAmounts(date, anji_amount, kesav_amount,trinadh_amount,sujith_amount,vicky_amount,chakri_amount));
            count++;
        }
        if(count==0)
        {
            Toast.makeText(getApplicationContext(), "Please add atleast one Item..!!", Toast.LENGTH_LONG).show();
            finish();

        }

        adapter = new MyAdapterByAmount(amounts);
        recyclerView.setAdapter(adapter);
    }

}
