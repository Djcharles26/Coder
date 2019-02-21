package com.Proyect1;

public  class Asabath extends Cifrar {

    public Asabath(String mensaje){
        super.Cifrar(mensaje);

        for(int i= 0; i<26; i++){
            ABCCodificador[i] = ABC[25-i];
        }
    }

    public String codificar() {
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
        return mensajeCifrado.toString();
    }

    public String getMensajeCifrado(){
        return mensajeCifrado.toString();
    }

    public void setContraseña(String contraseña) {
        Contraseña = "0";
    }
}

