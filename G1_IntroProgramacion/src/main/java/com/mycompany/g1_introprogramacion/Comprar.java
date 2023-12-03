
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author XPC
 */
public class Example {
    private static final List<List<String>> productos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcionStr;
            opcionStr = JOptionPane.showInputDialog("""
                                                    1. Agregar Producto
                                                    2. Retirar Producto
                                                    3. Mostrar Productos
                                                    4. Salir""");

            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> retirarProducto();
                case 3 -> mostrarProductos();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void agregarProducto() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del producto:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría del producto:");

        List<String> nuevoProducto = new ArrayList<>();
        nuevoProducto.add(id);
        nuevoProducto.add(nombre);
        nuevoProducto.add(categoria);

        productos.add(nuevoProducto);

        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
    }

    private static void retirarProducto() {
        String idRetirar = JOptionPane.showInputDialog("Ingrese el ID del producto que desea retirar:");

        Iterator<List<String>> iterator = productos.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            List<String> productoActual = iterator.next();
            if (productoActual.get(0).equals(idRetirar)) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Producto retirado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un producto con ese ID.");
        }
    }

    private static void mostrarProductos() {
        StringBuilder mensaje = new StringBuilder("Lista de Productos:\n");

        for (List<String> producto : productos) {
            mensaje.append("ID: ").append(producto.get(0)).append(", Nombre: ").append(producto.get(1)).append(", Categoría: ").append(producto.get(2)).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author XPC
 */
public class Example {
    private static final List<List<String>> productos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcionStr;
            opcionStr = JOptionPane.showInputDialog("""
                                                    1. Agregar Producto
                                                    2. Retirar Producto
                                                    3. Mostrar Productos
                                                    4. Salir""");

            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> retirarProducto();
                case 3 -> mostrarProductos();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void agregarProducto() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del producto:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría del producto:");

        List<String> nuevoProducto = new ArrayList<>();
        nuevoProducto.add(id);
        nuevoProducto.add(nombre);
        nuevoProducto.add(categoria);

        productos.add(nuevoProducto);

        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
    }

    private static void retirarProducto() {
        String idRetirar = JOptionPane.showInputDialog("Ingrese el ID del producto que desea retirar:");

        Iterator<List<String>> iterator = productos.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            List<String> productoActual = iterator.next();
            if (productoActual.get(0).equals(idRetirar)) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Producto retirado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un producto con ese ID.");
        }
    }

    private static void mostrarProductos() {
        StringBuilder mensaje = new StringBuilder("Lista de Productos:\n");

        for (List<String> producto : productos) {
            mensaje.append("ID: ").append(producto.get(0)).append(", Nombre: ").append(producto.get(1)).append(", Categoría: ").append(producto.get(2)).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
