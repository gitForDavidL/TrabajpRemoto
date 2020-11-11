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

		} else if (command.contentEquals(view.getPanelControlGame().ACTUALIZARGAME)) {

			String opcion = view.menu();
			int jugador = view.getPanelJugadores().getData().getSelectedIndex();
			int juego = view.getPanelJuego().getData().getSelectedIndex();

			switch (opcion) {

			case "1.Nickname":

				String nom = view.pedirDatos("Ingrese el nuevo nombre del juego: ");

				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setNombre(nom);

				torneo.getGamerDAO().getBin().escribirRegistros(torneo.getGamerDAO().getGamerRegistros());

				view.mostrarMensaje("El nombre del juego se ha cambiado con exito");

				cargarListaGame();

			case "2.Puntaje":

				Double punt = view.capturarDatoNumerico("Ingrese nuevo Puntaje : ");

				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setPuntaje(punt);

				torneo.getGamerDAO().getBin().escribirRegistros(torneo.getGamerDAO().getGamerRegistros());

				cargardatosListaGamers();

			case "3.Dia":

				String dia = view.pedirDatos("Ingrese el nuevo nombre del juego: ");

				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setFecha(dia);

				torneo.getGamerDAO().getBin().escribirRegistros(torneo.getGamerDAO().getGamerRegistros());

				view.mostrarMensaje("El dia del registro se ha cambiado con exito");

				cargarListaGame();

			case "4.Todos":

				nom = view.pedirDatos("Ingrese el nuevo nombre del juego: ");
				punt = view.capturarDatoNumerico("Ingrese nuevo Puntaje : ");
				dia = view.pedirDatos("Ingrese el nuevo nombre del juego: ");

				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setPuntaje(punt);
				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setFecha(dia);
				torneo.getGamerDAO().getGamerRegistros().get(jugador).getJuegos().get(juego).setNombre(nom);
				torneo.getGamerDAO().getBin().escribirRegistros(torneo.getGamerDAO().getGamerRegistros());

				view.mostrarMensaje("Se han cambiado todos los datos con exito");

				cargarListaGame();

			case "Salir":

				view.mostrarMensaje("Hasta pronto :)");

			default:

			}

		} else if (command.contentEquals(view.getPanelControl().REPORTE)) {

			int jugador = view.getPanelJugadores().getData().getSelectedIndex();

			if (jugador >= 0) {

				view.setSize(1000, 450);
				view.getPanelResultados().setVisible(true);
				view.getPanelResultados().getResultados().setEditable(true);
				view.getPanelResultados().getResultados().setText(torneo.generarReporte(jugador));
				view.getPanelResultados().getResultados().setEditable(false);

			} else {

				view.mostrarMensaje("Señor usuario seleccione un jugador para generar registro");

			}

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
