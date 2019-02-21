package com.Proyect1;
import java.util.*;
public  class Asabath extends Cifrar {

    public Asabath(String mensaje){
        super.Cifrar(mensaje);

        for(int i= 0; i<26; i++){
            ABCCodificador[i] = ABC[25-i];
        }
    }

    public void codificar() {
        int numeroLetra = 0;
        int positionMensajeCifrado = 0;
        for(char letra:mensajeSinCifrar.toCharArray()){
            numeroLetra = 0;
            if(letra==' '){
                mensajeCifrado[positionMensajeCifrado] = letra;
                positionMensajeCifrado++;
            }else {
                char letraMayuscula = Character.toUpperCase(letra);
                for (char ABCletra : ABC) {
                    if (letraMayuscula == ABCletra) break;
                    else numeroLetra++;
                }
                mensajeCifrado[positionMensajeCifrado] = ABCCodificador[numeroLetra];
                positionMensajeCifrado++;
            }
        }
    }

    public void deCodificar() {

    }

    public String getMensajeCifrado(){
        return Arrays.toString(mensajeCifrado);
    }

    public String getMensajeDeCifrado(){
        return Arrays.toString(mensajeDeCifrado);
    }

    public void setContraseña(String contraseña) {
        Contraseña = "0";
    }
}

