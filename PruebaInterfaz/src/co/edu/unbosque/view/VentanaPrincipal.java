package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	// private PanelInicioSesion panelInicioSesion;
	private PanelControlAdmin panelControlAdmin;

	public VentanaPrincipal() {

		setTitle("Casa de Apuestas");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void inicializarComponentes() {

		// panelInicioSesion = new PanelInicioSesion();
		// add(panelInicioSesion, BorderLayout.CENTER);

		panelControlAdmin = new PanelControlAdmin();
		add(panelControlAdmin);

	}

	/**
	 * @return the panelControlAdmin
	 */
	public PanelControlAdmin getPanelControlAdmin() {
		return panelControlAdmin;
	}

	/**
	 * @param panelControlAdmin the panelControlAdmin to set
	 */
	public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
		this.panelControlAdmin = panelControlAdmin;
	}
	
	public void mostrarMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	
	

}
