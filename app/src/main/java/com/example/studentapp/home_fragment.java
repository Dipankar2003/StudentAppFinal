package com.example.studentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class home_fragment extends Fragment {

    private ImageSlider imageSlider;
    private ViewPager2 viewPager2;
    private Handler slidehanlder=new Handler();

    public ArrayList<SlideModel> arrayList;
    slideadapter slideadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home_fragment, container, false);
        imageSlider=v.findViewById(R.id.imagesl);
        viewPager2=v.findViewById(R.id.viewpager);


        List<slideitem> slideitems=new ArrayList<>();
        slideadapter =new slideadapter(slideitems,viewPager2);

        FirebaseDatabase.getInstance().getReference().child("CSBanner").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                slideitems.clear();
                for(DataSnapshot data: snapshot.getChildren()){

                    String uri=data.child("Banner").getValue().toString();
                    slideitems.add(new slideitem(uri));
                }
                slideadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        List<slideitem> slideitems=new ArrayList<>();
//        slideitems.add(new slideitem(R.drawable.event));
//        slideitems.add(new slideitem(R.drawable.event));
//        slideitems.add(new slideitem(R.drawable.event));
//        slideitems.add(new slideitem(R.drawable.event));

        viewPager2.setAdapter(slideadapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer= new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slidehanlder.removeCallbacks(sliderRunnable);
                slidehanlder.postDelayed(sliderRunnable,3000);
            }
        });


        ArrayList<SlideModel> slideModels=new ArrayList<>();

       // final List<SlideModel> list=new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("EventBanner").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data: snapshot.getChildren()){

                    String uri=data.child("Banner").getValue().toString();
                    slideModels.add(new SlideModel(uri,  null));
                    imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        slideModels.add(new SlideModel(R.drawable.b1, null));
//        slideModels.add(new SlideModel(R.drawable.b1, null));
//        slideModels.add(new SlideModel(R.drawable.b1, null));
//        slideModels.add(new SlideModel(R.drawable.b1, null));
       // imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        return  v;
    }
    private  Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        slidehanlder.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        slidehanlder.postDelayed(sliderRunnable,3000);
    }

}