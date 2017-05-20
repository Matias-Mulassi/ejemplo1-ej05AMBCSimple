package entities;


public class Vehiculo {

	private  String patente;
	private boolean pagado;
	private String modelo;
	private String anio;
	private String titular;
	
	
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public boolean equals(Object obj){
	    if(obj instanceof Vehiculo){
	    	return (((Vehiculo)obj).getPatente().equals(this.getPatente())); //JAVA busco unicamente por direccion de memoria, por eso la redefinicion//
	    }
	    return false;
	}
	
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	public Vehiculo() {}
	
	public Vehiculo (String patente , boolean pagado , String modelo ,String anio , String titular  ) {
		this.patente=patente;
		this.pagado=pagado;
		this.modelo=modelo;
		this.titular=titular;
		this.anio=anio;
	
		
	}

	
	
	
	
}
