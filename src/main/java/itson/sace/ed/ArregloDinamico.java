package itson.sace.ed; // Paquete de Estructuras de Datos (ed)

/**
 * Implementación personalizada de un arreglo dinámico.
 * Esta clase sustituye el uso de java.util.ArrayList cumpliendo con la restricción
 * del proyecto de no utilizar estructuras de datos prefabricadas de Java.
 * Funciona manejando internamente un arreglo nativo (Object[]) que crece
 * automáticamente cuando se queda sin espacio.
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class ArregloDinamico {
    
    // --- Atributos Internos ---

    /**
     * Arreglo interno donde se guardan realmente los datos.
     * Es de tipo Object para ser genérico (poder guardar Cursos, Calificaciones o Estudiantes).
     */
    private Object[] datos;
    
    /** * Contador de elementos lógicos. 
     * Indica cuántos espacios del arreglo están realmente ocupados por datos válidos.
     * Diferente de datos.length (que es la capacidad física).
     */
    private int contador;
    
    /**
     * Constructor que inicializa el arreglo con una capacidad inicial pequeña.
     * Complejidad: O(1)
     */
    public ArregloDinamico() {
        // Iniciamos con tamaño 5. Es pequeño para forzar que el redimensionamiento
        // ocurra pronto y probar que la lógica de crecimiento funciona.
        datos = new Object[5];
        contador = 0;
    }
    
    /**
     * Agrega un nuevo elemento al final del arreglo.
     * Si el arreglo está lleno, duplica su tamaño automáticamente.
     * * @param elemento El objeto a guardar (puede ser Curso, Estudiante, Double, etc.)
     */
    public void agregar(Object elemento) {
        // 1. Verificación de capacidad (Lógica de Resizing)
        if (contador == datos.length) {
            // Si llegamos al límite físico, creamos un arreglo nuevo del doble de tamaño.
            Object[] nuevoArr = new Object[datos.length * 2];
            
            // Copiamos manualmente los elementos del arreglo viejo al nuevo.
            for (int i = 0; i < datos.length; i++) {
                nuevoArr[i] = datos[i];
            }
            
            // Reemplazamos la referencia: ahora 'datos' apunta al arreglo grande.
            datos = nuevoArr;
        }
        
        // 2. Inserción del elemento
        datos[contador++] = elemento; // Guarda y luego incrementa el contador
    }
    
    /**
     * Obtiene el elemento en una posición específica.
     * * @param index Índice del elemento deseado.
     * @return El objeto en esa posición, o null si el índice es inválido.
     */
    public Object get(int index) {
        // Validación de rangos para evitar ArrayIndexOutOfBoundsException
        if (index >= 0 && index < contador) {
            return datos[index];
        }
        return null; // Retorno seguro si piden un índice fuera de rango
    }
    
    /**
     * Retorna la cantidad de elementos guardados actualmente.
     * * @return Número entero con la cantidad de elementos.
     */
    public int size() {
        return contador;
    }
    
    /**
     * Elimina un elemento en un índice específico y compacta el arreglo.
     * Mueve todos los elementos a la derecha del índice eliminado un paso hacia la izquierda.
     * * @param index Índice del elemento a eliminar.
     */
    public void eliminar(int index) {
        if (index >= 0 && index < contador) {
            // Lógica de desplazamiento hacia la izquierda
            // Sobrescribimos el elemento a borrar con el siguiente, y así sucesivamente.
            for (int i = index; i < contador - 1; i++) {
                datos[i] = datos[i + 1];
            }
            
            // Decrementamos el contador lógico
            contador--;
            
            // Limpieza: Ponemos null en la última posición física que quedó duplicada
            // para ayudar al Garbage Collector de Java a liberar memoria.
            datos[contador] = null;
        }
    }
}