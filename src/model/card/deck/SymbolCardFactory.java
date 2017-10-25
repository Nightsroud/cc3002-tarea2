package model.card.deck;

import model.card.type.Color;
import model.card.type.*;
import model.card.type.Symbol;

public class SymbolCardFactory implements ICardFactory {

	@Override
	public ICard buildCard(Symbol symbol, Color color) {
		if(symbol.equals(Symbol.DRAW_TWO)) {
			Plus2Card p2 = new Plus2Card(color);
			return p2;
		}
		else if(symbol.equals(Symbol.SKIP)) {
			SkipCard sk = new SkipCard(color);
			return sk;
		}
		else {
			InvertCard in = new InvertCard(color);
			return in;
		}
	}

}
