package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.IController;
import model.IGameLogic;
import model.card.CardPiles;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.deck.*;
import model.card.type.Color;
import model.card.type.ColorCard;
import model.card.type.ICard;
import model.card.type.InvertCard;
import model.card.type.NullCard;
import model.card.type.NumericCard;
import model.card.type.Plus2Card;
import model.card.type.Plus4Card;
import model.card.type.SkipCard;
import model.card.type.Symbol;
import model.player.IPlayerListBuilder;
import model.player.IPlayerManager;
import model.player.PlayerListBuilder;
import model.player.type.ComputerPlayer;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import view.ConsoleView;

public class StrategyTest {
	
	private IPlayer you, cpu1,cpu2;
	private ICardPile deck, deck2, deck3, discard;
	private ICardPilesManager cpm;
	private IPlayerListBuilder plm;
	private IPlayerManager pm;
	private IController ctrl;
	private IGameLogic game;
	private ICard num,num2,num3,p2,p4,wild,invert,skip,nan;
	private ConsoleView view;
	private IDeckStrategy strat, strat2;
	private TestDeckStrategy strat3;
	
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
		strat2 = new NumericStrategy();
		strat3 = new TestDeckStrategy();
		plm = new PlayerListBuilder();
		deck = strat.createDeck();
		deck2 = strat2.createDeck();
		deck3 = strat3.createDeck();
		discard = new CardPiles();
	}

	@Test
	public void NumericTest() {
		for(int i = 0; i< deck2.getSize(); i++) {
			assertNotSame(deck2.popCard(), p2);
		}
	}
	
	@Test
	public void TestDeckTest() {
		ICard test = strat3.addNumeric(deck3, Symbol.FIVE, Color.BLUE).popCard();
		ICard test2 = strat3.addSymbol(deck3, Symbol.DRAW_TWO, Color.BLUE).popCard();
		ICard test3 = strat3.addWild(deck3, Symbol.WILD_DRAW_FOUR, Color.NONE).popCard();
		assertEquals(Color.BLUE,test.getColor());
		assertEquals(Symbol.FIVE,test.getSymbol());
		assertEquals(Color.BLUE,test2.getColor());
		assertEquals(Symbol.DRAW_TWO,test2.getSymbol());
		assertEquals(Color.NONE,test3.getColor());
		assertEquals(Symbol.WILD_DRAW_FOUR,test3.getSymbol());
	}

}
