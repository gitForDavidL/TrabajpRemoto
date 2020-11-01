package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class Registro implements Serializable {

	private String nombre;
	private String juego;
	private Double puntaje;
	private int iD;

	public Registro(String nombre, String juego, Double puntaje) {

		this.nombre = nombre;
		this.juego = juego;
		this.puntaje = puntaje;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}


	public Double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}

	public String toString() {
		return iD + " -Nombre: " + this.nombre + " Juego: " + this.juego + " Puntaje : " + this.puntaje + "\n";
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

}
