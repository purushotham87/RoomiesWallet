package com.example.coleta1.roomieswallet;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class MyAdapterByPerson extends RecyclerView.Adapter<MyAdapterByPerson.MyViewHolder> {

    private ArrayList<ByPerson> peopleDataSet;
    public Typeface type,type_lato;

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewDate;
        TextView textViewDescription;
        TextView textViewPerson;
        TextView textViewPersonAmount;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            this.textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            this.textViewPerson = (TextView) itemView.findViewById(R.id.textViewPerson);
            this.textViewPersonAmount = (TextView) itemView.findViewById(R.id.textViewPersonAmount);

        }
    }

    public MyAdapterByPerson(ArrayList<ByPerson> people) {
        this.peopleDataSet = people;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout_byperson, parent, false);

        type= Typeface.createFromAsset(parent.getContext().getAssets(), "fontawesome-webfont.ttf");
        type_lato= Typeface.createFromAsset(parent.getContext().getAssets(), "helvetica-neue.ttf");
        view.setOnClickListener(ViewRecordByPerson.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewDate = holder.textViewDate;
        TextView textViewDescription = holder.textViewDescription;
        TextView textViewPerson = holder.textViewPerson;
        TextView textViewPersonAmount = holder.textViewPersonAmount;





        textViewDate.setTypeface(type_lato);
        textViewDescription.setTypeface(type_lato);
        textViewPerson.setTypeface(type_lato);
        textViewPersonAmount.setTypeface(type_lato);




        textViewDate.setText(peopleDataSet.get(listPosition).getDate());
        textViewDescription.setText(peopleDataSet.get(listPosition).getDescription());
        textViewPerson.setText(peopleDataSet.get(listPosition).getPerson());
        textViewPersonAmount.setText(peopleDataSet.get(listPosition).getPerson_amount());

    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }
}
