/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.miumg.excell;


public class Celda {
    public int fila;
    public int columna;
    public String contenido;
    
    // Punteros para la red ortogonal
    public Celda arriba, abajo, izquierda, derecha;

    public Celda(int fila, int columna, String contenido) {
        this.fila = fila;
        this.columna = columna;
        this.contenido = contenido;
        this.arriba = this.abajo = this.izquierda = this.derecha = null;
    }
}