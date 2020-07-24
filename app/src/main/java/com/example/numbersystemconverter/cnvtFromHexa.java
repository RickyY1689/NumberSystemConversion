package com.example.numbersystemconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class cnvtFromHexa extends AppCompatActivity {
    public String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnvt_from_hexa);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("________");

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("________");
    }

    /** Called when the user taps the Send button */
    public void userInput(View view) {
        // Do something in response to button
        EditText editText = findViewById(R.id.editText);
        val = editText.getText().toString();
        int decimalVal = 0;
        int decimalIntrcment[] = new int[4];
        int currentHexaVal;
        int maxVal = 3;
        int i;
        int binaryVal[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (i = 0; i < val.length(); i++) {
                decimalVal = decimalVal + (Character.getNumericValue(val.charAt(i))) * (int)Math.pow(16, 3-i);
        }

        for (int j = 0; j < 4; j++) {
            currentHexaVal = Character.getNumericValue(val.charAt(j));
            while (currentHexaVal != 0) {
                i = 0;
                if (currentHexaVal%2 == 0) {
                    binaryVal[maxVal-i] = 1;
                } else if (currentHexaVal%2 == 1) {
                    binaryVal[maxVal-i] = 1;
                }
                i = i + 1;
                currentHexaVal = (currentHexaVal - currentHexaVal%2)/2;

                if (i == 4) {
                    break;
                }
            }
            maxVal = maxVal + 4;
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(decimalVal));

        // Capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(Arrays.toString(binaryVal));
    }
}
