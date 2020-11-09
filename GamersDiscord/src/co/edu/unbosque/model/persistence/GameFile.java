package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GameFile {

	private String ruta = "./Data/Game.dat";

	public void escribirRegistros(ArrayList<GameDTO> reg) {

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

	public ArrayList<GameDTO> leerRegistros() {
		ObjectInputStream in;
		ArrayList<GameDTO> reg = new ArrayList<GameDTO>();
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<GameDTO>) in.readObject();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}
