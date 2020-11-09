package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

public class GamerDTO implements Serializable {

	private String nombre;
	private ArrayList<GameDTO> juegos;
	private int iD;

	public GamerDTO(String nombre) {

		this.nombre = nombre;
		juegos = new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<GameDTO> getJuegos() {
		return juegos;
	}

	public void setJuegos(ArrayList<GameDTO> juegos) {
		this.juegos = juegos;
	}

	public String toString() {
		return "ID : "+ this.iD + "| Nickname: " + this.nombre;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

}
