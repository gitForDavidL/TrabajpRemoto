package co.edu.unbosque.model.persitence;

import java.io.Serializable;
import java.util.ArrayList;

public class SedesDTO implements Serializable {

	private String nombre;
	private Double presupuesto;
	private String localidad;
	private int empleados;
	private ArrayList<EventosDTO> eventosDTO;

	public SedesDTO(String nombreSede, Double presupuesto, String localidad, int empleados) {

		this.nombre = nombreSede;
		this.presupuesto = presupuesto;
		this.localidad = localidad;
		this.empleados = empleados;
		eventosDTO = new ArrayList<EventosDTO>();

	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the presupuesto
	 */
	public Double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the empleados
	 */
	public int getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	/**
	 * @return the eventosDTO
	 */
	

	@Override
	public String toString() {
		return "nombre= " + nombre + ", presupuesto=" + presupuesto + ", localidad=" + localidad + ", empleados="
				+ empleados + "]";
	}

	/**
	 * @return the eventosDTO
	 */
	public ArrayList<EventosDTO> getEventosDTO() {
		return eventosDTO;
	}

	/**
	 * @param eventosDTO the eventosDTO to set
	 */
	public void setEventosDTO(ArrayList<EventosDTO> eventosDTO) {
		this.eventosDTO = eventosDTO;
	}

}
