package com.example.takepic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    private ImageView mimageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //frameLayout =findViewById(R.id.frameLayout);

        //open the camera

        //camera = android.hardware.Camera.open();
        //  showCamera = new ShowCamera(this,camera);


        //vid 2
        mimageView =findViewById(R.id.imageView);

    }

    public void takePicture(View view) {

        Intent imagrTakenIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imagrTakenIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(imagrTakenIntent,REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {


            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mimageView.setImageBitmap(imageBitmap);
        }

    }
}
