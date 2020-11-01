package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BinariosFile;
import co.edu.unbosque.model.persistence.Registro;

public class Gamer {

	private BinariosFile bin;
	private ArrayList<Registro> gamerRegistros;

	public Gamer() {

		bin = new BinariosFile();
		gamerRegistros = new ArrayList<Registro>();
	}

	public void ingresarDatos(String nombre, String juego, Double puntaje) {

		gamerRegistros.add(new Registro(nombre, juego, puntaje));

	}
	

	public BinariosFile getBin() {
		return bin;
	}

	public void setBin(BinariosFile bin) {
		this.bin = bin;
	}

	public ArrayList<Registro> getGamerRegistros() {
		return gamerRegistros;
	}

	public void setGamerRegistros(ArrayList<Registro> gamerRegistros) {
		this.gamerRegistros = gamerRegistros;
	}

}
