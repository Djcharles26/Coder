package com.Proyect1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Cesar extends Cifrar{
    public Cesar (String mensaje){
        super.Cifrar(mensaje);
    }
    public String codificar(){
        mensajeSinCifrar.toLowerCase();
        char [] caracteres = mensajeSinCifrar.toCharArray(); // array de mensaje sin cifrar
        char [] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char [] abcesar = {'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'};
        char [] mensajeCifrado = new char[1000];
        int x = mensajeSinCifrar.length();
        // recorrer mensaje sin cifrar
        for (int i = 0; i < x; i++){
            // recorrer array de abc
            for (int j = 0; j < 26; j++){
                // checa espacios
                if (caracteres[i] == ' '){
                    mensajeCifrado[i] = ' ';
                }
                if (caracteres[i] == abc[j]){
                    mensajeCifrado[i] = abcesar[i];
                    j = 27;
                }
            }
        }
        return null;
    }
    public String getMensajeCifrado(){
        return Arrays.toString(mensajeCifrado);
    }
    public void setContraseña (String contraseña){
        Contraseña = "0";
    }
}
