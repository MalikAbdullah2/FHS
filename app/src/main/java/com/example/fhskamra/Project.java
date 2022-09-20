package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Project extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<project_retrieve> projectArrayList;
    private RecyclerAdpter recyclerAdpter;
    private Context pcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        recyclerView=findViewById(R.id.recyclerview_project);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        projectArrayList=new ArrayList<>();
        ClearAll();
        GetDataFromFirebase();
    }

    private void GetDataFromFirebase() {
        Query query=databaseReference.child("Projects");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){

                    project_retrieve projectRetrieved=new project_retrieve();
                    projectRetrieved.setImage(snapshot1.child("image").getValue().toString());
                    projectRetrieved.setDetails(snapshot1.child("Details").getValue().toString());
                    projectRetrieved.setName(snapshot1.child("Name").getValue().toString());

                    projectArrayList.add(projectRetrieved);
                }
                recyclerAdpter =new RecyclerAdpter(getApplicationContext(),projectArrayList);
                recyclerView.setAdapter(recyclerAdpter);
                recyclerAdpter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ClearAll(){
        if (projectArrayList!=null){
            projectArrayList.clear();
            if (recyclerAdpter!=null){
                recyclerAdpter.notifyDataSetChanged();

            }
        }
        projectArrayList=new ArrayList<>();
    }
}