package com.example.studentrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText st_username, st_password;
    Button st_btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide Title Bar
        getSupportActionBar().hide();

        st_username = findViewById(R.id.stUserName);
        st_password = findViewById(R.id.stPassword);
        st_btnLogin = findViewById(R.id.stBtnLogin);

        st_btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String userName = st_username.getText().toString();
        String password = st_password.getText().toString();

        //Validation
        if(st_username.getText().toString().matches("")){
            st_username.setError("Enter Your Username");
            return;
        }
        if(st_password.getText().toString().matches("")){
            st_password.setError("Enter Your correct password");
            return;
        }

        if(userName.equals("softwarica") && password.equals("coventry"))
        {
            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "SORRY INVALID USER ID OR PASSWORD",Toast.LENGTH_LONG).show();
        }
        st_password.getText().clear();
        st_username.getText().clear();
    }
}
