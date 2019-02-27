package com.Proyect1;
/*
*CLASE ABSTARCTA NECESARIA, EL METODO CIFRAR SE UTILIZA EN TODO EL PROGRAMA
* Clase Cifrar extiende de Cifrador e implementa los metodos cifradores
* No tiene constructor
* Tiene un metodo que cumple como complemento de la asignacion del mensaje llamado cifrar
* este guarda el mensaje recibido, guarda el tamaño del arreglo de espacios
* crea un arreglo de espacios para guardar las posiciones donde habra espacios
* crea un nuevo arreglo de caracteres llamado mensaje cifrado y otro decifrado
* Tiene un metodo que cuenta los espacios dentro del String recibido
* */
public abstract class Cifrar extends Cifrador implements MetodosCifradores {


    public void Cifrar(String mensaje){
        mensajeSinCifrar = mensaje.toUpperCase();
        size_espacios = countSpaces(mensajeSinCifrar);
        espacios = new int[size_espacios];
        mensajeCifrado = new char[mensaje.length() + 10];
        mensajeDeCifrado = new char[mensajeCifrado.length];
    }


    private int countSpaces(String mensaje){
        int spaces = 0;

        for(char character:mensaje.toCharArray()){
            if(character==' '){
                spaces++;
            }
        }
        return spaces;
    }
}
