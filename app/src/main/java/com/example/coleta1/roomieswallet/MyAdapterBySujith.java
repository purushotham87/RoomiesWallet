package com.example.coleta1.roomieswallet;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class MyAdapterBySujith extends RecyclerView.Adapter<MyAdapterBySujith.MyViewHolder> {

    private ArrayList<ByPersonStatus> peopleDataSet;
    public Typeface type,type_lato;

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewCreditIcon1;
        TextView textViewDebitIcon1;
        TextView textViewStatusIcon1;
        TextView textViewCreditIcon;
        TextView textViewDebitIcon;
        TextView textViewStatusIcon;
        TextView textViewCredit;
        TextView textViewDebit;
        TextView textViewStatus;



        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewCreditIcon1 = (TextView) itemView.findViewById(R.id.textViewCreditIcon1);
            this.textViewDebitIcon1 = (TextView) itemView.findViewById(R.id.textViewDebitIcon1);
            this.textViewStatusIcon1 = (TextView) itemView.findViewById(R.id.textViewStatusIcon1);
            this.textViewCreditIcon = (TextView) itemView.findViewById(R.id.textViewCreditIcon);
            this.textViewDebitIcon = (TextView) itemView.findViewById(R.id.textViewDebitIcon);
            this.textViewStatusIcon = (TextView) itemView.findViewById(R.id.textViewStatusIcon);
            this.textViewCredit = (TextView) itemView.findViewById(R.id.textViewCredit);
            this.textViewDebit = (TextView) itemView.findViewById(R.id.textViewDebit);
            this.textViewStatus = (TextView) itemView.findViewById(R.id.textViewStatus);

        }
    }

    public MyAdapterBySujith(ArrayList<ByPersonStatus> people) {
        this.peopleDataSet = people;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_byperson, parent, false);

        type= Typeface.createFromAsset(parent.getContext().getAssets(), "fontawesome-webfont.ttf");
        type_lato= Typeface.createFromAsset(parent.getContext().getAssets(), "helvetica-neue.ttf");
        view.setOnClickListener(ViewStatusSujith.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewCreditIcon1 = holder.textViewCreditIcon1;
        TextView textViewDebitIcon1 = holder.textViewDebitIcon1;
        TextView textViewStatusIcon1 = holder.textViewStatusIcon1;
        TextView textViewCreditIcon = holder.textViewCreditIcon;
        TextView textViewDebitIcon = holder.textViewDebitIcon;
        TextView textViewStatusIcon = holder.textViewStatusIcon;


        textViewCreditIcon1.setTypeface(type);
        textViewDebitIcon1.setTypeface(type);
        textViewStatusIcon1.setTypeface(type);

        TextView textViewCredit = holder.textViewCredit;
        TextView textViewDebit = holder.textViewDebit;
        TextView textViewStatus = holder.textViewStatus;


        textViewCreditIcon.setTypeface(type_lato);
        textViewDebitIcon.setTypeface(type_lato);
        textViewStatusIcon.setTypeface(type_lato);
        textViewCredit.setTypeface(type_lato);
        textViewDebit.setTypeface(type_lato);
        textViewStatus.setTypeface(type_lato);




        textViewCredit.setText(peopleDataSet.get(listPosition).getCredit());
        textViewDebit.setText(peopleDataSet.get(listPosition).getDebit());
        textViewStatus.setText(peopleDataSet.get(listPosition).getStatus());


    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }
}
