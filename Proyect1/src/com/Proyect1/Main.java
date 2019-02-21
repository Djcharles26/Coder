package com.Proyect1;
import java.util.*;
public class Main {
    public static  void main(String[] args){
        Asabath codigo;
        System.out.println("Dame una frase");
        codigo = new Asabath(new Scanner(System.in).nextLine());
        String mensajeCodificado = codigo.codificar();
        System.out.println(mensajeCodificado);
    }
}
