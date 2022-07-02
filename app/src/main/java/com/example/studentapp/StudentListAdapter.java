package com.example.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {
    ArrayList<StudentEventList> arrayList;

    public StudentListAdapter(ArrayList<StudentEventList> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.calendar_list_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.EventName.setText(arrayList.get(position).getClub());
        holder.ClubName.setText(arrayList.get(position).getName());
        holder.Date.setText(arrayList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String link=arrayList.get(position).getLink().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                view.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Date;
        TextView EventName;
        TextView ClubName;
        TextView ClubLink;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            EventName = itemView.findViewById(R.id.eventName);
            ClubName = itemView.findViewById(R.id.clubName);
         //   ClubLink = itemView.findViewById(R.id.clubLink);
            Date = itemView.findViewById(R.id.date);
        }
    }
}
