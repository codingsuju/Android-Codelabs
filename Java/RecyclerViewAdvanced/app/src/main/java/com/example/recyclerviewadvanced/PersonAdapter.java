package com.example.recyclerviewadvanced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter{
    ItemClicked activity;
    private ArrayList<Person> people;
    private ArrayList<String> topic;
    public interface ItemClicked{
        void onItemSelected(int index,int viewType);
    }
    public PersonAdapter(Context context, ArrayList<Person> list,ArrayList<String> t) {
        people=list;
        topic=t;
        activity=(ItemClicked)context;
    }

    @Override
    public int getItemViewType(int position) {
        if((position%5 )==0){
            return 0;
        }
        else
            return 1;
    }

    public class ViewHolderOne extends RecyclerView.ViewHolder{
        TextView tvTopic;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tvTopic=itemView.findViewById(R.id.tvTopic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  activity.onItemSelected(topic.indexOf((String)v.getTag()),0);
                }
            });
        }
    }
    public class ViewHolderTwo extends RecyclerView.ViewHolder{
        ImageView ivPref;
        TextView tvName,tvSurname;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvSurname=itemView.findViewById(R.id.tvSurname);
            ivPref=itemView.findViewById(R.id.ivPref);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemSelected(people.indexOf((Person)v.getTag()),1);
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        if(viewType==0){
            View v;
            v=inflater.inflate(R.layout.list_items,parent,false);
            return new ViewHolderOne(v);
        }
        else{
            View v;
            v=inflater.inflate(R.layout.list_item_extra,parent,false);
            return new ViewHolderTwo(v);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       //holder.itemView.setTag(people.get(position));
       if((position%5)==0)
        {
           ViewHolderOne viewHolderOne=(ViewHolderOne) holder;
            Integer pos=position/5;
            viewHolderOne.itemView.setTag(topic.get(pos));
            viewHolderOne.tvTopic.setText(topic.get(pos).toString());
       }
       else{
            ViewHolderTwo viewHolderTwo=(ViewHolderTwo)holder;
            viewHolderTwo.itemView.setTag(people.get(position));
            viewHolderTwo.tvName.setText(people.get(position).getName());
            viewHolderTwo.tvSurname.setText(people.get(position).getSurname());
            viewHolderTwo.ivPref.setImageResource(R.drawable.account);
       }
    }
    // Returns the number of Items to display in recyclerView
    @Override
    public int getItemCount() {
        Integer x=topic.size();
        Integer y=people.size();
        x=x*5;
        if(x<y)
            return x;
        return y;
    }
}
