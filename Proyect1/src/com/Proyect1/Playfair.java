package com.Proyect1;

import java.util.Arrays;

/*
* Clase PlayFair que hereda de Cifrar
*Metodo Setcontraseña que revisa una excepcion dada si la contraseña es dada incorrectamente
* Metodo createABCtoCode que crea la matriz de 5 x 5 necesaria para codificar
* guarda la contraseña sin repetir letras y sucesivamente el abecedario
* Metodo addFormatToMessage Separa el mensaje recibido en pares de letras, agrega X cuando
* son dos letras seguidas iguales y si falta una letra para hacer el ultimo par
* Metodo Codificar, va revisando de dos en dos letras, y realiza el algoritmo asignado en el
* documento, los espacios los inserta directo en la cadena mensajeCifrado
* Metodo Decodificar, realiza el mismo algoritmo que Codificar pero de manera inversa
* Tiene getters
* Metodo Set mensaje que llama al metodo cifrar, y ademas genera los arreglos necesarios
* utilizados en la clase
*
* */
public class Playfair extends  Cifrar {
    private char[][] ABCCodificador = new char[5][5];
    private char [] mensajeConFormato;

    @Override
    public void setContraseña(String password){
        boolean passedProove = true;
        do{
            try{
                Contraseña = password.toUpperCase();
                for(char letra:Contraseña.toCharArray()){
                    if(!Character.isAlphabetic(letra)){
                        throw new PasswordFormatException();
                    }else{
                        passedProove = true;
                    }
                }
            }catch(PasswordFormatException e){
                e.printMessage();
                password = e.askForNewPassword();
                passedProove = e.passedProve;
            }
        }while(!passedProove);
        createABCtoCode();
    }


    private void createABCtoCode(){
        int i=0, j=0;
        boolean cantAdd = false;
        ABCCodificador = new char[5][5];
        for(char letra: Contraseña.toCharArray()){
            cantAdd = false;
            for(int k=0; k<5; k++){
                for(int l=0; l<5; l++){
                    if(ABCCodificador[k][l]=='\0') break;
                    else if(letra==ABCCodificador[k][l]){
                        cantAdd = true;
                        break;
                    }
                }
            }
            if(!cantAdd) {
                ABCCodificador[i][j] = letra;
                j++;
            }

            if(j==5){
                j=0;
                i++;
            }
        }

        for(char ABCletra: ABC){
            if(ABCletra != 'J'){
                cantAdd  = false;
                for(char letra:Contraseña.toCharArray()){

                    if(letra==ABCletra){
                        cantAdd = true;
                        break;
                    }
                }
                if(!cantAdd) {
                    ABCCodificador[i][j] = ABCletra;
                    j++;
                    if (j == 5) {
                        i++;
                        j = 0;
                    }
                }
            }


        }

    }


    private void addFormatToMessage(){

        int i = 0;
        int j = 0 ;
        int k = 0;
        int lettersInserted = 0;
        char letraSaved = ' ';
        for(char letra: mensajeSinCifrar.toCharArray()){

            if(lettersInserted == 2){

                j++;
                mensajeConFormato[j] = ' ';
                lettersInserted = 0;

            }if(letra == ' '){

                espacios[i] = k;
                i++;

            }else{
                if(letra == 'J'){
                    letra = 'I';
                }
                if(lettersInserted == 1){

                    if(letraSaved == letra){
                        mensajeConFormato[j] = 'X';
                        j++;
                        mensajeConFormato[j] = ' ';
                        lettersInserted = 0;
                    }
                }

                mensajeConFormato[j] = letra;
                lettersInserted++;
                k++;
                j++;
                if(lettersInserted == 1) letraSaved = letra;


            }

        }
        if(lettersInserted<2){
            mensajeConFormato[j] = 'X';
            j++;
        }
        mensajeConFormato[j] = '\n';
    }

