package nl.sogyo.mancala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPlayer {
	
	private Player Testplayer;
	
	@Before
	public void before() {
		Testplayer = new Player(true);
	}
	@Test
	public void getActivePlayer() {
		boolean result = Testplayer.isActive();
		assertEquals(true, result);
	}

	@Test
	public void doIHaveAnOpponent() {
		assertNotNull(Testplayer.getOpponent());
		assertNotNull(Testplayer.getOpponent().getOpponent());
	}
	
	@Test
	public void getdidIWin() {
		boolean result = Testplayer.didIwin();
		assertEquals(false, result);
	}
		
}
