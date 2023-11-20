/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Registro {
    //Atributos, Listas & Variables
    private static int[] id = new int[100];
    private static String[] productos = new String[100];
    private static String[] categorias = new String[100];
    private static double[] precios = new double[100];
    private static int[] existencias = new int[100];
    private static Date[] fechasCaducidad = new Date[100];
    
    private static int contadorProductos = 1;

    //Constructor
    public Registro() {
      
    }
    
    public int[] getId() {
        return id;
    }
    public void setId(int[] id) {
        this.id = id;
    }
    
    //Getters y Setters
    public String[] getProductos() {
        return productos;
    }
    public void setProductos(String[] productos) {
        this.productos = productos;
    }

    public int getContadorProductos() {
        return contadorProductos;
    }
    public void setContadorProductos(int contadorProductos) {
        this.contadorProductos = contadorProductos;
    }

    private String[] getCategorias() {
        return new String[]{"Frescos", "Granos", "Carnicería", "Abarrotes", "Cereales", "Limpieza", "Lácteos", "Panadería", "Hogar", "Congelados"};
    }
    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    public double[] getPrecios() {
        return precios;
    }
    public void setPrecios(double[] precios) {
        Registro.precios = precios;
    }

    public int[] getExistencias() {
        return existencias;
    }
    public void setExistencias(int[] existencias) {
        Registro.existencias = existencias;
    }

    public Date[] getFechasCaducidad() {
        return fechasCaducidad;
    }
    public void setFechasCaducidad(Date[] fechasCaducidad) {
        Registro.fechasCaducidad = fechasCaducidad;
    }
    
    
    //Métodos
    public int registrarProducto() {
        try {
            if (contadorProductos > 100) {
                JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de productos.");
                return 0;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            String categoria = (String) JOptionPane.showInputDialog(null, "Categoría del producto:", "Seleccionar Categoría", JOptionPane.PLAIN_MESSAGE, null, getCategorias(), getCategorias()[0]);
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
            int existencia = Integer.parseInt(JOptionPane.showInputDialog("Existencias disponibles:"));
            String fechaCaducidadStr = JOptionPane.showInputDialog("Fecha de caducidad (DD/MM/YYYY):");
            Date fechaCaducidad = formatter.parse(fechaCaducidadStr);

            id[contadorProductos-1] = contadorProductos;
            productos[contadorProductos-1] = nombre;
            categorias[contadorProductos-1] = categoria;
            precios[contadorProductos-1] = precio;
            existencias[contadorProductos-1] = existencia;
            fechasCaducidad[contadorProductos-1] = fechaCaducidad;
            
            contadorProductos++;
            return id[contadorProductos-2];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Los valores ingresados no son vàlidos, inténtelo nuevamente.");
            return 0;
        }
    }
}
