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
		
		
		
    }

    @Override
    public String getMensajeDeCifrado() {
        return null;
    }
    public String getMensajeCifrado(){
        return null;
    }

    @Override
    public void deCodificar() {

    }


}
