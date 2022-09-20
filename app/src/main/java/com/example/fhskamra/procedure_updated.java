package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class procedure_updated extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<pdf_ret> uploadpdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure_updated);
        listView=findViewById(R.id.listview_proceduresUpdated);
        uploadpdf=new ArrayList<>();
        retrievePDF();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pdf_ret pdfRet=uploadpdf.get(position);
                Intent intent=new Intent();
                intent.setData(Uri.parse(pdfRet.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void retrievePDF() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Procedures");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    pdf_ret pdfRet=ds.getValue(pdf_ret.class);
                    uploadpdf.add(pdfRet);
                }
                String[] uploadsName=new String[uploadpdf.size()];
                for (int i=0;i<uploadsName.length;i++){

                    uploadsName[i]=uploadpdf.get(i).getName();
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,uploadsName){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view= super.getView(position, convertView, parent);
                        TextView textView=(TextView) view.findViewById(android.R.id.text1);
                        textView.setTextColor(Color.BLACK);
                        textView.setTextSize(20);
                        return view;
                    }
                };
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}