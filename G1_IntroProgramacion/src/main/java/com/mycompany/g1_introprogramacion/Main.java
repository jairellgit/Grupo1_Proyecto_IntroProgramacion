/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

import javax.swing.JOptionPane;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registro registro = new Registro();
        Organizar organizar = new Organizar(registro);
        Comprar comprar = new Comprar();
        Retirar retirar = new Retirar();
        
        int id;

        while (true) {
            try {
                String[] opciones = {"Registro de Productos", "Reorganizar Productos", "Realizar Compra", "Retirar Producto", "Salir"};
                String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Principal", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

                if (seleccion == null || seleccion.equals("Salir")) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                } else if (seleccion.equals("Registro de Productos")) {
                    id = registro.registrarProducto();
                    if (id == 0){
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Producto registrado con éxito. ");
                        organizar.organizarInicial(id);
                    }
                } else if (seleccion.equals("Reorganizar Productos")) {
                    int idProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto: "));
                    organizar.reorganizarProducto(idProducto); 
                } else if (seleccion.equals("Realizar Compra")) { 
                    comprar.realizarCompra();
                } else if (seleccion.equals("Retirar Producto")) {
                    JOptionPane.showMessageDialog(null, "Próximamente... ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Por favor, intente de nuevo.");
            }
        }
    }
    
}
