package com.Proyect1;
import java.util.*;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static  void main(String[] args){
        Atabash atabash = new Atabash();
        Cesar cesar = new Cesar();
        Playfair playfair = new Playfair();
         TransposicionColumnar transposicionColumnar = new TransposicionColumnar();
        String frase;
        boolean continuar = true;
        do {
            switch (menu()) {
                case "1":
                    switch (menu2()) {
                        case "1":
                            System.out.println("Ingrese la frase a codificar:");

                            frase = new Scanner(System.in).nextLine();
                            atabash.setMensaje(frase);
                            atabash.codificar();
                            System.out.println(atabash.getMensajeCifrado().replaceAll("\0",""));
                            break;
                        case "2":
                            atabash.deCodificar(atabash.getMensajeCifrado());
                            System.out.println(atabash.getMensajeDeCifrado());
                            break;
                        case "3":
                            System.out.println("Ingrese frase a decodificar");
                            frase = new Scanner(System.in).nextLine();
                            atabash.deCodificar(frase);
                            System.out.println(atabash.getMensajeDeCifrado() + "\n\n");
                            break;
                        case "4":
                            System.out.println("Regresando...");
                        break;
                        default:
                            System.out.println("Opcion incorrecta");
                        break;
                    }
                    break;
                case "2"://Cesar//
                    switch (menu2()) {
                        case "1":
                            System.out.println("Ingrese la frase a codificar:");
                            frase = new Scanner(System.in).nextLine();
                            cesar.setMensaje(frase);
                            System.out.print("Ingrese contraseña (3-6):");
                            cesar.setContraseña(new Scanner(System.in).nextLine());
                            cesar.codificar();
                            System.out.println(cesar.getMensajeCifrado().replaceAll("\0",""));
                            break;
                        case "2":
                             System.out.print("Ingrese contraseña (3-6):");
                            cesar.setContraseña(new Scanner(System.in).nextLine());
                            cesar.deCodificar(cesar.getMensajeCifrado());
                            System.out.println(cesar.getMensajeDeCifrado().replaceAll("\0",""));
                            break;
                        case "3":
                            System.out.println("Ingrese frase a decodificar");
                            frase = new Scanner(System.in).nextLine();
                            System.out.print("Ingrese contraseña (3-6):");
                            cesar.setContraseña(new Scanner(System.in).nextLine());
                            cesar.deCodificar(frase);
                            System.out.println(cesar.getMensajeDeCifrado().replaceAll("\0","") + "\n\n");
                            break;
                        case "4":
                            System.out.println("Regresando...");
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                        break;
                    }
                break;
                case "3"://Playfair
                    switch (menu2()) {
                        case "1":
                            System.out.println("Ingrese la frase a codificar:");

                            frase = new Scanner(System.in).nextLine();
                            playfair.setMensaje(frase);
                            System.out.print("Ingrese contraseña (Evite Simbolos o numeros):");
                            playfair.setContraseña(new Scanner(System.in).nextLine());
                            playfair.codificar();
                            System.out.println(playfair.getMensajeCifrado().replaceAll("\0",""));
                            break;
                        case "2":
                            System.out.print("Ingrese contraseña (Evite Simbolos o numeros):");
                            playfair.setContraseña(new Scanner(System.in).nextLine());
                            playfair.deCodificar(playfair.getMensajeCifrado());
                            System.out.println(playfair.getMensajeDeCifrado());
                            break;
                        case "3":
                            System.out.println("Ingrese frase a decodificar");
                            frase = new Scanner(System.in).nextLine();
                            System.out.print("Ingrese contraseña (Evite Simbolos o numeros):");
                            playfair.setContraseña(new Scanner(System.in).nextLine());
                            playfair.deCodificar(frase);
                            System.out.println(playfair.getMensajeDeCifrado() + "\n\n");
                            break;
                        case "4":
                            System.out.println("Regresando...");
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                break;
                case "4":
                    switch (menu2()) {
                        case "1":
                            System.out.println("Ingrese la frase a codificar:");

                            frase = new Scanner(System.in).nextLine();
                            transposicionColumnar.setMensaje(frase);
                            System.out.print("Ingrese contraseña (2-10):");
                            transposicionColumnar.setContraseña(new Scanner(System.in).nextLine());
                            transposicionColumnar.codificar();
                            System.out.println(transposicionColumnar.getMensajeCifrado().replaceAll("\0",""));
                            break;
                        case "2":
                            System.out.print("Ingrese contraseña (Evite Simbolos o numeros):");
                            transposicionColumnar.setContraseña(new Scanner(System.in).nextLine());
                            transposicionColumnar.deCodificar(transposicionColumnar.getMensajeCifrado());
                            System.out.println(transposicionColumnar.getMensajeDeCifrado());
                            break;
                        case "3":
                            System.out.println("Ingrese frase a decodificar");
                            frase = new Scanner(System.in).nextLine();
                            System.out.print("Ingrese contraseña (2-10):");
                            transposicionColumnar.setContraseña(new Scanner(System.in).nextLine());
                            transposicionColumnar.deCodificar(frase);
                            System.out.println(transposicionColumnar.getMensajeDeCifrado() + "\n\n");
                            break;
                        case "4":
                            System.out.println("Regresando...");
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                    break;
                    case "5":
                    System.out.println("Adios");
                    break;
                    default:
                        System.out.println("Opcion incorrecta");
                    break;


            }
        }while(continuar);
//        Atabash codigo;
//        Cesar codigoCesar;
//        Playfair codigoPlay;
//        TransposicionColumnar codigoColumna;
//        String aux;
//        System.out.println("Dame una frase");
//        codigo = new Atabash(new Scanner(System.in).nextLine());
//        codigo.codificar();
//        System.out.println((aux = codigo.getMensajeCifrado()));
//        codigo.setMensaje(aux);
//        codigo.deCodificar();
//        System.out.println(codigo.getMensajeDeCifrado());
//        System.out.println("\n\nCodigo cesar:");
//        codigoCesar = new Cesar(new Scanner(System.in).nextLine(),"3");
//        codigoCesar.codificar();
//        System.out.println(codigoCesar.getMensajeCifrado());
//        codigoCesar.setMensaje(codigoCesar.getMensajeCifrado());
//        codigoCesar.setContraseña("3");
//        codigoCesar.deCodificar();
//        System.out.println(codigoCesar.getMensajeDeCifrado());
//
//        System.out.println("\n\nPlayFair: ");
//        codigoPlay = new Playfair(new Scanner(System.in).nextLine(),"Playfair");
//        codigoPlay.codificar();
//        System.out.println(codigoPlay.getMensajeCifrado());
//        codigoPlay.setMensaje(codigoPlay.getMensajeCifrado());
//        codigoPlay.deCodificar();
//        System.out.println(codigoPlay.getMensajeDeCifrado());
//
//
//
//        System.out.println("\n\nTransposicion: ");
//        codigoColumna = new TransposicionColumnar(new Scanner(System.in).nextLine(),"5");
//        codigoColumna.codificar();
//
//        System.out.println(codigoColumna.getMensajeCifrado());
//        codigoColumna.setMensaje(codigoColumna.getMensajeCifrado());
//        codigoColumna.deCodificar();
//        System.out.println(codigoColumna.getMensajeDeCifrado());
    }

    static String menu(){
        System.out.print("Codificador DaVinci 2.0\nCodificadores:\n1.Atabash\n2.Cesar\n3.PlayFair\n4.Transposicion Columnar\n-->");
        return scanner.next();
    }

    static String menu2(){
        System.out.print("1.Codificar frase\n2.Decodificar frase codificada con este metodo\n3.Decodificar otra frase (Inseguro)\n4.Regresar\n-->");
        return scanner.next();
    }
}
