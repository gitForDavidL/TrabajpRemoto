package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class GameDTO implements Serializable {

	private String nombre;
	private int ID;
	private String fecha;
	private Double puntaje;

	public GameDTO(String nombre, Double puntaje) {

		this.nombre = nombre;
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}

	public String toString() {

		return "| Nombre del juego: " + this.nombre + " | ID jugador: " + ID + "| Fecha :  " + this.fecha
				+ "| Puntaje: " + this.puntaje + " | ";
	}

}
