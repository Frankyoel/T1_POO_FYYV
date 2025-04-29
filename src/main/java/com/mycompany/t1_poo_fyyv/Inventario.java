package com.mycompany.t1_poo_fyyv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class Inventario {
    
    //
    private PriorityQueue<Producto> inventario = new PriorityQueue<>();
    
    //Para asignarle un formato a la fecha
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yy");
    
    public void agregarProductos(){
        
        //Agregamos el nombre, cantidad y fecha
        String nombreprod = JOptionPane.showInputDialog(null,
        "Ingrese el nombre del producto");
        //Validaciones 
        if (nombreprod == null || nombreprod.trim().isEmpty()) return;

        try{
        int cant = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Ingrese cantidad del producto"));

        //En el caso de la fecha, primero ingresara como texto
        String fechatext = JOptionPane.showInputDialog(null, 
        "Ingrese la fecha de vencimiento del producto "+
        "\n  Recuerde que la feha debe tener el siguiente formato: "+
        "\n  01-01-25");
        //Luego con la clase LocalDate.parce la convertiremos en una fecha que 
        //Pueda ser aceptada por el programa 
        LocalDate fechavenci = LocalDate.parse(fechatext, FORMATTER);

        //Se añaden todos los datos al inventario
        Producto product = new Producto(nombreprod, cant, fechavenci);
        inventario.add(product);

        JOptionPane.showMessageDialog(null, 
        "El producto ha sido agregado con exito");

        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, 
            "Ocurrio un error \nIntente de nuevo");
        }

    }


    //Metodo para mostrar todos los producto
    public void mostrarInventario(){

        if(inventario.isEmpty()){
            JOptionPane.showMessageDialog(null, 
        "El inventario esta vacio");
        return;
        }
        
        //Mostraremos todos los productos 
        StringBuilder msje = new StringBuilder("Inventario:\n\n");
        for (Producto p : inventario) {
            msje.append(p.toString()).append("\n\n");
        }
        
        JOptionPane.showMessageDialog(null, msje.toString());
    }


    //Metodo para mostrar productos a vencer en los proximos 7 dias
    public void mostrarProximosAVencer() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
            "El inventario está vacío");
            return;
        }

        LocalDate fechaLimite = LocalDate.now().plusDays(7);
        StringBuilder msje = new StringBuilder("Productos próximos a vencer (7 días):\n\n");
        
        for (Producto p : inventario) {
            if (!p.getFecha().isAfter(fechaLimite)) {
                msje.append(p.toString()).append("\n\n");
            }
        }
        
        if (msje.length() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos próximos a vencer");
        } else {
            JOptionPane.showMessageDialog(null, msje.toString());
        }
    }

    //Metodo para buscar
    public void buscarProducto() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío");
            return;
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a buscar");
        if (nombre == null || nombre.trim().isEmpty()) return;

        StringBuilder msje = new StringBuilder("Resultados de búsqueda:\n\n");
        boolean encontrado = false;
        
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                msje.append(p.toString()).append("\n\n");
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            msje.append("No se encontró el producto: ").append(nombre);
        }
        
        JOptionPane.showMessageDialog(null, msje.toString());
    }


    //Metodo para eliminar producto
    public void eliminarProductos() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío");
            return;
        }

        try {
            String fechatext = JOptionPane.showInputDialog(null, 
                    "Ingrese la fecha límite para eliminar productos\n" +
                    "(ej. 01-01-25)");
            
            LocalDate fechaLimite = LocalDate.parse(fechatext, FORMATTER);
            PriorityQueue<Producto> nuevosProductos = new PriorityQueue<>();

            int eliminados = 0;
            
            for (Producto p : inventario) {
                if (p.getFecha().isAfter(fechaLimite)) {
                    nuevosProductos.add(p);
                } else {
                    eliminados++;
                }
            }
            
            inventario = nuevosProductos;
            JOptionPane.showMessageDialog(null, 
                    "Se eliminaron " + eliminados + " productos vencidos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en formato de fecha");
        }
    }

    public void mostrarMenu() {
        while (true) { 
            int opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escoja la acción a realizar:\n\n" +
                    "1 => Registrar un producto\n" +
                    "2 => Buscar un producto\n" +
                    "3 => Mostrar todos los productos\n" +
                    "4 => Eliminar productos\n" +
                    "0 => Cerrar el programa\n"));
            procesarOpcion(opc);
        } 
        
    }
    
    private void procesarOpcion(int opc) {
        switch (opc) {
            case 1 -> this.agregarProductos();
            case 2 -> this.buscarProducto();
            case 3 -> this.mostrarInventario();
            case 4 -> this.eliminarProductos();
            case 0 -> {
                JOptionPane.showMessageDialog(null,
                        "Saliendo del sistema");
                System.exit(0);
            }
            default -> {
                JOptionPane.showMessageDialog(null,
                        "Ingrese un numero valido");
            }
        }
    }


    public void cargarDatosIniciales() {
        inventario.add(new Producto("Leche", 10, LocalDate.of(2025, 5, 1)));
        inventario.add(new Producto("Pan", 20, LocalDate.of(2025, 4, 30)));
        inventario.add(new Producto("Queso", 15, LocalDate.of(2025, 5, 3)));
        inventario.add(new Producto("Yogurt", 12, LocalDate.of(2025, 5, 5)));
        inventario.add(new Producto("Jugo", 8, LocalDate.of(2025, 5, 2)));
    }
    
   
}
