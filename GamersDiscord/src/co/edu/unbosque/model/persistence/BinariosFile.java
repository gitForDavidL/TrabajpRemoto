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

	public void EscribirRegistros(ArrayList<Registro> reg) {

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

	public ArrayList<Registro> leerRegistros() {
		ObjectInputStream in;
		ArrayList<Registro> reg = new ArrayList<Registro>();
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<Registro>) in.readObject();

			in.close();

			for (int i = 0; i < reg.size(); i++) {

				System.out.println(reg.get(i).getNombre());
				System.out.println(reg.get(i).getJuego());
				System.out.println(reg.get(i).getPuntaje()+"\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}