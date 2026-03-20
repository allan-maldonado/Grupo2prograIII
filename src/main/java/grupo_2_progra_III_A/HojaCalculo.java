/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.miumg.grupo_2_progra_iii_a;

/**
 *
 * @author jayron
 */
class HojaCalculo {
     private Celda raiz;

    public HojaCalculo() {
        raiz = new Celda(0, 0, "RAIZ");
    }
// METODO PARA INSERTAR DATOS 
    public void insertar(int f, int c, String valor) {
        // SI NO EXISTE ELIMINA 
        if (valor == null || valor.isEmpty()) {
            eliminar(f, c);
            return;
        }
// SI YA EXISTE ACCTUALIZA 
        Celda existente = buscarCelda(f, c);
        if (existente != null) {
            existente.contenido = valor;
            return;
        }
// SI NO EXISTE CREA 
        crearYNuevoNodo(f, c, valor);
    }

    private void eliminar(int f, int c) {
            Celda objetivo = buscarCelda(f, c);
        if (objetivo == null) {
            return;
        }

        if (objetivo.izquierda != null) {
            objetivo.izquierda.derecha = objetivo.derecha;
        }
        if (objetivo.derecha != null) {
            objetivo.derecha.izquierda = objetivo.izquierda;
        }
        if (objetivo.arriba != null) {
            objetivo.arriba.abajo = objetivo.abajo;
        }
        if (objetivo.abajo != null) {
            objetivo.abajo.arriba = objetivo.arriba;
        }
    }

    private Celda buscarCelda(int f, int c) {
        Celda filaAux = raiz;
        // Navegación vertical hasta la fila
        while (filaAux != null && filaAux.fila < f) {
            filaAux = filaAux.abajo;
        }

        if (filaAux == null || filaAux.fila != f) {
            return null;
        }

        
        Celda actual = filaAux;
        while (actual != null && actual.columna < c) {
            actual = actual.derecha;
        }

        return (actual != null && actual.columna == c) ? actual : null;
       }

    private void crearYNuevoNodo(int f, int c, String valor) {
      
        Celda cabFila = buscarOCrearCabeceraFila(f);
        Celda cabCol = buscarOCrearCabeceraColumna(c);
       
        Celda nueva = new Celda(f, c, valor);

        enlazarHorizontalmente(cabFila, nueva);
        enlazarVerticalmente(cabCol, nueva);
        }

    private Celda buscarOCrearCabeceraFila(int f) {
            Celda aux = raiz;
        while (aux.abajo != null && aux.abajo.fila < f) {
            aux = aux.abajo;
        }

        if (aux.abajo != null && aux.abajo.fila == f) {
            return aux.abajo;
        }

        Celda nueva = new Celda(f, 0, "H_FILA");
        nueva.abajo = aux.abajo;
        if (aux.abajo != null) {
            aux.abajo.arriba = nueva;
        }
        aux.abajo = nueva;
        nueva.arriba = aux;
        return nueva;
    }

    private Celda buscarOCrearCabeceraColumna(int c) {
         Celda aux = raiz;
        while (aux.derecha != null && aux.derecha.columna < c) {
            aux = aux.derecha;
        }

        if (aux.derecha != null && aux.derecha.columna == c) {
            return aux.derecha;
        }

        Celda nueva = new Celda(0, c, "H_COL");
        nueva.derecha = aux.derecha;
        if (aux.derecha != null) {
            aux.derecha.izquierda = nueva;
        }
        aux.derecha = nueva;
        nueva.izquierda = aux;
        return nueva;
    }

    private void enlazarHorizontalmente(Celda filaHeader, Celda nueva) {
       
         Celda ant = filaHeader;
        while (ant.derecha != null && ant.derecha.columna < nueva.columna) {
            ant = ant.derecha;
        }

        nueva.derecha = ant.derecha;
        if (ant.derecha != null) {
            ant.derecha.izquierda = nueva;
        }
        ant.derecha = nueva;
        nueva.izquierda = ant;
    }

    private void enlazarVerticalmente(Celda colHeader, Celda nueva) {
          Celda ant = colHeader;
        while (ant.abajo != null && ant.abajo.fila < nueva.fila) {
            ant = ant.abajo;
        }

        nueva.abajo = ant.abajo;
        if (ant.abajo != null) {
            ant.abajo.arriba = nueva;
        }
        ant.abajo = nueva;
        nueva.arriba = ant;
        
    }

  
}
