package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.GamerFile;
import co.edu.unbosque.model.persistence.GameDAO;
import co.edu.unbosque.model.persistence.GameDTO;
import co.edu.unbosque.model.persistence.GamerDAO;
import co.edu.unbosque.model.persistence.GamerDTO;

public class Torneo {

	private GamerDAO gamerDAO;
	private GameDAO gameDAO;

	public Torneo() {

		gamerDAO = new GamerDAO();
		gameDAO = new GameDAO();

	}

	public void asignarJuegosJugador(int selec, String nombre, Double puntaje, String dia) {

		gamerDAO.getGamerRegistros().get(selec).getJuegos().add(gameDAO.ingresarJuego(nombre, puntaje, dia));
		gamerDAO.getBin().escribirRegistros(gamerDAO.getGamerRegistros());
	}

	public void IDJuego(int selec) {

		for (int i = 0; i < gamerDAO.getGamerRegistros().get(selec).getJuegos().size(); i++) {

			gamerDAO.getGamerRegistros().get(selec).getJuegos().get(i)
					.setID(gamerDAO.getGamerRegistros().get(selec).getiD());

		}
	}

	public GamerDAO getGamerDAO() {
		return gamerDAO;
	}

	public void setGamerDAO(GamerDAO gamerDAO) {
		this.gamerDAO = gamerDAO;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}