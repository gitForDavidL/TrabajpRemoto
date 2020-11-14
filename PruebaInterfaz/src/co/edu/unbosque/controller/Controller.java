package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.View;

import com.sun.jdi.Value;

import co.edu.unbosque.model.CasaApuesta;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {

	private VentanaPrincipal vista;
	private CasaApuesta casaApuesta;

	public Controller() {

		vista = new VentanaPrincipal();
		casaApuesta = new CasaApuesta();
		asignarOyentes();

	}

	public void asignarOyentes() {
		vista.getPanelControlAdmin().devolverBoton(0, vista.getPanelControlAdmin().getBotonesControl())
				.addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(0, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(1, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(2, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede().getGuardarCrear().addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede().getGuardarSedeModificar().addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede().getBorrarSede().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("SEDES")) {
			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(0).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			cargarSedesTabla();
			vista.repaint();

		} else if (command.equals("CREARSEDE")) {

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("SAVESEDE")) {

			if (vista.getPanelControlAdmin().getPanelSede()
					.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
					.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
							.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
							.isEmpty()) {

				vista.mostrarMensaje("Seño usuario hay campos vacios.");

			} else {

				if (vista.getPanelControlAdmin().getPanelSede()
						.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
						.isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
								.getText().isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
								.getText().isBlank()) {

					vista.mostrarMensaje("Señor usuario hay campos vacios");

				} else {

					if (esNumero(vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
							.getText()) == true
							|| esNumero(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText()) == false
							|| esNumero(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText()) == false) {
						vista.mostrarMensaje("Señor usuario verifique los datos ingresados");
					} else {

						if (vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear().getSelectedIndex() > 0) {

							casaApuesta.getSedesDAO().leerSedes();
							String nom = vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText();

							Double presu = Double.parseDouble(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText());

							String localidad = (String) vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear()
									.getSelectedItem();

							int empleados = Integer.parseInt(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText());

							casaApuesta.getSedesDAO().crearSede(nom, presu, localidad, empleados);

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear().setSelectedIndex(0);

							vista.mostrarMensaje("Sede creada con exito. ");

						} else {

							vista.mostrarMensaje("Señor usuario no ha escogido ninguna localidad para la nueva sede. ");

						}

					}

				}

			}

		} else if (command.equals("MODIFICARSEDE")) {

			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().getSedesModificar().removeAllItems();
			vista.getPanelControlAdmin().getPanelSede().getSedesModificar().addItem("");

			for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

				vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
						.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

			}

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("SAVEMODIFI")) {

			if (vista.getPanelControlAdmin().getPanelSede()
					.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText()
					.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
							.getText().isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
							.getText().isEmpty()) {

				vista.mostrarMensaje("Señor usuario hay campos vacios.");

			} else {

				if (vista.getPanelControlAdmin().getPanelSede()
						.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText()
						.isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText().isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText().isBlank()) {

					vista.mostrarMensaje("Señor usuario hay campos vacios.");

				} else {

					if (vista.getPanelControlAdmin().getPanelSede().getLocalidadesModificar().getSelectedIndex() > 0
							|| vista.getPanelControlAdmin().getPanelSede().getSedesModificar().getSelectedIndex() > 0) {

						if (esNumero(vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText()) == true
								|| esNumero(vista.getPanelControlAdmin().getPanelSede()
										.devolverTextField(1,
												vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
										.getText()) == false
								|| esNumero(vista.getPanelControlAdmin().getPanelSede()
										.devolverTextField(2,
												vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
										.getText()) == false) {

							vista.mostrarMensaje("Valide datos de ingreso. ");
						} else {

							int pos = vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
									.getSelectedIndex();

							String nom = vista.getPanelControlAdmin().getPanelSede().devolverTextField(0,
									vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText();
							Double presu = Double
									.parseDouble(vista.getPanelControlAdmin().getPanelSede()
											.devolverTextField(1,
													vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
											.getText());

							String localidad = (String) vista.getPanelControlAdmin().getPanelSede()
									.getLocalidadesModificar().getSelectedItem();

							int empleados = Integer
									.parseInt(vista.getPanelControlAdmin().getPanelSede()
											.devolverTextField(2,
													vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
											.getText());

							casaApuesta.getSedesDAO().modificarSede(pos - 1, nom, presu, localidad, empleados);

							vista.mostrarMensaje("Sede editada con exito. ");

							casaApuesta.getSedesDAO().leerSedes();
							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().removeAllItems();
							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().addItem("");

							for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

								vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
										.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

							}

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede().getLocalidadesModificar().setSelectedIndex(0);

							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().setSelectedIndex(0);

						}

					} else {

						vista.mostrarMensaje(
								"Valide sede a modificar o localidad de la sede (no pueden estar en blanco). ");

					}

				}
			}

		} else if (command.equals("ELIMINARSEDE")) {

			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().removeAllItems();
			vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().addItem("");

			for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar()
						.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

			}

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("BORRARSEDE")) {

			int selec = vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().getSelectedIndex();

			if (!vista.getPanelControlAdmin().getPanelSede().getBorrar().isSelected()
					|| vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().getSelectedIndex() == 0) {

				vista.mostrarMensaje("Señor usuario no confirmo eliminar la sede o no selecciono sede para eliminar. ");

				

			} else {
				casaApuesta.getSedesDAO().eliminarSede(selec - 1);

				vista.mostrarMensaje("Sede eliminada con exito.");

				casaApuesta.getSedesDAO().leerSedes();
				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().removeAllItems();
				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().addItem("");
				for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

					vista.getPanelControlAdmin().getPanelSede().getSedesBorrar()
							.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

				}

			}

		}
	}

	private boolean esNumero(String m) {
		try {
			Double.parseDouble(m);
			return true;
		} catch (NumberFormatException nfe) {
			return false;

		}

	}

	public void cargarSedesTabla() {

		String headTable[];

		headTable = new String[4];
		headTable[0] = "Nombre";
		headTable[1] = "Presupuesto";
		headTable[2] = "Localidad";
		headTable[3] = "Empleados";

		

		String datos[][];

		casaApuesta.getSedesDAO().getFileSede().leerRegistros();
		datos = new String[casaApuesta.getSedesDAO().getSedes().size()][4];

		for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

			datos[i][0] = casaApuesta.getSedesDAO().getSedes().get(i).getNombre();
			datos[i][1] = casaApuesta.getSedesDAO().getSedes().get(i).getPresupuesto().toString();
			datos[i][2] = casaApuesta.getSedesDAO().getSedes().get(i).getLocalidad();
			datos[i][3] = Integer.toString(casaApuesta.getSedesDAO().getSedes().get(i).getEmpleados());

		}

		DefaultTableModel modelo = new DefaultTableModel(datos, headTable);
		vista.getPanelControlAdmin().getPanelSede().getTablaSede().setModel(modelo);
		
		for (int i = 0; i < 4; i++) {

			vista.getPanelControlAdmin().getPanelSede().getTablaSede().getColumn(headTable[i]).setHeaderValue(headTable[i]);
		}

	}

}
