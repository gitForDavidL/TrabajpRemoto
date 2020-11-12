package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelInicioSesion panelInicioSesion;
	private PanelJuegos panelJuegos;

	public VentanaPrincipal() {

		setTitle("Casa de Apuestas");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void inicializarComponentes() {

		panelInicioSesion = new PanelInicioSesion();
		panelInicioSesion.setBounds(5, 5, 875, 100);
		add(panelInicioSesion);
		
		panelJuegos = new PanelJuegos();
		panelJuegos.setBounds(5,113, 875, 545);
		add(panelJuegos);
		
		

	}
	
	

}
