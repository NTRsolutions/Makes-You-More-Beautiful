package com.example.nagi.makesyoubeautiful;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_IMAGE_CAPTURE = 100;
    public ImageView cameraButton;
    public ImageView fileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cameraButton = findViewById(R.id.cameraButton);
        fileButton = findViewById(R.id.fileButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager())!= null){
                    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bitmap bitmap=(Bitmap)data.getExtras().get("data");

            Intent imageIntent = new Intent(MenuActivity.this, FilterActivity.class);
            imageIntent.putExtra("image", bitmap);
            startActivity(imageIntent);
            finish();

        }
    }



}
