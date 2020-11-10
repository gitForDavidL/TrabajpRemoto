package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelControl panelControl;
	private PanelJugadores panelJugadores;
	private PanelControlGame panelControlGame;
	private PanelJuego panelJuego;

	public View(Controller control) {

		setSize(650, 650);
		setResizable(false); // Se puede cambiar el tamaño de la ventana?
		setTitle("Gamers de discord"); // tìtulo de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);// qué debe hacer si cierra la ventana
		setLocationRelativeTo(null);
		setLayout(null); // Se agrega al layout en la parte NORTH, el panel de entrada definido

		inicializarComponentes();

		panelControl.getCrear().addActionListener(control);
		panelControl.getBorrar().addActionListener(control);
		panelControl.getActualizar().addActionListener(control);

		panelControlGame.getCrear().addActionListener(control);
		panelControlGame.getLeer().addActionListener(control);
		panelControlGame.getBorrar().addActionListener(control);

	}

	private void inicializarComponentes() {

		panelControl = new PanelControl();
		panelControl.setBounds(0, 0, 150, 200);
		add(panelControl);

		panelJugadores = new PanelJugadores();
		panelJugadores.setBounds(160, 0, 470, 200);
		add(panelJugadores);

		panelControlGame = new PanelControlGame();
		panelControlGame.setBounds(0, 200, 150, 200);
		add(panelControlGame);

		panelJuego = new PanelJuego();
		panelJuego.setBounds(160, 200, 470, 200);
		add(panelJuego);

	}

	public PanelControl getPanelControl() {
		return panelControl;
	}

	public void setPanelControl(PanelControl panelControl) {
		this.panelControl = panelControl;
	}

	public PanelJugadores getPanelJugadores() {
		return panelJugadores;
	}

	public void setPanelJugadores(PanelJugadores panelJugadores) {
		this.panelJugadores = panelJugadores;
	}

	public PanelControlGame getPanelControlGame() {
		return panelControlGame;
	}

	public void setPanelControlGame(PanelControlGame panelControlGame) {
		this.panelControlGame = panelControlGame;
	}

	public PanelJuego getPanelJuego() {
		return panelJuego;
	}

	public void setPanelJuego(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
	}

	public String pedirDatos(String m) {

		String aux = JOptionPane.showInputDialog(m);

		while (esNumero(aux) == true || aux.isEmpty()) {

			mostrarMensaje("Señor No ingrese números en este campo :)");
			aux = JOptionPane.showInputDialog(m);

		}
		return aux;

	}

	public void mostrarMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}

	public Double capturarDatoNumerico(String m) {

		Double resultado = 0.0;
		String aux = JOptionPane.showInputDialog(m);

		while (esNumero(aux) == false) {
			mostrarMensaje("Señor usuario digite un valor valido.");
			aux = JOptionPane.showInputDialog(m);

		}

		while (Double.parseDouble(aux) < 0) {
			mostrarMensaje("Señor usuario digite número positivo");
			aux = JOptionPane.showInputDialog(m);

		}
		resultado = Double.parseDouble(aux);

		return resultado;

	}

	public String menu() {
		Object[] opciones = { "1.Nickname", "2.Puntaje", "3.Dia", "4.Todos", "Salir" };
		Object opcion = JOptionPane.showInputDialog(null, "        ..:Seleciona campo a actualizar :.. ", "Elegir",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return opcion.toString();
	}

	private boolean esNumero(String m) {
		try {
			Double.parseDouble(m);
			System.out.println("Ingreso integer");
			return true;
		} catch (NumberFormatException nfe) {
			System.out.println("Ingreso String");
			return false;

		}

	}

}
