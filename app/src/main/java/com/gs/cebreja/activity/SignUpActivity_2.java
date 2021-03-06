package com.gs.cebreja.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gs.cebreja.R;
import com.gs.cebreja.controller.SignUpController;
import com.gs.cebreja.mapper.UserLoginMapper;
import com.gs.cebreja.model.User;
import com.gs.cebreja.model.UserRequest;
import com.gs.cebreja.model.UserRole;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.UserLoginResponse;
import com.gs.cebreja.network.response.UserRegisterResponse;
import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.view.IRegisterView;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity_2 extends MainActivity implements IRegisterView {

    private ImageButton signup_back_button;
    private Button btnLoginSignUp, btnFinishRegister;
    private RadioGroup radioGroup;
    private DatePicker datePicker;
    private SignUpController signUpPresenter;
    private String date,gender;
    private User user;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_2);
        SetupUI.set(findViewById(R.id.signUpPage2), SignUpActivity_2.this);
        dialog = new ProgressDialog(SignUpActivity_2.this);
        dialog.setTitle("Realizando Cadastro");
        dialog.setMessage("Carregando Solicitação");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

        signUpPresenter = new SignUpController(this);

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
                        dialog.show();
                        if(OldAgeValidade(datePicker.getDayOfMonth(),datePicker.getMonth()+1,datePicker.getYear())){
                            signUpPresenter.OnRegister_2();
                        }else {
                            Context contexto = getApplicationContext();
                            dialog.dismiss();
                            String texto = "Idade menor que 18 anos!";
                            Toast toast = Toast.makeText(contexto,texto,Toast.LENGTH_SHORT);
                            toast.show();
                        }
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

    @Override
    public void OnRegisterSuccess(String message) {
        //Recebendo dados do objeto vindo da tela anterior!
        user = getIntent().getParcelableExtra("user");
        date = String.valueOf(datePicker.getYear());
        date += "-0" + String.valueOf(datePicker.getMonth()+1);
        date += "-" + String.valueOf(datePicker.getDayOfMonth());
        date += "T03:00:00Z";
        gender = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        if (gender.equals("Masculino")){
            gender = "M";
        }else if(gender.equals("Feminino")){
            gender = "F";
        }else{
            gender = "O";
        }
        user.setBirthDate(date);
        user.setGender(gender);

        UserRequest userRequest = new UserRequest(date,user.getFirstName(),user.getLastName(),user.getGender(), user.getEmail(), user.getPassword());

        System.out.println(userRequest);

        post_request(userRequest);

        //Intent intent = new Intent(SignUpActivity_2.this, RankingActivity.class);
        //intent.putExtra("user", user);
        //startActivity(intent);
    }

    @Override
    public void OnRegisterError(String message) {
        dialog.dismiss();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
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

    public void post_request(UserRequest userRequest) {

        ApiService.getInstanceRegister()
                .obterDadosUser(userRequest)
                .enqueue(new Callback<UserRegisterResponse>() {
                    @Override
                    public void onResponse(Call<UserRegisterResponse> call, Response<UserRegisterResponse> response) {
                        if (response.isSuccessful()){
                            System.out.println(response.body().getToken());
                            User userN = new User(response.body().getEmail(),response.body().getFirstName(),response.body().getLastName(),response.body().getGender(),response.body().getBirthday(),response.body().getToken());
                            Intent intent = new Intent();
                            intent = new Intent(SignUpActivity_2.this, RankingActivity.class);
                            intent.putExtra("user", userN);
                            Toast.makeText(SignUpActivity_2.this,"Usuario registrado com sucesso",Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            startActivity(intent);
                            System.out.println(userN);
                        }else {
                            dialog.dismiss();
                            Toast.makeText(SignUpActivity_2.this,"Email ja registrado!",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<UserRegisterResponse> call, Throwable t) {
                        dialog.dismiss();
                        System.out.println("deu ruim");
                    }
                });

    }
}