package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.persistence.GamerFile;
import co.edu.unbosque.model.persistence.GamerDTO;

public class GamerDAO {

	private GamerFile gamerFile;
	private ArrayList<GamerDTO> gamerRegistros;

	public GamerDAO() {

		gamerFile = new GamerFile();
		gamerRegistros = new ArrayList<GamerDTO>();
	}

	public void ingresarGamer(String nombre) {

		gamerRegistros.add(new GamerDTO(nombre));

		gamerFile.escribirRegistros(gamerRegistros);

	}

	public boolean leerGamers() {

		if (gamerRegistros.size() != gamerFile.leerRegistros().size()) {

			for (int i = 0; i < gamerFile.leerRegistros().size(); i++) {
				gamerRegistros.add(gamerFile.leerRegistros().get(i));
			}

			return true;

		} else {

			return false;
		}

	}

	public void generarID(int i) {

		Random rnd = new Random();
		int id;

		id = rnd.nextInt(2000);

		gamerRegistros.get(i).setiD(id);

		gamerFile.escribirRegistros(gamerRegistros);

	}

	public boolean borrarGamer(int a) {

		if (a >= 0) {

			gamerRegistros.remove(a);
			gamerFile.leerRegistros().remove(a);
			gamerFile.escribirRegistros(gamerRegistros);

			return true;

		} else {

			return false;

		}
	}

	public void actualizar(int update, int selec, String dat) {

		if (update == 1) {
			gamerRegistros.get(selec).setNombre(dat);
			gamerFile.escribirRegistros(gamerRegistros);

		}

	}

	public void actualizarAll(int selec, String nom, String jueg) {

		gamerRegistros.get(selec).setNombre(nom);

	}

	public GamerFile getBin() {
		return gamerFile;
	}

	public void setBin(GamerFile bin) {
		this.gamerFile = bin;
	}

	public ArrayList<GamerDTO> getGamerRegistros() {
		return gamerRegistros;
	}

	public void setGamerRegistros(ArrayList<GamerDTO> gamerRegistros) {
		this.gamerRegistros = gamerRegistros;
	}

}
