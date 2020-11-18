package co.edu.unbosque.model;

import co.edu.unbosque.model.persitence.EventosDAO;
import co.edu.unbosque.model.persitence.SedesDAO;

public class CasaApuesta {

	private SedesDAO sedesDAO;
	private EventosDAO eventosDAO;

	public CasaApuesta() {

		sedesDAO = new SedesDAO();
		eventosDAO = new EventosDAO();

	}

	public void cargarEventosSedes(int selec, String nombre, String sede, Double presupuesto, String fecha) {

		sedesDAO.getSedes().get(selec).getEventosDTO().add(eventosDAO.ingresarEvento(nombre, sede, presupuesto, fecha));

		sedesDAO.getFileSede().escribirRegistros(sedesDAO.getSedes());
	}

	/**
	 * @return the sedesDAO
	 */
	public SedesDAO getSedesDAO() {
		return sedesDAO;
	}

	/**
	 * @param sedesDAO the sedesDAO to set
	 */
	public void setSedesDAO(SedesDAO sedesDAO) {
		this.sedesDAO = sedesDAO;
	}

}
