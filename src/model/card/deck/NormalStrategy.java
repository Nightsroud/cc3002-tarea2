package model.card.deck;

import model.card.ICardPile;

public class NormalStrategy implements IDeckStrategy {

	@Override
	public ICardPile createDeck() {
		NormalDeckFactory N = new NormalDeckFactory();
		return N.buildDeck();
	}

}
