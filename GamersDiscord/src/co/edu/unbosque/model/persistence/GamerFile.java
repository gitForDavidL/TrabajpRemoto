package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GamerFile {

	private String ruta = "./Data/Gamer.dat";

	public void escribirRegistros(ArrayList<GamerDTO> reg) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.writeObject(reg);
			out.close();
			System.out.println("dato ingresado con exito");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error de IO");
		}

	}

	public ArrayList<GamerDTO> leerRegistros() {
		ObjectInputStream in;
		ArrayList<GamerDTO> reg = new ArrayList<GamerDTO>();
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<GamerDTO>) in.readObject();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}