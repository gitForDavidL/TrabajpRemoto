package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BinariosFile;
import co.edu.unbosque.model.persistence.GamerDAO;
import co.edu.unbosque.model.persistence.GamerDTO;

public class Gamer {

	private GamerDAO gamerDAO;

	public Gamer() {

		gamerDAO = new GamerDAO();

	}

	public GamerDAO getGamerDAO() {
		return gamerDAO;
	}

	public void setGamerDAO(GamerDAO gamerDAO) {
		this.gamerDAO = gamerDAO;
	}

}