package itson.sace.ed; // Paquete de Estructuras de Datos.

/**
 * Implementación manual de una Pila (Stack) dinámica.
 * Esta estructura sigue el principio LIFO (Last In, First Out - Último en entrar, Primero en salir).
 * 
 * "El sistema debe mantener una pila donde se registren las acciones importantes del usuario".
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class PilaHistorial {

    // --- Atributos de la Pila ---

    /**
     * Referencia al nodo que está en la cima (arriba) de la pila.
     * Es el punto de acceso principal. Si tope es null, la pila está vacía.
     */
    private NodoPila tope;

    /**
     * Método para agregar una nueva acción al historial (operación Push).
     * Inserta el elemento en la cima de la estructura.
     * Complejidad temporal: O(1) - Constante.
     * * @param accion Descripción de texto de la acción realizada (ej. "Se agregó curso X").
     */
    public void push(String accion) {
        // 1. Crear el nuevo nodo con el dato recibido.
        NodoPila nuevo = new NodoPila(accion);

        // 2. Enlazar el nuevo nodo con el antiguo tope.
        // El nuevo nodo ahora "pisa" al que estaba antes arriba.
        nuevo.siguiente = tope;

        // 3. Actualizar la referencia del tope.
        // Ahora el "tope" oficial es este nuevo nodo.
        tope = nuevo;
    }

    /**
     * Muestra el contenido de la pila desde el tope hasta el fondo.
     * Esto cumple con el requisito de mostrar el historial en "orden inverso" 
     * (lo más reciente primero), tal como funciona un historial real.
     */
    public void mostrarHistorial() {
        System.out.println("=== HISTORIAL DE ACCIONES (LIFO) ===");
        
        // Usamos un puntero auxiliar 'actual' para recorrer sin perder la referencia 'tope'.
        NodoPila actual = tope;

        // Recorremos mientras existan nodos (hasta llegar a null).
        while (actual != null) {
            // Imprimimos la acción del nodo actual.
            System.out.println("-> " + actual.accion);

            // Avanzamos al siguiente nodo (hacia abajo en la pila).
            actual = actual.siguiente;
        }
    }
}