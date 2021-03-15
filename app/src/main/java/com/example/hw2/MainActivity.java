package com.example.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton photo;
    ImageButton telephone;
    ImageButton google;
    Button enter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.view_312);
        photo = findViewById(R.id.img_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhoto = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intentPhoto);
            }
        });


        telephone = findViewById(R.id.img_tele);
        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTelephone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(996)555 71 88 82"));
                startActivity(intentTelephone);
            }
        });


        google = findViewById(R.id.img_google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Mikle";
                Intent intentGoogle = new Intent(Intent.ACTION_WEB_SEARCH);
                intentGoogle.putExtra(SearchManager.QUERY, text);
                startActivity(intentGoogle);
            }
        });


        enter = findViewById(R.id.btn_enter);
        enter.setOnClickListener((View v) -> {
            Intent intentEnter = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intentEnter, 15);


        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != RESULT_CANCELED) {
            if (requestCode == 15) {
                String btn = data.getStringExtra("key");
                textView.setText(btn);
            }
        }

    }
}