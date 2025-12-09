/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sace.bst;

import itson.sace.bo.Estudiante;
import java.util.List;

/**
 *
 * @author ramuk
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

    public void estudiantesInOrder(Estudiante e) {
        if (e == null) {
            System.out.println("No se encontró al estudiante");
        }
        
        
        
        
    }

    

}
