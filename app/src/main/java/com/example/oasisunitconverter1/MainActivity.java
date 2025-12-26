package com.example.oasisunitconverter1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private Spinner categorySpinner;
    private TextView resultTextView;
    private static final String[] CATEGORIES = {"Length", "Weight", "Temperature"};
    private static final String[] LENGTH_UNITS = {"cm", "m", "km"};
    private static final String[] WEIGHT_UNITS = {"mg", "g", "kg"};
    private static final String[] TEMP_UNITS = {"Celsius", "Fahrenheit", "Kelvin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.editTextText3);
        fromSpinner = findViewById(R.id.spinner);
        toSpinner = findViewById(R.id.spinner2);
        categorySpinner = findViewById(R.id.spinner3);
        resultTextView = findViewById(R.id.textView);
        Button convertButton = findViewById(R.id.button);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, CATEGORIES);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) categorySpinner.getSelectedItem();
                String[] currentUnits;
                if (selectedCategory.equals("Length")) {
                    currentUnits = LENGTH_UNITS;
                } else if (selectedCategory.equals("Weight")) {
                    currentUnits = WEIGHT_UNITS;
                } else {
                    currentUnits = TEMP_UNITS;
                }
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_spinner_item, currentUnits);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                fromSpinner.setAdapter(unitAdapter);
                toSpinner.setAdapter(unitAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }
    private void performConversion() {
        String inputStr = inputEditText.getText().toString();

        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter a value.", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format. Please use digits.", Toast.LENGTH_SHORT).show();
            return;
        }
        String category = (String) categorySpinner.getSelectedItem();
        String fromUnit = (String) fromSpinner.getSelectedItem();
        String toUnit = (String) toSpinner.getSelectedItem();
        double result = 0.0;
        if (category.equals("Length")) {
            result = convertLength(inputValue, fromUnit, toUnit);
        } else if (category.equals("Weight")) {
            result = convertWeight(inputValue, fromUnit, toUnit);
        } else if (category.equals("Temperature")) {
            result = convertTemperature(inputValue, fromUnit, toUnit);
        } else {
            Toast.makeText(this, "Invalid category selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        String vi = String.format("%.2f", result);
        resultTextView.setText(vi + " " + toUnit);
    }
    private double convertLength(double value, String from, String to) {
        if (from.equals(to)) return value;
        double baseMeters = 0.0;
        if (from.equals("cm")) baseMeters = value / 100.0;
        else if (from.equals("m")) baseMeters = value;
        else if (from.equals("km")) baseMeters = value * 1000.0;
        if (to.equals("cm")) return baseMeters * 100.0;
        else if (to.equals("m")) return baseMeters;
        else if (to.equals("km")) return baseMeters / 1000.0;
        return 0.0;
    }
    private double convertWeight(double value, String from, String to) {
        if (from.equals(to)) return value;
        double baseKilograms = 0.0;
        if (from.equals("mg")) baseKilograms = value / 1000000.0;
        else if (from.equals("g")) baseKilograms = value / 1000.0;
        else if (from.equals("kg")) baseKilograms = value;
        if (to.equals("mg")) return baseKilograms * 1000000.0;
        else if (to.equals("g")) return baseKilograms * 1000.0;
        else if (to.equals("kg")) return baseKilograms;
        return 0.0;
    }
    private double convertTemperature(double value, String from, String to) {
        if (from.equals(to)) return value;
        double baseCelsius = 0.0;
        if (from.equals("Celsius")) {
            baseCelsius = value;
        } else if (from.equals("Fahrenheit")) {
            baseCelsius = (value - 32.0) * 5.0 / 9.0;
        } else if (from.equals("Kelvin")) {
            baseCelsius = value - 273.15;
        }
        if (to.equals("Celsius")) {
            return baseCelsius;
        } else if (to.equals("Fahrenheit")) {
            return (baseCelsius * 9.0 / 5.0) + 32.0;
        } else if (to.equals("Kelvin")) {
            return baseCelsius + 273.15;
        }
        return 0.0;
    }
}
