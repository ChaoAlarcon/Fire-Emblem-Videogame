package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Enemigo {

	// ATRIBUTOS
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private Destreza destreza;

	// CONSTRUCTORES
	public Enemigo() {

	}

	public Enemigo(String nombre, int vida, int ataque, int defensa, Destreza destreza) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.destreza = destreza;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public Destreza getDestreza() {
		return destreza;
	}

	public void setDestreza(Destreza destreza) {
		this.destreza = destreza;
	}

	// OTROS MÉTODOS

	public static void numeroDeEnemigos(ArrayList<Enemigo> enemigos) {
		Scanner sc = new Scanner(System.in);
		int numeroDeEnemigos = 0;
		System.out.println("\n¿Contra cuántos enemigos quieres luchar?");
		do {
			System.out.println("Elige una cifra entre 2 y 5:");
			numeroDeEnemigos = sc.nextInt();
		} while (numeroDeEnemigos > 5 || numeroDeEnemigos < 2);

		switch (numeroDeEnemigos) { 
		case 2:
			for (int i = enemigos.size() - 1; i >= 2; i--) {
				enemigos.remove(i);
			}
			break;
		case 3:

			for (int i = enemigos.size() - 1; i >= 3; i--) {
				enemigos.remove(i);
			}
			break;
		case 4:
			for (int i = enemigos.size() - 1; i >= 4; i--) {
				enemigos.remove(i);
			}

			break;

		default:
			break;
		}
		System.out.println("-----------------------------");
		System.out.println("TE ENFRENTARÁS A " + enemigos.size() + " ENEMIGOS:\n");
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).imprimirInfo();
			System.out.println();
		}
	}

	public void atacar(Estudiante defensor) {
		if (defensor.getVida() > 0) {
			// DAÑO QUE VAS A HACER:
			int daño = this.ataque - defensor.getDefensa();
			if (daño <= 0) {
				System.out.println("El ataque no supera a la defensa de " + defensor.getNombre()
						+ ", se le restará 1 punto de vida.");
				daño = 1;
			}
			// VIDA - DAÑO = VIDA RESULTANTE:
			int vidaResultante = Math.max(0, defensor.getVida() - daño);
			System.out.println("Daño infligido: " + daño);
			defensor.setVida(vidaResultante);
			defensor.imprimirInfo();
		} else {
			System.out.println(defensor.getNombre() + " ya está muerto/a");
		}
	}

	public void resucitar() {
		System.out.println("\n¡El enemigo ha conseguido resucitar!");
		if (this.destreza == Destreza.DEBIL) {
			this.vida = 30;
		} else {
			this.vida = 50;
		}
		this.defensa += 1;
		this.ataque += 1;
		this.imprimirInfo();
	}

	// MÉTODO DE IMPRESIÓN

	public void imprimirInfo() {
		String personaje = "Enemigo: " + nombre + "\nVida: " + vida + "\nAtaque: " + ataque + "\nDefensa: " + defensa
				+ "\nDestreza: " + destreza.getDestreza();

		System.out.println(personaje);
	}

	public static void imprimirTodosLosEnemigos(ArrayList<Enemigo> enemigos) {
		int enemigoNum = 1;
		System.out.println("Estos son todos los enemigos:\n");
		for (Enemigo enemigo : enemigos) {
			System.out.println("#" + enemigoNum);
			enemigo.imprimirInfo();
			enemigoNum++;
			System.out.println();
		}
	}

}
