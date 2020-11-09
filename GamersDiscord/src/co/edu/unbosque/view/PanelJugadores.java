package co.edu.unbosque.view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelJugadores extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> data;

	public PanelJugadores() {

		setLayout(null);
		setBorder(new TitledBorder("Datos ingresados"));

		inicializarComponentes();

	}

	private void inicializarComponentes() {

		data = new JList<>();
		data.setBounds(40, 20, 300, 170);
		add(data);



	}

	public JList<String> getData() {
		return data;
	}

	public void setData(JList<String> data) {
		this.data = data;
	}

}
