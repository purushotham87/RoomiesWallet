package com.example.coleta1.roomieswallet;

import android.graphics.Bitmap;

public class ByPerson {
    private String date;
    private String description;
    private String person;
    private String person_amount;

    public ByPerson(String date,String description,String person,String person_amount){


        this.date = date;
        this.description = description;
        this.person = person;
        this.person_amount = person_amount;
    }


    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }

    public String getPerson_amount() {
        return person_amount;
    }
    public void setPerson_amount(String person_amount) {
        this.person_amount = person_amount;
    }



}