package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.GamerFile;
import co.edu.unbosque.model.persistence.GamerDAO;
import co.edu.unbosque.model.persistence.GamerDTO;

public class Torneo {

	private GamerDAO gamerDAO;

	public Torneo() {

		gamerDAO = new GamerDAO();

	}

	public GamerDAO getGamerDAO() {
		return gamerDAO;
	}

	public void setGamerDAO(GamerDAO gamerDAO) {
		this.gamerDAO = gamerDAO;
	}

}