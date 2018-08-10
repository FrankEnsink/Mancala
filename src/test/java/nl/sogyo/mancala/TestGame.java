package nl.sogyo.mancala;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGame  {

		private Hole Firsthole;
		
		@Before
		public void before() {
			Firsthole = new Hole(14, 1);
		}
		
		@Test
		public void canIMakeNeighbours() {
			Pitt result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour()
					.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour(); 
			assertNotNull(result);
			}
			
		@Test
		public void makeAMove() {
		Firsthole.makeAMove();
		int result = Firsthole.getNumberofStones();
		int result2 = Firsthole.getNeighbour().getNumberofStones();
		assertEquals(result, 0);
		assertEquals(result2, 5);
		}
		
		@Test
		public void emptyHole() {
			((Hole) Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour()).emptyHoles();
			int result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
			assertEquals(0, result);
		}
		
		@Test
		public void doesMyKalahaHaveStartingStones() {
			int result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
			assertEquals(0, result);
		}
		
		@Test
		public void testStrike() {
			((Hole) Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour()).emptyHoles();
			Firsthole.makeAMove();
			int result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
			assertEquals(result, 0);
			int result2 = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
			assertEquals(5, result2 );
		}
		
		@Test 
		public void givingAllStonesToMyKahala() {
		int result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
		Firsthole.getNeighbour().RecieveAllStonesInTheRowToKahala();
		
		assertEquals(0, result);
		
		}
		
		@Test
		public void makeTwoMoves() {
			Firsthole.makeAMove();
			Firsthole.chooseThePittThatMakesAMove(9);
			int result = Firsthole.getNumberofStones();
			assertEquals(result, 0);
		}
		
		@Test
		public void ICantGoTwoTurnsInARow() {
			Firsthole.makeAMove();
			Firsthole.chooseThePittThatMakesAMove(9);
			int result = Firsthole.getNeighbour().getNumberofStones();
			assertEquals(5, result);
		}
		
		@Test
		public void testificanreachOpponent() {
			assertNotNull(Firsthole.getPlayer().getOpponent());
			assertNotNull(Firsthole.getNeighbour().getNeighbour().getNeighbour().
					getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getPlayer().getOpponent());
		}
		
}
