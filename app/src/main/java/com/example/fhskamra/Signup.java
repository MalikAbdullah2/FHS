package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText edtName,edtPhone,edtCnic,edtEmail,edtPassword;
    Button BtnSignup;
    String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" +

            "\\." +

            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

            ")+";
    TextView login;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    user Reguser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login=findViewById(R.id.link_login_signup);
        edtName=findViewById(R.id.edt_name_signup);
        edtCnic=findViewById(R.id.edt_cnic_signup);
        edtEmail=findViewById(R.id.edt_email_signup);
        edtPhone=findViewById(R.id.edt_phone_signup);
        edtPassword=findViewById(R.id.edt_password_signup);
        BtnSignup=findViewById(R.id.btn_createaccount_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_login_signup:
                Intent b=new Intent(getApplicationContext(),Login.class);
                startActivity(b);
                break;
            case R.id.btn_createaccount_signup:
                if (checkForsignupDeatils()){
                    final String email=edtEmail.getText().toString().trim();
                    final String name=edtName.getText().toString().trim();
                    final String password=edtPassword.getText().toString().trim();
                    final String cnic=edtCnic.getText().toString().trim();
                    final String number=edtPhone.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Reguser = new user(email,name,number,cnic);
                                firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(Reguser);

                                            Toast.makeText(Signup.this, "data inserted" +
                                                    ",please check email for verification", Toast.LENGTH_LONG).show();
                                            Intent j = new Intent(getApplicationContext(), Login.class);

                                    }else {
                                            Toast.makeText(Signup.this, task.getException().getMessage(),
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }

                                });


                            } else {


                            }

                        }
                    });
                }
                break;
            default:
                break;
        }


    }
    private boolean checkForsignupDeatils() {
        String email = edtEmail.getText().toString();
        Matcher matcher = Pattern.compile(validemail).matcher(email);
        if (!matcher.matches()) {
            edtEmail.setError("Enter valid email");
            edtEmail.setFocusable(true);
            return false;
        }
        if (edtName.getText().toString().equals("") || edtName.length() < 3) {
            edtName.setError("at least 3 characters");
            edtName.setFocusable(true);
            return false;
        } else {
            edtName.setError(null);
        }


        return true;
    }
}