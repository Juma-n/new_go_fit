package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ex_loss extends AppCompatActivity {
    VideoView vid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_loss);

        vid1 = findViewById(R.id.vid1);


        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.vid1;
        Uri uri = Uri.parse(videopath);
        vid1.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        vid1.setMediaController(mediaController);
        mediaController.setAnchorView(vid1);



    }
}