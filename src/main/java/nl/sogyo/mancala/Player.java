package nl.sogyo.mancala;

public class Player {

	public Player opponent;

	private boolean active;
	private boolean didIWin;
	private boolean theGameEndsInATie;

	public Player(boolean activePlayer) {
		this.active = activePlayer;
		makeOpponent(this);
	}

	public Player(boolean active, Player player) {
		this.active = active;
		setOpponent(player);
	}

	public void makeOpponent(Player player) {
		this.opponent = new Player(!player.isActive(), player);
	}

	private void setOpponent(Player player) {
		this.opponent = player;
	}

	public Player getOpponent() {
		return opponent;
	}

	public boolean isActive() {
		return active;
	}

	public void switchactivePlayer() {
		if (active == true) {
			active = false;
		} else {
			active = true;
		}
	}

	public Player getPlayer() {
		return this;
	}

	protected void myKahalaHasTheMostStones() {
		didIWin = true;
	}

	protected void myKahalaHasTheSameAmountOfStonesAsTheOppent() {
		theGameEndsInATie = true;
	}

	public boolean didTheGameEndInATie() {
		return theGameEndsInATie;
	}

	public boolean didIwin() {
		return didIWin;
	}

}