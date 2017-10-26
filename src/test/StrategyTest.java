package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.ICardPile;
import model.card.deck.*;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Plus2Card;
import model.card.type.Symbol;

public class StrategyTest {
	
	private ICardPile deck2, deck3;
	private ICard p2;
	private IDeckStrategy strat2;
	private TestDeckStrategy strat3;
	
	@Before
	public void setUp() throws Exception {
		p2 = new Plus2Card(Color.BLUE);
		strat2 = new NumericStrategy();
		strat3 = new TestDeckStrategy();
		deck2 = strat2.createDeck();
		deck3 = strat3.createDeck();
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
		assertEquals(true, deck3.isEmpty());
	}

}
