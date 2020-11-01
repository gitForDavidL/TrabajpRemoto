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

	public void IngresarGamer(ArrayList<Registro> reg) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.writeObject(reg);
			out.close();
			System.out.println("Gamer ingresado con exito");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error de IO");
		}

	}

	public ArrayList<Registro> leerRegistros(ArrayList<Registro> reg) {
		ObjectInputStream in;
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<Registro>) in.readObject();

			in.close();

			for (int i = 0; i < reg.size(); i++) {

				System.out.println(reg.get(i).getNombre());
				System.out.print(reg.get(i).getJuego());
				System.out.println(reg.get(i).getPuntaje());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}