package itson.sace.ed; // Paquete de Estructuras de Datos.

// Importamos la clase Estudiante porque este nodo guardará objetos de ese tipo.
import itson.sace.bo.Estudiante;

/**
 * Clase que representa un nodo (eslabón) de la Lista Enlazada Simple.
 * A diferencia del NodoPila que guardaba texto, este nodo está diseñado para
 * almacenar referencias a objetos 'Estudiante'.
 * "Cada curso debe mantener una lista enlazada simple de estudiantes inscritos".
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class NodoLista {

    // --- Atributos del Nodo ---

    /**
     * El "Dato" o carga útil del nodo.
     * Guardamos una referencia al objeto Estudiante que se inscribió al curso.
     * No guardamos una copia, sino la referencia al estudiante original (memoria eficiente).
     */
    Estudiante estudiante;

    /**
     * El "Puntero" o enlace al siguiente nodo de la lista.
     * Permite recorrer la lista de inscritos secuencialmente (del primero al último).
     * Si es null, indica que este es el último estudiante de la lista.
     */
    NodoLista siguiente;

    /**
     * Constructor para inicializar el nodo de inscripción.
     * * @param e El objeto Estudiante que deseamos guardar en este eslabón.
     */
    public NodoLista(Estudiante e) {
        // Asignamos el estudiante recibido al atributo del nodo.
        this.estudiante = e;
        
        // Inicializamos el puntero en null.
        // Se conectará con otro nodo cuando usemos el método 'agregar' en la ListaEnlazada.
        this.siguiente = null;
    }
}