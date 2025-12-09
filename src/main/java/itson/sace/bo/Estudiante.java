package itson.sace.bo; // Define que esta clase pertenece al paquete de Objetos de Negocio (Business Objects).

// Importamos nuestra estructura de datos personalizada.
// Esto es necesario porque el proyecto prohíbe el uso de java.util.ArrayList.
import itson.sace.ed.ArregloDinamico;

/**
 * Clase que representa a un Estudiante dentro del sistema escolar.
 * Contiene los datos personales y la estructura para almacenar sus calificaciones.
 * @author Vladimir Ivan Mendoza Baypoli
 * @author Oscar Adrian Castan Lopez
 */
public class Estudiante {

    // --- Atributos del Estudiante ---
    
    /** Identificador único del estudiante (se usa para ordenar en el BST). */
   public int matricula;
    
    /** Nombre completo del estudiante. */
    String nombre;
    
    /** Número de teléfono de contacto. */
    String telefono;
    
    /** Correo electrónico personal o institucional. */
    String email;
    
    /** Dirección del domicilio del estudiante. */
    String domicilio;
    
    /** * Estructura personalizada para almacenar las calificaciones.
     * Se usa un Arreglo Dinámico en lugar de un array simple o ArrayList 
     * para cumplir con el Requerimiento 1.
     */
    ArregloDinamico calificaciones;

    /**
     * Constructor para inicializar un nuevo objeto Estudiante.
     * * @param matricula Número de identificación único.
     * @param nombre Nombre completo.
     * @param telefono Teléfono de contacto.
     * @param email Correo electrónico.
     * @param domicilio Dirección.
     */
    public Estudiante(int matricula, String nombre, String telefono, String email, String domicilio) {
        // Asignación de los valores recibidos a los atributos de la instancia (this)
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        
        // IMPORTANTE: Inicializamos el arreglo dinámico vacío.
        // Si no hacemos esto, la variable 'calificaciones' sería null y daría error al intentar agregar notas.
        this.calificaciones = new ArregloDinamico();
    }
    
    /**
     * Calcula el promedio aritmético de las calificaciones del estudiante.
     * Recorre el Arreglo Dinámico personalizado para sumar los valores.
     * * @return El promedio como valor tipo double. Retorna 0.0 si no tiene calificaciones.
     */
    public double obtenerPromedio() {
        // Validación de seguridad: Evitar división entre cero si el arreglo está vacío.
        if (calificaciones.size() == 0) return 0.0;
        
        double suma = 0; // Acumulador para la suma de notas
        
        // Iteramos desde el índice 0 hasta el tamaño actual del arreglo dinámico (size())
        for (int i = 0; i < calificaciones.size(); i++) {
            // DETALLE TÉCNICO IMPORTANTE:
            // Nuestro ArregloDinamico guarda datos tipo 'Object' (genérico básico).
            // Es OBLIGATORIO hacer un cast explícito a (double) para poder sumarlo numéricamente.
            suma += (double) calificaciones.get(i);
        }
        
        // Retornamos el resultado de la división (Suma Total / Cantidad de Elementos)
        return suma / calificaciones.size();
    }

    /**
     * Sobrescribe el método toString de Java para mostrar una representación legible del objeto.
     * Útil para imprimir el estudiante en consola o listas.
     * * @return Cadena de texto con la matrícula y el nombre.
     */
    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + '}';
    }
    
}