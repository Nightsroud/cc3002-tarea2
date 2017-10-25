package model.card.deck;


import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.Symbol;

public class NumericCardFactory implements ICardFactory {


	@Override
	public ICard buildCard(Symbol symbol, Color color) {
		NumericCard N = new NumericCard(symbol,color);
		return N;
	}

}
