package com.example.dz_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        EditText editEmail;
        EditText editPassword;
        Button buttonConfig;
        TextView textAk;
        String isPassword = "admin";
        TextView textVxod;
        TextView textVipVxod;
        TextView textOne;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.ed_email);
        editPassword = findViewById(R.id.ed_password);
        buttonConfig = findViewById(R.id.button);
        textAk = findViewById(R.id.clk_text);
        textVxod = findViewById(R.id.vxod);
        textVipVxod = findViewById(R.id.text_vipvxod);
        textOne = findViewById(R.id.text1);



        editEmail.addTextChangedListener(write);
        editPassword.addTextChangedListener(write);

        click();
        textClick();
    }
    private TextWatcher write = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String inputEmail = editEmail.getText().toString().trim();
            String InputPassword = editPassword.getText().toString().trim();
            buttonConfig.setActivated(!inputEmail.isEmpty() || !InputPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };

    public void click () {
        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                if (!email.equals(isPassword) || !password.equals(isPassword)) {
                    if (!email.equals(isPassword)){
                        editEmail.setError("Неправильный логин");
                    }
                    else if (!password.equals(isPassword)){
                        editPassword.setError("Неправильный пароль");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    editEmail.setVisibility(View.INVISIBLE);
                    editPassword.setVisibility(View.INVISIBLE);
                    buttonConfig.setVisibility(View.INVISIBLE);
                    textAk.setVisibility(View.INVISIBLE);
                    textVxod.setVisibility(View.INVISIBLE);
                    textVipVxod.setVisibility(View.INVISIBLE);
                    textOne.setVisibility(View.INVISIBLE);
                }

            }
        });

    }
    public void textClick(){
        textAk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    }
