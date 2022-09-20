package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class complaint extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    EditText edtname,edtcontact,edtbranch,edtdetail;
    Button btnsubmit;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    complaint_guest complaintGuest_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        bottomNavigationView=findViewById(R.id.bottomnav_visitor2);
        edtname=findViewById(R.id.edt_name_complaint);
        edtbranch=findViewById(R.id.edt_departement_complaint);
        edtcontact=findViewById(R.id.edt_number_complaint);
        edtdetail=findViewById(R.id.edt_detail_complaint);
        firebaseStorage=FirebaseStorage.getInstance();
        complaintGuest_submit=new complaint_guest();
        storageReference=firebaseStorage.getReference();
        bottomNavigationView.setSelectedItemId(R.id.nav_complaint_visitor);
        databaseReference = FirebaseDatabase.getInstance().getReference("Guest Complaint and Query");
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_contact_visitor:
                        return true;
                    case R.id.nav_complaint_visitor:
                        Intent b=new Intent(getApplicationContext(), complaint.class);
                        overridePendingTransition(0,0);
                        startActivity(b);
                        return true;
                    case R.id.nav_home_visitor:
                        Intent c=new Intent(getApplicationContext(), visitor2.class);
                        overridePendingTransition(0,0);
                        startActivity(c);
                        return true;
                    case R.id.navw_aboutus_visitor:
                        Intent t=new Intent(getApplicationContext(), aboutus.class);
                        overridePendingTransition(0,0);
                        startActivity(t);
                        return true;
                }
                return false;
            }

        }
        );
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_submit_complaint:
                submitComplaint();

                break;
        }
    }

    private void submitComplaint() {
        complaint_guest complaintGuest=new complaint_guest();
        String name=edtname.getText().toString().trim();
        String brach=edtbranch.getText().toString().trim();
        String contact=edtcontact.getText().toString().trim();
        String detail=edtdetail.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(complaint.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(brach)) {
            Toast.makeText(complaint.this, "Please Enter Branch", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(contact)) {
            Toast.makeText(complaint.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(detail)) {
            Toast.makeText(complaint.this, "Please Enter detail", Toast.LENGTH_SHORT).show();
            return;
        }
        complaintGuest_submit.setName(name);
        complaintGuest_submit.setBranch(brach);
        complaintGuest_submit.setContact(contact);
        complaintGuest_submit.setDetail(detail);
        databaseReference.push().setValue(complaintGuest_submit).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Report submitted",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),visitor2.class);
                    startActivity(intent);}
                else {
                    Toast.makeText(complaint.this,task.getException().getMessage()
                            ,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}