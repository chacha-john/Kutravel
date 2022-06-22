package com.chachaup.kutravel.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chachaup.kutravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.buttonDashboardAttractions)
    TextView mAttractions;
    @BindView(R.id.buttonDashboardEvents) TextView mEvents;
    @BindView(R.id.buttonDashboardVenues) TextView mVenues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAttractions.setOnClickListener(this);
        mEvents.setOnClickListener(this);
        mVenues.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mAttractions){
            Intent intent = new Intent(MainActivity.this, AttractionsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v == mEvents){
            Intent intent = new Intent(MainActivity.this, EventsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v == mVenues){
            Intent intent = new Intent(MainActivity.this, VenueActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}