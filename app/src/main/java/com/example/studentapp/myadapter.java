package com.example.studentapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
        ArrayList<Model> data;
        Context context;
    public myadapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        holder.name.setText(data.get(position).getUserName());
        holder.email.setText(data.get(position).getEmail());
        Glide.with(holder.img.getContext()).load(data.get(position).getLogo().toString()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), holder.name.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),MainActivity2.class);
                intent.putExtra("CALLED_FROM",1);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView name,email;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.t1);
            email=itemView.findViewById(R.id.t2);
            img=itemView.findViewById(R.id.img1);

        }
    }

//
//
//
//    @NonNull
//    @Override
//    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//
//
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
}
