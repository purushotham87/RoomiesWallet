package com.example.coleta1.roomieswallet;

public class RoomieWallet {

    private String date;
    private String description;
    private String person;
    private String person_amount;
    private String anji_amount;
    private String kesav_amount;
    private String trinadh_amount;
    private String sujith_amount;
    private String vicky_amount;
    private String chakri_amount;

    public RoomieWallet(){

    }

    public RoomieWallet(String date,String description,String person,String person_amount,String anji_amount,String kesav_amount,String trinadh_amount,String sujith_amount,String vicky_amount,String chakri_amount){


        this.date = date;
        this.description = description;
        this.person = person;
        this.person_amount = person_amount;
        this.anji_amount = anji_amount;
        this.kesav_amount = kesav_amount;
        this.trinadh_amount = trinadh_amount;
        this.sujith_amount = sujith_amount;
        this.vicky_amount = vicky_amount;
        this.chakri_amount = chakri_amount;

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
    public String getAnji_amount() {
        return anji_amount;
    }
    public void setAnji_amount(String anji_amount) {
        this.anji_amount = anji_amount;
    }
    public String getKesav_amount() {
        return kesav_amount;
    }
    public void setKesav_amount(String kesav_amount) {
        this.kesav_amount = kesav_amount;
    }
    public String getTrinadh_amount() {
        return trinadh_amount;
    }
    public void setTrinadh_amount(String trinadh_amount) {
        this.trinadh_amount = trinadh_amount;
    }
    public String getSujith_amount() {
        return sujith_amount;
    }
    public void setSujith_amount(String sujith_amount) {
        this.sujith_amount = sujith_amount;
    }
    public String getVicky_amount() {
        return vicky_amount;
    }
    public void setVicky_amount(String vicky_amount) {
        this.vicky_amount = vicky_amount;
    }
    public String getChakri_amount() {
        return chakri_amount;
    }
    public void setChakri_amount(String chakri_amount) {
        this.chakri_amount = chakri_amount;
    }





}