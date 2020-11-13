package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelControlAdmin extends JPanel {

	private JPanel panelControl;
	private JButton[] botonesControl;
	private JLabel[] labelsControl;

	public PanelControlAdmin() {

		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		panelControl = new JPanel(); // Panel de control del admin, para moverser por las opciones :)
		panelControl.setBackground(Color.WHITE);
		panelControl.setLayout(null);
		panelControl.setBounds(5, 5, 200, 655);
		add(panelControl);

		botonesControl = new JButton[3];
		inicializarBotones("SEDES", 0, "Sedes", 70, 30, 100, 40, new Color(218, 238, 238), panelControl);
		inicializarBotones("EVENTOS", 1, "Eventos", 70, 80, 100, 40, new Color(218, 238, 238), panelControl);
		inicializarBotones("PREMIOS", 2, "Premios", 70, 130, 100, 40, new Color(218, 238, 238), panelControl);

		labelsControl = new JLabel[4];

		devolverImagenLabel("Sede", "png", 40, 40, 0, 10, 30, 40, 40 , panelControl);

	}

	public void inicializarBotones(String command, int pos, String nomBoton, int x, int y, int xB, int yB, Color color,
			JPanel jp) {
		botonesControl[pos] = new JButton(nomBoton);
		botonesControl[pos].setBackground(color);
		botonesControl[pos].setActionCommand(command);
		botonesControl[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonesControl[pos].setBounds(x, y, xB, yB);
		jp.add(botonesControl[pos]);
	}

	public void inicializarLabels(String tipoRegistro, int pos, int x, int y, int xB, int yB, JPanel jp) {
		labelsControl[pos] = new JLabel(tipoRegistro);
		labelsControl[pos].setVisible(true);
		labelsControl[pos].setBounds(x, y, xB, yB);
		jp.add(labelsControl[pos]);
	}

	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, int b, int x, int y, int xB,
			int yB, JPanel jp) {
		labelsControl[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		labelsControl[b].setIcon(icon);
		labelsControl[b].setBounds(x, y, xB, yB);
		jp.add(labelsControl[b]);
	}

}
