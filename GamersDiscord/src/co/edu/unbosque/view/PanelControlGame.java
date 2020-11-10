package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelControlGame extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JButton crear, agregar, borrar,leer, actualizar ;
	public static final String CREARGAME = "CrearGame", BORRARGAME = "borrarGame",
			ACTUALIZARGAME = "actualizarGame" , LEERGAME = "leerGame";

	public PanelControlGame() {

		setLayout(null);
		setBorder(new TitledBorder("CRUD GAME"));
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		crear = new JButton("Crear");
		crear.setActionCommand(CREARGAME);
		crear.setBounds(30, 30, 80, 30);
		add(crear);

		leer =  new JButton("Leer");
		leer.setActionCommand(LEERGAME);
		leer.setBounds(30, 70,80,30);
		add(leer);
		

		borrar = new JButton("Borrar");
		borrar.setActionCommand(BORRARGAME);
		borrar.setBounds(30, 110, 80, 30);
		add(borrar);

		actualizar = new JButton("Actualizar");
		actualizar.setActionCommand(ACTUALIZARGAME);
		actualizar.setBounds(25, 150, 90, 30);
		add(actualizar);

	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getLeer() {
		return leer;
	}

	public void setLeer(JButton leer) {
		this.leer = leer;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}


	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}

}


