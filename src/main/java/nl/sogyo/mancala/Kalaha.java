package nl.sogyo.mancala;

class Kalaha extends Pitt {

	public Kalaha(int boardLength, int numberOfPittsMade, Player player) {
		super(boardLength, numberOfPittsMade);
		this.setPlayer(player);
		makeHoleOrKalaha(this, player, numberOfPittsMade);
	}

	public Kalaha(int boardLength, int numberOfPittsMade, Pitt Firsthole, Player player) {
		super(boardLength, numberOfPittsMade);
		this.setPlayer(player);
		this.setFirsthole(Firsthole);
		makeHoleOrKalaha(Firsthole, player, numberOfPittsMade);

	}

	private void makeHoleOrKalaha(Pitt Firsthole, Player PlayerOne, int numberOfPittsMade) {
		if (getActivePlayer() == true) {
			setNeighbour(new Hole(getBoardLength(), numberOfPittsMade + 1, Firsthole, PlayerOne.getOpponent()));
		} else {
			setNeighbour(Firsthole);
		}
	}

	@Override
	public void makeAMove() {
	}

	@Override
	public void RecieveAStone(int hand) {
		if (getActivePlayer() == false) {
			getNeighbour().RecieveAStone(hand);
		} else {
			myOwnKahalaRecievesAStone(hand);
		}
	}

	private void myOwnKahalaRecievesAStone(int hand) {
		if (hand > 1) {
			setStoneNumber(getNumberofStones() + 1);
			getNeighbour().RecieveAStone(hand - 1);
		} else if (hand == 1) {
			setStoneNumber(getNumberofStones() + 1);
			switchActivePlayer();
		}
	}

	@Override
	public boolean amItheActivePlayersKalaha() {
		boolean iAmtheActivePlayersKalaha = false;
		if (getActivePlayer() == true) {
			iAmtheActivePlayersKalaha = true;
		}
		return iAmtheActivePlayersKalaha;
	}

	@Override
	protected boolean isThePlayersRowEmpty(Pitt pitt) {
		boolean thePlayersRowIsEmpty = true;
		return thePlayersRowIsEmpty;
	}

	protected void giveAllStonesInTheRowToKahala() {
		if (getActivePlayer() == true) {
			getMyKahala().setStoneNumber(
					getMyKahala().getNumberofStones() + getFirsthole().getAllStonesLeftInRowAfterGameEnds(0));
		} else {
			getMyKahala().setStoneNumber(getMyKahala().getNumberofStones()
					+ getTheFirstHoleOfTheOpponent().getAllStonesLeftInRowAfterGameEnds(0));
		}
	}

	protected void doIHaveMoreStonesThanMyOpponentsKalaha() {
		if (getNumberofStones() > getTheNumberOfStonesOfMyOpponentsKalaha()) {
			getPlayer().myKahalaHasTheMostStones();
		} else if (getNumberofStones() == getTheNumberOfStonesOfMyOpponentsKalaha()) {
			getPlayer().myKahalaHasTheSameAmountOfStonesAsTheOppent();
		} else {
			getPlayer().getOpponent().myKahalaHasTheMostStones();
		}

	}

	protected int getTheNumberOfStonesOfMyOpponentsKalaha() {
		int theIndexNumberOfMyOpponentsKalaha = getTheIndexNumberOfMyOpponentsKalaha();
		int theNumberOfStonesOfMyOpponentsKalaha = getNumberOfStonesOfMyOpponentsKalaha(
				theIndexNumberOfMyOpponentsKalaha);
		return theNumberOfStonesOfMyOpponentsKalaha;
	}

	@Override
	protected int getNumberOfStonesOfMyOpponentsKalaha(int IndexNumberOfMyOpponentsKalaha) {
		int theNumberOfStonesOfMyOpponentsKalaha;
		if (getTheIndexOfMyPosition(this) == IndexNumberOfMyOpponentsKalaha) {
			theNumberOfStonesOfMyOpponentsKalaha = this.getNumberofStones();
		} else {
			return getNeighbour().getNumberOfStonesOfOpposite(IndexNumberOfMyOpponentsKalaha);
		}
		return theNumberOfStonesOfMyOpponentsKalaha;
	}

	public int getAllStonesLeftInRowAfterGameEnds(int allStonesLeftInRowAfterGameEnds) {
		return allStonesLeftInRowAfterGameEnds;

	}

	protected int getTheIndexNumberOfMyOpponentsKalaha() {
		int IndexNumberOfMyOpponentsKalaha;
		if (getTheIndexOfMyPosition(this) == getBoardLength() / 2) {
			IndexNumberOfMyOpponentsKalaha = getBoardLength();
		} else {
			IndexNumberOfMyOpponentsKalaha = getBoardLength() / 2;
		}

		return IndexNumberOfMyOpponentsKalaha;
	}

}
