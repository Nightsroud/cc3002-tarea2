package model.card.deck;

import model.card.*;
import model.card.type.Color;
import model.card.type.Symbol;

public class TestDeckStrategy implements IDeckStrategy {

	@Override
	public ICardPile createDeck() {
		CardPiles deck = new CardPiles();
		return deck;
	}
	
	public ICardPile addNumeric(ICardPile deck, Symbol symbol, Color color) {
		NumericCardFactory N = new NumericCardFactory();
		deck.pushCard(N.buildCard(symbol, color));
		return deck;
	}
	
	public ICardPile addSymbol(ICardPile deck, Symbol symbol, Color color) {
		SymbolCardFactory S = new SymbolCardFactory();
		deck.pushCard(S.buildCard(symbol, color));
		return deck;
	}
	
	public ICardPile addWild(ICardPile deck, Symbol symbol, Color color) {
		WildCardFactory W = new WildCardFactory();
		deck.pushCard(W.buildCard(symbol, color));
		return deck;
	}
	
}
