/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author danie
 */
public class MateriaPrima {
    int codmat;
    String nombre;
    String feccad;
    int cantidad;
    String unidad;
    double precio;

    public MateriaPrima() {
    }

    public MateriaPrima(int codmat, String nombre, String feccad, int cantidad, String unidad, double precio) {
        this.codmat = codmat;
        this.nombre = nombre;
        this.feccad = feccad;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio = precio;
    }
    
}
