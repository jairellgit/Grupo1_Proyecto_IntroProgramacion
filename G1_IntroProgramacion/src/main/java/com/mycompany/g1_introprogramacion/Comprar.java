/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

import javax.swing.JOptionPane;


public class Comprar {
    //>>>EN PROGRESO

    //Clases
    Registro registro = new Registro();
    Organizar organizar = new Organizar(registro);

    private static int totalCompras;
    private String[] productos = registro.getProductos();
    private static int[] productosComprados = new int[7];
    private int[][] organizacion = organizar.getOrganizacion();

    public Comprar() {

    }

    public void realizarCompra() {
        if (totalCompras >= 50) {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de compras totales.");
        } else {
            //Guardar la información del cliente
            String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
            int cedulaCliente = Integer.parseInt(JOptionPane.showInputDialog("Cédula del cliente:"));

            int cantidadProductos = 0;
            boolean continuarCompra = true;

            while (cantidadProductos < 7 && continuarCompra) {
                int pasillo = seleccionarPasillo();
                if (pasillo == -1) {
                    break;
                } else {
                    boolean producto = seleccionarProducto(pasillo);

                    if (producto == false) {
                        JOptionPane.showMessageDialog(null, "El ID del producto no existe.");
                        break;
                    } else {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a comprar:"));

                        /*if (existencias[producto] >= cantidad) {
                            productosComprados[cantidadProductos] = producto;
                            cantidadProductos++;
                            existencias[producto] -= cantidad;
                            totalCompras++;
                            JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay suficientes existencias para ese producto.");
                        }
                         */
                    }
                }
                continuarCompra = JOptionPane.showConfirmDialog(null, "¿Desea seguir comprando?", "Continuar Comprando", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }

            //JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
        }
    }

    private int seleccionarPasillo() {
        int pasillo = -1;
        do {
            try {
                pasillo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el pasillo (1-10):\nOpción -1 para cancelar"));
                if (pasillo == -1) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un pasillo valido");
            }
        } while (pasillo > 10 || pasillo < 1);
        return pasillo;
    }

    private boolean seleccionarProducto(int pasillo) {
        imprimirFila(organizacion, pasillo-1);

        int producto = -1;
        while (producto < 1 || producto > 100) {
            producto = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un producto válido del pasillo " + pasillo + ":\nOpción -1 para cancelar"));
            if (producto == -1) {
                JOptionPane.showMessageDialog(null, "Saliendo.");
                break;
            } else if (existeProducto(producto)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeProducto(int idProducto) {
        int[] id = registro.getId();

        for (int i = 0; i < id.length; i++) {
            if (id[i] == idProducto) {
                return true;
            }
        }
        return false;
    }


    public void imprimirFila(int[][] matriz, int fila) {
        StringBuilder filaStr = new StringBuilder();
        for (int x = 0; x < matriz[fila].length; x++) {
            filaStr.append(matriz[fila][x]);
            String nombre = obtenerNombreProducto(matriz[fila][x]);
            filaStr.append(" - ").append(nombre);
            
            if (x < matriz[fila].length - 1) {
                filaStr.append("\n"); // Tabulación para separar valores en la fila
            }
        }
        
        String filaPrint = String.valueOf(fila+1);
        
        JOptionPane.showMessageDialog(null, "\nProductos en el pasillo " + filaPrint + ": \n" + filaStr.toString(), "Productos disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    public String obtenerNombreProducto(int idBuscado) {
        for (int i = 0; i < registro.getId().length; i++) {
            if (registro.getId()[i] == idBuscado) {
                if(idBuscado == 0){
                    return "No existe";
                }else{
                    return productos[i];
                }
            }
        }
        return "ID no encontrado";
    }
}
