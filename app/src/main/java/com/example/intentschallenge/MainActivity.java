package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView ivcall,ivlocaton,ivface,ivwebsite;
    Button btncontacts;
    TextView tvresult;
    String name="",phone="",website="",location="",mood="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivcall=findViewById(R.id.ivcall);
        ivwebsite=findViewById(R.id.ivwebsite);
        ivlocaton=findViewById(R.id.ivlocation);
        ivface=findViewById(R.id.ivface);
        btncontacts=findViewById(R.id.btncontact);
        tvresult=findViewById(R.id.tvresult);
        ivface.setVisibility(View.GONE);
        ivcall.setVisibility(View.GONE);
        ivwebsite.setVisibility(View.GONE);
        ivlocaton.setVisibility(View.GONE);
        tvresult.setVisibility(View.GONE);
        btncontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,
                        com.example.intentschallenge.loginActivity.class);
                startActivityForResult(intent,8);

            }
        });
        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
        ivlocaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });
        ivwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+website));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
          if(requestCode == 8)
          {
              if(resultCode == RESULT_OK)
              {
                  ivface.setVisibility(View.VISIBLE);
                  ivcall.setVisibility(View.VISIBLE);
                  ivlocaton.setVisibility(View.VISIBLE);
                  tvresult.setVisibility(View.VISIBLE);
                  ivwebsite.setVisibility(View.VISIBLE);
                   name=data.getStringExtra("name");
                   phone=data.getStringExtra("phone");

                   website=data.getStringExtra("website");
                   location=data.getStringExtra("location");
                   mood=data.getStringExtra("mood");

                  tvresult.setText(name);
                  if(mood.equals("red"))
                  {
                      ivface.setImageResource(R.drawable.sadface);
                  }
                  else if(mood.equals("green"))
                  {
                      ivface.setImageResource(R.drawable.happyface);
                  }
                  else
                  {
                      ivface.setImageResource(R.drawable.normalface);
                  }


              }
              if(resultCode == RESULT_CANCELED)
              {
                 tvresult.setText("no data recieved");
              }
          }
    }
}