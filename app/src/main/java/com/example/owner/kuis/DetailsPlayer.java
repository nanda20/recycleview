package com.example.owner.kuis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsPlayer extends AppCompatActivity {
    private  TextView playerName,playerInfo,playerDetails;
    private  ImageView playerImage;
    String txtplayerName,txtplayerInfo,txtplayerDetails;
    int txtplayerImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_player);
        Intent intent= getIntent();
        txtplayerName = intent.getStringExtra("playerName");
        txtplayerInfo = intent.getStringExtra("playerInfo");
        txtplayerImage = intent.getIntExtra("playerImage",-1);
        txtplayerDetails = intent.getStringExtra("playerDetails");


        playerName = (TextView) findViewById(R.id.playerNameDetails);
        playerInfo = (TextView) findViewById(R.id.playerInfoDetails);
        playerImage = (ImageView) findViewById(R.id.playerImagesDetails);
        playerDetails = (TextView) findViewById(R.id.playerDetails);

        playerName.setText(txtplayerName);
        playerInfo.setText(txtplayerInfo);
        playerImage.setImageResource(txtplayerImage);
        playerDetails.setText(txtplayerDetails);

    }
}
