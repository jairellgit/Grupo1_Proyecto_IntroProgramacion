/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

import javax.swing.JOptionPane;


public class Organizar {
    
    Registro registro = new Registro();
    private static int[][] organizacion = new int[10][10];
    private int contadorProductos = registro.getContadorProductos();
    private static int pasilloAnterior = 0;    
    private static int posicionAnterior = 0;


    public Organizar(Registro registro) {
        
    }

    public static int[][] getOrganizacion() {
        return organizacion;
    }
    public static void setOrganizacion(int[][] organizacion) {
        Organizar.organizacion = organizacion;
    }
    
    

    //Organizar el producto en un pasillo y posición
    public void organizarInicial(int idProducto) {
        if (idProducto <= 0) {
            JOptionPane.showMessageDialog(null, "El ID debe ser mayor a 0");
            
        } else if (existeId(idProducto) == false) {
            JOptionPane.showMessageDialog(null, "El producto con ID " + idProducto + " no existe.");
        } else {
            int pasillo = -1;
            int posicion = -1;

            while (pasillo < 1 || pasillo > 10 || posicion < 1 || posicion > 10 || organizacion[pasillo - 1][posicion - 1] != 0) {
                pasillo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el pasillo (1-10):"));
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición (1-10):"));

                if (pasillo < 1 || pasillo > 10 || posicion < 1 || posicion > 10) {
                    JOptionPane.showMessageDialog(null, "La posición seleccionada no es válida.");
                } else if (organizacion[pasillo - 1][posicion - 1] != 0) {
                    JOptionPane.showMessageDialog(null, "Esta posición ya está ocupada. Elija otra posición.");
                }
            }

            organizacion[pasillo - 1][posicion - 1] = idProducto;
            JOptionPane.showMessageDialog(null, "Producto organizado en el pasillo " + pasillo + ", posición " + posicion);
        }
    }

    //Cambiar el producto a otro pasillo-posición
    public void reorganizarProducto(int idProducto) {   
        imprimirMatriz(organizacion);
                
        if (existeId(idProducto) == false) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados para reorganizar.");
            return;
        }
        boolean posicionActual = encontrarPosicion(idProducto);

        if (posicionActual == false) {
            JOptionPane.showMessageDialog(null, "El producto con ID " + idProducto + " no existe.");
        } else {
            int pasillo = -1;
            int posicion = -1; 

            while (pasillo < 1 || pasillo > 10 || posicion < 1 || posicion > 10 || organizacion[pasillo - 1][posicion - 1] != 0) {
                pasillo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo pasillo (1-10):"));
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva posición (1-10):"));

                if (pasillo < 1 || pasillo > 10 || posicion < 1 || posicion > 10) {
                    JOptionPane.showMessageDialog(null, "La posición seleccionada no es válida.");
                } else if (organizacion[pasillo - 1][posicion - 1] != 0) {
                    JOptionPane.showMessageDialog(null, "Esta posición ya está ocupada. Elija otra posición.");
                }
            }
            organizacion[pasillo - 1][posicion - 1] = idProducto;
            organizacion[pasilloAnterior][posicionAnterior] = 0;

            JOptionPane.showMessageDialog(null, "Producto reorganizado en el pasillo " + pasillo + ", posición " + posicion);
        }
    }

    private boolean encontrarPosicion(int idProducto) {
    for (int pasillo = 0; pasillo < 10; pasillo++) {
        for (int posicion = 0; posicion < 10; posicion++) {
            if (organizacion[pasillo][posicion] == idProducto) {
                pasilloAnterior = pasillo;
                posicionAnterior = posicion;
                return true;
            }
        }
    }
    return false;
}

    private boolean existeId(int idProducto) {
        int[] id = registro.getId();
        
        for (int i = 0; i < id.length; i++) {
            if(id[i] == idProducto){
                return true;
            }
        }
        return false;
    }
    
    public void imprimirMatriz(int[][] matriz) {
        StringBuilder matrizStr = new StringBuilder();

        // Recorre la matriz y construye una representación de cadena
        for (int i = 0; i < organizacion.length; i++) {
            for (int j = 0; j < organizacion[i].length; j++) {
                matrizStr.append(organizacion[i][j]);
                if (j < organizacion[i].length - 1) {
                    matrizStr.append("\t"); // Tabulación para separar columnas
                }
            }
            matrizStr.append("\n"); // Nueva línea para separar filas
        }

        // Muestra la matriz en un cuadro de diálogo de JOptionPane
        JOptionPane.showMessageDialog(null, "\n" + matrizStr.toString(), "Productos Supermecado", JOptionPane.INFORMATION_MESSAGE);
    }


}
