package com.walhalla.clicker;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private EditText basePriceEditText;
    private EditText optionsPriceEditText;
    private EditText taxRateEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basePriceEditText = findViewById(R.id.base_price_edit_text);
        optionsPriceEditText = findViewById(R.id.options_price_edit_text);
        taxRateEditText = findViewById(R.id.tax_rate_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(v -> {
            try {
                double basePrice = Double.parseDouble(basePriceEditText.getText().toString());
                double optionsPrice = Double.parseDouble(optionsPriceEditText.getText().toString());
                double taxRate = Double.parseDouble(taxRateEditText.getText().toString());

                CarPriceCalculator calculator = new CarPriceCalculator(basePrice, optionsPrice, taxRate);
                double totalPrice = calculator.calculatePrice();

                resultTextView.setText(String.format("Total price: $%.2f", totalPrice));
            }catch (Exception e){
                Toast.makeText(this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

