package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import co.edu.unbosque.model.Gamers;
import co.edu.unbosque.model.persistence.BinariosFile;
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

		

		}else if(command.contains(view.getPanelControl().LEER)) {
			
		}

	}

	public void cargardatos() {

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (int i = 0; i < gamers.getGamerRegistros().size(); i++) {
			gamers.getGamerRegistros().get(i).setiD(i);
			model.addElement(gamers.getGamerRegistros().get(i).toString());
			
		}
		view.getPanelJugadores().getData().setModel(model);

	}

}
