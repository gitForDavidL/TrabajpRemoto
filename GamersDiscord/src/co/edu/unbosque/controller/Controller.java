package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import co.edu.unbosque.model.Gamers;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view;
	private Gamers gamers;

	public Controller() {

		gamers = new Gamers();
		view = new View(this);
		view.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.contentEquals(view.getPanelControl().CREAR)) {

			String gmr = view.pedirDatos("Ingrese nombre del jugador: ", "Nombre jugador");
			String gam = view.pedirDatos("Ingrese nombre del juego : ", "Juego ");
			Double punt = view.capturarDatoNumerico("Ingrese puntaje del jugador: ");

			gamers.getBin().IngresarGamer(gmr, gam, punt);
			cargardatos();

		}else if(command.contains(view.getPanelControl().LEER)) {
			gamers.getBin().leerRegistros();
			
			cargardatos();
		}

	}

	public void cargardatos() {

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (int i = 0; i < gamers.getBin().getRegistros().size(); i++) {
			gamers.getBin().getRegistros().get(i).setiD(i);
			model.addElement(gamers.getBin().getRegistros().get(i).toString());
		}
		view.getPanelJugadores().getData().setModel(model);

	}

}
