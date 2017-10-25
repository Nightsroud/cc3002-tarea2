package model.card.deck;

import java.util.ArrayList;
import java.util.Arrays;

import model.card.CardPiles;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Symbol;

public class NumericDeckFactory implements IDeckFactory {

	@Override
	public ICardPile buildDeck() {
		ArrayList<Symbol> num = new ArrayList<>(Arrays.asList(Symbol.ZERO, Symbol.ONE, Symbol.TWO, Symbol.THREE, Symbol.FOUR, Symbol.FIVE, Symbol.SIX, Symbol.SEVEN, Symbol.EIGHT, Symbol.NINE));
		ArrayList<Color> col = new ArrayList<>(Arrays.asList(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW));
		CardPiles deck = new CardPiles();
		NumericCardFactory N = new NumericCardFactory();
		for(int i = 0; i<num.size();i++) {
			for(int j = 0; j< col.size(); j++) {
				deck.pushCard(N.buildCard(num.get(i), col.get(j)));
				if(num.get(i).equals(Symbol.ZERO) && j == 3) {
					break;
				}
			}
		}
		return deck;
	}

}
