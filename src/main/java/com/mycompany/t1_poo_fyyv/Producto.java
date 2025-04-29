/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.t1_poo_fyyv;

import java.time.LocalDate;

/**
 *
 * @author YOVERA-2
 */
class Producto implements Comparable<Producto>{

    private String Nombre;
    private int Cantidad;
    private LocalDate Fecha;
    //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yy");

    public Producto(String nombre, int cantidad, LocalDate fecha){
        this.Nombre = nombre;
        this.Cantidad = cantidad;
        this.Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.Fecha = fecha;
    }    

    @Override
    public int compareTo(Producto otro) {
        return this.Fecha.compareTo(otro.Fecha);
    }
}
