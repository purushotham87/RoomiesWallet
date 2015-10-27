package com.example.coleta1.roomieswallet;

import android.graphics.Bitmap;

public class ByPersonStatus {
    private String credit;
    private String debit;
    private String status;


    public ByPersonStatus(String credit,String debit,String status){


        this.credit = credit;
        this.debit = debit;
        this.status = status;

    }


    public String getCredit() {
        return credit;
    }
    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDebit() {
        return debit;
    }
    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }





}