package co.edu.unbosque.model;

import co.edu.unbosque.model.persitence.SedesDAO;

public class CasaApuesta {

	private SedesDAO sedesDAO;

	public CasaApuesta() {
		
		sedesDAO = new SedesDAO();

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
