package nl.sogyo.mancala;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

		public class TestHole {
		
		
		private Hole Firsthole;
		
		@Before
		public void before() {
			Firsthole = new Hole(4, 1);
		}
		
		@Test
		public void doesmyFirstholeHaveAFirsthole() {
			Pitt result = Firsthole.getFirsthole();
			assertNotNull(result);
		}
		@Test
		public void gettingTheIndexOfPitts() {
		int	result = Firsthole.getIndexOf(Firsthole); 
		assertEquals(1, result);
		int result2 = Firsthole.getNeighbour().getNeighbour().TestgetTheIndexOfMyPosition();
		assertEquals(3, result2);
		int result3 = Firsthole.getNeighbour().getNeighbour().getNeighbour().TestgetTheIndexOfMyPosition();
		assertEquals(4, result3);
		}
		
		@Test
		public void doesAHoleMakeNeighbours() {
			Pitt result = Firsthole.getNeighbour();
			Pitt result2 = Firsthole.getNeighbour().getNeighbour().getNeighbour();
			assertNotNull(result);
			assertNotNull(result2);
		}
						
		@Test
		public void canIMakeAFullCircle() {
			Pitt result = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour();
			assertNotNull(result);
		}
		@Test
		public void doMyHolesHaveStones() {
			int result=Firsthole.getNumberofStones();
			assertEquals(4, result);
		}
						
		@Test
		public void emptyHoles() {
			Firsthole.emptyHoles();
			((Hole) Firsthole.getNeighbour().getNeighbour()).emptyHoles();
			int result2 = Firsthole.getNeighbour().getNeighbour().getNumberofStones();
			int result = Firsthole.getNumberofStones();
			assertEquals(0, result);
			assertEquals(0, result2);
		}
		
		@Test
		public void makingAMove() {
			Firsthole.makeAMove();
			int result = Firsthole.getNumberofStones();
			int result2 = Firsthole.getNeighbour().getNumberofStones();
			int result3 = Firsthole.getNeighbour().getNeighbour().getNeighbour().getNumberofStones();
			assertEquals(1, result);
			assertEquals(2, result2);
			assertEquals(0, result3); //the enemy kalaha recieved no stones
		}
	
		@Test
		public void selectingAPittandMakeAMoveWithIt() {
			Firsthole.chooseThePittThatMakesAMove(1);
			Firsthole.chooseThePittThatMakesAMove(3);
			int result = Firsthole.getNumberofStones();
			assertEquals(1, result);
		}
		
		@Test
		public void getMyOpposite() {
		int	result = Firsthole.getNumberOfStonesOfOpposite(3);
		assertEquals(4, result);
		
		}
		
		@Test
		public void determiningIfIAmAKahala() {
		boolean result = Firsthole. amItheActivePlayersKalaha();
		assertEquals(false, result);
		}
		
		@Test 
		public void givingAllStonesToMyKahala() {
		int	result = Firsthole.getAllStonesLeftInRowAfterGameEnds(0);
		assertEquals(4, result);
		}
		
		@Test
		public void switchingActivePlayer() {
		boolean result = Firsthole.getActivePlayer();
		assertEquals(true, result);
		Firsthole.switchActivePlayer();
		boolean result2 = Firsthole.getActivePlayer();
		boolean result3 = Firsthole.getPlayer().getOpponent().isActive();
		assertEquals(false, result2);
		assertEquals(true, result3);
		}
		
}	