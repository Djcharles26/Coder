package com.Proyect1;

import java.util.Arrays;
/*
* Clase TransposicionColumnar que hereda de Cifrar
* Metodo Codificar, realiza el algoritmo en el documento de word
* Tiene getters
* Metodo deCodificar, realiza el algoritmo en el documento de word
* Todos los metodos manejan problemas de arraynullpointer para que no se rompa
* Metodo setMensaje utiliza el metodo cifrar
* */
public class TransposicionColumnar extends  Cifrar{
    private char[][] mat;

    @Override
    public void codificar() {
        int num_col = Integer.parseInt(Contraseña);
        int num_reng;
        int y = 0, z  = 0;
        for(char letra:mensajeSinCifrar.toCharArray()){
            if(letra == ' '){
                espacios[z] = y;
                z++;

            }
            y++;
        }

        String mensajeSinCifrado = mensajeSinCifrar.toUpperCase().replaceAll("\\s","");



        if (mensajeSinCifrado.length() % num_col == 0)
            num_reng = mensajeSinCifrado.length() / num_col;
        else
            num_reng = (mensajeSinCifrado.length() / num_col) + 1;
        mat = new char[num_reng][num_col];

        char []transposicion = new char [(num_col*num_reng) + 10];

        int cont = 0;
        // pasa de cadena a matriz
        for (int i = 0; i < num_reng; i++){
            for (int j = 0; j < num_col; j++){
                mat[i][j] = mensajeSinCifrado.charAt(cont);
                cont++;
                if(cont >= mensajeSinCifrado.length()){
                    break;
                }
            }
        }

        // imprimir la matriz llena con los caracteres del mensaje
        for (int i = 0; i < num_reng; i++){
            for (int j = 0; j < num_col; j++){
                System.out.printf("[%c]  ",mat[i][j]);
            }
            System.out.printf("\n");
        }

        // guardar en string
        int k = 0;
        for (int j = 0; j < num_col; j++){
            for (int i = 0; i < num_reng; i++){
                transposicion[k] = mat[i][j];
                k++;
            }
            transposicion[k] = ' ';
            k++;
        }

        mensajeCifrado = transposicion;
        mensajeCifrado[mensajeCifrado.length - 1] = '\n';
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
                }else{
                    Contraseña = password;
                    passedProve = true;
                }
            }catch(PasswordFormatException e){
                e.printMessage();
                e.askForNewPassword();
            }
        }while(!passedProve);

    }

    public void setMensaje(String mensaje){
        super.Cifrar(mensaje);

    }

    @Override
    public void deCodificar(String mensaje) {
        int num_col,cont,k;
        String cifrar = mensaje;
        int cont_espacios = 0;
        char [][]mat_cifrar = null;
        if(mensajeSinCifrar == null){
            mensajeSinCifrar = cifrar;
        }
        // contar espacios
        for (int i = 0; i < cifrar.length() && cifrar.charAt(i) != '\n'; i++){
            if (cifrar.charAt(i) == ' ') {
                cont_espacios++;
            }
        }
        int num_reng=0;
        if(cont_espacios<1) num_reng++;
        else while(cifrar.charAt(num_reng)!=' ') num_reng++;
        if(cifrar.charAt(cifrar.length() - 1)!=' ') cont_espacios++;
        num_col = cont_espacios; // int num_col = cont_espacios++;
        char []cifrado = new char[num_col*num_reng  + size_espacios + 1 ];

        String mensajeTransposicion = cifrar.toUpperCase().replaceAll("\\s","");

//        if (mensajeTransposicion.length() - 1 % num_col == 0){
//            num_reng = mensajeTransposicion.length() / num_col;
//        }
//        else{
//            num_reng = (mensajeTransposicion.length() - 1 / num_col) + 1;
//        }

        mat_cifrar = new char[num_reng][num_col];
        cont = 0; // int cont = 0;
        // pasa de cadena a matriz

        for (int j = 0; j < num_col; j++){
            for (int i = 0; i < num_reng; i++){
                mat_cifrar[i][j] = mensajeTransposicion.charAt(cont);
                cont++;
                if(cont >= mensajeSinCifrar.length()){
                    break;
                }
            }
        }

        // guardar en string
        k = 0; // int k = 0
        int y = 0, z = 0;
        for (int i = 0; i < num_reng; i++){
            for (int j = 0; j < num_col; j++){
                if(y<size_espacios && espacios[y] == z){
                    cifrado[k] = ' ';
                    y++;
                    k++;
                }
                cifrado[k] = mat_cifrar[i][j];
                k++;

                z++;
            }
        }

        // impresion de mensaje descifrado
        String mensajeD = String.valueOf(cifrado).toUpperCase().replaceAll("\0","");
        mensajeDeCifrado = mensajeD.toCharArray();

    }

    @Override
    public String getMensajeDeCifrado() {
        return String.valueOf(mensajeDeCifrado);
    }
}
