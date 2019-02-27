package com.Proyect1;

import java.util.Arrays;

/*
* Clase cesar hereda de Cifrar
* Tiene el metodo codificar que usa la contraseña para desplazar el abecedario y guarda en otro arreglo
* metodo setMensaje llama al metodo cifrar
* tiene sus getters
* metodo set contraseña que revisa una excepcion si la contraseña es diferente a la necesitada
* si no es correcta se repite el proceso
* el metodo decodificar hace lo contrario que codificar
* */

public class Cesar extends  Cifrar {


    @Override
    public void codificar() {
        int j,band,resta;
        String mensajeSinCifrar = super.mensajeSinCifrar;
        mensajeSinCifrar = mensajeSinCifrar.toUpperCase();
        char[] cesar = new char [mensajeSinCifrar.length()];
        // recorrer mensaje sin cifrar
        for (int i = 0; i < mensajeSinCifrar.length(); i++) {
            j = 0; // contador de abc
            band = 0;
            // recorrer array de ABC
            do {
                // checa espacios
                if (mensajeSinCifrar.charAt(i) == ' '){
                    cesar[i] = mensajeSinCifrar.charAt(i);
                    band = 1;
                }
                if (mensajeSinCifrar.charAt(i) == ABC[j]){
                    resta = 26 - j;
                    int idx = Integer.parseInt(Contraseña);
                    if (resta <= idx){
                        int parametro = 26 - idx;
                        cesar[i] = ABC[j - parametro];
                        band = 1;
                    }
                    else {
                        cesar[i] = ABC[j+idx];
                        band = 1;
                    }
                }
                else {
                    j++;
                }
            } while (band == 0);
        }

        // imprimir mesaje cifrado
        mensajeCifrado = cesar;
    }

    public void setMensaje(String mensaje){
        super.Cifrar(mensaje);
    }

    @Override
    public String getMensajeCifrado() {
        return String.valueOf(mensajeCifrado);
    }

    @Override
    public void setContraseña(String password) {
        boolean passedProve = false;
        do{
            try{
                if(Character.isAlphabetic(password.charAt(0))){
                    throw new PasswordFormatException("Contraseña Incorrecta,Reintente");
                }else if(Character.getNumericValue(password.charAt(0))>6 || Character.getNumericValue(password.charAt(0))<3){
                    throw new PasswordFormatException("Contraseña mayor a 6 o menor a 3,Reintente");
                }else{
                    Contraseña = password;
                    passedProve = true;
                }
            }catch(PasswordFormatException e){
                e.printMessage();
                e.askForNewPassword();
                passedProve = e.passedProve;
            }
        }while(!passedProve);
    }

    @Override
    public void deCodificar(String mensaje) {
        int idx,band,j,resta,parametro;
        idx = Integer.parseInt(Contraseña);
        String cifrar = mensaje;
        String mensajeCesar = cifrar.toUpperCase();
        char[] descifrado = new char [cifrar.length() + 5];
        // recorrer mensaje cifrado
        for (int i = 0; i < mensajeCesar.length(); i++) {
            j = 0; // contador de abc
            band = 0;
            // recorrer array de abc
            do {
                // checa espacios
                if (mensajeCesar.charAt(i) == ' '){
                    descifrado[i] = mensajeCesar.charAt(i);
                    band = 1;
                }
                if (mensajeCesar.charAt(i) == ABC[j]){
                    if (j < idx){
                        resta = 26 - idx;
                        parametro = resta + j;
                        descifrado[i] = ABC[parametro];
                        band = 1;
                    }
                    else {
                        descifrado[i] = ABC[j-idx];
                        band = 1;
                    }
                }
                else {
                    j++;
                }
            } while (band == 0);
        }

        // imprimir mensaje descifrado
        mensajeDeCifrado  = descifrado;
    }

    @Override
    public String getMensajeDeCifrado() {
        return String.valueOf(mensajeDeCifrado);    }
}
