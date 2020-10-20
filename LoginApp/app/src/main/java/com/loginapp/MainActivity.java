package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        EditText editEmailOrCpf = findViewById(R.id.editTextTextEmailAddress);
        String cpfOrEmail = editEmailOrCpf.getText().toString();
        EditText editPassword = findViewById(R.id.editTextTextPassword);
        String password = editPassword.getText().toString();

        User user = new User();
        List<User> users = user.getUser();
        for (int i = 0; i < users.size(); i++){
            if((cpfOrEmail.equals(users.get(i).Cpf) || cpfOrEmail.equals(users.get(i).Email)) && password.equals(users.get(i).Password))
            {
                Intent intent = new Intent(this, ShowDataActivity.class);
                startActivity(intent);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Erro de login!");
                builder.setMessage("Dados de usuário inválidos!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, "OK=" + arg1, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create();
                builder.show();
            }
        }
    }
}