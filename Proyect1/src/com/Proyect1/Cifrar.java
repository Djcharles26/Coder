package com.Proyect1;

public abstract class Cifrar extends Cifrador implements MetodosCifradores {
    public void Cifrar(String mensaje){
        mensajeSinCifrar = mensaje;
        size_espacios = countSpaces(mensajeSinCifrar);
        espacios = new int[size_espacios];

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
