package com.example.magicidapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String idNumber = etID.getText().toString().trim();

                 String dob = idNumber.substring(0,6);

                 int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                 String sgender;

                 if(gender < 5)
                     sgender = getString(R.string.female);
                 else
                     sgender = getString(R.string.male);

                 int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                 String snationality;

                 if(nationality ==0)
                     snationality = getString(R.string.sac);
                 else
                     snationality = getString(R.string.permanent);

                 String text = getString(R.string.dob) + dob + "/n" +
                         getString(R.string.gender) + sgender + "/n" +
                         getString(R.string.nationality) + snationality;


                 tvResults.setText(text);

                 tvResults.setVisibility(View.VISIBLE);
             }
         });
    }
}