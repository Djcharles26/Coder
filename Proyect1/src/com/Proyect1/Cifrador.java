package com.Proyect1;

public abstract class Cifrador {
    protected int[] espacios;
    protected char[] ABC = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
            'T','U','V','W','X','Y','Z'};
    protected char[] ABCCodificador = new char[26];
    protected  int size_espacios;
    protected String mensajeSinCifrar;
    protected char[] mensajeCifrado;
    protected String Contraseña;
    protected char[] mensajeDeCifrado;
}
