package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class ForgetPasswordCodeVerifyActivity extends MainActivity {

    private ImageButton forget_password_back_btn;
    private Button forget_password_next_btn;
    private EditText code1,code2,code3,code4,code5;
    private int previousLength;
    private boolean backSpace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_code_verify);
        SetupUI.set(findViewById(R.id.activity_forget_password_code_verify), ForgetPasswordCodeVerifyActivity.this);

        code1 = (EditText) findViewById(R.id.code1);
        code2 = (EditText) findViewById(R.id.code2);
        code3 = (EditText) findViewById(R.id.code3);
        code4 = (EditText) findViewById(R.id.code4);
        code5 = (EditText) findViewById(R.id.code5);

        code1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();
                if (backSpace) {
                    code1.requestFocus();
                }
                else {
                    code2.requestFocus();
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        code2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();
                if (backSpace) {
                    code1.requestFocus();
                }else{
                    code3.requestFocus();
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        code3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();
                if (backSpace) {
                    code2.requestFocus();
                }else{
                    code4.requestFocus();
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        code4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();
                if (backSpace) {
                    code3.requestFocus();
                }else{
                    code5.requestFocus();
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        code5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                backSpace = previousLength > s.length();
                if (backSpace) {
                    code4.requestFocus();
                }else{
                    SetupUI.hideSoftKeyboard(ForgetPasswordCodeVerifyActivity.this);
                    //CODIGO VERIFICADOR
                    String code = code1.getText().toString().toUpperCase() + code2.getText().toString().toUpperCase() + code3.getText().toString().toUpperCase() + code4.getText().toString().toUpperCase() + code5.getText().toString().toUpperCase();
                    System.out.println(code);
                }


            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });



        //Botão proximo
        forget_password_next_btn = (Button) findViewById(R.id.forget_password_next_btn);
        forget_password_next_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(ForgetPasswordCodeVerifyActivity.this, ForgetPasswordResetActivity.class);
                    }
                }
        );

        //Botão voltar
        forget_password_back_btn = (ImageButton) findViewById(R.id.forget_password_back_btn);
        forget_password_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );
    }
}