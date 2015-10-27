package com.example.coleta1.roomieswallet;


import android.app.DatePickerDialog;
import android.app.Dialog;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ParseException;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chakri on 5/5/15.
 */
public class AddItem extends ActionBarActivity {

    private TextView Calendar,Select,Add;
    private EditText  Date,Description,PersonAmount,Anji_EditText,Kesav_EditText,Trinadh_EditText,Sujith_EditText,Vicky_EditText,Chakri_EditText;
    private CheckBox Anji_Radio,Kesav_Radio,Trinadh_Radio,Sujith_Radio,Vicky_Radio,Chakri_Radio;
    private AutoCompleteTextView Person;
    private Button Go,Update;
    public String cdate;
    public int count = 0;
    private DBAdapter DbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
       // actionBar.setLogo(R.drawable.icon1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e353f")));
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        //actionBar.setIcon(R.drawable.icon1);


        String[] bus_numbers = getResources().
                getStringArray(R.array.list_of_names);
        ArrayAdapter adapter = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,bus_numbers);
        Person = (AutoCompleteTextView) findViewById(R.id.person);
        Person.setAdapter(adapter);
        Typeface font2= Typeface.createFromAsset(getAssets(), "helvetica-neue.ttf");
        Person.setTypeface(font2);



        DbHelper = new DBAdapter(this);

        Calendar = (TextView)findViewById(R.id.calendar);
        Select = (TextView)findViewById(R.id.select);
        Add = (TextView)findViewById(R.id.add);

        Date = (EditText)findViewById(R.id.date);
        Date.setKeyListener(null);
        Description = (EditText)findViewById(R.id.description);

        PersonAmount = (EditText)findViewById(R.id.amount);
        Anji_EditText = (EditText)findViewById(R.id.anji_amount);
        Kesav_EditText = (EditText)findViewById(R.id.kesav_amount);
        Trinadh_EditText = (EditText)findViewById(R.id.trinadh_amount);
        Sujith_EditText = (EditText)findViewById(R.id.sujith_amount);
        Vicky_EditText = (EditText)findViewById(R.id.vicky_amount);
        Chakri_EditText = (EditText)findViewById(R.id.chakri_amount);

        Anji_Radio = (CheckBox)findViewById(R.id.anji);
        Kesav_Radio = (CheckBox)findViewById(R.id.kesav);
        Trinadh_Radio = (CheckBox)findViewById(R.id.trinadh);
        Sujith_Radio = (CheckBox)findViewById(R.id.sujith);
        Vicky_Radio = (CheckBox)findViewById(R.id.vicky);
        Chakri_Radio = (CheckBox)findViewById(R.id.chakri);

        Go = (Button)findViewById(R.id.go);
        Update = (Button)findViewById(R.id.update);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Typeface type_lato= Typeface.createFromAsset(getAssets(), "helvetica-neue.ttf");

        Calendar.setTypeface(font);
        PersonAmount.setTypeface(font);
        Anji_EditText.setTypeface(font);
        Kesav_EditText.setTypeface(font);
        Trinadh_EditText.setTypeface(font);
        Sujith_EditText.setTypeface(font);
        Vicky_EditText.setTypeface(font);
        Chakri_EditText.setTypeface(font);
        Go.setTypeface(font);
        Update.setTypeface(font);

        Anji_EditText.setVisibility(View.GONE);
        Kesav_EditText.setVisibility(View.GONE);
        Trinadh_EditText.setVisibility(View.GONE);
        Sujith_EditText.setVisibility(View.GONE);
        Vicky_EditText.setVisibility(View.GONE);
        Chakri_EditText.setVisibility(View.GONE);


        Anji_Radio.setTypeface(type_lato);
        Kesav_Radio.setTypeface(type_lato);
        Trinadh_Radio.setTypeface(type_lato);
        Sujith_Radio.setTypeface(type_lato);
        Vicky_Radio.setTypeface(type_lato);
        Chakri_Radio.setTypeface(type_lato);
        Select.setTypeface(type_lato);
        Add.setTypeface(type_lato);






        Date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date.setError(null);
            }
        });
        Person.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Person.setError(null);
            }
        });
        PersonAmount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                PersonAmount.setError(null);
            }
        });
        Description.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Description.setError(null);
            }
        });





        Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Date.setError(null);
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getSupportFragmentManager(), "DatePicker");


            }
        });


        Go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(PersonAmount.length()==0){

                    PersonAmount.setText(String.valueOf(0));
                }


                if(Anji_Radio.isChecked()){

                    count++;
                }

                if(Kesav_Radio.isChecked()){

                    count++;
                }

                if(Trinadh_Radio.isChecked()){

                    count++;
                }
                if(Sujith_Radio.isChecked()){

                    count++;
                }
                if(Vicky_Radio.isChecked()){

                    count++;
                }
                if(Chakri_Radio.isChecked()){

                    count++;
                }

                String person_amount = PersonAmount.getText().toString();

                if(Anji_Radio.isChecked()){

                   int anji_amount = (Integer.parseInt(person_amount)/count);
                    Anji_EditText.setVisibility(View.VISIBLE);
                    Anji_EditText.setText(String.valueOf(anji_amount));
                }else{

                    Anji_EditText.setVisibility(View.VISIBLE);
                    Anji_EditText.setText(String.valueOf(0));
                }
                if(Kesav_Radio.isChecked()){

                    int kesav_amount = (Integer.parseInt(person_amount)/count);
                    Kesav_EditText.setVisibility(View.VISIBLE);
                    Kesav_EditText.setText(String.valueOf(kesav_amount));
                }else{

                    Kesav_EditText.setVisibility(View.VISIBLE);
                    Kesav_EditText.setText(String.valueOf(0));
                }
                if(Trinadh_Radio.isChecked()){

                    int trinadh_amount = (Integer.parseInt(person_amount)/count);
                    Trinadh_EditText.setVisibility(View.VISIBLE);
                    Trinadh_EditText.setText(String.valueOf(trinadh_amount));
                }else{

                    Trinadh_EditText.setVisibility(View.VISIBLE);
                    Trinadh_EditText.setText(String.valueOf(0));
                }
                if(Sujith_Radio.isChecked()){

                    int sujith_amount = (Integer.parseInt(person_amount)/count);
                    Sujith_EditText.setVisibility(View.VISIBLE);
                    Sujith_EditText.setText(String.valueOf(sujith_amount));
                }else{

                    Sujith_EditText.setVisibility(View.VISIBLE);
                    Sujith_EditText.setText(String.valueOf(0));
                }
                if(Vicky_Radio.isChecked()){

                    int vicky_amount = (Integer.parseInt(person_amount)/count);
                    Vicky_EditText.setVisibility(View.VISIBLE);
                    Vicky_EditText.setText(String.valueOf(vicky_amount));
                }else{

                    Vicky_EditText.setVisibility(View.VISIBLE);
                    Vicky_EditText.setText(String.valueOf(0));
                }
                if(Chakri_Radio.isChecked()){

                    int chakri_amount = (Integer.parseInt(person_amount)/count);
                    Chakri_EditText.setVisibility(View.VISIBLE);
                    Chakri_EditText.setText(String.valueOf(chakri_amount));
                }else{

                    Chakri_EditText.setVisibility(View.VISIBLE);
                    Chakri_EditText.setText(String.valueOf(0));
                }

                count=0;

            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String date1 = Date.getText().toString();
                final String description1 = Description.getText().toString();
                final String person1 = Person.getText().toString();
                final String person_amountt1 = PersonAmount.getText().toString();
                final String anji_amountt1 = Anji_EditText.getText().toString();
                final String kesav_amountt1 = Kesav_EditText.getText().toString();
                final String trinadh_amountt1 = Trinadh_EditText.getText().toString();
                final String sujith_amountt1 = Sujith_EditText.getText().toString();
                final String vicky_amountt1 = Vicky_EditText.getText().toString();
                final String chakri_amountt1 = Chakri_EditText.getText().toString();

                if (date1.length() == 0) {
                    Date.requestFocus();
                    Date.setError("Field Cannot Be Empty");
                }
                else if (description1.length() == 0) {
                    Description.requestFocus();
                    Description.setError("Field Cannot Be Empty");
                }
                else if (person1.length() == 0) {
                    Person.requestFocus();
                    Person.setError("Field Cannot Be Empty");
                }
                else if (person_amountt1.length() == 0) {
                    PersonAmount.requestFocus();
                    PersonAmount.setError("Field Cannot Be Empty");
                }
                else if (anji_amountt1.length() == 0) {
                    Anji_EditText.requestFocus();
                    Anji_EditText.setError("Field Cannot Be Empty");
                }
                else if (kesav_amountt1.length() == 0) {
                    Kesav_EditText.requestFocus();
                    Kesav_EditText.setError("Field Cannot Be Empty");
                }
                else if (trinadh_amountt1.length() == 0) {
                    Trinadh_EditText.requestFocus();
                    Trinadh_EditText.setError("Field Cannot Be Empty");
                }
                else if (sujith_amountt1.length() == 0) {
                    Sujith_EditText.requestFocus();
                    Sujith_EditText.setError("Field Cannot Be Empty");
                }
                else if (vicky_amountt1.length() == 0) {
                    Vicky_EditText.requestFocus();
                    Vicky_EditText.setError("Field Cannot Be Empty");
                }else if (chakri_amountt1.length() == 0) {
                    Chakri_EditText.requestFocus();
                    Chakri_EditText.setError("Field Cannot Be Empty");
                }
                else if (person_amountt1.equalsIgnoreCase(""+0)) {
                    Toast.makeText(getApplicationContext(), "Please enter amount More than 0..!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    RoomieWallet roomieWallet = new RoomieWallet(date1,description1,person1,person_amountt1,anji_amountt1,kesav_amountt1,trinadh_amountt1,sujith_amountt1,vicky_amountt1,chakri_amountt1);
                    DbHelper.open();
                    DbHelper.insertItemDetails(roomieWallet);
                    Toast.makeText(getApplicationContext(), "Item Added Successfully", Toast.LENGTH_SHORT).show();
                    DbHelper.close();
                    finish();
                    roomieWallet = null;
                }

            }
        });

    }

    public void populateSetDate(int year, int month, int day) {

        Date.setText(cdate);
    }

    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final java.util.Calendar calendar = java.util.Calendar.getInstance();
            int yyyy = calendar.get(java.util.Calendar.YEAR);
            int mm = calendar.get(java.util.Calendar.MONTH);

            int dd = calendar.get(java.util.Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yyyy, mm, dd);
        }

        public void onDateSet(DatePicker view, int yyyy, int mm, int dd) {

            try{
                java.util.Date date = new Date(yyyy-1900, mm,dd);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
                cdate = formatter.format(date);
                populateSetDate(yyyy,mm+1,dd);
            }catch (ParseException e1){
                e1.printStackTrace(); }
        }
    }
}
