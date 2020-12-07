package ldp.e.purdueacademicplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class WhatIfCalculator extends AppCompatActivity {


    /*
    majors
    <item>Computer and Information Technology</item>
        <item>Cyber-Security</item>
        <item>Network Engineering Technology</item>
        <item>Systems Analysis and Design</item>

    minors
    <item>Organizational Leadership</item>
    <item>Electrical Engineering Tech</item>
        <item>Management</item>
        <item>History</item>
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_if_calculator);
        Resources res = getResources();
        Button goBack = (Button) findViewById(R.id.ButtonReturn);

        final TextView majorclasslist = (TextView) findViewById(R.id.textViewMajorClasses);
        final TextView minorclasslist = (TextView) findViewById(R.id.textViewMinorClasses);
        Button submitbutton = (Button) findViewById(R.id.buttonSubmit);


        final Spinner spinnerMajor = (Spinner) findViewById(R.id.spinnerMajor);
        ArrayAdapter<String> adapterMajor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,res.getStringArray(R.array.Majors));
        adapterMajor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMajor.setAdapter(adapterMajor);

        final Spinner spinnerMinor = (Spinner) findViewById(R.id.spinnerMinor);
        ArrayAdapter<String> adapterMinor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.Minors));
        adapterMinor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinor.setAdapter(adapterMinor);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerMajor.getSelectedItem().toString().equals("Computer and Information Technology")) {
                    majorclasslist.setText("Major Classes: \n" +
                            "CNIT 15501 - Introduction to Software Development Concepts\n" +
                            "CNIT 27200 - Database Fundamentals\n" +
                            "CNIT 32500 - Object-Oriented Application Development\n" +
                            "CNIT 48000 - Managing Information Technology Project\n");
                }

                if(spinnerMajor.getSelectedItem().toString().equals("Cyber-Security")) {
                    majorclasslist.setText("Major Classes: \n" +
                            "CNIT 27000 - Cybersecurity Fundamental\n" +
                            "CNIT 37000 - Introduction To Cryptography\n" +
                            "CNIT 45500 - Network Security\n" +
                            "CNIT 47100 - Vulnerability Analysis And Testing\n"+
                    "CNIT 42000 - Basic Cyber Forensics\n");
                }

                if(spinnerMajor.getSelectedItem().toString().equals("Network Engineering Technology")) {
                    majorclasslist.setText("Major Classes: \n" +
                            "CNIT 24000 - Data Communications And Networking\n" +
                            "CNIT 34500 - Internetwork Design And Implementation\n" +
                            "CNIT 34210 - Storage Area Networking\n" +
                            "CNIT 34600 - Wireless Networks\n");
                }

                if(spinnerMajor.getSelectedItem().toString().equals("Systems Analysis and Design")) {
                    majorclasslist.setText("Major Classes: \n" +
                            "CNIT 18000 - Introduction To Systems Development\n" +
                            "CNIT 28000 - Systems Analysis And Design Methods\n" +
                            "CNIT 38000 - Advanced Analysis And Design\n" +
                            "CGT 25600 - Principles Of User Experience Design\n");
                }





                if(spinnerMinor.getSelectedItem().toString().equals("Organizational Leadership"))
                minorclasslist.setText("Minor Classes: \n"+
                        "OLS 25200 - Human Behavior in Organizations\n"+
                        "OLS 27400 - Applied Leadership\n"+
                        "TLI 25300 - Principle of Technology Strategy\n"+
                        "OLS 38600 - Management of Change\n");

                if(spinnerMinor.getSelectedItem().toString().equals("Electrical Engineering Tech"))
                    minorclasslist.setText("Minor Classes: \n"+
                            "ECET 17700 - Data Acquisition and Systems Controls\n"+
                            "ECET 17900 - Introduction to Digital Systems\n"+
                            "ECET 22700 - DC and Pulse Electronics\n"+
                            "ECET 27700 - AC and Power Electronics\n");

                if(spinnerMinor.getSelectedItem().toString().equals("Management"))
                    minorclasslist.setText("Minor Classes: \n"+
                            "MGMT 20000 - Introductory Accounting\n"+
                            "MGMT 20100 - Management Accounting I\n"+
                            "ECON 25100 - Microeconomics\n"+
                            "MGMT 35200 - Strategic Management \n");

                if(spinnerMinor.getSelectedItem().toString().equals("History"))
                    minorclasslist.setText("Minor Classes: \n"+
                            "History 30000 - Eve of Destruction: Global Crisis and World Organization in the 2oth Century\n"+
                            "History 30400 - America in the 1960's\n"+
                            "History 30505 - The United State in the World: 1898 - Present\n"+
                            "History 30605 - Technology and War in U.S. History\n");







            }
        });






    }
}