package com.example.studentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class club_fragment extends Fragment {


    public club_fragment() {
        // Required empty public constructor
    }

    RecyclerView rcv;
    AllclubAdapter adapter;
    ArrayList<Allclub> list;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_club_fragment, container, false);
       // Toast.makeText(getContext(), "enter2", Toast.LENGTH_SHORT).show();
        rcv=v.findViewById(R.id.recview1);
       // Toast.makeText(getContext(), "enter4", Toast.LENGTH_SHORT).show();

        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
      //  Toast.makeText(getContext(), "enter5", Toast.LENGTH_SHORT).show();


        list= new ArrayList<>();
       adapter=new AllclubAdapter(list,getContext());
     //   Toast.makeText(getContext(), "enter4", Toast.LENGTH_SHORT).show();

        reference= FirebaseDatabase.getInstance().getReference();
       reference.child("Club").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot dataSnapshot: snapshot.getChildren())
               {
                   Allclub model=dataSnapshot.child("Profile").getValue(Allclub.class);
                   list.add(model);
               }
               adapter.notifyDataSetChanged();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
      //  Toast.makeText(getContext(), "enter5", Toast.LENGTH_SHORT).show();


        // adapter=new myadapter(dataqueue());

        rcv.setAdapter(adapter);
   //     Toast.makeText(getContext(), "enter6", Toast.LENGTH_SHORT).show();
/*
        Button b1=v.findViewById(R.id.dept);
        Toast.makeText(getContext(), "enter7", Toast.LENGTH_SHORT).show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(getContext(),b1);
                popupMenu.getMenuInflater().inflate(R.menu.dept_popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch(menuItem.getItemId())
                        {
                            case R.id.it:
                                Toast.makeText(getContext(),"ITtttttttttttt",Toast.LENGTH_LONG).show();

                                break;
                            case R.id.cse:
                                Toast.makeText(getContext(),"Cseeeeee",Toast.LENGTH_LONG).show();
                                break;
                        }

                        Toast.makeText(getContext(), "enter", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();

            }
        });
        */

        Toast.makeText(getContext(), "enter8", Toast.LENGTH_SHORT).show();
/*
        Button b=v.findViewById(R.id.type);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(getContext(),b);
                popupMenu.getMenuInflater().inflate(R.menu.type_popup_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId())
                        {
                            case R.id.item1:
                                Toast.makeText(getContext(),"techical",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(getContext(),"nontechical",Toast.LENGTH_LONG).show();
                                break;
                        }
                        Toast.makeText(getContext(), "enter9", Toast.LENGTH_SHORT).show();




                        return true;
                    }
                });
                Toast.makeText(getContext(), "enter10", Toast.LENGTH_SHORT).show();

                popupMenu.show();
            }
        });*/
        Toast.makeText(getContext(), "enter9", Toast.LENGTH_SHORT).show();


        return v;
    }
 /*   public ArrayList<Model> dataqueue()
    {

        ArrayList<Model> holder=new ArrayList<>();
        Model ob2=new Model();
        ob2.setHeader("SAIT");
        ob2.setDesc("Technical");
        ob2.setImgname(R.drawable.sait);
        holder.add(ob2);



        Model ob1=new Model();
        ob1.setHeader("WLUG");
        ob1.setDesc("Technical");
        ob1.setImgname(R.drawable.wlug);
        holder.add(ob1);



        Model ob3=new Model();
        ob3.setHeader("PACE");
        ob3.setDesc("Non-technical");
        ob3.setImgname(R.drawable.pace);
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setHeader("GDSC");
        ob4.setDesc("Technical");
        ob4.setImgname(R.drawable.gdsc);
        holder.add(ob4);


        Model ob5=new Model();
        ob5.setHeader("ACM");
        ob5.setDesc("Technical");
        ob5.setImgname(R.drawable.acm);
        holder.add(ob5);


        Model ob6=new Model();
        ob6.setHeader("Art circle");
        ob6.setDesc("Non-Technical");
        ob6.setImgname(R.drawable.artcircle);
        holder.add(ob6);




        return holder;
    }

  */

}