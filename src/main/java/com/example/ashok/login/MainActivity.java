package com.example.ashok.login;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button bsignup,bsignin;
    //LoginDatabaseAdapter loginDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loginDatabaseAdapter=new LoginDatabaseAdapter(this);
        //loginDatabaseAdapter=loginDatabaseAdapter.open();

        bsignin=(Button)findViewById(R.id.button);
        bsignup=(Button)findViewById(R.id.button2);

        bsignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(i);
            }
        });
    }
    public void signin(View v)
    {
        Intent in=new Intent(getApplicationContext(),Loginactivity.class);
        startActivity(in);
    }
}

