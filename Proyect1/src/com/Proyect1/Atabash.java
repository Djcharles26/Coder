package com.Proyect1;
/*
* Clase Atabash, Extiende de Cifrar
*Su constructor genera el abecedario que usaremos para codificar
* El metodo codificar usa un forEach para checar letra por letra
* si es espacio lo mete directo a la cadena decifrado, si no, la hace mayuscula y busca en el
* abecedario para cambiar con la posicion del abecedario codificador
* Tiene el metodo set mensaje que llama al metodo cifrar
* El metodo deCodificar hace lo contrario exactamente que el de codificar
* Tiene getter para Codificar y decodificar
* */
public  class Atabash extends Cifrar {

    public Atabash(){
        for(int i= 0; i<26; i++){
            ABCCodificador[i] = ABC[25-i];
        }
    }

    public void codificar() {
        int numeroLetra = 0;
        int positionMensajeCifrado = 0;
        for(char letra : mensajeSinCifrar.toCharArray()){
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

    public void setMensaje(String mensaje){
        super.Cifrar(mensaje);
    }


    public void deCodificar(String mensaje) {
        mensajeCifrado = mensaje.toCharArray();
        if(mensajeDeCifrado == null) mensajeDeCifrado = new char[mensajeCifrado.length];

        int numeroLetra = 0;
        int posMensajeDecifrado = 0;
        for(char letra: mensajeCifrado){
            numeroLetra = 0;
            if(letra == ' ') {
                mensajeDeCifrado[posMensajeDecifrado] = letra;
                posMensajeDecifrado++;
            }else if(letra == '\0') break;
            else{
                for(char ABCletra: ABCCodificador){
                    if(letra == ABCletra) break;
                    else numeroLetra++;
                }
                mensajeDeCifrado[posMensajeDecifrado] = ABC[numeroLetra];
                posMensajeDecifrado++;
            }
        }
        String mensajeD = String.valueOf(mensajeDeCifrado).toUpperCase().replaceAll("\0","");
        mensajeDeCifrado = mensajeD.toCharArray();
    }

    public String getMensajeCifrado(){
        return String.valueOf(mensajeCifrado);
    }

    public String getMensajeDeCifrado(){
        return String.valueOf(mensajeDeCifrado);
    }

    public void setContraseña(String contraseña) {
        Contraseña = "0";
    }
}

