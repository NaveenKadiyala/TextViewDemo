package com.pumosoft.naveenkadiyala.textviewdemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Demo2 extends AppCompatActivity {

    private TextInputLayout email_textInputLayout,pass_textInputLayout;
    private Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        email_textInputLayout = findViewById(R.id.text_input_email);
        pass_textInputLayout = findViewById(R.id.text_input_password);
        login_btn = findViewById(R.id.login_btn);
    }
    private boolean validateEmail()
    {
        String email_data = email_textInputLayout.getEditText().getText().toString().trim();
        if (email_data.isEmpty())
        {
            email_textInputLayout.setError("Email Cannot be Empty");
            return false;
        }
        else {
            email_textInputLayout.setError(null);
            email_textInputLayout.setCounterEnabled(false);
            return true;
        }
    }
    private boolean validatePass()
    {
        String pass_data = pass_textInputLayout.getEditText().getText().toString().trim();
        if (pass_data.isEmpty())
        {
            pass_textInputLayout.setError("Password Cannot be Empty");
            return false;
        }
        else {
            pass_textInputLayout.setError(null);
            pass_textInputLayout.setCounterEnabled(false);
            return true;
        }
    }
    public void confirmInput(View view)
    {
        if (!validateEmail() && !validatePass())
        {
            return;
        }
        String input = "Email : " +email_textInputLayout.getEditText().getText().toString();
        input += "\n";
        input += "Password : "+ pass_textInputLayout.getEditText().getText().toString();
        Toast.makeText(getApplicationContext(),input,Toast.LENGTH_LONG).show();
    }
}
