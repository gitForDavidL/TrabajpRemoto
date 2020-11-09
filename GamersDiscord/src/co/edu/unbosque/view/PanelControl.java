package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelControl extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton crear, agregar, borrar, actualizar;
	public static final String CREAR = "Crear", BORRAR = "borrar",
			ACTUALIZAR = "actualizar";

	public PanelControl() {

		setLayout(null);
		setBorder(new TitledBorder("CRUD GAMERS"));
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		crear = new JButton("Crear");
		crear.setActionCommand(CREAR);
		crear.setBounds(30, 30, 80, 30);
		add(crear);


		borrar = new JButton("Borrar");
		borrar.setActionCommand(BORRAR);
		borrar.setBounds(30, 70, 80, 30);
		add(borrar);

		actualizar = new JButton("Actualizar");
		actualizar.setActionCommand(ACTUALIZAR);
		actualizar.setBounds(25, 110, 90, 30);
		add(actualizar);

	}

	public JButton getCrear() {
		return crear;
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
