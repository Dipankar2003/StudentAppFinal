package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class slideadapter extends RecyclerView.Adapter<slideadapter.sliderviewholder> {

    private List<slideitem> slideitems;
    private ViewPager2 viewPager2;


    @NonNull
    @Override
    public sliderviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new sliderviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull sliderviewholder holder, int position) {
        holder.setImage(slideitems.get(position));
        if(position==slideitems.size()-2)
        {
            viewPager2.post(runnable);
        }
    }

    public slideadapter(List<slideitem> slideitems, ViewPager2 viewPager2) {
        this.slideitems = slideitems;
        this.viewPager2 = viewPager2;
    }

    @Override
    public int getItemCount() {
        return slideitems.size();
    }

    class sliderviewholder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;

        public sliderviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageslide);
        }

        void setImage(slideitem sliderItem) {


            Glide.with(imageView.getContext()).load(sliderItem.getImage()).into(imageView);
           // imageView.setImageResource(sliderItem.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideitems.addAll(slideitems);
            notifyDataSetChanged();
        }
    };

}




