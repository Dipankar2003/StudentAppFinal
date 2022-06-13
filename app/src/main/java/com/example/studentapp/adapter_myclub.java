package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_myclub extends RecyclerView.Adapter<myviewholder> {

    ArrayList<Model> data;
    public adapter_myclub (ArrayList<Model> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
       // holder.t1.setText(data.get(position).getHeader());
       // holder.t2.setText(data.get(position).getDesc());
      //  holder.img.setImageResource(data.get(position).getImgname());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), holder.t1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
