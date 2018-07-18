package com.example.nagi.makesyoubeautiful;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FilterActivity extends AppCompatActivity {
    public ImageView photoIv;
    public ImageView smallFilterIv;
    public ImageView homeButton;
    public static final String BACK_HOME_KEY = "backhome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        //ImageView of captured photo by camera
        photoIv = findViewById(R.id.photoImageView);


        smallFilterIv = findViewById(R.id.smallFilterPhoto);
        homeButton = findViewById(R.id.homeButton);

        smallFilterIv.setImageResource(R.drawable.filterphoto);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backhome = new Intent(FilterActivity.this,MenuActivity.class);
                backhome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backhome);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bitmap image = (Bitmap) extras.get("image");
            if (image != null) {
                photoIv.setImageBitmap(image);
            }
        }


    }
}
