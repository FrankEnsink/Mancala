package nl.sogyo.mancala;

import java.util.ArrayList;

public class Mancala {
	Pitt firsthole;

	public Mancala() {
		makeBoard();
	}

	public void makeBoard() {
		firsthole = new Hole(14, 1);
	}

	public ArrayList<Integer> getContentOfEveryPitt() {
		ArrayList<Integer> pittContent = new ArrayList<Integer>();
		for (int numberOfPitts = 1; numberOfPitts <= firsthole.getBoardLength(); numberOfPitts++) {
			int numberOfStones = getStoneNumberOfPit(numberOfPitts);
			pittContent.add(numberOfStones);
		}
		return pittContent;
	}

	public void makeAMove(int choosenHole) {
		Pitt choosenpit = firsthole.getThePitt(choosenHole);
		choosenpit.makeAMove();
	}

	public int getStoneNumberOfPit(int pittNumber) {
		Pitt pitt = firsthole.getThePitt(pittNumber);
		int content = pitt.getNumberofStones();
		return content;
	}

	public boolean didIWin() {
		return firsthole.getPlayer().didIwin();
	}
	
	public boolean didMyOpponentWin() {
		return firsthole.getPlayer().getOpponent().didIwin();
	}
	
	public boolean ItisATie() {
		return firsthole.getPlayer().didTheGameEndInATie();
		
	}
}