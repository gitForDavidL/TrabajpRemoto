package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class GameDAO {

	private GameFile gameFile;
	private ArrayList<GameDTO> registrosGame;

	public GameDAO() {

		gameFile = new GameFile();
		registrosGame = new ArrayList<GameDTO>();

	}
	
	

}
