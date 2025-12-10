/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sace.bst;

import itson.sace.bo.Estudiante;
import itson.sace.ed.ArregloDinamico;
import java.util.List;

/**
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class ArbolEstudiantesBST {

    NodoBST raiz;

    List<NodoBST> lista;

    public ArbolEstudiantesBST() {
        raiz = null;
    }

    public NodoBST insertar(Estudiante e) {
        NodoBST nuevo = new NodoBST(e);
        if (raiz == null) {
            raiz = nuevo;
            lista.add(nuevo);
            return raiz;
        }

        if (nuevo.dato.matricula < raiz.izq.dato.matricula) {
            raiz.der = insertar(raiz.der.dato);
        } else {
            raiz.izq = insertar(raiz.izq.dato);
        }

        return raiz;
    }

//    public boolean buscarEstudianteMatricula(int matricula) {
//        boolean presente = false;
//
//        while (raiz != null) {
//            if (raiz.dato.matricula == matricula) {
//                presente = true;
//                System.out.print(raiz.toString());
//                break;
//            } else if (matricula > raiz.dato.matricula) {
//                raiz = raiz.der;
//            } else {
//                raiz = raiz.izq;
//            }
//        }
//        return presente;
//    }
    public int buscarEstudianteMatricula(int matricula) {

        if (raiz == null) {
            System.out.println("No se encontró la matricula");
            return 0;
        }
        if (raiz.dato.matricula == matricula) {
            System.out.println("Datos del estudiante:" + raiz.dato.toString());
            return matricula;
        }

        if (matricula > raiz.dato.matricula) {
            return buscarEstudianteMatricula(raiz.der.dato.matricula);
        } else {
            return buscarEstudianteMatricula(raiz.izq.dato.matricula);
        }
    }

    public void inOrden(NodoBST nodo) {
        if (raiz != null) {
            inOrden(raiz.izq);
            System.out.print(raiz.dato + "");
            inOrden(raiz.der);
        }
    }

    public void llenarArreglo(ArregloDinamico arreglo){
        llenarArregloRec(raiz, arreglo);
    }
    
    public void llenarArregloRec(NodoBST actual, ArregloDinamico arreglo){
        if(actual!= null){
            llenarArregloRec(actual.izq,arreglo);
            arreglo.agregar(actual.dato);
            llenarArregloRec(actual.der,arreglo); 
        }
    }
    

}
