package com.example.thesisapplication.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.thesisapplication.Homepage.AddCarabao;
import com.example.thesisapplication.Homepage.MainActivity;
import com.example.thesisapplication.R;

public class LoginActivity extends AppCompatActivity {

    String userMode; //online or offline
    int passwordMode = 0; //hidden
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        ImageButton passwordToggle = findViewById(R.id.passwordToggle);
        Button loginBtn = findViewById(R.id.loginBtn);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        // on below line we are adding check change listener for our radio group.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);
                userMode = String.valueOf(radioButton.getText());

                // on below line we are displaying a toast message.
                //Toast.makeText(LoginActivity.this, "Selected Radio Button is : " + userMode, Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AddCarabao.class));
            }
        });

        passwordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordMode == 0) {
                    passwordToggle.setImageResource(R.drawable.baseline_visibility_24);
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    passwordMode = 1;
                } else if(passwordMode == 1) {
                    passwordToggle.setImageResource(R.drawable.baseline_visibility_off_24);
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordMode = 0;
                }
            }
        });
    }
}