package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelJugadores extends JPanel {

	private JList<String> data;

	public PanelJugadores() {

		setLayout(null);
		setBorder(new TitledBorder("Datos ingresados"));

		inicializarComponentes();

	}

	private void inicializarComponentes() {

		data = new JList<>();
		data.setBounds(60, 20, 400, 380);
		add(data);

	}

	public JList<String> getData() {
		return data;
	}

	public void setData(JList<String> data) {
		this.data = data;
	}

	

}
