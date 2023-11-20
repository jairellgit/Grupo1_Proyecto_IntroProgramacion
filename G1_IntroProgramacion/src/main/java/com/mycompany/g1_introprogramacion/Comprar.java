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
    
    //Productos (nombre)
    private String[] productos = registro.getProductos();
    //Productos (precio)
    private double[] precios = registro.getPrecios();
    //Productos (existencias)
    private int[] existencias = registro.getExistencias();
    //Matriz organización de los productos
    private int[][] organizacion = organizar.getOrganizacion();
    
   //Arrays secundarios
    private double[] productosComprados = new double[7];
    private double[] productosCantidades = new double[7];
    private double[] productosPrecio = new double[7];
    
    //Matriz primaria
    private double[][] compras = new double[productosComprados.length][5];
    
    //Constructor
    public Comprar() {

    }

    //Método principal para comprar
    public void realizarCompra() {
        if (totalCompras > 50) {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de compras totales.");
        } else {
            //Guardar la información del cliente
            String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
            int cedulaCliente = Integer.parseInt(JOptionPane.showInputDialog("Cédula del cliente:"));

            int cantidadProductos = 0;
            boolean continuarCompra = true;

            while (cantidadProductos < 8 && continuarCompra) {
                int pasillo = seleccionarPasillo();

                if (pasillo == 0) {
                    break;
                } else {
                    int[] seleccionarProducto = seleccionarProducto(pasillo);
                    int idProducto = seleccionarProducto[0];
                    int cantProducto = seleccionarProducto[1];
                    
                    if (idProducto ==0){
                        JOptionPane.showMessageDialog(null, "No se añadió ningún producto a su lista.");
                    }else{
                        
                    }
                }
                continuarCompra = JOptionPane.showConfirmDialog(null, "¿Desea comprar  otros productos?", "Continuar Comprando", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }

            //JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
        }
    }

    //Elegir el pasillo
    private int seleccionarPasillo() {
        int pasillo = 0;
        do {
            try {
                pasillo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el pasillo (1-10):\nDigite 0 para cancelar"));
                if (pasillo == 0) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un pasillo valido. Inténtelo nuevamente.");
            }
        } while (pasillo < 0 || pasillo > 10);
        return pasillo;
    }

    //Elegir el producto y la catidad
    private int[] seleccionarProducto(int pasillo) {
        imprimirFila(organizacion, pasillo - 1);

        int idProducto = 0;
        int cantidad = 0;

        while (true) {
            try {
                idProducto = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el ID de un producto válido del pasillo " + pasillo + ":\nDigite 0 para cancelar"));

                if (idProducto == 0) {
                    break;
                } else if (existeProducto(idProducto) == true) {
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a comprar:"));
                    return new int[]{idProducto, cantidad};
                } else {
                    JOptionPane.showMessageDialog(null, "El ID del producto no existe. Inténtelo nuevamente");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido. Inténtelo nuevamente");
            }
        }
        return new int[]{idProducto, cantidad};
    }

    //Validar por el ID si el producto existe
    private boolean existeProducto(int idProducto) {
        int[] id = registro.getId();

        for (int i = 0; i < id.length; i++) {
            if (id[i] == idProducto) {
                return true;
            }
        }
        return false;
    }

    //Imprimir los valores del pasillo seleccionado
    public void imprimirFila(int[][] matriz, int fila) {
        StringBuilder filaStr = new StringBuilder();
        for (int x = 0; x < matriz[fila].length; x++) {
            filaStr.append(matriz[fila][x]);
            String nombre = obtenerNombreProducto(matriz[fila][x]);
            double precio = obtenerPrecioProducto(matriz[fila][x]);
            filaStr.append(" - ").append(nombre).append(" - ").append(precio);

            if (x < matriz[fila].length - 1) {
                filaStr.append("\n"); // Tabulación para separar valores en la fila
            }
        }

        String filaPrint = String.valueOf(fila + 1);

        JOptionPane.showMessageDialog(null, "\nProductos en el pasillo " + filaPrint + ": \n" + filaStr.toString(), "Productos disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    //Obtener nombre del producto en base al ID
    public String obtenerNombreProducto(int idBuscado) {
        for (int i = 0; i < registro.getId().length; i++) {
            if (registro.getId()[i] == idBuscado) {
                if (idBuscado == 0) {
                    return "No existe";
                } else {
                    return productos[i];
                }
            }
        }
        return "ID no encontrado";
    }
    
    //Obtener nombre del producto en base al ID
    public double obtenerPrecioProducto(int idBuscado) {
        for (int i = 0; i < registro.getId().length; i++) {
            if (registro.getId()[i] == idBuscado) {
                if (idBuscado == 0) {
                    return 0;
                } else {
                    return precios[i];
                }
            }
        }
        return 0;
    }
}
