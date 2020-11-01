package co.edu.unbosque.model.persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 

public class BinariosFile {

	private String ruta = "./Data/registro.dat";

	private File file;
	private FileOutputStream fos;
	private DataOutputStream dos;
	private FileOutputStream fis;
	private DataInputStream dis;
	private ArrayList<Registro> registros;
	

	public BinariosFile() {

		registros = new ArrayList<>();

	}

	public void IngresarGamer(String nombre, String juego, Double puntaje) {
		Registro gmrs = new Registro(nombre, juego, puntaje);
		registros.add(gmrs);

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.writeObject(gmrs);
			out.close();
			System.out.println("Gamer ingresado con exito");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error de IO");
		}

	}

	public void leerRegistros() {
		ObjectInputStream in;

		try {
			System.out.println(registros.size());
			in = new ObjectInputStream(new FileInputStream(ruta));
			registros = (ArrayList<Registro>) in.readObject();
			
			in.close();

			for (int i = 0; i < registros.size(); i++) {

				System.out.println(registros.get(i).getNombre());
				System.out.print(registros.get(i).getJuego());
				System.out.println(registros.get(i).getPuntaje());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;
	}

}