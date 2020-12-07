package ldp.e.purdueacademicplan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.ArrayList;


public class LoginMain extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView newUser;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        try{
            db = openOrCreateDatabase(
                    "LoginInformation",
                    Activity.MODE_PRIVATE,
                    null);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Password Hashing using SHA-256
                String password = passwordEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String hash = "";
                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hashByte = digest.digest(password.getBytes("UTF-8"));

                    for (byte b : hashByte) {
                        String hex = String.format("%02x", b);
                        hash += hex;
                    }

                }catch(Exception e) {
                    e.printStackTrace();
                }

                // TODO: Insert password hash matching here!!!

                ArrayList<String> passwordHashes = new ArrayList<String>();
                ArrayList<String> usernames = new ArrayList<String>();

                boolean check = false;


                Cursor c = db.rawQuery("SELECT username, passwordHash from login where passwordHash = '" + hash + "';", null);

                c.moveToFirst();
                while(c.isAfterLast() == false){
                    passwordHashes.add(c.getString(c.getColumnIndex("passwordHash")));
                    usernames.add(c.getString(c.getColumnIndex("username")));

                    c.moveToNext();
                }

                for(int counter = 0; counter < passwordHashes.size(); counter++){

                    if(passwordHashes.get(counter).equals(hash)){

                        for(int counter2 = 0; counter2 < usernames.size(); counter2++){

                            if(usernames.get(counter).equals(username)){
                                Intent StudentProfilePage = new Intent(getApplicationContext(), StudentProfile.class);
                                StudentProfilePage.putExtra("username", username);

                                startActivity(StudentProfilePage);
                                check = true;
                            }

                        }

                    }

                }
                if(!check){
                    Toast.makeText(getApplicationContext(),"Wrong Username or Password!!",Toast.LENGTH_SHORT).show();
                }


//
//                if(password.equals("Pears") && usernameEditText.getText().toString().equals("ldperry")) {
//                    Intent StudentProfilePage = new Intent(getApplicationContext(), StudentProfile.class);
//                    startActivity(StudentProfilePage);
//                    // finish();
//                }else{
//                    Toast.makeText(getApplicationContext(),"Wrong Username or Password!!",Toast.LENGTH_SHORT).show();
//                }
            }
        });


        newUser = findViewById(R.id.newUserTextView);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newUserPage = new Intent(getApplicationContext(), NewUser.class);
                startActivity(newUserPage);

            }
        });



    }
}