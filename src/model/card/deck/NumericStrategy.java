package model.card.deck;

import model.card.ICardPile;

public class NumericStrategy implements IDeckStrategy {

	@Override
	public ICardPile createDeck() {
		NumericDeckFactory N = new NumericDeckFactory();
		return N.buildDeck();
	}

}
