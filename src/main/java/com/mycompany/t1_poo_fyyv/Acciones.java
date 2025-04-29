package com.mycompany.t1_poo_fyyv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class Acciones {
    
    private PriorityQueue<Producto> inventario = new PriorityQueue<>();
    
    //Para asignarle un formato a la fecha
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yy");
    
    public void agregarProductos(){
        
        //Agregamos el nombre, cantidad y fecha
        String nombreprod = JOptionPane.showInputDialog(null,
        "Ingrese el nombre del producto");

        int cant = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Ingrese cantidad del producto"));

        //En el caso de la fecha, primero ingresara como texto
        String fechatext = JOptionPane.showInputDialog(null, 
        "Ingrese la fecha de vencimiento del producto "+
        "\n  Recuerde que la feha debe tener el siguiente formato: "+
        "\n  01-01-2025");
        //Luego con la clase LocalDate.parce la convertiremos en una fecha que 
        //Pueda ser aceptada por el programa 
        LocalDate fechavenci = LocalDate.parse(fechatext, FORMATTER);

        //Se añaden todos los datos al inventario
        Producto product = new Producto(nombreprod, cant, fechavenci);
        inventario.add(product);

        JOptionPane.showMessageDialog(null, 
        "El producto ha sido agregado con exito");

    }



    public void mostrarInventario(){

        if(inventario.isEmpty()){
            JOptionPane.showMessageDialog(null, 
        "El inventario esta vacio");
        return;
        }

        StringBuilder msje = new StringBuilder();

        for (Producto p : inventario) {
        msje.append(p.toString()).append("\n\n");
        }
        
        JOptionPane.showMessageDialog(null, msje.toString());

        //estoy provando otro metodo usando el String Builder
        //StringBuilder mensaje = new StringBuilder();
        //for (int i = 0; i < inventario.size(); i++) {
        //    
        //}


        //Mostraremos todos los productos 
        
        for(Producto producto : inventario){
            JOptionPane.showMessageDialog(null,"Inventario\n\n"+ producto);
        }

        //mostraremos los productos proximos a vencer en los proximos 7 dias
        LocalDate fechelim = LocalDate.now().plusDays(7);
        for(Producto product : inventario){
            if(!product.getFecha().isAfter(fechelim)){
                JOptionPane.showMessageDialog(null, product);        

            }
        }
    }

    public void BuscarProducto(){
        //Buscaremos todos los productos segun su nombre
        if(inventario.isEmpty()){
            JOptionPane.showMessageDialog(null, 
        "No hay ningun producto en el inventario");
        }
    }

    public void EliminarProducto(){

        //Eliminaremos los productos que segun la fecha que escojamos
        LocalDate fecha = LocalDate.now();
        
        //En el caso de la fecha, primero ingresara como texto
        String fechatext = JOptionPane.showInputDialog(null, 
        "Escriba la fecha de vencimiento de los productos a eliminar"+
        "\n  Recuerde que la feha debe tener el siguiente formato: "+
        "\n  01-01-25");
        //Luego con la clase LocalDate.parce la convertiremos en una fecha que 
        //Pueda ser aceptada por el programa 
        LocalDate fechaDate = LocalDate.parse(fechatext);
        

        Producto producto = inventario.poll();

    }
   
}
