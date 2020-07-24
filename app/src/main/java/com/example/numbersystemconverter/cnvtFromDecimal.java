package com.example.numbersystemconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class cnvtFromDecimal extends AppCompatActivity {
    public String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnvt_from_decimal);


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
        int decimalVal = Integer.parseInt(val);
        int i = 0;
        int binaryVal[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int hexaVal[] = {0, 0};



        while (decimalVal != 0) {
            if (decimalVal%2 == 0) {
                binaryVal[7-i] = 0;
            } else if (decimalVal%2 == 1) {
                binaryVal[7-i] = 1;
            }
            i = i + 1;
            decimalVal = (decimalVal - decimalVal%2)/2;
        }

        for (i = 0; i < 8; i++) {
            if (i < 4) {
                if (binaryVal[i] == 1) {
                    hexaVal[0] = hexaVal[0] + (int)Math.pow(2, 3-i);
                }
            } else {
                if (binaryVal[i] == 1) {
                    hexaVal[1] = hexaVal[1] + (int)Math.pow(2, 7-i);
                }
            }
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(Arrays.toString(binaryVal));

        // Capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(Arrays.toString(hexaVal));
    }
}
