package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class GameDAO {

	private GameFile gameFile;
	private GamerFile bin;

	public GameDAO() {

		gameFile = new GameFile();
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

	public GamerFile getBin() {
		return bin;
	}

	public void setBin(GamerFile bin) {
		this.bin = bin;
	}

	public GameFile getGameFile() {
		return gameFile;
	}

	public void setGameFile(GameFile gameFile) {
		this.gameFile = gameFile;
	}

}
