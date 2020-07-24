package com.example.numbersystemconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class cnvtFromBinary extends AppCompatActivity {

    public String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnvt_from_binary);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("________");

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("________");
    }

    /** Called when the user taps the Send button */
    public void userInput(View view) {
        // Do something in response to button
        int decimalVal = 0;
        int hexaVal[] = {0, 0};
        EditText editText = findViewById(R.id.editText);
        val = editText.getText().toString();

        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '1') {
                decimalVal = decimalVal + (int)Math.pow(2, 7-i);
            }
        }

        for (int i = 0; i < val.length(); i++) {
            if (i < 4) {
                if (val.charAt(i) == '1') {
                    hexaVal[0] = hexaVal[0] + (int)Math.pow(2, 3-i);
                }
            } else {
                if (val.charAt(i) == '1') {
                    hexaVal[1] = hexaVal[1] + (int)Math.pow(2, 7-i);
                }
            }
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(decimalVal));

        // Capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView2);
        System.out.println("hello");
        textView2.setText(Arrays.toString(hexaVal));
    }
}
