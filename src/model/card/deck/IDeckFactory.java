package model.card.deck;

import model.card.*;

public interface IDeckFactory {
	
	public ICardPile buildDeck();
}
