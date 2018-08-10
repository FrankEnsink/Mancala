package nl.sogyo.mancala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MancalaTest {

	private Mancala test;

	@Before
	public void before() {
		test = new Mancala();
	}

	@Test
	public void canIMakeNeighbours() {
		boolean result = test.didMyOpponentWin();
		assertNotNull(result);
	}

	@Test
	public void canIReturnPittContent() {
		ArrayList<Integer> pittContent = test.getContentOfEveryPitt();
		int result = pittContent.get(3);
		int result2 = pittContent.get(6); // de kalaha
		assertEquals(result, 4);
		assertEquals(result2, 0);
	}

	@Test
	public void makeAMove() {

		test.makeAMove(1);
		ArrayList<Integer> pittContent = test.getContentOfEveryPitt();
		int result = pittContent.get(2);
		assertEquals(result, 5);
	}

}