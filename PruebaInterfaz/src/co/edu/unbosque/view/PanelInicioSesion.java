package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author David López, Sergio Peña, Briannys Monserrrate y Diana Rios.
 *
 */

public class PanelInicioSesion extends JPanel {

	private JLabel l1, l2, lbalo, lsupe, lfutbol;
	private JButton login, reg, baloto, astro, futbol;
	private JPanel inicio, juegos;

	/**
	 * Método Constructor PanelInicioSesion
	 */

	public PanelInicioSesion() {

		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();

	}

	/**
	 * Método encargado de inicializar todos los compontenes de PanelInicioSesión
	 * 
	 */

	private void inicializarComponentes() {

		inicio = new JPanel();
		inicio.setBounds(5, 5, 875, 100);
		inicio.setLayout(null);
		inicio.setBackground(Color.WHITE);
		inicio.setVisible(true);
		add(inicio);

		l2 = new JLabel();
		devolverImagenLabel("User", "gif", 40, 40, l2);
		l2.setBounds(460, 30, 40, 40);
		inicio.add(l2);

		login = new JButton(devolverImagen("login", "gif", 160, 30));
		login.setBackground(Color.WHITE);
		login.setRolloverIcon(devolverImagen("log1", "png", 160, 30));
		login.setBorder(null);
		login.setActionCommand("INICIARSESION");
		login.setBounds(520, 35, 160, 30);
		inicio.add(login);

		reg = new JButton(devolverImagen("reg", "gif", 160, 30));
		reg.setBackground(Color.WHITE);
		reg.setBorderPainted(false);
		reg.setRolloverIcon(devolverImagen("registro", "png", 160, 30));
		reg.setActionCommand("REGISTRARSE");
		reg.setBounds(700, 35, 160, 30);
		inicio.add(reg);

		l1 = new JLabel();
		devolverImagenLabel("HOUSEBEAT_LOGIN", "png", 150, 70, l1);
		l1.setBounds(10, 15, 150, 80);
		inicio.add(l1);

		juegos = new JPanel();
		juegos.setBounds(5, 113, 875, 545);
		juegos.setLayout(null);
		juegos.setVisible(true);
		juegos.setBackground(new Color(3, 6, 97));
		add(juegos);

		baloto = new JButton(devolverImagen("Baloto", "gif", 220, 300));
		baloto.setBounds(60, 100, 220, 300);
		baloto.setActionCommand("BALOTO");
		baloto.setBackground(Color.WHITE);
		juegos.add(baloto);

		lbalo = new JLabel("Baloto");
		lbalo.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lbalo.setForeground(Color.WHITE);
		lbalo.setBounds(110, 60, 220, 40);
		juegos.add(lbalo);

		astro = new JButton(devolverImagen("super", "gif", 220, 300));
		astro.setBackground(Color.WHITE);
		astro.setActionCommand("SUPERASTRO");
		astro.setBounds(330, 100, 220, 300);
		juegos.add(astro);

		lsupe = new JLabel("Super Astro");
		lsupe.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lsupe.setForeground(Color.WHITE);
		lsupe.setBounds(360, 60, 220, 40);
		juegos.add(lsupe);

		futbol = new JButton(devolverImagen("futbol", "gif", 220, 300));
		futbol.setBackground(Color.WHITE);
		futbol.setActionCommand("FUTBOL");
		futbol.setBounds(600, 100, 220, 300);
		juegos.add(futbol);

		lfutbol = new JLabel("Marcadores");
		lfutbol.setBackground(Color.WHITE);
		lfutbol.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lfutbol.setForeground(Color.WHITE);
		lfutbol.setBounds(620, 60, 240, 40);
		juegos.add(lfutbol);

	}

	/**
	 * Método encargado de cargar un objeto tipo ImageICon en n Jlabel
	 * 
	 * @param src     Nombre de la imagen
	 * @param tipo    Tipo de la imagen
	 * @param escalax Tamaño de la imagen en el eje X
	 * @param escalay Tamañao de la imagen en el eje y
	 * @param b       JLabel en el que se va a cargar el ImageIcon
	 */
	
	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		b.setIcon(icon);
	}

	/**
	 * Método encargado de crear un objeto tipo ImageIcon
	 * 
	 * @param src     Nombre de la imagen
	 * @param tipo    Tipo de la imagen
	 * @param escalax Tamaño de la imagen en el eje X
	 * @param escalay Tamañao de la imagen en el eje y
	 * @return Objeto ImageIcon
	 */

	public ImageIcon devolverImagen(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}

	/**
	 * 
	 * @return l1 Jlabel
	 */

	public JLabel getL1() {
		return l1;
	}

	/**
	 * 
	 * @param l1 Jlabel
	 */

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	/**
	 * 
	 * @return l2 Jlabel
	 */

	public JLabel getL2() {
		return l2;
	}

	/**
	 * 
	 * @param l2 Jlabel
	 */

	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	/**
	 * 
	 * @return lbalo Jlabel
	 */

	public JLabel getLbalo() {
		return lbalo;
	}

	/**
	 * 
	 * @param lbalo Jlabel
	 */

	public void setLbalo(JLabel lbalo) {
		this.lbalo = lbalo;
	}

	/**
	 * 
	 * @return lsuper Jlabel
	 */
	public JLabel getLsupe() {
		return lsupe;
	}

	/**
	 * 
	 * @param lsupe Jlabel
	 */

	public void setLsupe(JLabel lsupe) {
		this.lsupe = lsupe;
	}

	/**
	 * 
	 * @return lfutbol Jlabel
	 */

	public JLabel getLfutbol() {
		return lfutbol;
	}

	/**
	 * 
	 * @param lfutbol Jlabel
	 */

	public void setLfutbol(JLabel lfutbol) {
		this.lfutbol = lfutbol;
	}

	/**
	 * 
	 * @return login JButton
	 */

	public JButton getLogin() {
		return login;
	}

	/**
	 * 
	 * @param login JButton
	 */

	public void setLogin(JButton login) {
		this.login = login;
	}

	/**
	 * 
	 * @return reg JButton
	 */

	public JButton getReg() {
		return reg;
	}

	/**
	 * 
	 * @param reg JButton
	 */

	public void setReg(JButton reg) {
		this.reg = reg;
	}

	/**
	 * 
	 * @return baloto JButton
	 */

	public JButton getBaloto() {
		return baloto;
	}

	/**
	 * 
	 * @param baloto JButton
	 */
	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	/**
	 * 
	 * @return astro JButton
	 */

	public JButton getAstro() {
		return astro;
	}

	/**
	 * 
	 * @param astro JButton
	 */

	public void setAstro(JButton astro) {
		this.astro = astro;
	}

	/**
	 * 
	 * @return futbol JButton
	 */

	public JButton getFutbol() {
		return futbol;
	}

	/**
	 * 
	 * @param futbol JButton
	 */

	public void setFutbol(JButton futbol) {
		this.futbol = futbol;
	}

	/**
	 * 
	 * @return inicio JPanel
	 */

	public JPanel getInicio() {
		return inicio;
	}

	/**
	 * 
	 * @param inicio JPanel
	 */

	public void setInicio(JPanel inicio) {
		this.inicio = inicio;
	}

	/**
	 * 
	 * @return juegos JPanel
	 */

	public JPanel getJuegos() {
		return juegos;
	}

	/**
	 * 
	 * @param juegos JPanel
	 */

	public void setJuegos(JPanel juegos) {
		this.juegos = juegos;
	}

}
