package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	public static void bienvenida() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a Fire Emblem Three Houses");
		System.out.println("¿Cuál es tu nombre?:");
		String nombreUsuario = sc.nextLine();
		System.out.println("Seas bienvenido, " + nombreUsuario + ".");
		crearListaEnemigos();
	}

	public static void pulsarEnter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Pulsa ENTER para continuar");
		sc.nextLine();
	}
	
	public static void elegirPersonaje(ArrayList<Enemigo> enemigos) {
		// ELIGIENDO ESTUDIANTE
				int vidaEstudiante = (int) (Math.random() * (20 + 1)) + 40;
				int ataqueEstudiante = (int) (Math.random() * (5 + 1)) + 7;
				int defensaEstudiante = (int) (Math.random() * (3 + 1)) + 4;
				int vidaMaxEstudiante = vidaEstudiante;

				int nivel = 1;
				int estudianteElegido = Estudiante.estudianteElegido();
				Estudiante seleccionado;
				if (estudianteElegido == 1) {
					System.out.println("Has elegido a:");
					Estudiante hubert = new Estudiante("Hubert", Casa.AGUILAS_NEGRAS, vidaEstudiante, ataqueEstudiante,
							defensaEstudiante, nivel);
					hubert.imprimirInfoParcial();
					seleccionado = hubert;
				} else if (estudianteElegido == 2) {
					System.out.println("Has elegido a:");
					Estudiante dimitri = new Estudiante("Dimitri", Casa.LEONES_AZULES, vidaEstudiante, ataqueEstudiante,
							defensaEstudiante, nivel);
					dimitri.imprimirInfoParcial();
					seleccionado = dimitri;
				} else {
					System.out.println("Has elegido a:");
					Estudiante claude = new Estudiante("Claude", Casa.CIERVOS_DORADOS, vidaEstudiante, ataqueEstudiante,
							defensaEstudiante, nivel);
					claude.imprimirInfoParcial();
					seleccionado = claude;
				}
				// FIN ELEGIENDO ESTUDIANTE
				Enemigo.numeroDeEnemigos(enemigos);
				Combate.combate(enemigos, seleccionado, vidaEstudiante, ataqueEstudiante, defensaEstudiante, vidaMaxEstudiante);
				Estudiante.resultadoFinal(seleccionado);
	}
	
	public static void crearListaEnemigos() {
		ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
		enemigos.add(new Enemigo("Epyon", 30, 8, 2, Destreza.DEBIL));
		enemigos.add(new Enemigo("Sinanju", 50, 10, 4, Destreza.FUERTE));
		enemigos.add(new Enemigo("Zaku", 30, 8, 2, Destreza.DEBIL));
		enemigos.add(new Enemigo("Sazabi", 50, 10, 4, Destreza.FUERTE));
		enemigos.add(new Enemigo("Z'Gok", 30, 8, 2, Destreza.DEBIL));

		elegirPersonaje(enemigos);
	}

}