package com.example.studentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class calender_list_adapter extends RecyclerView.Adapter<calender_list_adapter.calendar_list_ViewHolder> {
    ArrayList<StudentEventList> list;
    public OnEventClickListener listener;
    Context context;
    public calender_list_adapter(ArrayList<StudentEventList> list, OnEventClickListener listener)
    {
        this.list = list;
        this.listener=listener;
        //this.Club_data = Club_data;
    }



    @NonNull
    @Override
    public calendar_list_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.calendar_list_layout, parent,false);
        return new calendar_list_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull calendar_list_ViewHolder holder, int position) {

       // String Event_name = Event_data[position];
        //String Club_name = Club_data[position];
       // holder.EventName.setText(Event_name);
        //holder.ClubName.setText(Club_name);
        holder.EventName.setText(list.get(position).getName());
       // Toast.makeText(EventName.getContext(), holder.EventName, Toast.LENGTH_SHORT).show();
      //  holder.ClubLink.setText(list.get(position).getLink());
        holder.ClubName.setText(list.get(position).getClub());
        holder.Date.setText(list.get(position).getDate());



//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), holder.EventName.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class calendar_list_ViewHolder extends RecyclerView.ViewHolder{

        TextView Date;
        TextView EventName;
        TextView ClubName;
        TextView ClubLink;
        public calendar_list_ViewHolder(@NonNull View itemView) {
            super(itemView);
            EventName = itemView.findViewById(R.id.eventName);
            ClubName = itemView.findViewById(R.id.clubName);
           // ClubLink = itemView.findViewById(R.id.clubLink);
            Date = itemView.findViewById(R.id.date);
        }
    }


}
