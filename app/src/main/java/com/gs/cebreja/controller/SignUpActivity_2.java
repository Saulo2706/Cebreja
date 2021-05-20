package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUpActivity_2 extends MainActivity{

    private ImageButton signup_back_button;
    private Button btnLoginSignUp, btnFinishRegister;
    private RadioGroup radioGroup;
    private DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_2);
        SetupUI.set(findViewById(R.id.signUpPage2), SignUpActivity_2.this);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

        //BOTÃO DE VOLTAR
        signup_back_button = (ImageButton) findViewById(R.id.signup_back_button);
        signup_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

        //BOTÃO FINALIZAR CADASTRO
        btnFinishRegister = (Button) findViewById(R.id.signup_finish_button);
        btnFinishRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String radiovalue =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();



                        String date = String.valueOf(datePicker.getYear());
                        date += "-" + String.valueOf(datePicker.getMonth()+1);
                        date += "-" + String.valueOf(datePicker.getDayOfMonth());

                        if(OldAgeValidade(datePicker.getDayOfMonth(),datePicker.getMonth()+1,datePicker.getYear())){
                            System.out.println("Radio Val: "+ radiovalue + " Dt. Nascimento: " + date);
                        }else {
                            Context contexto = getApplicationContext();
                            String texto = "Idade menor que 18 anos!";
                            int duracao = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(contexto, texto,duracao);
                            toast.show();
                        }



                        //changeActivity(SignUpActivity_2.this, LoginActivity.class);
                    }
                }
        );

        //BOTÃO PARA IR PARA TELA DE LOGIN
        btnLoginSignUp = (Button) findViewById(R.id.signup_login_button_2);
        btnLoginSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity_2.this, LoginActivity.class);
                    }
                }
        );



    }

    private boolean OldAgeValidade(int diaN, int mesN, int anoN){
        Calendar c = Calendar.getInstance();
        int diaA = c.get(Calendar.DAY_OF_MONTH);
        int mesA = c.get(Calendar.MONTH)+1;
        int anoA = c.get(Calendar.YEAR);

        int idade = anoA - anoN;
        if(mesN > mesA){
            idade--;
        }else if(mesA == mesN){
            if(diaN >= diaA){
                idade--;
            }
        }

        if (idade >= 18){
            return true;
        }else{
            return false;
        }
    }
}