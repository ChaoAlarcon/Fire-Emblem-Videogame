package model;

public class Enemigo {
	
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private Destreza destreza;
	
	public Enemigo(String nombre, int vida, int ataque, int defensa, Destreza destreza) {

		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.destreza = destreza;

	}
	
	public Enemigo() {
		
	}

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

	
	
	
	

}
