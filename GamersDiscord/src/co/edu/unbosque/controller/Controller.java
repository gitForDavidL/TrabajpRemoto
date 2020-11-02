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
		} else if (command.contentEquals(view.getPanelControl().BORRAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();

			if (selec >= 0) {

				view.mostrarMensaje("Se va a eliminar el jugador seleccionado. ");

				gamer.getGamerRegistros().remove(selec);
				gamer.getBin().leerRegistros().remove(selec);

				view.mostrarMensaje("El jugador se ha eliminado correctamente");

				gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());
				cargardatos();

			} else {

				view.mostrarMensaje("No se ha seleccionado ningun jugador. ");
			}

		} else if (command.contentEquals(view.getPanelControl().ACTUALIZAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();
			if (selec >= 0) {

				String opcion = view.menu();

				switch (opcion) {
				case "1.Nombre":

					String a = view.pedirDatos("Ingrese el nuevo nombre para el jugador "
							+ gamer.getGamerRegistros().get(selec).getNombre() + ":");
					gamer.getGamerRegistros().get(selec).setNombre(a);
					gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());
					cargardatos();

					break;

				case "2.Juego":

					a = view.pedirDatos("Ingrese nuevo juego para el jugador "
							+ gamer.getGamerRegistros().get(selec).getNombre() + ":");

					gamer.getGamerRegistros().get(selec).setJuego(a);
					gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());
					cargardatos();

					break;
				case "3.Puntaje":

					Double b = view.capturarDatoNumerico(
							"Ingrese nuevo puntaje para " + gamer.getGamerRegistros().get(selec).getNombre());

					gamer.getGamerRegistros().get(selec).setPuntaje(b);
					gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());
					cargardatos();

					break;

				case "4.Todos":

					String gam = view.pedirDatos("Ingrese nombre a modificar para el jugador "
							+ gamer.getGamerRegistros().get(selec).getNombre());

					String jueg = view.pedirDatos("Ingrese juego a modificar para el jugador "
							+ gamer.getGamerRegistros().get(selec).getNombre());

					Double punt = view.capturarDatoNumerico("Ingrese juego a modificar para el jugador "
							+ gamer.getGamerRegistros().get(selec).getNombre());

					gamer.getGamerRegistros().get(selec).setNombre(gam);
					gamer.getGamerRegistros().get(selec).setJuego(jueg);
					gamer.getGamerRegistros().get(selec).setPuntaje(punt);
					gamer.getBin().EscribirRegistros(gamer.getGamerRegistros());

					cargardatos();
					break;

				case "Salir":

					view.mostrarMensaje("Hasta pronto.");

					break;

				default:
					view.mostrarMensaje("Señor usuario no ha seleccionado ningun campo a modificar.");
					break;
				}

			} else {

				view.mostrarMensaje("Selecciona un jugador para poder actualizar alguno de sus campos. ");

			}

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
