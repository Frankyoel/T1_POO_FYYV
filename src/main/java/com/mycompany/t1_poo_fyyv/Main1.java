/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t1_poo_fyyv;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author YOVERA-2
 */

public class Main1{

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Acciones act = new Acciones();
        inventario.mostrarMenu();
        
        //System.out.println("");
    }    
}

class Inventario{
    //private final PriorityQueue<Producto> prodvence;
    private final Scanner scanner = null;

    public void mostrarMenu() {
    
        while (true) { 
            int opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escoja la acción a realizar:\n\n" +
                    "1 => Registrar un producto\n" +
                    "2 => Buscar un producto\n" +
                    "3 => Mostrar todos los productos\n" +
                    "4 => Eliminar productos\n" +
                    "0 => Cerrar el programa"));
            procesarOpcion(opc);
        } 
        
    }
    
    private void procesarOpcion(int opc) {
        Acciones act = new Acciones();
        switch (opc) {
            case 1: act.agregarProductos();  break;
            case 2: act.BuscarProducto();   break;
            case 3: act.mostrarInventario();  break;
            case 4: act.EliminarProducto(); break;
            case 0: JOptionPane.showMessageDialog(null, 
            "Saliendo del sistema");
                    System.exit(0);; break;
            default:
                JOptionPane.showMessageDialog(null, 
                "Ingrese un numero valido");;
        }
    }

}
