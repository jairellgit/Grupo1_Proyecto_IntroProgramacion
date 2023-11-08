/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.g1_introprogramacion;

/**
 *
 * @author Grupo1
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = scanner.nextInt();

        double precioUnitario = 10.0; // Precio unitario del producto
        double iva = 0.19; // Valor del IVA
        double descuento = 0.1; // Valor del descuento

        double precioTotalSinIva = cantidad * precioUnitario;
        double precioTotalConIva = precioTotalSinIva * (1 + iva);
        double precioFinalConDescuento = precioTotalConIva * (1 - descuento);

        System.out.println("El precio total sin IVA es: " + precioTotalSinIva);
        System.out.println("El precio total con IVA es: " + precioTotalConIva);
        System.out.println("El precio final con descuento es: " + precioFinalConDescuento);

        scanner.close();
