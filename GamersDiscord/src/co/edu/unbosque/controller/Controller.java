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
	

		
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.contentEquals(view.getPanelControl().CREAR)) {

			String jug = view.pedirDatos("Ingrese nombre de jugador: ");
			String jueg = view.pedirDatos("ingrese nombre del juego:  ");
			Double punt = view.capturarDatoNumerico("Ingrese puntaje: ");
			gamer.getGamerDAO().ingresarGamer(jug, jueg, punt);
			gamer.getGamerDAO().getBin().escribirRegistros(gamer.getGamerDAO().getGamerRegistros());
			cargardatosLista();

		} else if (command.contains(view.getPanelControl().LEER)) {

			if (gamer.getGamerDAO().leerGamers() == true) {

				view.mostrarMensaje("Datos leidos con exito.");
				cargardatosLista();
			} else {

				view.mostrarMensaje("Ya se han leido todos los datos registrados.");
			}

		} else if (command.contentEquals(view.getPanelControl().BORRAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();

			if (gamer.getGamerDAO().borrarGamer(selec) == true) {

				view.mostrarMensaje("Jugador eliminado correctamente. ");
				cargardatosLista();

			} else {

				view.mostrarMensaje("No se ha seleccionado ningun jugador para borrar");

			}

		} else if (command.contentEquals(view.getPanelControl().ACTUALIZAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();
			if (selec >= 0) {

				String opcion = view.menu();

				switch (opcion) {
				case "1.Nombre":

					String a = view.pedirDatos("Ingrese el nuevo nombre para el jugador "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre() + ":");
					gamer.getGamerDAO().actualizar(1, selec, a);
					cargardatosLista();

					break;

				case "2.Juego":

					a = view.pedirDatos("Ingrese nuevo juego para el jugador "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre() + ":");

					gamer.getGamerDAO().actualizar(2, selec, a);
					cargardatosLista();

					break;
				case "3.Puntaje":

					Double b = view.capturarDatoNumerico("Ingrese nuevo puntaje para "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre());

					gamer.getGamerDAO().actualizar(selec, b);
					cargardatosLista();

					break;

				case "4.Todos":

					String gam = view.pedirDatos("Ingrese nombre a modificar para el jugador "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre());

					String jueg = view.pedirDatos("Ingrese juego a modificar para el jugador "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre());

					Double punt = view.capturarDatoNumerico("Ingrese juego a modificar para el jugador "
							+ gamer.getGamerDAO().getGamerRegistros().get(selec).getNombre());

					gamer.getGamerDAO().actualizarAll(selec, gam, jueg, punt);
					cargardatosLista();
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

	public void cargardatosLista() {

		DefaultListModel<String> model = new DefaultListModel<String>();
		gamer.getGamerDAO().modificarID();
		for (int i = 0; i < gamer.getGamerDAO().getGamerRegistros().size(); i++) {

			model.addElement(gamer.getGamerDAO().getGamerRegistros().get(i).toString());

		}
		view.getPanelJugadores().getData().setModel(model);

	}

}
