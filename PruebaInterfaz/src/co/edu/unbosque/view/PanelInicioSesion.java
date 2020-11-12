package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelInicioSesion extends JPanel {

	private JLabel l1, l2;
	private JButton login, reg;

	public PanelInicioSesion() {

		setBounds(5, 5, 875, 100);
		setLayout(null);
		setVisible(true);
		setBackground(Color.WHITE);
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		l2 = new JLabel();
		devolverImagenLabel("User", "gif", 40, 40, l2);
		l2.setBounds(470, 30, 40, 40);
		add(l2);

		login = new JButton(devolverImagenButton("login", "gif", 160, 30));
		login.setBackground(Color.WHITE);
		login.setRolloverIcon(devolverImagenButton("log1", "png", 160, 30));
		login.setBounds(520, 35, 160, 30);
		login.setBorderPainted(false);
		devolverImagenButton("log", "png", 160, 30);
		add(login);

		reg = new JButton(devolverImagenButton("reg", "gif", 160, 30));
		reg.setBackground(Color.WHITE);
		reg.setBorderPainted(false);
		reg.setRolloverIcon(devolverImagenButton("reg1", "png", 160, 30));
		reg.setBounds(700, 35, 160, 30);
		add(reg);

		l1 = new JLabel();
		devolverImagenLabel("HOUSEBEAT", "png", 160, 80, l1);
		l1.setBounds(10, 15, 160, 80);
		add(l1);

	}

	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		b.setIcon(icon);
	}

	public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}
}
