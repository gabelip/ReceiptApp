package com.example.receiptsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Results extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);
        Intent i = getIntent();
        HashMap<String, Double> results = (HashMap<String, Double>) i.getSerializableExtra("results");
        String finalMessage = "";
        for (String person: results.keySet()) {
            finalMessage = finalMessage + "\n" + person + ": " + results.get(person).toString();
        }
        update(finalMessage);
    }

    public void update(String message) {
        TextView fin = findViewById(R.id.fin);
        fin.setText(message);
    }
}