package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class procedures extends AppCompatActivity {
    ListView pdffiles;

    List<procedure_retrive> procedureRetrives;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedures);
        pdffiles=findViewById(R.id.listview_procedures);
        procedureRetrives=new ArrayList<>();
        viewFiles();
        pdffiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                procedure_retrive retrive=procedureRetrives.get(position);
                Intent intent=new Intent();
                intent.setData(Uri.parse(retrive.getUrl()));
                startActivity(intent);
            }
        });
    }
    private void viewFiles() {
        reference= FirebaseDatabase.getInstance().getReference("Procedures");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    procedure_retrive retrive=dataSnapshot.getValue(procedure_retrive.class);
                    procedureRetrives.add(retrive);
                }
                String[] Name=new String[procedureRetrives.size()];
                 for (int i=0;i<Name.length;i++){

                     Name[i]=procedureRetrives.get(i).getName();
                 }
                 ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,Name);

                }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}