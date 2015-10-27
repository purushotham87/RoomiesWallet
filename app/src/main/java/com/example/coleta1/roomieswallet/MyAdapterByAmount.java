package com.example.coleta1.roomieswallet;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class MyAdapterByAmount extends RecyclerView.Adapter<MyAdapterByAmount.MyViewHolder> {

    private ArrayList<ByAmounts> peopleDataSet;
    public Typeface type,type_lato;

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewDate;

        TextView textViewAnjiAmount;
        TextView textViewKesavAmount;
        TextView textViewTrinadhAmount;
        TextView textViewSujithAmount;
        TextView textViewVickyAmount;
        TextView textViewChakriAmount;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);

            this.textViewAnjiAmount = (TextView) itemView.findViewById(R.id.textViewAnji);
            this.textViewKesavAmount = (TextView) itemView.findViewById(R.id.textViewKesav);
            this.textViewTrinadhAmount = (TextView) itemView.findViewById(R.id.textViewTrinadh);
            this.textViewSujithAmount = (TextView) itemView.findViewById(R.id.textViewSujith);
            this.textViewVickyAmount = (TextView) itemView.findViewById(R.id.textViewVicky);
            this.textViewChakriAmount = (TextView) itemView.findViewById(R.id.textViewChakri);

        }
    }

    public MyAdapterByAmount(ArrayList<ByAmounts> people) {
        this.peopleDataSet = people;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout_byamount, parent, false);

        type= Typeface.createFromAsset(parent.getContext().getAssets(), "fontawesome-webfont.ttf");
        type_lato= Typeface.createFromAsset(parent.getContext().getAssets(), "helvetica-neue.ttf");
        view.setOnClickListener(ViewRecordByAmount.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewDate = holder.textViewDate;

        TextView textViewAnjiAmount = holder.textViewAnjiAmount;
        TextView textViewKesavAmount = holder.textViewKesavAmount;
        TextView textViewTrinadhAmount = holder.textViewTrinadhAmount;
        TextView textViewSujithAmount = holder.textViewSujithAmount;
        TextView textViewVickyAmount = holder.textViewVickyAmount;
        TextView textViewChakriAmount = holder.textViewChakriAmount;






        textViewDate.setTypeface(type_lato);
        textViewAnjiAmount.setTypeface(type_lato);
        textViewKesavAmount.setTypeface(type_lato);
        textViewTrinadhAmount.setTypeface(type_lato);
        textViewSujithAmount.setTypeface(type_lato);
        textViewVickyAmount.setTypeface(type_lato);
        textViewChakriAmount.setTypeface(type_lato);




        textViewDate.setText(peopleDataSet.get(listPosition).getDate());
        textViewAnjiAmount.setText(peopleDataSet.get(listPosition).getAnji_amount());
        textViewKesavAmount.setText(peopleDataSet.get(listPosition).getKesav_amount());
        textViewTrinadhAmount.setText(peopleDataSet.get(listPosition).getTrinadh_amount());
        textViewSujithAmount.setText(peopleDataSet.get(listPosition).getSujith_amount());
        textViewVickyAmount.setText(peopleDataSet.get(listPosition).getVicky_amount());
        textViewChakriAmount.setText(peopleDataSet.get(listPosition).getChakri_amount());

    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }
}
