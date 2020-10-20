package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class ShowDataActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data);
        GetUser(intent);
    }

    private User GetUser(Intent intent){
        EditText editEmailOrCpf = findViewById(R.id.editTextTextEmailAddress);
        String cpfOrEmail = editEmailOrCpf.getText().toString();
        EditText editPassword = findViewById(R.id.editTextTextPassword);
        String password = editPassword.getText().toString();

        User u = new User();
        List<User> users = u.getUser();
        for(int i = 0; i < users.size(); i++){
            if((users.get(i).Email.equals(cpfOrEmail) || users.get(i).Cpf.equals(cpfOrEmail)) &&
                users.get(i).Password.equals(password)){
                u = users.get(i);
            }
        }

        return u;
    }

    public void backToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
