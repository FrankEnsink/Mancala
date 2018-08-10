package nl.sogyo.mancala;

class Pitt{

private int boardLength;
private int numberOfStones;

private Pitt neighbour;
private Pitt firsthole;
private Player player;

	public Pitt(int boardLength, int indexNumber) {
		this.boardLength = boardLength;
	}
		
	public Pitt getNeighbour() {
		return neighbour;
	}
	
	public int getBoardLength() {
		return boardLength;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void switchActivePlayer() {
		getPlayer().switchactivePlayer();
		getPlayer().getOpponent().switchactivePlayer();
	}
	
	public Pitt getFirsthole() {
		return firsthole;
	}

	protected void setFirsthole(Pitt firsthole) {
		this.firsthole = firsthole;
	}

	protected void setPlayer(Player player) {
		this.player = player;
	}

	protected void setNeighbour(Pitt neighbour) {
		this.neighbour = neighbour;
	}
	
	public boolean getActivePlayer() {
		boolean activePlayer = getPlayer().isActive();
		return activePlayer;
	}
			
	public int getNumberofStones() {
		return numberOfStones;
	}

	public void setStoneNumber(int stoneNumber) {
		this.numberOfStones = stoneNumber;
	}
	
	public int getIndexOfPittThatMakesFirstKalaha() {
		return boardLength/2 -1;
	}
	
	public int getIndexOfPittThatMakesSecondKalaha() {
		return boardLength -1;
	}
		
	public void makeAMove() {
	}
		
	public void RecieveAStone(int hand) {
	}
	
	public void sendPlayerMyNumberOfStonesInformation() {
	}
	
	protected int TestgetTheIndexOfMyPosition() {
		int TheIndexOfMyPosition = getTheIndexOfMyPosition(this);
		return TheIndexOfMyPosition;
	}
	
	protected int getTheIndexOfMyPosition(Pitt pitt) {
		int TheIndexOfMyPosition = getFirsthole().getIndexOf(pitt);
		return TheIndexOfMyPosition;
	}

	
	protected int getIndexOf(Pitt pitt) {
			int result;
			if(pitt == this) {
				result = 1;
				return result;
			}else {
				return getNeighbour().getIndexOf(pitt)+1;
			}
	}
	
	
	protected void chooseThePittThatMakesAMove(int ChoosenPittNumber) {
		selectTheChoosenPitt(ChoosenPittNumber);
	}
	
	protected Pitt selectTheChoosenPitt(int indexOfChoosenPitt) {
		if(getTheIndexOfMyPosition(this) == indexOfChoosenPitt) {
			this.makeAMove();}
		else{
			getNeighbour().selectTheChoosenPitt(indexOfChoosenPitt);
		}
		return this;
	}

	protected int getNumberOfStonesOfOpposite(int indexOfOpposite) {
		int NumberOfStonesOfOpposite;
		if(getTheIndexOfMyPosition(this) == indexOfOpposite ) {
			NumberOfStonesOfOpposite = this.getNumberofStones();
			}else{
			return getNeighbour().getNumberOfStonesOfOpposite(indexOfOpposite);
			}return NumberOfStonesOfOpposite;
	}

	protected boolean amItheActivePlayersKalaha() {
		boolean iAmtheActivePlayersKalaha = false;
		if(this.getPlayer().isActive() == true && getTheIndexOfMyPosition(this) ==7|| getTheIndexOfMyPosition(this) ==14) {
			return  iAmtheActivePlayersKalaha = true;}
			return iAmtheActivePlayersKalaha;
	}
	
	protected Pitt getMyKahala() {
		Pitt myKahala;
		if(amItheActivePlayersKalaha() == true) {
			 myKahala = this; 
		}else 
		{
			return getNeighbour().getMyKahala();
		}
		return myKahala;
	}
	
	public void RecievesTheLastStoneInHand(int hand) {
		
	}
	
	public boolean isTheRowEmpty() {
		boolean theRowIsEmpty = false;
		if(getActivePlayer() == true) {
			isThePlayersRowEmpty();
		}else {
			isTheOppontsRowEmpty();
		}
		return theRowIsEmpty;
	}
	
	private boolean isThePlayersRowEmpty() {
		boolean thePlayersRowIsEmpty = false;
		thePlayersRowIsEmpty = isThePlayersRowEmpty(getFirsthole()); 
		return thePlayersRowIsEmpty;
	}
	
	private boolean isTheOppontsRowEmpty() {
		boolean thePlayersRowIsEmpty = false;
		thePlayersRowIsEmpty = isThePlayersRowEmpty(getTheFirstHoleOfTheOpponent()); 
		return thePlayersRowIsEmpty;
	}
	
	protected boolean isThePlayersRowEmpty(Pitt pitt) {
		boolean thePlayersRowIsEmpty = false;
		if(isMyHoleEmpty() == true) {
			return getNeighbour().isThePlayersRowEmpty(this);
		}
		return thePlayersRowIsEmpty;
	}
	
	private boolean isMyHoleEmpty() {
		boolean myHoleIsEmpty = false;
		if(getNumberofStones() == 0) {
			myHoleIsEmpty = true;
		}
		return myHoleIsEmpty;
	}
		
	protected Pitt getTheFirstHoleOfTheOpponent() {
		Pitt firstHoleOfTheOpponent;
		if(getTheIndexOfMyPosition(this) == getTheIndexOfTheFirstHoleOfTheOpponent()) {
		firstHoleOfTheOpponent = this;}
		else {return getNeighbour().getTheFirstHoleOfTheOpponent();}
		return firstHoleOfTheOpponent;
	}
	
	protected int getTheIndexOfTheFirstHoleOfTheOpponent() {
		int TheIndexOfTheFirstHoleOfTheOpponent = getBoardLength()/2 +1;
		return TheIndexOfTheFirstHoleOfTheOpponent;
	}
	 
	protected void RecieveAllStonesInTheRowToKahala() {
		getMyKahala().setStoneNumber(getNumberofStones() - getFirsthole().getAllStonesLeftInRowAfterGameEnds(0)); 
		getMyKahala().setStoneNumber(getNumberofStones() - getTheFirstHoleOfTheOpponent().getAllStonesLeftInRowAfterGameEnds(0)); 	
		
	}
	
	public int getAllStonesLeftInRowAfterGameEnds(int allStonesLeftInRowAfterGameEnds) {
		if(getTheIndexOfMyPosition(this) == 7 || getTheIndexOfMyPosition(this)==14 ) {
			allStonesLeftInRowAfterGameEnds = allStonesLeftInRowAfterGameEnds + getNumberofStones();	
		}else {			
			int numberOfStones= getNumberofStones();
			
		return getNeighbour().getAllStonesLeftInRowAfterGameEnds(allStonesLeftInRowAfterGameEnds + numberOfStones);
		}
		return allStonesLeftInRowAfterGameEnds;
	}

	
	protected int getNumberOfStonesOfMyOpponentsKalaha(int IndexNumberOfMyOpponentsKalaha) {
		int theNumberOfStonesOfMyOpponentsKalaha;
		if(getTheIndexOfMyPosition(this) == IndexNumberOfMyOpponentsKalaha ) {
			theNumberOfStonesOfMyOpponentsKalaha = this.getNumberofStones();
			}else{
			return getNeighbour().getNumberOfStonesOfOpposite(IndexNumberOfMyOpponentsKalaha);
			}
		return theNumberOfStonesOfMyOpponentsKalaha;
	}
	
	protected Pitt getThePitt(int indexOfChoosenPitt) {
		if(getTheIndexOfMyPosition(this) == indexOfChoosenPitt) {
			Pitt pitt = this;
			return pitt; }
		else
			
		return getNeighbour().getThePitt(indexOfChoosenPitt);
	}
	
}