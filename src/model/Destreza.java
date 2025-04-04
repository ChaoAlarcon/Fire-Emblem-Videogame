package model;

public enum Destreza {

	DEBIL("Débil"), FUERTE("Fuerte");

	private String destreza = "";

	private Destreza(String destreza) {
		this.destreza = destreza;
	}

	public String getDestreza() {
		return destreza;
	}

}