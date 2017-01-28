package com.example.ashok.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class Loginactivity extends AppCompatActivity
{
 EditText usr,pass;
    Button bsign;
    LoginDatabaseAdapter loginDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        usr=(EditText)findViewById(R.id.userName);
        pass=(EditText)findViewById(R.id.password);
        bsign=(Button)findViewById(R.id.signIn);
        loginDatabaseAdapter=new LoginDatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();
     try {
         bsign.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {
                 String userName = usr.getText().toString();
                 String password = pass.getText().toString();
                 // fetch the Password form database for respective user name
                 String storedPassword = loginDatabaseAdapter.getSingleEntry(userName);
                 // check if the Stored password matches with  Password entered by user
                 if (password.equals(storedPassword))
                 {
                     Intent it = new Intent(Loginactivity.this, Syncontacts.class);
                     startActivity(it);
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(), "User Name and Password Does Not Matches", Toast.LENGTH_LONG).show();
                 }
             }
         });
     }
     catch (RuntimeException e)
     {
         Toast.makeText(getApplicationContext(),"exception",Toast.LENGTH_LONG).show();
     }
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        loginDatabaseAdapter.close();
    }
}
