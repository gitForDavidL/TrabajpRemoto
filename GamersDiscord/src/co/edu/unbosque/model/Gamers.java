package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.BinariosFile;

public class Gamers {

	private BinariosFile bin;

	public Gamers() {

		bin = new BinariosFile();
	}

	

	public BinariosFile getBin() {
		return bin;
	}

	public void setBin(BinariosFile bin) {
		this.bin = bin;
	}
	
	

}
