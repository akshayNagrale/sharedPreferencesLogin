package com.andro.sharedpreferenceslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_login;
    MainActivity context;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        checkbox = findViewById(R.id.checkbox);
        context = MainActivity.this;
        btn_login = findViewById(R.id.btn_login);

        setCondition();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hiiiiii", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
                startActivity(intent);
            }
        });

//
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.commit();
                    Toast.makeText(context, "checked", Toast.LENGTH_SHORT).show();

                } else if (buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "False");
                    editor.commit();
                    Toast.makeText(context, "Unchecked", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void setCondition() {
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals(true)) {
            Intent i = new Intent(context, WelcomeScreen.class);
            startActivity(i);
        } else if (checkbox.equals(false)) {
            Toast.makeText(context, "Please Sign In First", Toast.LENGTH_LONG).show();
        }
//
    }
}
