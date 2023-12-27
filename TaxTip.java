package com.example.receiptsjava;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;

        import java.util.HashMap;

public class TaxTip extends AppCompatActivity {

    double taxRate;
    double tipPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_tip);
        Intent i = getIntent();
        taxRate = i.getDoubleExtra("tax", 0);
        tipPercentage = i.getDoubleExtra("tip", 0);
    }



    HashMap<String, Double> list = new HashMap<>();
    double total = 0.0;
    public void enter (View v) {
        TextView n = findViewById(R.id.Name);
        TextView p = findViewById(R.id.Price);
        String name = n.getText().toString();
        Double price = Double.parseDouble(p.getText().toString());
        total = total + price;
        list.put(name, price);
        Log.d(name, list.get(name).toString());
        n.setText("");
        p.setText("");

    }




    public HashMap<String, Double> totals
            (View v) {

        double tip = total * tipPercentage;

        HashMap<String, Double> ans = new HashMap<>();
        for (String person: list.keySet()) {
            double personalTotal = list.get(person);
            double tax = personalTotal*taxRate;
            double portion = list.get(person)/total;
            double personalTip = portion*tip;
            personalTotal = personalTotal + tax + personalTip;
            ans.put(person, personalTotal);
        }

        for (String person : ans.keySet()) {
            Log.d("Name:", ans.get(person).toString());
        }

        Intent i = new Intent(this, Results.class);
        i.putExtra("results", ans);
        startActivity(i);

        return ans;
    }
}