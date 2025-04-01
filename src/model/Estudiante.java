package model;

import java.util.*;

public class Estudiante {

	Random random = new Random();

	Scanner sc = new Scanner(System.in);

	private String nombre;
	private Casa casa;
	private int vida;
	private int ataque;
	private int defensa;
	private int nivel = 1;
	private int eleccion;

	public Estudiante() {

	}

	public Estudiante(String nombre, Casa casa, int vida, int ataque, int defensa) {

		this.nombre = nombre;
		this.casa = casa;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = nivel;
	}

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

	public void atacar(Estudiante defensor) {

		if (defensor.getVida() > 0) {
			int resultado = defensor.getVida() - (this.ataque - defensor.getDefensa());

			defensor.setVida(resultado);

			defensor.imprimirInfo();

		} else {
			System.out.println(defensor.getNombre() + " está muerto/a");
		}

	}

	public void elegirEstudiante() {
		System.out.println("Elije tu estudiante:");
		System.out.println("1. Dimitri, Leones Azules");
		System.out.println("2. Edelgard, Águilas Negras");
		System.out.println("3. Claude, Ciervos Dorados");
		eleccion = sc.nextInt();
		System.out.println("");
		while (eleccion < 1 || eleccion > 3) {
			System.out.println("Eso no es una opción válida, elije un número entre 1 y 3");
			System.out.println("Elije tu estudiante:");
			System.out.println("1. Dimitri, Leones Azules");
			System.out.println("2. Edelgard, Águilas Negras");
			System.out.println("3. Claude, Ciervos Dorados");
			eleccion = sc.nextInt();
			System.out.println("");
		}
		if (eleccion == 1) {
			System.out.println("Has elegido a Dimitri que está en la casa de Leones Azules");
			setNombre("Dimitri");
			setCasa(Casa.LEONES_AZULES);
		}
		if (eleccion == 2) {
			System.out.println("Has elegido a Edelgard que está en la casa de Águilas Negras");
			setNombre("Edelgard");
			setCasa(Casa.AGUILAS_NEGRAS);
		}

		if (eleccion == 3) {
			System.out.println("Has elegido a Claude que está en la casa de Ciervos Dorados");
			setNombre("Claude");
			setCasa(Casa.CIERVOS_DORADOS);
		}
		setVida(random.nextInt(21) + 40);
		setAtaque(random.nextInt(6) + 7);
		setDefensa(random.nextInt(4) + 4);
		System.out.println("");
		imprimirInfo();
	}

	public void imprimirInfo() {
		String personaje = "Estudiante: " + nombre + "\nCasa: " + casa + "\nLema: " + casa.getLema() + "\nVida: " + vida
				+ "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nNivel: " + nivel;

		System.out.println(personaje);
		System.out.println();
	}

}
