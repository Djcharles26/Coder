package com.Proyect1;

import java.util.Scanner;

public class PasswordFormatException extends Exception{

    public boolean passedProve = false;

    public PasswordFormatException(){
        super();
        passedProve = true;
    }

    public PasswordFormatException(String message){
        super(message);
        passedProve = true;
    }
    public void printMessage() {
        System.out.println(super.getMessage());
    }


    public String askForNewPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nueva contraseña: ");
        String newPassword = scanner.next();
        return newPassword;
    }
}
