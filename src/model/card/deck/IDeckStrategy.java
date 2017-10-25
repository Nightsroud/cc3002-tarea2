package model.card.deck;

import model.card.ICardPile;

/**
 * This interface allows to specify a Deck Generation Strategy
 * @author eriveros
 *
 */
public interface IDeckStrategy {
  
  /**
   * Creates a UNO Deck, i.e. a collection of UNO Cards.
   * @return a collection of UNO Cards
   */
    public ICardPile createDeck();
}
