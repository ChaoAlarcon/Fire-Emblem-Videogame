package model;

import java.util.ArrayList;

public class ListaEnemigos {
    
    private ArrayList<Enemigo> enemigos;
    private ArrayList<Enemigo> numeroEnemigosElegido;

    public ListaEnemigos() {
        enemigos = new ArrayList<>();
        numeroEnemigosElegido = new ArrayList<>();
        inicializarEnemigos();
    }

    public ArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<Enemigo> enemigos) {
        this.enemigos = enemigos;
    }

    public ArrayList<Enemigo> getNumeroEnemigosElegido() {
        return numeroEnemigosElegido;
    }

    public void seleccionarEnemigo(int indice) {
        if (indice >= 0 && indice < enemigos.size()) {
            numeroEnemigosElegido.add(enemigos.get(indice));
        }
    }

    public void inicializarEnemigos() {
        enemigos.add(new Enemigo("Goblin", 50, 10, 4, Destreza.Fuerte));
        enemigos.add(new Enemigo("Orco", 30, 8, 2, Destreza.Débil));
        enemigos.add(new Enemigo("Troll", 70, 15, 6, Destreza.Fuerte));
        enemigos.add(new Enemigo("Dragón", 100, 20, 10, Destreza.Fuerte));
        enemigos.add(new Enemigo("Esqueleto", 40, 12, 3, Destreza.Débil));
    }

    public Enemigo obtenerEnemigo(int indice) {
        if (indice >= 0 && indice < enemigos.size()) {
            return enemigos.get(indice);
        }
        return null;
    }

    public int cantidadEnemigos() {
        return enemigos.size();
    }

    public void mostrarDetallesEnemigos() {
        for (Enemigo enemigo : enemigos) {
            System.out.println("-------------------");
            System.out.println(enemigo.getNombre() + " es un enemigo " + enemigo.getDestreza() + 
                               " tiene " + enemigo.getVida() + " puntos de vida, " + 
                               enemigo.getAtaque() + " puntos de ataque y " + 
                               enemigo.getDefensa() + " puntos de defensa");
            System.out.println("");
        }
    }
}
	
	
	
	
	
	

