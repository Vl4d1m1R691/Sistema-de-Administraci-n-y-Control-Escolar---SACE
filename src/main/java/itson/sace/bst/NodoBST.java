package itson.sace.bst;

import itson.sace.bo.Estudiante;

/**
 *
 * @author Vladimir Ivan Mendoza Baypoli
 */
public class NodoBST {
    Estudiante dato;
    NodoBST izq, der;
    
    public NodoBST(Estudiante dato){
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
}