    @Override
    public void codificar() {
        addFormatToMessage();
        char letter1,letter2;
        int x = 0;
        boolean stopAdding = false;
        int[] iLetter = new int[2];
        int[] jLetter = new int[2];
        int currentLetter = 0;
        do {
            for (int h = 0; h < 2; h++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (mensajeConFormato[currentLetter] == '\0') {
                            mensajeCifrado[x] = ' ';
                            currentLetter++;
                            x++;
                            i = 5;
                            j = 5;
                            h--;
                        } else if (mensajeConFormato[currentLetter] == ABCCodificador[i][j]) {
                            iLetter[h] = i;
                            jLetter[h] = j;
                            currentLetter++;
                            i = 5;
                            j = 5;
                        }else if(mensajeConFormato[currentLetter] == '\n'){
                            i= 5;
                            j = 5;
                            h = 2;
                            stopAdding = true;
                        }
                    }

                }
            }
            if(!stopAdding) {
                if (iLetter[0] == iLetter[1]) {

                    for (int i = 0; i < 2; i++) {
                        if (jLetter[i] == 4) {
                            mensajeCifrado[x] = ABCCodificador[iLetter[0]][0];
                        } else {
                            mensajeCifrado[x] = ABCCodificador[iLetter[0]][jLetter[i] + 1];
                        }
                        x++;
                    }
                } else if (jLetter[0] == jLetter[1]) {

                    for (int i = 0; i < 2; i++) {
                        if (iLetter[i] == 4) {
                            mensajeCifrado[x] = ABCCodificador[0][jLetter[0]];
                            x++;
                        } else {
                            mensajeCifrado[x] = ABCCodificador[iLetter[i] + 1][jLetter[0]];
                            x++;
                        }
                    }
                } else {
                    mensajeCifrado[x] = ABCCodificador[iLetter[0]][jLetter[1]];
                    x++;
                    mensajeCifrado[x] = ABCCodificador[iLetter[1]][jLetter[0]];
                    x++;
                }
            }
        }while(mensajeConFormato[currentLetter]!='\n');
    }

    @Override
    public String getMensajeDeCifrado() {
        return String.valueOf(mensajeDeCifrado);
    }

    @Override
    public void setMensaje(String mensaje) {
        super.Cifrar(mensaje);
        this.mensajeConFormato = new char[mensajeSinCifrar.length() + 20];
        this.size_espacios  = mensaje.length() +5;
        this.espacios = new int[mensaje.length() + 5];
    }

    public String getMensajeCifrado(){
        return String.valueOf(mensajeCifrado);
    }

    @Override
    public void deCodificar(String mensaje) {
        String deCifrar = mensaje;
        if(espacios == null) espacios = new int[5];
        if(mensajeDeCifrado == null) mensajeDeCifrado = new char[deCifrar.length()];
        int i = 0, j = 0 , h = 0;
        int [] xLetter = new int[2], yLetter = new int[2];
        deCifrar = deCifrar.toUpperCase().replaceAll("\\s","");
        for(char letra: deCifrar.toCharArray()){
            if(espacios[i]==j) {
                mensajeDeCifrado[j] = ' ';
                j++;
                i++;
            }
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (letra == ABCCodificador[x][y]) {
                        xLetter[h] = x;
                        yLetter[h] = y;
                        x = y = 5;
                        h++;
                    }
                }
            }
            if(h==2) {
                if (xLetter[0] == xLetter[1]) {
                    for (int x = 0; x <2; x++) {
                        if (yLetter[x] == 0)
                            mensajeDeCifrado[j] = ABCCodificador[xLetter[0]][4];
                         else
                            mensajeDeCifrado[j] = ABCCodificador[xLetter[0]][yLetter[x] - 1 ];
                        j++;
                    }
                }else if(yLetter[0] == yLetter[1]){
                    for(int x = 0; x <2; x++){
                        if(xLetter[x] == 0)
                            mensajeDeCifrado[j] = ABCCodificador[4][yLetter[0]];
                        else
                            mensajeDeCifrado[j] = ABCCodificador[xLetter[x] - 1][yLetter[0]];
                        j++;
                    }
                }else{
                    mensajeDeCifrado[j] = ABCCodificador[xLetter[0]][yLetter[1]];
                    j++;
                    mensajeDeCifrado[j] = ABCCodificador[xLetter[1]][yLetter[0]];
                    j++;
                }
                h = 0;
            }

        }
    //TODO:
        String mensajeD = String.valueOf(mensajeDeCifrado).toUpperCase().replaceAll("\0","");
        mensajeDeCifrado = mensajeD.toCharArray();
    }

}
