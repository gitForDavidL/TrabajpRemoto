package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PanelControlAdmin extends JPanel {

	private JPanel panelControl, panelContolSedes, panelCrearSede;
	private JButton[] botonesControl, botonesControlSedes, botonesCerarSede;
	private JLabel[] labelsControl, labelsSedes, labelsCrear;
	private JTextField[] campoCrear;
	private JButton GuardarCrearSede;
	private JComboBox<String> localidades;

	public PanelControlAdmin() {

		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		panelControl = new JPanel(); // Panel de control del admin, para moverser por las opciones :)
		panelControl.setBackground(Color.WHITE);
		panelControl.setLayout(null);
		panelControl.setBounds(5, 5, 170, 655);
		add(panelControl);

		botonesControl = new JButton[3];
		inicializarBotones(botonesControl, "SEDES", 0, "Sedes", 60, 30, 100, 30, new Color(218, 238, 238),
				panelControl);
		inicializarBotones(botonesControl, "EVENTOS", 1, "Eventos", 60, 80, 100, 30, new Color(218, 238, 238),
				panelControl);
		inicializarBotones(botonesControl, "PREMIOS", 2, "Premios", 60, 130, 100, 30, new Color(218, 238, 238),
				panelControl);

		labelsControl = new JLabel[4];
		devolverImagenLabel(labelsControl, "Sede", "png", 30, 30, 0, 10, 30, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "evento", "png", 30, 30, 1, 10, 80, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "premios", "png", 30, 30, 2, 10, 130, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "HOUSEBEAT_LOGIN", "png", 120, 60, 3, 20, 550, 120, 60, panelControl); // Hasta
																													// aca
																													// llegan
		panelContolSedes = new JPanel();
		panelContolSedes.setBackground(new Color(3, 6, 97));
		panelContolSedes.setLayout(null);
		panelContolSedes.setVisible(false);
		panelContolSedes.setBounds(180, 5, 700, 150);
		add(panelContolSedes);

		botonesControlSedes = new JButton[3];
		inicializarBotones(botonesControlSedes, "CREARSEDE", 0, "Crear Sede", 80, 80, 120, 30, new Color(218, 238, 238),
				panelContolSedes);
		inicializarBotones(botonesControlSedes, "MODIFICARSEDE", 1, "Modificar Sede", 300, 80, 120, 30,
				new Color(218, 238, 238), panelContolSedes);
		inicializarBotones(botonesControlSedes, "ELIMINARSEDE", 2, "Eliminar Sede", 520, 80, 120, 30,
				new Color(218, 238, 238), panelContolSedes);

		labelsSedes = new JLabel[4];
		inicializarLabels(labelsSedes, "Gestión de sedes: ", 0, 30, 25, 200, 30, panelContolSedes,
				new Color(218, 238, 238), 20);
		devolverImagenLabel(labelsSedes, "agregar", "png", 30, 30, 1, 35, 80, 30, 30, panelContolSedes);
		devolverImagenLabel(labelsSedes, "editar", "png", 30, 30, 2, 260, 80, 30, 30, panelContolSedes);
		devolverImagenLabel(labelsSedes, "borrar", "png", 30, 30, 3, 480, 80, 30, 30, panelContolSedes);

		panelCrearSede = new JPanel();
		panelCrearSede.setBackground(Color.WHITE);
		panelCrearSede.setLayout(null);
		panelCrearSede.setVisible(false);
		panelCrearSede.setBounds(180, 160, 700, 500);
		add(panelCrearSede);

		labelsCrear = new JLabel[8];
		inicializarLabels(labelsCrear, "Crear nueva sede", 0, 30, 50, 210, 20, panelCrearSede, new Color(3, 6, 97), 20);
		inicializarLabels(labelsCrear, "Nombre de la sede : ", 1, 50, 110, 210, 15, panelCrearSede, Color.BLACK, 15);
		inicializarLabels(labelsCrear, "Presupuesto para la sede : ", 2, 50, 170, 210, 15, panelCrearSede, Color.BLACK,
				15);
		inicializarLabels(labelsCrear, "localidad :", 3, 50, 230, 140, 15, panelCrearSede, Color.BLACK, 15);
		inicializarLabels(labelsCrear, "Cantindad de empleados : ", 4, 50, 290, 210, 15, panelCrearSede, Color.BLACK,
				15);
		devolverImagenLabel(labelsCrear, "casa", "png", 20, 20, 4, 15, 105, 20, 20, panelCrearSede);
		devolverImagenLabel(labelsCrear, "presupuesto", "png", 20, 20, 5, 15, 165, 20, 20, panelCrearSede);
		devolverImagenLabel(labelsCrear, "localidad", "png", 20, 20, 6, 15, 225, 20, 20, panelCrearSede);
		devolverImagenLabel(labelsCrear, "usuarios", "png", 20, 20, 7, 15, 285, 20, 20, panelCrearSede);

		campoCrear = new JTextField[3];
		inicializarCampos(campoCrear, 0, 250, 105, 430, 20, panelCrearSede);
		inicializarCampos(campoCrear, 1, 250, 165, 430, 20, panelCrearSede);
		inicializarCampos(campoCrear, 2, 250, 285, 430, 20, panelCrearSede);

		localidades = new JComboBox<String>();
		localidades.setVisible(true);
		localidades.addItem("1.Usaquén.");
		localidades.addItem("2.Chapinero.");
		localidades.addItem("3.San Cristobal");
		localidades.addItem("4.Santa Fe.");
		localidades.addItem("5.San Cristóbal.");
		localidades.addItem("6.	Usme.");
		localidades.addItem("7.Tunjuelito.");
		localidades.addItem("8.Bosa.");
		localidades.addItem("9.	Kennedy.");
		localidades.addItem("10.Fontibon");
		localidades.addItem("10.Engativá");
		localidades.addItem("11.suba");

		localidades.setBounds(250, 225, 430, 20);
		panelCrearSede.add(localidades);

	}

	public void inicializarBotones(JButton[] bot, String command, int pos, String nomBoton, int x, int y, int xB,
			int yB, Color color, JPanel jp) {
		bot[pos] = new JButton(nomBoton);
		bot[pos].setBackground(color);
		bot[pos].setActionCommand(command);
		bot[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
		bot[pos].setBounds(x, y, xB, yB);
		jp.add(bot[pos]);
	}

	public void inicializarLabels(JLabel[] lab, String tipoRegistro, int pos, int x, int y, int xB, int yB, JPanel jp,
			Color color, int tamaño) {
		lab[pos] = new JLabel(tipoRegistro);
		lab[pos].setVisible(true);
		lab[pos].setForeground(color);
		lab[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamaño));
		lab[pos].setBounds(x, y, xB, yB);
		jp.add(lab[pos]);
	}

	public void devolverImagenLabel(JLabel[] lab, String src, String tipo, int escalax, int escalay, int b, int x,
			int y, int xB, int yB, JPanel jp) {
		lab[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		lab[b].setIcon(icon);
		lab[b].setBounds(x, y, xB, yB);
		jp.add(lab[b]);
	}

	public void inicializarCampos(JTextField[] campos, int pos, int x, int y, int xB, int yB, JPanel jp) {
		campos[pos] = new JTextField();
		campos[pos].setBounds(x, y, xB, yB);
		campos[pos].setBorder(new LineBorder(Color.black));
		jp.add(campos[pos]);

	}

	public JButton devolverBoton(int pos, JButton[] botones) {
		return botones[pos];
	}

	/**
	 * @return the panelControl
	 */
	public JPanel getPanelControl() {
		return panelControl;
	}

	/**
	 * @param panelControl the panelControl to set
	 */
	public void setPanelControl(JPanel panelControl) {
		this.panelControl = panelControl;
	}

	/**
	 * @return the panelContolSedes
	 */
	public JPanel getPanelContolSedes() {
		return panelContolSedes;
	}

	/**
	 * @param panelContolSedes the panelContolSedes to set
	 */
	public void setPanelContolSedes(JPanel panelContolSedes) {
		this.panelContolSedes = panelContolSedes;
	}

	/**
	 * @return the botonesControl
	 */
	public JButton[] getBotonesControl() {
		return botonesControl;
	}

	/**
	 * @param botonesControl the botonesControl to set
	 */
	public void setBotonesControl(JButton[] botonesControl) {
		this.botonesControl = botonesControl;
	}

	/**
	 * @return the botonesControlSedes
	 */
	public JButton[] getBotonesControlSedes() {
		return botonesControlSedes;
	}

	/**
	 * @param botonesControlSedes the botonesControlSedes to set
	 */
	public void setBotonesControlSedes(JButton[] botonesControlSedes) {
		this.botonesControlSedes = botonesControlSedes;
	}

	/**
	 * @return the labelsControl
	 */
	public JLabel[] getLabelsControl() {
		return labelsControl;
	}

	/**
	 * @param labelsControl the labelsControl to set
	 */
	public void setLabelsControl(JLabel[] labelsControl) {
		this.labelsControl = labelsControl;
	}

	/**
	 * @return the panelCrearSede
	 */
	public JPanel getPanelCrearSede() {
		return panelCrearSede;
	}

	/**
	 * @param panelCrearSede the panelCrearSede to set
	 */
	public void setPanelCrearSede(JPanel panelCrearSede) {
		this.panelCrearSede = panelCrearSede;
	}

	/**
	 * @return the labelsSedes
	 */
	public JLabel[] getLabelsSedes() {
		return labelsSedes;
	}

	/**
	 * @param labelsSedes the labelsSedes to set
	 */
	public void setLabelsSedes(JLabel[] labelsSedes) {
		this.labelsSedes = labelsSedes;
	}

}
