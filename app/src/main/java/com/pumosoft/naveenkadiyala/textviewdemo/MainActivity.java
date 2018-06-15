package com.pumosoft.naveenkadiyala.textviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password,fname,lname,phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password =findViewById(R.id.password);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone);
        button =findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Demo2.class));
            }
        });

        email.setOnEditorActionListener(actionListener);
        password.setOnEditorActionListener(actionListener);
        phone.setOnEditorActionListener(actionListener);
    }
    private TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_NEXT)
            {
                switch (textView.getId())
                {
                    case R.id.email : emailValidator(); break;
                    case R.id.password: passwordValidator(); break;
                }
            }
            if (i == EditorInfo.IME_ACTION_DONE)
            {
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
            }
            return false;
        }
    };
    private void emailValidator() {
        String email_data = email.getText().toString();
        if (email_data.equals(""))
        {
            email.setError("Email Cannot be Empty");
        }
        else if (!email_data.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"))
        {
            email.setError("Invalid Format");
        }
    }
    private void passwordValidator() {
        String pass_data = password.getText().toString();
        if (pass_data.equals(""))
        {
            password.setError("Password Cannot be Empty");
        }
        else if(pass_data.length()<6)
        {
            password.setError("Invalid Format");
        }
    }
}
