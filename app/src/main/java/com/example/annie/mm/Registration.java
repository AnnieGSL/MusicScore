package com.example.annie.mm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText etAge = (EditText)findViewById(R.id.etAge);
        final EditText etName = (EditText)findViewById(R.id.etName);
        final EditText etUser = (EditText)findViewById(R.id.etUser);
        final EditText etPassword = (EditText)findViewById(R.id.etPassword);

        final Button bRegister = (Button)findViewById(R.id.user_register_button);

        int imeActionId = getResources().getInteger(R.integer.customImeActionId);
    }
}
