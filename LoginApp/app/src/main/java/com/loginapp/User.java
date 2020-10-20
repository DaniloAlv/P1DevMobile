package com.loginapp;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String Name;
    public String Email;
    public String Cpf;
    public String Password;

    User(){}

    User(String name, String email, String cpf, String password)
    {
        Name = name;
        Email = email;
        Cpf = cpf;
        Password = password;
    }

    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        User danilo = new User("Danilo", "dan.alves300@gmail.com", "25898713233", "nanadoludovigo01");
        User lais = new User("Lais", "laiz@uool.com.br", "12396478520", "lasanhola86");
        User peter = new User("Peter", "parker_peter@outlook.com", "11977630425", "Miranha99");
        users.add(danilo);
        users.add(lais);
        users.add(peter);

        return users;
    }
}
