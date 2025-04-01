package model;

public enum Casa {
	
	AGUILAS_NEGRAS("Volemos alto"),
	LEONES_AZULES("Oye mi rugido"),
	CIERVOS_DORADOS("No sé que hago aquí");
	
	private final String LEMA;
	
	private Casa(String lema) {
		
		this.LEMA = lema;
	}

	public String getLema() {
		return LEMA;
	}
	

}
