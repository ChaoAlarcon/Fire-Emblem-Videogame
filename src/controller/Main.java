package controller;
import model.*;

public class Main {

	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante();
		System.out.println("¡Bienvenido a Fire Emblem Three Houses!");
		estudiante.elegirEstudiante();
		Combate combate = new Combate();
		combate.iniciarCombate();
		
		
	}

}
