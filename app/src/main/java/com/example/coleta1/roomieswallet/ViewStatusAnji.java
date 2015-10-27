package com.example.coleta1.roomieswallet;

import android.content.Intent;
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
 * Created by chakri on 6/5/15.
 */
public class ViewStatusAnji extends ActionBarActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ByPersonStatus> status;
    static View.OnClickListener myOnClickListener;
    public int count=0;
    public int credit1 = 0;
    public int debit1 = 0;
    public int status1 = 0;

    public String credit = ""+0;
    public String debit = ""+0;
    public String status2 = ""+0;

    private Button Whatsapp,Message;

    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_anji_status);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.drawable.icon1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e353f")));
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        //actionBar.setIcon(R.drawable.icon1);

        Whatsapp = (Button)findViewById(R.id.whatsapp);
        Message = (Button)findViewById(R.id.message);
        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Whatsapp.setTypeface(font);
        Message.setTypeface(font);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        status = new ArrayList<ByPersonStatus>();
        List<RoomieWallet> cards = db.getAllDetailsByCreditAnji();
        for (RoomieWallet roomieWallet : cards) {

            credit1 = credit1 + Integer.parseInt(roomieWallet.getPerson_amount());

            if(roomieWallet.getPerson_amount().length()==0){

                credit1=0;
            }

            credit = ""+credit1;
            Log.d("Credit",""+credit);
            Log.d("Credit1",""+credit1);


            count++;
        }

        List<RoomieWallet> cards1 = db.getAllDetailsByDebitAnji();
        for (RoomieWallet roomieWallet : cards1) {

            debit1 = debit1 + Integer.parseInt(roomieWallet.getAnji_amount());

            debit = ""+debit1;

            count++;
        }



        status1 = credit1-debit1;
        status2=""+status1;




        status.add(new ByPersonStatus(credit, debit, status2));
        if(count==0)
        {
            Toast.makeText(getApplicationContext(), "Please add atleast one Item..!!", Toast.LENGTH_LONG).show();
            finish();

        }

        Whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String shareBody = "Hi Anji,Your Room Bill was : Rs."+status2;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Text caption message!!");
                intent.setType("text/plain");

                intent.setPackage("com.whatsapp");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Room Bill");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(intent);

            }

        });

        Message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String shareBody = "Hi Anji,Your Room Bill was : Rs."+status2;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Text caption message!!");
                intent.setType("text/plain");
                intent.setPackage("com.mms");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Room Bill");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(intent);

            }

        });

        adapter = new MyAdapterByAnji(status);
        recyclerView.setAdapter(adapter);
    }
}
