package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante {

	// ATRIBUTOS
	private String nombre;
	private Casa casa;
	private int vida;
	private int ataque;
	private int defensa;
	private int nivel = 1;

	// CONSTRUCTORES

	public Estudiante(String nombre, Casa casa) {
		this.nombre = nombre;
		this.casa = casa;
	}

	public Estudiante(String nombre, Casa casa, int vida, int ataque, int defensa, int nivel) {
		this.nombre = nombre;
		this.casa = casa;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = nivel;
	}

	public Estudiante() {

	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	// OTROS MÉTODOS

	public static int estudianteElegido() {
		Scanner sc = new Scanner(System.in);
		int estudianteElegido = 0;
		do {
			System.out.println("\n¿Qué estudiante vas a elegir?:");
			System.out.println("1. Hubert | 2. Dimitri | 3. Claude");
			estudianteElegido = sc.nextInt();
			sc.nextLine();
		} while (estudianteElegido > 3 || estudianteElegido < 1);
		return estudianteElegido;
	}

	public void atacar(Enemigo defensor) {
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

	// MÉTODO DE IMPRESIÓN
	public void imprimirInfo() {
		String personaje = "Estudiante: " + nombre + "\nCasa: " + casa + "\nLema: " + casa.getLema() + "\nVida: " + vida
				+ "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nNivel: " + nivel;

		System.out.println(personaje);
	}

	public void imprimirInfoParcial() {
		String personaje = "Estudiante: " + nombre + "\nCasa: " + casa;

		System.out.println(personaje);
	}

	public static int empezarPor(ArrayList<Enemigo> enemigos, Estudiante seleccionado) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"-----------------------------\nTU PERSONAJE HA RECIBIDO SUS PARÁMETROS DE VIDA, ATAQUE Y DEFENSA:");
		seleccionado.imprimirInfo();
		int empezarPor = (int) (Math.random() * (enemigos.size() + 0)) + 0;
		System.out.println("\n-----------------------------\nEn primer lugar te enfrentarás a "
				+ enemigos.get(empezarPor).getNombre());
		System.out.println("Pulsa ENTER para simular el entrenamiento");
		sc.nextLine();
		return empezarPor;
	}

	public void combateGanado(ArrayList<Enemigo> enemigos, int empezarPor2, Estudiante seleccionado, int vidaEstudiante,
			int ataqueEstudiante, int defensaEstudiante, int vidaMaxEstudiante) {
		// DESTREZA DÉBIL
		if (enemigos.get(empezarPor2).getDestreza() == Destreza.DEBIL) {
			System.out.println(
					"\nComo la destreza del enemigo era Débil tus estadísticas aumentan en:\n5 puntos de vida máxima posible\n2 puntos de ataque\n1 punto de defensa\n1 nivel");
			vidaMaxEstudiante += 5;
			seleccionado.setAtaque(this.ataque + 2);
			seleccionado.setDefensa(this.defensa + 1);
			seleccionado.setNivel(this.nivel + 1);
			System.out.println();
			seleccionado.imprimirInfo();
			Usuario.pulsarEnter();
			System.out.println(
					"\nAdemás, al haber subido 1 nivel, aumentas tu vida en 10 pts, no pudiendo sobrepasar tu vida máxima que es ahora ("
							+ vidaMaxEstudiante + ").");
			if (this.vida < vidaMaxEstudiante - 10) {
				seleccionado.setVida(seleccionado.getVida() + 10);
				System.out.println();
				seleccionado.imprimirInfo();
			} else if (this.vida >= vidaMaxEstudiante - 10) {
				seleccionado.setVida(vidaMaxEstudiante);
				System.out.println();
				seleccionado.imprimirInfo();
			}
			// DESTREZA FUERTE
		} else if (enemigos.get(empezarPor2).getDestreza() == Destreza.FUERTE) {
			System.out.println(
					"\nComo la destreza del enemigo era Fuerte tus estadísticas aumentan en:\n8 puntos de vida máxima posible\n3 puntos de ataque\n2 punto de defensa\n2 niveles");
			vidaMaxEstudiante += 8;
			seleccionado.setAtaque(this.ataque + 3);
			seleccionado.setDefensa(this.defensa + 2);
			seleccionado.setNivel(this.nivel + 2);
			System.out.println();
			seleccionado.imprimirInfo();
			Usuario.pulsarEnter();
			System.out.println(
					"\nAdemás, al haber subido 2 niveles, aumentas tu vida en 20 pts, no pudiendo sobrepasar tu vida máxima que es ahora ("
							+ vidaMaxEstudiante + ").");
			if (this.vida < vidaMaxEstudiante - 20) {
				seleccionado.setVida(seleccionado.getVida() + 20);
				System.out.println();
				seleccionado.imprimirInfo();
			} else if (this.vida >= vidaMaxEstudiante - 20) {
				seleccionado.setVida(vidaMaxEstudiante);
				System.out.println();
				seleccionado.imprimirInfo();
			}
		}
	}

	public static void resultadoFinal(Estudiante seleccionado) {
		if (seleccionado.getVida() <= 0) {
			System.out.println("\n\nHAS MUERTO, FIN DEL JUEGO");
		} else if (seleccionado.getNivel() >= 10) {
			System.out.println("\n\n¡ENHORABUENA, HAS ALCANZADO EL NIVEL 10!");
		}
	}

}