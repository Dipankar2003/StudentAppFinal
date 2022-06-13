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

import de.hdodenhof.circleimageview.CircleImageView;

public class AllclubAdapter extends RecyclerView.Adapter<AllclubAdapter.MyViewHolder> {
    ArrayList<Allclub> list;
    Context context;

    public AllclubAdapter(ArrayList<Allclub> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row,parent,false);
        return  new AllclubAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position).getUserName());
        holder.email.setText(list.get(position).getEmail());
        Glide.with(holder.img.getContext()).load(list.get(position).getLogo()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), holder.name.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),MainActivity2.class);
                intent.putExtra("CALLED_FROM",1);
                intent.putExtra("student",list.get(position).getUserName());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email;
        CircleImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.t1);
            email=itemView.findViewById(R.id.t2);
            img=itemView.findViewById(R.id.img1);
        }
    }
}
