package com.example.receiptsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNext(View v) {
        Intent i = new Intent(this, TaxTip.class);
        TextView tax = findViewById(R.id.tax);
        TextView tip = findViewById(R.id.tip);
        i.putExtra("tax", Double.parseDouble(tax.getText().toString()));
        i.putExtra("tip", Double.parseDouble(tip.getText().toString()));
        startActivity(i);
    }


}