package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {

	private VentanaPrincipal view;

	public Controller() {

		view = new VentanaPrincipal();
		asignarOyentes();
		
	}
	
	public void asignarOyentes() {
		view.getPanelControlAdmin().devolverBoton(0, view.getPanelControlAdmin().getBotonesControl()).addActionListener(this);
		view.getPanelControlAdmin().devolverBoton(0, view.getPanelControlAdmin().getBotonesControlSedes()).addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("SEDES")) {
		
			view.getPanelControlAdmin().getPanelContolSedes().setVisible(true);
			view.repaint();
		}else if (command.equals("CREARSEDE")) {
			
			view.getPanelControlAdmin().getPanelCrearSede().setVisible(true);
			view.repaint();
			
		
			
			
		}

	}
	
	


}
