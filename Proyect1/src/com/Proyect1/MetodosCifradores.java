package com.Proyect1;
/*
* INTERFAZ NECESARIA, CREA TODAS LAS FUNCIONES NECESARIAS PARA QUE TODO EL PROGRAMA FUNCIONE
* */
public interface MetodosCifradores {
    public void codificar();
    public String getMensajeCifrado();
    public void setContraseña(String contraseña);
    public void deCodificar(String mensaje);
    public String getMensajeDeCifrado();
    public void setMensaje(String mensaje);
}
