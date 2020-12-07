package ldp.e.purdueacademicplan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentProfile extends AppCompatActivity {
    Button whatIfCalculatorButton;
    Button planOverviewButton;
    Button tostart;

    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile);

        Intent mIntent = getIntent();

        if(mIntent == null){
            return;
        }

        whatIfCalculatorButton = findViewById(R.id.whatIfCalculatorButton);
        whatIfCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whatIfCalculatorPage = new Intent(getApplicationContext(), WhatIfCalculator.class);
                startActivity(whatIfCalculatorPage);
                //finish();
            }
        });

        planOverviewButton = findViewById(R.id.planOverviewButton);
        planOverviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent planOverviewPage = new Intent(getApplicationContext(), PlanOverview.class);
                startActivity(planOverviewPage);
                //finish();
            }
        });

        tostart = findViewById(R.id.buttonStartover);
        tostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Set username accordingly
        TextView studentID = findViewById(R.id.studentID);
        TextView email = findViewById(R.id.email);
        String username = mIntent.getStringExtra("username");
        Log.d("NewUserUsernameAfterSwitch: ", username);


        ArrayList<String> emails = new ArrayList<String>();
        ArrayList<String> usernames = new ArrayList<String>();

        try{
            db = openOrCreateDatabase(
                    "LoginInformation",
                    Activity.MODE_PRIVATE,
                    null);

            Cursor c = db.rawQuery("SELECT * from login where username = '" + username + "';", null);

            c.moveToFirst();
            while(c.isAfterLast() == false){
                emails.add(c.getString(c.getColumnIndex("email")));
                usernames.add(c.getString(c.getColumnIndex("username")));

                c.moveToNext();
            }

            for(int counter = 0; counter < usernames.size(); counter++){
                studentID.setText("StudentID: " + usernames.get(counter));
            }

            for(int counter = 0; counter < emails.size(); counter++){
                email.setText("Email: " + emails.get(counter));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

//        studentID.setText("StudentID: " + username);
    }
}
