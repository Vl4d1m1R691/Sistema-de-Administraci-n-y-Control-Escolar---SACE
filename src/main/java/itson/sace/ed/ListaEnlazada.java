package itson.sace.ed; // Paquete de Estructuras de Datos.

import itson.sace.bo.Estudiante;

/**
 * Implementación manual de una Lista Enlazada Simple.
 * Esta estructura se utiliza exclusivamente para gestionar las inscripciones de los cursos.
 * "Cada curso debe mantener una lista enlazada simple de estudiantes inscritos".
 * * NOTA: Sustituye a java.util.LinkedList.
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class ListaEnlazada {

    // --- Atributos de la Lista ---

    /**
     * Referencia al primer nodo de la lista (Head).
     * Es el punto de entrada único. Si cabeza es null, significa que no hay
     * estudiantes inscritos en el curso todavía.
     */
    NodoLista cabeza;

    /**
     * Método para agregar un estudiante al final de la lista de inscritos.
     * Realiza un recorrido secuencial para encontrar el último nodo y enlazar el nuevo.
     * * @param e El objeto Estudiante que se va a inscribir.
     */
    public void agregar(Estudiante e) {
        // 1. Crear el nuevo nodo (eslabón) que contiene al estudiante.
        NodoLista nuevo = new NodoLista(e);

        // 2. Verificar si la lista está vacía.
        if (cabeza == null) {
            // Caso base: Si no hay nadie, el nuevo nodo se convierte en la cabeza.
            cabeza = nuevo;
        } else {
            // Caso recursivo/iterativo: La lista ya tiene gente.
            // Necesitamos un puntero auxiliar ('temp') para recorrerla sin perder la cabeza.
            NodoLista temp = cabeza;

            // Recorremos la lista hasta encontrar el último nodo.
            // Sabemos que es el último cuando su 'siguiente' es null.
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }

            // 3. Enlazamos el último nodo encontrado con el nuevo nodo.
            // Ahora el nuevo nodo es el final de la lista.
            temp.siguiente = nuevo;
        }
    }

    /**
     * Muestra en consola todos los estudiantes inscritos en esta lista.
     * Recorre nodo por nodo desde la cabeza hasta que encuentra null.
     * Cumple con la parte de "Mostrar los estudiantes inscritos".
     */
    public void mostrar() {
        // Puntero auxiliar para recorrer desde el inicio.
        NodoLista temp = cabeza;

        // Bucle de recorrido (Traversal).
        while (temp != null) {
            // Imprimimos el estudiante usando su método toString().
            // Agregamos un guion visual "-" para que parezca una lista viñeteada.
            System.out.println(" - " + temp.estudiante.toString());

            // Avanzamos al siguiente nodo.
            temp = temp.siguiente;
        }
    }
}