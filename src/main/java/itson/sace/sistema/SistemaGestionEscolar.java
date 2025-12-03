/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package itson.sace.sistema;

import java.util.Scanner;

/**
 *
 * @author ramuk
 */
public class SistemaGestionEscolar {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
        do{
            imprimirMenu();
            try{
                opcion = Integer.parseInt(sc.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e){
                System.out.println("Erro: Ingresa un numero valido");
            }
        } while (opcion != 6);
    }
    
    static void imprimirMenu(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    static void ejecutarOpcion(int op){
        switch (op) {
            case 1:
                menuEstudiantes();
                break;
            case 2:
                menuCursos();
                break;
            case 3:
                menuInscripciones();
                break;
            case 4:
                menuCalificaiones();
                break;
            case 5:
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
    
    static void menuEstudiantes(){
        
    }
    
    static void menuCursos(){
        
    }
    
    static void menuInscripciones(){
        
    }
    
    static void menuCalificaiones(){
        
    }
}
