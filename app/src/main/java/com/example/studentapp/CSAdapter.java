package com.example.studentapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class CSAdapter extends RecyclerView.Adapter<CSAdapter.MyViewHolder> {
    ArrayList<event> list;
    public OnEventClickListener listener;
    DatabaseReference reference;
    private FirebaseUser user;
    private static String currentUser;


    public CSAdapter(ArrayList<event> list, OnEventClickListener listener) {
        this.list = list;
        this.listener = listener;
        reference= FirebaseDatabase.getInstance().getReference();
       // user = FirebaseAuth.getInstance().getCurrentUser();
       // currentUser = user.getDisplayName();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.event_row,parent,false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textEventName.setText(list.get(position).getName());
        holder.textDate.setText(list.get(position).getDate());

//        holder.dlt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String Event = list.get(position).getDate();
//                reference.child("Club").child(currentUser).child("Club Service").child(Event).removeValue();
//                reference.child("EventList").child(Event +" "+ currentUser+" CS").removeValue();
//                reference.child("CSBanner").child(Event +" "+ currentUser).removeValue();
//            }
//        });

        holder.expandableDescription.setText(list.get(position).getDescription());
        holder.expandableDescription.setOnStateChangeListener(new ExpandableTextView.OnStateChangeListener() {
            @Override
            public void onStateChange(boolean isShrink) {
                event item = list.get(position);
                item.setShrink(isShrink);
                list.set(position,item);
            }
        });
        holder.expandableDescription.setText(list.get(position).getDescription());
        holder.expandableDescription.resetState(list.get(position).isShrink);
        holder.bind(list.get(position),listener);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textEventName;
        TextView textDate;
        ExpandableTextView expandableDescription;
        ImageView dlt;
        //
        ImageSlider imageSlider;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textEventName = itemView.findViewById(R.id.eventName);
            textDate = itemView.findViewById(R.id.date);
            expandableDescription = itemView.findViewById(R.id.expandable_description);
            imageSlider=itemView.findViewById(R.id.image_slider);
           // dlt = itemView.findViewById(R.id.dltEvent);
        }
        public void bind(final event item, final OnEventClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    listener.onItemClicked(item);
                }
            });
        }
    }
}
