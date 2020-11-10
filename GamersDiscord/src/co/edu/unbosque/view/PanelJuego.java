package co.edu.unbosque.view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> data;

	public PanelJuego() {

		setLayout(null);
		setBorder(new TitledBorder("Datos ingresados"));

		inicializarComponentes();

	}

	private void inicializarComponentes() {

		data = new JList<>();
		data.setBounds(10, 20, 450, 170);
		add(data);

	}

	public JList<String> getData() {
		return data;
	}

	public void setData(JList<String> data) {
		this.data = data;
	}

}
