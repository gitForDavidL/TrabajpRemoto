package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BinariosFile;
import co.edu.unbosque.model.persistence.Registro;

public class Gamers {

	private BinariosFile bin;
	private ArrayList<Registro> gamerRegistros;

	public Gamers() {

		bin = new BinariosFile();
		gamerRegistros = new ArrayList<Registro>();
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
