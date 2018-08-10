package nl.sogyo.mancala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestKalaha<Kahala> {

	private Hole Firsthole;
	private Pitt MyKahala;
	@Before
	public void before() {
		Firsthole = new Hole(4, 1);
		MyKahala = Firsthole.getNeighbour();
	}
	
	@Test
	public void doesMyKahalaHaveStartingstones() {
		int result = MyKahala.getNumberofStones();
		assertEquals(0, result);
	}
			
	
	@Test
	public void determiningIfIAmAKahala() {
	boolean result = MyKahala. amItheActivePlayersKalaha();
	assertEquals(true, result);
	}
	
	@Test
	public void isThePlayersRowEmpty() {
		boolean result = Firsthole.isThePlayersRowEmpty();
		Firsthole.emptyHoles();
		boolean result2 = Firsthole.isThePlayersRowEmpty();
		assertEquals(false, result);
		assertEquals(true, result2);
	}
	
	@Test
	public void getTheNumberOfStonesInMyOpponentsKalaha() {
		int result = ((Kalaha) Firsthole.getNeighbour()).getTheNumberOfStonesOfMyOpponentsKalaha();
		Firsthole.makeAMove();
		Firsthole.chooseThePittThatMakesAMove(3);
		int result2 = ((Kalaha) Firsthole.getNeighbour()).getTheNumberOfStonesOfMyOpponentsKalaha();
		assertEquals(0, result);
		int result3 = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
//		assertEquals(2, result3);
	}
	
	@Test
	public void canTheKalahaTellIfHeHasMoreStonesThanTheOpponentKalaha() {
		boolean result = Firsthole.getPlayer().didIwin();
		Firsthole.makeAMove();
		Firsthole.doIHaveMoreStonesThanMyOpponentsKalaha();
		boolean result2 = Firsthole.getPlayer().didIwin();
		boolean result3 = Firsthole.getPlayer().getOpponent().didIwin();
		assertEquals(false, result);
		assertEquals(true, result2);
		assertEquals(false, result3);
	}
}
