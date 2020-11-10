package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.persistence.GamerFile;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view;
	private Torneo torneo;

	public Controller() {

		torneo = new Torneo();
		view = new View(this);
		view.setVisible(true);
		funcionar();

	}

	private void funcionar() {

		if (torneo.getGamerDAO().leerGamers() == true) {

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
			torneo.getGamerDAO().ingresarGamer(jug);
			cargardatosListaGamers();

		} else if (command.contentEquals(view.getPanelControl().BORRAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();

			if (torneo.getGamerDAO().borrarGamer(selec) == true) {

				view.mostrarMensaje("Jugador eliminado correctamente. ");
				cargardatosListaGamers();

			} else {

				view.mostrarMensaje("No se ha seleccionado ningun jugador para borrar");

			}

		} else if (command.contentEquals(view.getPanelControl().ACTUALIZAR)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();
			if (selec >= 0) {

				String a = view.pedirDatos("Ingrese el nuevo nombre para el jugador "
						+ torneo.getGamerDAO().getGamerRegistros().get(selec).getNombre() + ":");
				torneo.getGamerDAO().actualizar(1, selec, a);
				cargardatosListaGamers();

			} else {

				view.mostrarMensaje("Selecciona un jugador para poder actualizar alguno de sus campos. ");

			}

		} else if (command.contentEquals(view.getPanelControlGame().CREARGAME)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();
			
			if (selec >= 0) {

				String nom = view.pedirDatos("Digite nombre del juego: ");
				Double punt = view.capturarDatoNumerico("Digite el puntaje del jugador: ");
				String fech = view.pedirDatos("Digite día de ingreso del juego para el gamer "
						+ torneo.getGamerDAO().getGamerRegistros().get(selec).getNombre() + ": ");

				torneo.asignarJuegosJugador(selec, nom, punt, fech);
				torneo.IDJuego(selec);
				cargarListaGame();

			} else {

				view.mostrarMensaje("Seleccione un jugador para cargar sus datos.");
			}

		} else if (command.contentEquals(view.getPanelControlGame().LEERGAME)) {

			int selec = view.getPanelJugadores().getData().getSelectedIndex();

			if (selec >= 0) {
				if (torneo.getGameDAO().leerjuegos(selec, torneo.getGamerDAO().getGamerRegistros()) == false) {

					view.mostrarMensaje("Datos leidos con exito ");
					cargarListaGame();

				} else {

					view.mostrarMensaje("Error leyendo datos :C");

				}
			} else {

				view.mostrarMensaje("No se ha seleccionado ningún jugador.");

			}

		} else if (command.contentEquals(view.getPanelControlGame().BORRARGAME)) {

			int jugador = view.getPanelJugadores().getData().getSelectedIndex();
			int juego = view.getPanelJuego().getData().getSelectedIndex();

			torneo.getGameDAO().borrarjuego(jugador, juego, torneo.getGamerDAO().getGamerRegistros());

			view.mostrarMensaje("Se ha borrado el juego correctamente :)");

			cargarListaGame();

		}

	}

	public void cargardatosListaGamers() {

		DefaultListModel<String> model = new DefaultListModel<String>();
		torneo.getGamerDAO().generarID(torneo.getGamerDAO().getGamerRegistros().size() - 1);

		for (int i = 0; i < torneo.getGamerDAO().getGamerRegistros().size(); i++) {

			model.addElement(torneo.getGamerDAO().getGamerRegistros().get(i).toString());

		}
		view.getPanelJugadores().getData().setModel(model);

	}

	public void cargarListaGame() {

		int selec = view.getPanelJugadores().getData().getSelectedIndex();
		System.out.println(selec);

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (int i = 0; i < torneo.getGamerDAO().getGamerRegistros().get(selec).getJuegos().size(); i++) {

			model.addElement(torneo.getGamerDAO().getGamerRegistros().get(selec).getJuegos().get(i).toString());
		}
		view.getPanelJuego().getData().setModel(model);
	}

}
