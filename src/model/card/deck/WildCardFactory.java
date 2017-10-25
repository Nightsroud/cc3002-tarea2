package model.card.deck;

import model.card.type.Color;
import model.card.type.*;
import model.card.type.Symbol;

public class WildCardFactory implements ICardFactory {

	@Override
	public ICard buildCard(Symbol symbol, Color color) {
		if(symbol.equals(Symbol.WILD_DRAW_FOUR)) {
			Plus4Card p4 = new Plus4Card();
			return p4;
		}
		else {
			ColorCard co = new ColorCard();
			return co;
		}
	}

}
