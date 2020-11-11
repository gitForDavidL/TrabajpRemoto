package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class GameDAO {

	private GamerFile bin;

	public GameDAO() {

		bin = new GamerFile();

	}

	public GameDTO ingresarJuego(String nombre, Double puntaje, String dia) {

		GameDTO jue = new GameDTO(nombre, puntaje, dia);

		return jue;

	}

	public boolean leerjuegos(int selec, ArrayList<GamerDTO> reg) {

		if (reg.get(selec).getJuegos().size() != bin.leerRegistros().get(selec).getJuegos().size()) {

			for (int i = 0; i < bin.leerRegistros().get(selec).getJuegos().size(); i++) {

				reg.get(selec).getJuegos().add(bin.leerRegistros().get(selec).getJuegos().get(i));
			}

			return true;

		} else {

			return false;
		}

	}

	public void borrarjuego(int selecjuega, int selecjueg, ArrayList<GamerDTO> reg) {

		reg.get(selecjuega).getJuegos().remove(selecjueg);

		bin.escribirRegistros(reg);

	}

	public String actualizar(int opc, int selecGamer, int selecGame, String nom, Double puntaje, String dia,
			ArrayList<GamerDTO> reg) {

		String resultado = "";

		if (opc == 0) {

			reg.get(selecGame).getJuegos().get(selecGame).setNombre(nom);
			resultado = "Se ha cambiado el nombre con exito :)";
		} else if (opc == 1) {

			reg.get(selecGamer).getJuegos().get(selecGame).setPuntaje(puntaje);
			resultado = "Se ha cambiado el puntaje del jugados con exito";

		} else if (opc == 2) {
			reg.get(selecGamer).getJuegos().get(selecGame).setFecha(dia);
			resultado = "Se ha cambiado el dia del registro con exito";
		} else if (opc == 3) {

			reg.get(selecGamer).getJuegos().get(selecGame).setNombre(nom);
			reg.get(selecGamer).getJuegos().get(selecGame).setPuntaje(puntaje);
			reg.get(selecGamer).getJuegos().get(selecGame).setFecha(dia);

			resultado = "Se han cambiado todos los campos del juego";
		}

		return resultado;

	}

	public GamerFile getBin() {
		return bin;
	}

	public void setBin(GamerFile bin) {
		this.bin = bin;
	}

}
