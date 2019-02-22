package com.Proyect1;

public class Cesar extends Cifrar{
    public Cesar (String mensaje){
        super.Cifrar(mensaje);
    }
    public String codificar(){
        mensajeSinCifrar.toLowerCase();
        char [] caracteres = mensajeSinCifrar.toCharArray(); // array de mensaje sin cifrar
        char [] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char [] abcesar = {'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'};
        char [] cesar = new char[1000];
        int x = mensajeSinCifrar.length();
        // recorrer mensaje sin cifrar
        for (int i = 0; i < x; i++){
            // recorrer array de abc
            for (int j = 0; j < 26; j++){
                // checa espacios
                if (caracteres[i] == ' '){
                    cesar[i] = ' ';
                }
                if (caracteres[i] == abc[j]){
                    cesar[i] = abcesar[i];
                    j = 27;
                }
            }
        }
        String 
        return null;
    }
    public String getMensajeCifrado(){
        return mensajeCifrado;
    }
    public void setContraseña (String contraseña){
        Contraseña = "0";
    }
}
