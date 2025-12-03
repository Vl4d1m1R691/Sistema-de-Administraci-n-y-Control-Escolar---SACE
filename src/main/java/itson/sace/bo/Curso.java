package itson.sace.bo; // Paquete de Objetos de Negocio.

// Importamos la estructura de datos lineal personalizada.
// Requisito: No se permite usar java.util.LinkedList.
import itson.sace.ed.ListaEnlazada;

/**
 * Clase que representa una materia o curso dentro del sistema escolar.
 * Esta clase actúa como un contenedor que agrupa la información del curso
 * y la lista de estudiantes que se han inscrito en él.
 * Cumple con la gestión de cursos y el manejo de inscripciones.
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class Curso {

    // --- Atributos del Curso ---

    /** * Identificador único del curso (Ej. "MAT101", "PROG1"). 
     * Se utiliza para buscar el curso en el arreglo dinámico principal.
     */
    String codigo;

    /** Nombre descriptivo de la materia (Ej. "Cálculo Diferencial"). */
    String nombre;

    /** * Estructura de datos personalizada para manejar los inscritos.
     * Cumple con el Requerimiento 3.3 del proyecto:
     * "Cada curso debe mantener una lista enlazada simple de estudiantes inscritos".
     */
    ListaEnlazada inscritos;

    /**
     * Constructor para inicializar un nuevo Curso.
     * * @param codigo El código único de la materia.
     * @param nombre El nombre de la materia.
     */
    public Curso(String codigo, String nombre) {
        // Asignación de los datos básicos del curso.
        this.codigo = codigo;
        this.nombre = nombre;

        // CRÍTICO: Inicialización de la Lista Enlazada.
        // Aquí instanciamos la lista vacía (cabeza = null internamente).
        // Si no hacemos 'new ListaEnlazada()', la variable 'inscritos' sería null
        // y el programa fallaría al intentar inscribir al primer alumno.
        this.inscritos = new ListaEnlazada();
    }

    /**
     * Representación en cadena del objeto Curso.
     * Útil para imprimir listados de cursos en la consola de manera legible.
     * * @return Cadena con el código y nombre del curso.
     */
    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}