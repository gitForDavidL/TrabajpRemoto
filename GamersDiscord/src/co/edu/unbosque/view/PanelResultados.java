package co.edu.unbosque.view;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel {

	private JTextArea resultados;

	public PanelResultados() {

		setLayout(null);
		setVisible(false);
		setBorder(new TitledBorder("Registro gamer"));
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		resultados = new JTextArea();
		resultados.setBounds(10, 20, 330, 370);
		resultados.setEditable(false);
		JScrollPane sp1 = new JScrollPane(resultados);
		sp1.setBounds(10, 20, 330, 370);
		add(sp1);

	}

	public JTextArea getResultados() {
		return resultados;
	}

	public void setResultados(JTextArea resultados) {
		this.resultados = resultados;
	}

}
