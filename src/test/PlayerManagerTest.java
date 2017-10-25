package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.player.*;
import model.player.type.*;


public class PlayerManagerTest {
	
	private IPlayer you, cpu1;
	private IPlayerListBuilder plm;
	private IPlayerManager pm;

	
	
	
	
	@Before
	public void setUp() throws Exception {
		you = new HumanPlayer();
		cpu1 = new ComputerPlayer();
		plm = new PlayerListBuilder();
		
	}

	@Test
	public void PMTest() {
		assertEquals(you.getHandSize(), 0);
		assertEquals(cpu1.getHandSize(), 0);
		plm.addPlayer(you);
		plm.addPlayer(cpu1);
		assertEquals(2, plm.buildPlayerList().size());
		pm = new PlayerManager(plm.buildPlayerList());
		assertEquals(2, pm.getPlayers().size());
	}

}
