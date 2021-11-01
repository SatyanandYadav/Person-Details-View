package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etname,etphone,etwebsite,etlocation;
    ImageView btngreen,btnyellow,btnred;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        etwebsite=findViewById(R.id.etwebsite);
        etlocation=findViewById(R.id.etlocation);
        btngreen=findViewById(R.id.btngreen);
        btnyellow=findViewById(R.id.btnyellow);
        btnred=findViewById(R.id.btnred);

        btngreen.setOnClickListener(this);
        btnyellow.setOnClickListener(this);
        btnred.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {
        if(etname.getText().toString().isEmpty()||etphone.getText().toString().isEmpty()||
                etwebsite.getText().toString().isEmpty()||etlocation.getText().toString().isEmpty())
        {
            Toast.makeText(loginActivity.this,"Please enter all fields!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String name=etname.getText().toString().trim();
            String phone=etphone.getText().toString().trim();
            String website=etwebsite.getText().toString().trim();
            String location=etlocation.getText().toString().trim();
            Intent intent =new Intent();
            intent.putExtra("name",name);
            intent.putExtra("phone",phone);
            intent.putExtra("website",website);
            intent.putExtra("location",location);
            if(v.getId() == R.id.btngreen)
            {
                intent.putExtra("mood","green");
            }
            else if(v.getId() == R.id.btnred)
            {
                intent.putExtra("mood","red");
            }
            else
            {
                intent.putExtra("mood","yellow");
            }
            setResult(RESULT_OK,intent);
            loginActivity.this.finish();
        }
    }
}