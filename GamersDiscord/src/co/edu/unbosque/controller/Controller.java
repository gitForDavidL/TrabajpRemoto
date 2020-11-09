package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.persistence.GamerFile;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view;
	private Torneo gamer;


	public Controller() {

		gamer = new Torneo();
		view = new View(this);
		view.setVisible(true);
	     funcionar();

	}

	private void funcionar() {

		if (gamer.getGamerDAO().leerGamers() == true) {

			view.mostrarMensaje("Datos leidos con exito.");
			cargardatosListaGamers();
		} else {

			view.mostrarMensaje("Error de datos. ");
		}

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.contentEquals(view.getPanelControl().CREAR)) {

			String jug = view.pedirDatos("Ingrese nombre de jugador: ");
			gamer.getGamerDAO().ingresarGamer(jug);
			gamer.getGamerDAO().getBin().escribirRegistros(gamer.getGamerDAO().getGamerRegistros());
			cargardatosListaGamers();

		} else if (command.contentEquals(view.getPanelControl().BORRAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();

			if (gamer.getGamerDAO().borrarGamer(selec) == true) {

				view.mostrarMensaje("Jugador eliminado correctamente. ");
				cargardatosListaGamers();

			} else {

				view.mostrarMensaje("No se ha seleccionado ningun jugador para borrar");

			}

		} else if (command.contentEquals(view.getPanelControl().ACTUALIZAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();
			if (selec >= 0) {

				String a = view.pedirDatos("Ingrese el nuevo nombre para el jugador "
						+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre() + ":");
				gamer.getGamerDAO().actualizar(1, selec, a);
				cargardatosListaGamers();

			} else {

				view.mostrarMensaje("Selecciona un jugador para poder actualizar alguno de sus campos. ");

			}

		}

	}

	public void cargardatosListaGamers() {

		DefaultListModel<String> model = new DefaultListModel<String>();
		gamer.getGamerDAO().generarID(gamer.getGamerDAO().getGamerRegistros().size()-1);
		
		for (int i = 0; i < gamer.getGamerDAO().getGamerRegistros().size(); i++) {

			model.addElement(gamer.getGamerDAO().getGamerRegistros().get(i).toString());

		}
		view.getPanelJugadores().getData().setModel(model);

	}

}
