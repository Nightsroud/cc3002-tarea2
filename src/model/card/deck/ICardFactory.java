package model.card.deck;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

public interface ICardFactory {
	
	public ICard buildCard(Symbol symbol,Color color);
}
