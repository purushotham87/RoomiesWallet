package com.example.coleta1.roomieswallet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Button AddItem,ViewRecords,PersonStatus,Anji,Kesav,Chakri,Vicky,Sujith,Trinadh,ByPerson,ByAmount;
    private TextView Roomies,Wallet;
    public int count = 0;
    public int count1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.drawable.icon1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e353f")));
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        //actionBar.setIcon(R.drawable.icon1);

        AddItem = (Button)findViewById(R.id.add_item);
        ViewRecords = (Button)findViewById(R.id.view_all);
        PersonStatus = (Button)findViewById(R.id.person_status);
        Anji = (Button)findViewById(R.id.anji);
        Kesav = (Button)findViewById(R.id.kesav);
        Chakri = (Button)findViewById(R.id.chakri);
        Vicky = (Button)findViewById(R.id.vicky);
        Sujith = (Button)findViewById(R.id.sujith);
        Trinadh = (Button)findViewById(R.id.trinadh);
        ByPerson = (Button)findViewById(R.id.by_person);
        ByAmount = (Button)findViewById(R.id.by_amount);

        Wallet = (TextView)findViewById(R.id.wallet);
        Roomies = (TextView)findViewById(R.id.roomies);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Typeface font1 = Typeface.createFromAsset(getAssets(), "SnackerComic_PerosnalUseOnly.ttf");


        AddItem.setTypeface(font);
        ViewRecords.setTypeface(font);
        PersonStatus.setTypeface(font);
        Anji.setTypeface(font);
        Kesav.setTypeface(font);
        Chakri.setTypeface(font);
        Vicky.setTypeface(font);
        Sujith.setTypeface(font);
        Trinadh.setTypeface(font);
        ByPerson.setTypeface(font);
        ByAmount.setTypeface(font);
        Roomies.setTypeface(font1);
        Wallet.setTypeface(font1);

        Anji.setVisibility(View.GONE);
        Kesav.setVisibility(View.GONE);
        Chakri.setVisibility(View.GONE);
        Vicky.setVisibility(View.GONE);
        Sujith.setVisibility(View.GONE);
        Trinadh.setVisibility(View.GONE);
        ByPerson.setVisibility(View.GONE);
        ByAmount.setVisibility(View.GONE);

        PersonStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

             if(count == 0){
                  Anji.setVisibility(View.VISIBLE);
                  Kesav.setVisibility(View.VISIBLE);
                  Chakri.setVisibility(View.VISIBLE);
                  Vicky.setVisibility(View.VISIBLE);
                  Sujith.setVisibility(View.VISIBLE);
                  Trinadh.setVisibility(View.VISIBLE);
                  count--;
              }
            else{
                 Anji.setVisibility(View.GONE);
                 Kesav.setVisibility(View.GONE);
                 Chakri.setVisibility(View.GONE);
                 Vicky.setVisibility(View.GONE);
                 Sujith.setVisibility(View.GONE);
                 Trinadh.setVisibility(View.GONE);
                 count++;

             }

            }

        });

        ViewRecords.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(count1 == 0){
                    ByPerson.setVisibility(View.VISIBLE);
                    ByAmount.setVisibility(View.VISIBLE);
                    count1--;
                }
                else{
                    ByPerson.setVisibility(View.GONE);
                    ByAmount.setVisibility(View.GONE);
                    count1++;

                }

            }

        });

        ByPerson.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewRecordByPerson.class);

                startActivity(i);


            }

        });
        ByAmount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewRecordByAmount.class);

                startActivity(i);


            }

        });


        AddItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddItem.class);

                startActivity(i);

            }

        });


        Anji.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusAnji.class);

                startActivity(i);

            }

        });

        Kesav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusKesav.class);

                startActivity(i);

            }

        });

        Trinadh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusTrinadh.class);

                startActivity(i);

            }

        });

        Sujith.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusSujith.class);

                startActivity(i);

            }

        });

        Vicky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusVicky.class);

                startActivity(i);

            }

        });


        Chakri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewStatusChakri.class);

                startActivity(i);

            }

        });


    }





























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
