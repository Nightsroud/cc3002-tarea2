package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import controller.*;
import model.*;
import model.card.*;
import model.card.type.*;
import model.player.*;
import model.player.type.*;
import view.ConsoleView;

public class PlayerHandTest {
	
	private IPlayer you, cpu1,cpu2;
	private ICardPile deck, discard;
	private ICardPilesManager cpm;
	private IPlayerListBuilder plm;
	private IPlayerManager pm;
	private IController ctrl;
	private IGameLogic game;
	private ICard num,p2,p4,wild,invert,skip;
	private ConsoleView view;
	
	
	@Before
	public void setUp() throws Exception {
		you = new HumanPlayer();
		cpu1 = new ComputerPlayer();
		cpu2 = new ComputerPlayer();
		plm = new PlayerListBuilder();
		num = new NumericCard(Symbol.FIVE, Color.BLUE);
		p2 = new Plus2Card(Color.BLUE);
		p4 = new Plus4Card();
		wild = new ColorCard();
		invert = new InvertCard(Color.BLUE);
		skip = new SkipCard(Color.BLUE);
		deck = new CardPiles();
		discard = new CardPiles();
		
	}

	@Test
	public void HandTest() {
		assertEquals(0,you.getHandSize());
		assertEquals(0,cpu1.getHandSize());
		assertEquals(0,cpu2.getHandSize());
		ArrayList<ICard> hand = new ArrayList<>(Arrays.asList(num,num,num,num));
		you.addToHand(hand);
		cpu1.addToHand(hand);
		cpu2.addToHand(hand);
		assertEquals(4,you.getHandSize());
		assertEquals(4,cpu1.getHandSize());
		assertEquals(4,cpu2.getHandSize());
		deck.pushCard(num);
		deck.pushCard(p2);
		deck.pushCard(p4);
		deck.pushCard(wild);
		deck.pushCard(invert);
		deck.pushCard(skip);
		discard.pushCard(num);
		plm.addPlayer(you);
		plm.addPlayer(cpu1);
		plm.addPlayer(cpu2);
		pm = new PlayerManager(plm.buildPlayerList());
		cpm = new CardPilesManager(deck,discard);
		game = new GameLogic(pm, cpm);
		view = new ConsoleView(game);
		ctrl = new ConsoleController(game,view);
		assertEquals(false, you.hasWon());
		assertEquals(false, cpu1.hasWon());
		assertEquals(false, cpu2.hasWon());
		assertEquals(false, you.hasOneCard());
		assertEquals(false, cpu1.hasOneCard());
		assertEquals(false, cpu2.hasOneCard());
		assertEquals(false, you.hasSaidUNO());
		assertEquals(false, cpu1.hasSaidUNO());
		assertEquals(false, cpu2.hasSaidUNO());
		you.removeCardFromHand(num);
		cpu1.removeCardFromHand(num);
		cpu2.removeCardFromHand(num);
		assertEquals(3, you.getHandSize());
		assertEquals(3, cpu1.getHandSize());
		assertEquals(3, cpu2.getHandSize());
		assertEquals(you, pm.getCurrentPlayer());
		p2.executeAction(game, ctrl);
		assertEquals(5, pm.getCurrentPlayer().getHandSize());
		cpm.discard(p2);
		assertEquals(p2, cpm.getCurrentPlayedCard());
		cpm.rebuildDeck();
		assertEquals(p2, cpm.getCurrentPlayedCard());
		pm.invertDirection();
		pm.skipPlayer();
		pm.getCurrentPlayer().removeCardFromHand(num);
		pm.getCurrentPlayer().removeCardFromHand(num);
		assertEquals(1, pm.getCurrentPlayer().getHandSize());
		cpm.rebuildDeck();
		p4.executeAction(game, ctrl);
		assertEquals(7, pm.getCurrentPlayer().getHandSize());
	}

}
