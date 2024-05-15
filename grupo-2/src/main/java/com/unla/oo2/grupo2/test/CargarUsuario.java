package com.unla.oo2.grupo2.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CargarUsuario {
    public static void main(String[] args) {
        BCryptPasswordEncoder cripto = new BCryptPasswordEncoder();
        String password = "1234";
        System.out.println(cripto.encode(password));;
    }
}
