package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;
import model.*;
import model.card.*;
import model.card.deck.*;
import model.card.type.*;
import model.player.*;
import model.player.type.*;
import view.ConsoleView;

public class PlayerCardTest {
	
	private IPlayer you, cpu1,cpu2;
	private ICardPile deck, discard;
	private ICardPilesManager cpm;
	private IPlayerListBuilder plm;
	private IPlayerManager pm;
	private IController ctrl;
	private IGameLogic game;
	private ICard num,num2,num3,p2,p4,wild,invert,skip,nan;
	private ConsoleView view;
	private IDeckStrategy strat;
	
	@Before
	public void setUp() throws Exception {
		num = new NumericCard(Symbol.FIVE, Color.BLUE);
		num2 = new NumericCard(Symbol.FIVE, Color.RED);
		num3 = new NumericCard(Symbol.SEVEN, Color.BLUE);
		p2 = new Plus2Card(Color.BLUE);
		p4 = new Plus4Card();
		wild = new ColorCard();
		invert = new InvertCard(Color.BLUE);
		skip = new SkipCard(Color.BLUE);
		nan = new NullCard();
		you = new HumanPlayer();
		cpu1 = new ComputerPlayer();
		cpu2 = new ComputerPlayer();
		strat = new NormalStrategy();
		plm = new PlayerListBuilder();
		deck = strat.createDeck();
		discard = new CardPiles();
	}

	@Test
	public void test() {
		assertEquals(Symbol.FIVE, num.getSymbol());
		assertEquals(Color.BLUE, num.getColor());
		assertEquals(true, num.isPlayableOver(num2));
		assertEquals(true, num.isPlayableOver(num3));
		assertEquals(true, p4.isPlayableOver(num));
		assertEquals(true, wild.isPlayableOver(num));
		assertEquals(true, nan.isPlayableOver(num));
		assertEquals(false, nan.isDiscardable());
		assertEquals(false, nan.isFirstPlayable());
		assertEquals(false, p2.isPlayableOver(num2));
		assertEquals(false, p4.isFirstPlayable());
		assertEquals(false, wild.isFirstPlayable());
		assertEquals(false, nan.isFirstPlayable());
		assertEquals(108, deck.getSize());
		cpm = new CardPilesManager(deck, discard);
		assertEquals(107, cpm.getDrawableCardsNumber());
	}

}
