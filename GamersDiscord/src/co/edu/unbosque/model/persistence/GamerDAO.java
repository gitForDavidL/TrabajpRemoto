package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BinariosFile;
import co.edu.unbosque.model.persistence.GamerDTO;

public class GamerDAO {

	private BinariosFile bin;
	private ArrayList<GamerDTO> gamerRegistros;

	public GamerDAO() {

		bin = new BinariosFile();
		gamerRegistros = new ArrayList<GamerDTO>();
	}

	public void ingresarGamer(String nombre, String juego, Double puntaje) {

		gamerRegistros.add(new GamerDTO(nombre, juego, puntaje));

	}

	public boolean leerGamers() {

		if (gamerRegistros.size() != bin.leerRegistros().size()) {

			for (int i = 0; i < bin.leerRegistros().size(); i++) {
				gamerRegistros.add(bin.leerRegistros().get(i));
			}

			return true;

		} else {

			return false;
		}

	}

	public void modificarID() {

		for (int i = 0; i < gamerRegistros.size(); i++) {

			gamerRegistros.get(i).setiD(i);

		}
	}

	public boolean borrarGamer(int a) {

		if (a >= 0) {

			gamerRegistros.remove(a);
			bin.leerRegistros().remove(a);
			bin.escribirRegistros(gamerRegistros);

			return true;

		} else {

			return false;

		}
	}

	public void actualizar(int update, int selec, String dat) {

		if (update == 1) {
			gamerRegistros.get(selec).setNombre(dat);
			bin.escribirRegistros(gamerRegistros);

		} else if (update == 2) {

			gamerRegistros.get(selec).setJuego(dat);
			bin.escribirRegistros(gamerRegistros);
		}

	}

	public void actualizar(int selec, Double dat) {

		gamerRegistros.get(selec).setPuntaje(dat);
		bin.escribirRegistros(gamerRegistros);

	}

	public void actualizarAll(int selec, String nom, String jueg, Double pun) {

		gamerRegistros.get(selec).setNombre(nom);
		gamerRegistros.get(selec).setJuego(jueg);
		gamerRegistros.get(selec).setPuntaje(pun);
		bin.escribirRegistros(gamerRegistros);
	}

	public BinariosFile getBin() {
		return bin;
	}

	public void setBin(BinariosFile bin) {
		this.bin = bin;
	}

	public ArrayList<GamerDTO> getGamerRegistros() {
		return gamerRegistros;
	}

	public void setGamerRegistros(ArrayList<GamerDTO> gamerRegistros) {
		this.gamerRegistros = gamerRegistros;
	}

}
