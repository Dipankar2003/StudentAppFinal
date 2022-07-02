package com.example.studentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class calender_fragment extends Fragment {
    private ArrayList<StudentEventList> list;
    private  StudentListAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_calender_fragment, container, false);
        recyclerView = v.findViewById(R.id.calnder_recyclerList);
        list =new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Toast.makeText(getContext(), "Calender1", Toast.LENGTH_SHORT).show();
        adapter=new StudentListAdapter(list);
        Toast.makeText(getContext(), "Calender6", Toast.LENGTH_SHORT).show();
        FirebaseDatabase.getInstance().getReference().child("EventList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               list.clear();
                for(DataSnapshot data: snapshot.getChildren()){

                    Toast.makeText(getContext(), "calender2", Toast.LENGTH_SHORT).show();


                    StudentEventList studentEventList=data.getValue(StudentEventList.class);
                    list.add(studentEventList);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        // String[] eName = {"WLUGEVENT", "PACEEVENT" , "SAITEVENT" , "ARAYNSEVENT", "ACCESEVENT", "ELSAEVENT"};
        Toast.makeText(getContext(), "calender3", Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(adapter);

        Toast.makeText(getContext(), "calender7", Toast.LENGTH_SHORT).show();
        return v;
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//       // RecyclerView recyclerView = v.findViewById(R.id.calnder_recyclerList);
//        //String[] cName = {"WLUG","PACE","SAIT", "ARAYANS","ACCES","ELSA"};
//
//        TextView Date;
//        TextView EventName;
//        TextView ClubName;
//        TextView ClubLink;
//
//       // EventName = view.findViewById(R.id.eventName);
//      //  ClubName = view.findViewById(R.id.clubName);
//       // ClubLink = view.findViewById(R.id.clubLink);
//       // Date =  view. findViewById(R.id.date);
//
//
//    }
}