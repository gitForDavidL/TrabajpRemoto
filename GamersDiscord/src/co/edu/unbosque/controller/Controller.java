package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import co.edu.unbosque.model.Gamer;
import co.edu.unbosque.model.persistence.BinariosFile;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view;
	private Gamer gamer;

	public Controller() {

		gamer = new Gamer();
		view = new View(this);
		view.setVisible(true);
		
		if (gamer.getBin().leerRegistros().size() != gamer.getGamerRegistros().size()) {

			for (int i = 0; i < gamer.getBin().leerRegistros().size(); i++) {
				gamer.getGamerRegistros().add(gamer.getBin().leerRegistros().get(i));

			}

			view.mostrarMensaje("Datos leidos correctamente :).");
			cargardatos();

		} else {

			view.mostrarMensaje("Señor usuario todos lo datos han sido leidos");
		}
	}

	

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.contentEquals(view.getPanelControl().CREAR)) {

			String jug = view.pedirDatos("Ingrese nombre de jugador: ");
			String jueg = view.pedirDatos("ingrese nombre del juego:  ");
			Double punt = view.capturarDatoNumerico("Ingrese puntaje: ");
			gamer.ingresarDatos(jug, jueg, punt);
			gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());
			cargardatos();

		} else if (command.contains(view.getPanelControl().LEER)) {

			if (gamer.getBin().leerRegistros().size() != gamer.getGamerRegistros().size()) {

				for (int i = 0; i < gamer.getBin().leerRegistros().size(); i++) {
					gamer.getGamerRegistros().add(gamer.getBin().leerRegistros().get(i));

				}

				view.mostrarMensaje("Datos leidos correctamente :).");
				cargardatos();

			} else {

				view.mostrarMensaje("Señor usuario todos lo datos han sido leidos");
			}
		}else if(command.contentEquals(view.getPanelControl().BORRAR)) {
			
		}

	}

	public void cargardatos() {

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (int i = 0; i < gamer.getGamerRegistros().size(); i++) {
			gamer.getGamerRegistros().get(i).setiD(i);
			model.addElement(gamer.getGamerRegistros().get(i).toString());

		}
		view.getPanelJugadores().getData().setModel(model);

	}

}
