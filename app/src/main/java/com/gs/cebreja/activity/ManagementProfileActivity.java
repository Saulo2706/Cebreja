package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;
import com.gs.cebreja.model.UserRequest;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.UserRegisterResponse;
import com.gs.cebreja.network.response.UserUpdateResponse;
import com.gs.cebreja.util.SetupUI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementProfileActivity extends AppCompatActivity {

    private String oldEmail, birthday,newPassword;
    private User user;
    private EditText etEmail;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_profile);
        SetupUI.set(findViewById(R.id.manageProfile), ManagementProfileActivity.this);
        user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        oldEmail = user.getEmail();
        birthday = user.getBirthDate() + "T03:00:00Z";

        dialog = new ProgressDialog(ManagementProfileActivity.this);
        dialog.setTitle("Realizando Alteração");
        dialog.setMessage("Carregando Solicitação");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);


        ImageButton manage_back_btn;
        Button set_new_password_btn;
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etlastName);
        etEmail = findViewById(R.id.etEmail);
        EditText etNewPassword1 = findViewById(R.id.etNewPassword1);
        EditText etNewPassword2 = findViewById(R.id.etNewPassword2);

        etFirstName.setText(user.getFirstName());
        etLastName.setText(user.getLastName());
        etEmail.setText(user.getEmail());

        //Botão voltar
        manage_back_btn = findViewById(R.id.manage_back_btn);
        manage_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

        set_new_password_btn = findViewById(R.id.set_new_password_btn);
        set_new_password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                if (etNewPassword2.getText().toString().equals(etNewPassword1.getText().toString())){
                    if (etNewPassword1.getText().toString().isEmpty()){
                        newPassword = null;
                    }else {
                        newPassword = etNewPassword1.getText().toString();
                    }

                    UserRequest userRequest = new UserRequest(birthday,etFirstName.getText().toString(),etLastName.getText().toString(),user.getGender(),etEmail.getText().toString(),newPassword);
                    post_request(userRequest);
                }else{
                    dialog.dismiss();
                    Toast.makeText(ManagementProfileActivity.this,"Senhas não conferem!!",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void post_request(UserRequest userRequest) {

        ApiService.getInstanceUpdateUser()
                .updateUser("Bearer "+User.token,userRequest)
                .enqueue(new Callback<UserUpdateResponse>() {
                    @Override
                    public void onResponse(Call<UserUpdateResponse> call, Response<UserUpdateResponse> response) {
                        if (response.isSuccessful()){
                            if (oldEmail.equals(etEmail.getText().toString())){
                                Intent intent = new Intent(ManagementProfileActivity.this, RankingActivity.class);
                                user.setEmail(response.body().getEmail());
                                user.setFirstName(response.body().getFirstName());
                                user.setLastName(response.body().getLastName());
                                intent.putExtra("user", user);
                                Toast.makeText(ManagementProfileActivity.this,"Perfil alterado com sucesso!",Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                                startActivity(intent);
                            }else{
                                dialog.dismiss();
                                Intent intent = new Intent(ManagementProfileActivity.this, LoginActivity.class);
                                Toast.makeText(ManagementProfileActivity.this,"Perfil alterado com sucesso, por favor realize o login novamente!",Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }
                        }else {
                            dialog.dismiss();
                            Toast.makeText(ManagementProfileActivity.this,"Email já cadastrado ou invalido, ou senha não atinge os criterios mínimos de 9 caracteres!",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<UserUpdateResponse> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(ManagementProfileActivity.this,"Erro ao requisitar a API - verifique sua conexão com a internet!",Toast.LENGTH_LONG).show();
                    }
                });

    }


}