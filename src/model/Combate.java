package model;

import java.util.*;

public class Combate {
    public void iniciarCombate() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de enemigos con los que deseas enfrentarte: ");
        int eleccion = scanner.nextInt();
        int enemigoAleatorio;
        ListaEnemigos listaEnemigos = new ListaEnemigos();
        Random random = new Random();
        
        
        
        
      
        
        if (eleccion > 0 && eleccion <= 5) {
            System.out.println("Has elegido combatir con " + eleccion + " enemigos");
            
           
        } else {
            System.out.println("Número de enemigos no válido. Por favor, elige un número entre 1 y " + 5);
        }
        
        listaEnemigos.seleccionarEnemigo(eleccion);
        
        
        
        // Generar un número aleatorio para el enemigo
        enemigoAleatorio = random.nextInt(listaEnemigos.cantidadEnemigos());
        Enemigo enemigo = listaEnemigos.obtenerEnemigo(enemigoAleatorio);
        System.out.println("Te enfrentarás contra " + enemigo.getNombre());
        
       
        } 
        
    

    private void EnemigosEnfrentar(ListaEnemigos listaEnemigos) {
        // Implementación del método
    }
    
    
}
