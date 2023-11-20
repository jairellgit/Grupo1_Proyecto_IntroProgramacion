/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private static String nombre;
    private static int cedula;
    
    public Cliente(String nombre, int cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Cliente.nombre = nombre;
    }

    public static int getCedula() {
        return cedula;
    }

    public static void setCedula(int cedula) {
        Cliente.cedula = cedula;
    }
    
    
    
    
}
