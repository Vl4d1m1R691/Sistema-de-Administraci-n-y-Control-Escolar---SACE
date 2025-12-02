package itson.sace.ed; // Paquete de Estructuras de Datos.

/**
 * Clase que representa un nodo individual (eslabón) para la Pila de Historial.
 * Funciona como un contenedor que guarda el dato (la acción) y sabe quién es el siguiente.
 * * Es necesario para implementar la Pila dinámica requerida en el punto.
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class NodoPila {

    // --- Atributos del Nodo ---

    /**
     * El dato real que queremos guardar.
     * En este caso es un String porque el requerimiento 3.5 pide guardar descripciones
     * de texto (ej: "Se registró el estudiante X").
     */
    String accion;

    /**
     * El "puntero" o referencia al siguiente nodo en la pila.
     * En una Pila, este puntero referencia al elemento que está "debajo" del actual.
     * Si es null, significa que hemos llegado al fondo de la pila.
     */
    NodoPila siguiente;

    /**
     * Constructor que inicializa el nodo.
     * Recibe el dato y prepara el puntero en null por defecto.
     * * @param accion El texto descriptivo de la acción realizada por el usuario.
     */
    public NodoPila(String accion) {
        // Guardamos el dato recibido en el atributo de la instancia.
        this.accion = accion;
        
        // Inicializamos la referencia en null.
        // Se conectará con otro nodo cuando se haga el 'push' en la clase PilaHistorial.
        this.siguiente = null;
    }
}
