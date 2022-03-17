package com.example.unit_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner options;
    TextView result1,result2,result3,unit1,unit2,unit3;
    ImageButton buttonLength, buttonTemp, buttonWeight;

    private final String[] userOptions = {"meter","celsius","kg"};

    private Double getInput() {
        EditText userInput = findViewById(R.id.editUserInput);
        String input = userInput.getText().toString();
        Double validate = Double.parseDouble(input);
        if (validate != 0)
            return validate;
        else
            return 0.0;
    }
    private void initializeSpinner(){
        options = findViewById(R.id.spinnerOptions);
        ArrayAdapter<String> optionsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userOptions);
        optionsAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        options.setAdapter(optionsAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLength = findViewById(R.id.buttonLength);
        buttonTemp = findViewById(R.id.buttonTemp);
        buttonWeight = findViewById(R.id.buttonWeight);
        result1 = findViewById(R.id.textViewResult1);
        result2 = findViewById(R.id.textViewResult2);
        result3 = findViewById(R.id.textViewResult3);
        unit1 = findViewById(R.id.textViewUnit1);
        unit2 = findViewById(R.id.textViewUnit2);
        unit3 = findViewById(R.id.textViewUnit3);
        initializeSpinner();
        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select = options.getSelectedItem().toString();
                double input  = getInput();
                lengthConverter(input,select);
            }
        });
        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select = options.getSelectedItem().toString();
                double input = getInput();
                weightConverter(input,select);
            }
        });
        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select = options.getSelectedItem().toString();
                double input = getInput();
                tempratureConverter(input,select);
            }
        });
    }
    public void lengthConverter(double meter, String selectedOption){
        if (!selectedOption.equals("meter"))
            Toast.makeText(this, "Please select the correct conversion option!", Toast.LENGTH_SHORT).show();
        else if (meter == 0.0)
            Toast.makeText(this, "Input cannot be empty or zero!", Toast.LENGTH_SHORT).show();
        else {
            double toCM = meter * 100.0;
            double toFoot = meter * 3.28;
            double toInch = meter * 39.3701;
            result1.setText(String.format("%.2f",toCM));
            result2.setText(String.format("%.2f",toFoot));
            result3.setText(String.format("%.2f",toInch));
            unit1.setText("cm");
            unit2.setText("Ft");
            unit3.setText("In");
        }
    }
    public void weightConverter(double kg,String selectedOption){
        if(!selectedOption.equals("kg"))
            Toast.makeText(this, "Please select the correct conversion option!", Toast.LENGTH_SHORT).show();
        else if(kg == 0.0)
            Toast.makeText(this, "Input cannot be empty or zero!", Toast.LENGTH_SHORT).show();
        else {
            double toGram = kg * 1000.0;
            double toOunce = kg * 35.274;
            double toPound = kg * 2.205;
            result1.setText(String.format("%.2f",toGram));
            result2.setText(String.format("%.2f",toOunce));
            result3.setText(String.format("%.2f",toPound));
            unit1.setText("Gram");
            unit2.setText("Ounce");
            unit3.setText("Pound");
        }
    }
    public void tempratureConverter(double celsius,String selectedOption){
        if(!selectedOption.equals("celsius"))
            Toast.makeText(this, "Please select the correct conversion option!", Toast.LENGTH_SHORT).show();
        else if(celsius == 0.0)
            Toast.makeText(this, "Input cannot be empty or zero!", Toast.LENGTH_SHORT).show();
        else {
            double toFahrenheit = (celsius * 1.8) + 32;
            double toK = celsius + 273.15;
            result1.setText(String.format("%.2f",toFahrenheit));
            result2.setText(String.format("%.2f",toK));
            unit1.setText("Fahrenheit");
            unit2.setText("Kelvin");
        }
    }
}