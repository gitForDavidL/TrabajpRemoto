package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelControl extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton crear, leer, agregar, borrar, actualizar;
	public static final String CREAR = "Crear", LEER = "leer", BORRAR = "borrar",
			ACTUALIZAR = "actualizar";

	public PanelControl() {

		setLayout(new GridLayout(1, 3, 5, 5));
		setBorder(new TitledBorder("CRUD"));
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		crear = new JButton("Crear");
		crear.setActionCommand(CREAR);
		add(crear);

		leer = new JButton("Leer");
		leer.setActionCommand(LEER);
		add(leer);


		borrar = new JButton("Borrar");
		borrar.setActionCommand(BORRAR);
		add(borrar);

		actualizar = new JButton("Actualizar");
		actualizar.setActionCommand(ACTUALIZAR);
		add(actualizar);

	}

	public JButton getCrear() {
		return crear;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}

	public JButton getLeer() {
		return leer;
	}

	public void setLeer(JButton leer) {
		this.leer = leer;
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
