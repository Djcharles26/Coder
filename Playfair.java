package com.Proyect1;

public class Playfair extends  Cifrar {
    private char[][] ABCCodificador = new char[5][5];

	private char [] mensajeConFormato;
	
	public Playfair(String mensaje, String password){
	
		this.mensajeSinCifrar = mensaje;
		this.mensajeConFormato = new char[mensaje.length() + 5];
		this.size_espacios  = mensaje.length() +5;
		setContraseña(password);
		this.espacios = new int[mensaje.length() + 5];
		createABCtoCode();
	}
	
    @Override
    public void setContraseña(String password) throws passwordFormatException{
		do{
			try{
				Contraseña = password;
			}catch(passwordFormatException e){
				e.printMessage();
				password = e.askForNewPassword();
			}
		}while(e.passedProove);
    }
	
	
	
	
	private void createABCtoCode(){
		int i=0, j=0;
		boolean cantAdd = false;
        for(char letra: Contraseña.toCharArray()){
			
			ABCCodificador[i][j] = letra;
			j++;
			if(j==5){
				j=0;
				i++;
			}
        }
		
		for(char ABCletra: ABC){
			cantAdd  = false;
			for(char letra:Contraseña.toCharArray()){
				if(letra==ABCletra){
					cantAdd = true;
				}
			}
			if(!cantAdd){
				ABCCodificador[i][j]=ABCletra; 
				j++;
				if(j==5){
					i++;
					j=0;
				}
			}
		 	
			
		}
	
	}

    
	private void addFormatToMessage(){
	
		int i = 0;
		int j = 0 ;
		int lettersInserted = 0;
		for(char letra: mensajeSinCifrar.toCharArray()){
			
			if(letra == ' '){
				espacios[i] = j;
				i++;
			}else{
				mensajeConFormato[j] = letra;
				lettersInserted++;
				if(lettersInserted == 2){
					mensajeConFormato[j] = ' ':
					j++;
				}
			}
			j++;
		}
	}	
	
	@Override
    public void codificar() {
		char letter1,letter2;
		int x = 0;
		int iLetter[] = new int[2], jLetter[] = new int[2], currentLetter = 0;
		for(int h =0; h<2; h++) {
			for (int i = 0; i < 5:i++){
				for (int j = 0; j < 5; j++) {
					if(mensajeConFormato[currentLetter] == ' ') {
						mensajeCifrado[x] = ' ';
						x++;
					}else if (mensajeConFormato[currentLetter] == ABCCodificador[i][j]) {
						i = iLetter[h];
						j = jLetter[h];
					}
				}

			}
		}

		if(iLetter[0]==iLetter[1]){

			for(int i = 0; i<2; i++) {
				if (jLetter[i] ==4){
					mensajeCifrado[x] = ABCCodificador[iLetter[0]][0];
				}else{
					mensajeCifrado[x] = ABCCodificador[iLetter[0]][jLetter[i] + 1];
				}
			}
		}else if(jLetter[0] == jLetter[1]){

			for(int i = 0; i<2; i++){
				if(iLetter[i]==4){
					mensajeCifrado[x] = ABCCodificador[0][jLetter[0]];
					x++;
				}else{
					mensajeCifrado[x] = ABCCodificador[iLetter[i] + 1][jLetter[0]];
					x++;
				}
			}
		}else{
			mensajeCifrado[x] = ABCCodificador[iLetter[0]][jLetter[1]];
			x++;
			mensajeCifrado[x] = ABCCodificador[iLetter[1]][jLetter[0]];
			x++;
		}


		
		
    }

    @Override
    public String getMensajeDeCifrado() {
        return mensajeDecifrado;
    }
    public String getMensajeCifrado(){

        return mensajeCifrado;
    }

    @Override
    public void deCodificar() {



    }


}
