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
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PanelEventos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel[] panelesEventos;
	private JButton[] botonesControlEventos;
	private JLabel[] labeslControlEventos, labelsCrear;
	private JTextField[] txtEventos;
	private JComboBox<String>[] sedes;
	private JDateChooser[] calendar;
	private JButton guardarEvento;

	public PanelEventos() {

		setLayout(null);
		setVisible(true);
		setBounds(180, 5, 700, 655);
		inicializaComponentes();

	}

	@SuppressWarnings("unchecked")
	private void inicializaComponentes() {

		panelesEventos = new JPanel[5];
		inicializarPaneles(0, new Color(3, 6, 97), 0, 0, 700, 150);

		botonesControlEventos = new JButton[3];
		inicializarBotones(botonesControlEventos, "CREAR_EVENTO", 0, "Crear Evento", 80, 80, 120, 30,
				new Color(218, 238, 238), devolverPaneles(0));
		inicializarBotones(botonesControlEventos, "MODIFICAR_EVENTO", 1, "Modificar Evento", 300, 80, 140, 30,
				new Color(218, 238, 238), devolverPaneles(0));
		inicializarBotones(botonesControlEventos, "ELIMINAR_EVENTO", 2, "Eliminar Evento", 520, 80, 140, 30,
				new Color(218, 238, 238), devolverPaneles(0));

		labeslControlEventos = new JLabel[4];
		inicializarLabels(labeslControlEventos, "Gestión de Eventos: ", 0, 30, 25, 300, 30, devolverPaneles(0),
				new Color(218, 238, 238), 20);
		devolverImagenLabel(labeslControlEventos, "agregar", "png", 30, 30, 1, 35, 80, 30, 30, devolverPaneles(0));
		devolverImagenLabel(labeslControlEventos, "editar", "png", 30, 30, 2, 260, 80, 30, 30, devolverPaneles(0));
		devolverImagenLabel(labeslControlEventos, "borrar", "png", 30, 30, 3, 480, 80, 30, 30, devolverPaneles(0));

		inicializarPaneles(1, Color.WHITE, 0, 155, 700, 500); // pane crear evento

		labelsCrear = new JLabel[9];
		inicializarLabels(labelsCrear, "Crear nuevo evento: ", 0, 30, 50, 210, 20, devolverPaneles(1),
				new Color(3, 6, 97), 20);
		inicializarLabels(labelsCrear, "Nombre del evento : ", 1, 50, 110, 210, 15, devolverPaneles(1), Color.BLACK,
				15);
		inicializarLabels(labelsCrear, "Sede del evento :  ", 2, 50, 170, 210, 15, devolverPaneles(1), Color.BLACK, 15);

		inicializarLabels(labelsCrear, "Presupuesto del evento  :", 3, 50, 230, 200, 15, devolverPaneles(1),
				Color.BLACK, 15);

		inicializarLabels(labelsCrear, "Dia del evento : ", 4, 50, 290, 210, 15, devolverPaneles(1), Color.BLACK, 15);

		devolverImagenLabel(labelsCrear, "evento", "png", 20, 20, 4, 15, 105, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "casa", "png", 20, 20, 5, 15, 165, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "presupuesto", "png", 20, 20, 6, 15, 225, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "dia", "jpg", 20, 20, 7, 15, 290, 20, 20, devolverPaneles(1));

		inicializarLabels(labelsCrear, "Guardar Evento", 8, 296, 445, 100, 10, devolverPaneles(1), new Color(3, 6, 97),
				10);

		txtEventos = new JTextField[4];
		inicializarCampos( 0, 290, 110, 380, 20, devolverPaneles(1));
		inicializarCampos( 1, 290, 230, 380, 20, devolverPaneles(1));

		sedes = new JComboBox[2];
		inicializarComboBox(0, 290, 170, 380, 20, devolverPaneles(1));

		calendar = new JDateChooser[2];
		inicialiarDateChosser(0, 290, 290, 380, 20, devolverPaneles(1));

	
		guardarEvento = new JButton(devolverImagen("guardar", "png", 60, 60));
		guardarEvento.setBorder(null);
		guardarEvento.setBackground(Color.WHITE);
		guardarEvento.setActionCommand("SAVE_EVENTO");
		guardarEvento.setToolTipText("Guardar Evento");
		guardarEvento.setRolloverIcon(devolverImagen("guardar", "png", 70, 70));
		guardarEvento.setBounds(300, 380, 60, 60);
		devolverPaneles(1).add(guardarEvento);
		
		
		
		

	}
	
	
	public JDateChooser devolverCalendario(int pos) {
		return calendar[pos];
	}

	public void inicialiarDateChosser(int pos, int x, int y, int ancho, int largo, JPanel jp) {

		calendar[pos] = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		calendar[pos].setBounds(x, y, ancho, largo);
		calendar[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
		calendar[pos].setBorder(new LineBorder(Color.black));
		jp.add(calendar[pos]);
	}

	public void inicializarComboBox(int pos, int x, int y, int ancho, int alto, JPanel jp) {

		sedes[pos] = new JComboBox<String>();
		sedes[pos].setBounds(x, y, ancho, alto);
		sedes[pos].addItem("");
		jp.add(sedes[pos]);

	}

	public void inicializarPaneles(int pos, Color color, int x, int y, int ancho, int largo) {
		panelesEventos[pos] = new JPanel();
		panelesEventos[pos].setBackground(color);
		panelesEventos[pos].setLayout(null);
		panelesEventos[pos].setVisible(false);
		panelesEventos[pos].setBounds(x, y, ancho, largo);
		add(panelesEventos[pos]);
	}

	public JPanel devolverPaneles(int pos) {
		return panelesEventos[pos];
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

	public JLabel devolverLabels(int pos, JLabel[] jb) {

		return jb[pos];
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

	public JButton devolverBoton(int pos, JButton[] botones) {
		return botones[pos];
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

	public void inicializarCampos( int pos, int x, int y, int xB, int yB, JPanel jp) {
		txtEventos[pos] = new JTextField();
		txtEventos[pos].setBounds(x, y, xB, yB);
		txtEventos[pos].setBorder(new LineBorder(Color.black));
		jp.add(txtEventos[pos]);

	}

	public ImageIcon devolverImagen(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}

	public JTextField devolverTextField(int pos) {
		return txtEventos[pos];

	}

	public JComboBox<String> devolverBox(int pos) {
		return sedes[pos];
	}

	/**
	 * @return the panelesEventos
	 */
	public JPanel[] getPanelesEventos() {
		return panelesEventos;
	}

	/**
	 * @param panelesEventos the panelesEventos to set
	 */
	public void setPanelesEventos(JPanel[] panelesEventos) {
		this.panelesEventos = panelesEventos;
	}

	/**
	 * @return the botonesControlEventos
	 */
	public JButton[] getBotonesControlEventos() {
		return botonesControlEventos;
	}

	/**
	 * @param botonesControlEventos the botonesControlEventos to set
	 */
	public void setBotonesControlEventos(JButton[] botonesControlEventos) {
		this.botonesControlEventos = botonesControlEventos;
	}

	/**
	 * @return the labeslControlEventos
	 */
	public JLabel[] getLabeslControlEventos() {
		return labeslControlEventos;
	}

	/**
	 * @param labeslControlEventos the labeslControlEventos to set
	 */
	public void setLabeslControlEventos(JLabel[] labeslControlEventos) {
		this.labeslControlEventos = labeslControlEventos;
	}

	/**
	 * @return the labelsCrear
	 */
	public JLabel[] getLabelsCrear() {
		return labelsCrear;
	}

	/**
	 * @param labelsCrear the labelsCrear to set
	 */
	public void setLabelsCrear(JLabel[] labelsCrear) {
		this.labelsCrear = labelsCrear;
	}

	/**
	 * @return the txtEventos
	 */
	public JTextField[] getTxtEventos() {
		return txtEventos;
	}

	/**
	 * @param txtEventos the txtEventos to set
	 */
	public void setTxtEventos(JTextField[] txtEventos) {
		this.txtEventos = txtEventos;
	}

	/**
	 * @return the sedes
	 */
	public JComboBox<String>[] getSedes() {
		return sedes;
	}

	/**
	 * @param sedes the sedes to set
	 */
	public void setSedes(JComboBox<String>[] sedes) {
		this.sedes = sedes;
	}

	/**
	 * @return the calendar
	 */
	public JDateChooser[] getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(JDateChooser[] calendar) {
		this.calendar = calendar;
	}

	/**
	 * @return the guardarEvento
	 */
	public JButton getGuardarEvento() {
		return guardarEvento;
	}

	/**
	 * @param guardarEvento the guardarEvento to set
	 */
	public void setGuardarEvento(JButton guardarEvento) {
		this.guardarEvento = guardarEvento;
	}

}
