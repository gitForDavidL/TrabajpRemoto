package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJuegos extends JPanel {

	private JButton baloto, astro, futbol;
	private JLabel lbalo, lsupe, lfutbol;

	public PanelJuegos() {

		setBounds(5, 113, 875, 545);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(3,6, 97));
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		baloto = new JButton(devolverImagenButton("baloto", "gif", 220, 300));
		baloto.setBounds(60, 100, 220, 300);
		baloto.setBackground(new Color(3,6, 97));
		add(baloto);

		lbalo = new JLabel("Baloto");
		lbalo.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lbalo.setForeground(Color.WHITE);
		lbalo.setBounds(110, 60, 220, 40);
		add(lbalo);

		astro = new JButton(devolverImagenButton("super", "gif", 220, 300));
		astro.setBackground(new Color(3,6, 97));
		astro.setBounds(330, 100, 220, 300);
		add(astro);

		lsupe = new JLabel("Super Astro");
		lsupe.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lsupe.setForeground(Color.WHITE);
		lsupe.setBounds(360, 60, 220, 40);
		add(lsupe);

		futbol = new JButton(devolverImagenButton("futbol", "gif", 220, 300));
		futbol.setBackground(new Color(3,6, 97));
		futbol.setBounds(600, 100, 220, 300);
		add(futbol);

		lfutbol = new JLabel("Marcadores");
		lfutbol.setForeground(Color.WHITE);
		lfutbol.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lfutbol.setBounds(620, 60, 240, 40);
		add(lfutbol);

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
