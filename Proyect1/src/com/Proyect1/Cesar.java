package com.Proyect1;

public class Cesar extends Cifrar{
    public Cesar (String mensaje){
        super.Cifrar(mensaje);
    }
    public String codificar(){
        char [] caracteres = mensajeSinCifrar.toCharArray();
        int x = mensajeSinCifrar.length();
        for (int i = 0; i < x; i++){
            if (caracteres[i] == 32){
                caracteres[i] = 32;
            }
            if (caracteres[i] == 120){
                caracteres[i] = 97;
            }
            else if (caracteres[i] == 121){
                caracteres[i] = 98;
            }
            else if (caracteres[i] == 122){
                caracteres[i] = 99;
            }
            if (caracteres[i] <= 97 && caracteres[i] == 119){
                caracteres[i] += 3;
            }
        }
        for (int i = 0; i < x; i++){
            String mensajeCifrado = Character.toString(caracteres[i]);
        }


        return null;
    }
    public String getMensajeCifrado(){
        return mensajeCifrado;
    }
    public void setContraseña (String contraseña){
        Contraseña = "0";
    }
}
