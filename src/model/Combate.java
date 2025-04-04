package model;

import java.util.ArrayList;

public class Combate {

	public static void combate(ArrayList<Enemigo> enemigos, Estudiante seleccionado, int vidaEstudiante, int ataqueEstudiante, int defensaEstudiante, int vidaMaxEstudiante) {
		// COMBATE
		int contadorCombate = 1;
		boolean combate = true;
		boolean guerra = true;
		int contadorParaSiguienteRandomEnemigo = 0;
		int enemigoSiguiente = Estudiante.empezarPor(enemigos, seleccionado); // Pulsar tecla ENTER para empezar
		while (guerra) {
			while (combate) {
				if (contadorParaSiguienteRandomEnemigo > 0) {
					enemigoSiguiente = (int) (Math.random() * (enemigos.size() + 0)) + 0; // En un ArrayList de tamaño
																							// 5, los índices válidos
																							// son {0, 1, 2, 3, 4}. Como
																							// Math.random() genera
																							// valores entre 0.0 y 1.0,
																							// debemos multiplicarlo por
																							// size (5) para asegurarnos
																							// de que los valores
																							// generados estén dentro
																							// del rango válido. Si
																							// sumáramos +1, podríamos
																							// obtener un número fuera
																							// del rango (5), lo que
																							// causaría un error al
																							// acceder a la lista.
					System.out.println("\n\nTU ENEMIGO AHORA ES: " + enemigos.get(enemigoSiguiente).getNombre());
				}
				// ATACA ESTUDIANTE
				System.out.println("-----------------------------");
				while (contadorCombate < 4) {
					if (seleccionado.getVida() > 0) {
						if (enemigos.get(enemigoSiguiente).getVida() > 0) {
							Usuario.pulsarEnter();
							System.out.println(
									seleccionado.getNombre() + " ataca a " + enemigos.get(enemigoSiguiente).getNombre()
											+ " por " + contadorCombate + "ª vez.");
							seleccionado.atacar(enemigos.get(enemigoSiguiente));
						}
						contadorCombate++;
					} else {
						Usuario.pulsarEnter();
						System.out.println(seleccionado.getNombre() + " está muerto.");
						System.out.println(
								enemigos.get(enemigoSiguiente).getNombre() + " ha ganado este combate, te ha matado");
						guerra = false;
						combate = false;
						contadorCombate = 4; // para cerrar bucle while (contadorCombate < 4)
					}
				}
				// ATACA ENEMIGO
				System.out.println("-----------------------------");
				contadorCombate = 1;
				if (enemigos.get(enemigoSiguiente).getVida() > 0) {
					if (seleccionado.getVida() > 0) {
						Usuario.pulsarEnter();
						System.out.println(enemigos.get(enemigoSiguiente).getNombre() + " ataca a "
								+ seleccionado.getNombre() + " 1 vez.");
						(enemigos.get(enemigoSiguiente)).atacar(seleccionado);
					}
				} else {
					Usuario.pulsarEnter();
					System.out.println(enemigos.get(enemigoSiguiente).getNombre() + " está muerto.");
					System.out.println(seleccionado.getNombre() + " ha ganado este combate");
					seleccionado.combateGanado(enemigos, enemigoSiguiente, seleccionado, vidaEstudiante,
							ataqueEstudiante, defensaEstudiante, vidaMaxEstudiante); // SEGÚN ENEMIGO ES DE DESTREZA
																						// DÉBIL O FUERTE
					Usuario.pulsarEnter();
					combate = false;
				}
				if (seleccionado.getNivel() >= 10) {
					guerra = false;
					combate = false;
				}
			}
			enemigos.get(enemigoSiguiente).resucitar();
			combate = true;
			contadorParaSiguienteRandomEnemigo++;
			System.out.println("Contador programa: " + contadorParaSiguienteRandomEnemigo); // quitar esto?
		}
		// FIN COMBATE
	}
}
