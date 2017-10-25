package model.card;

import model.card.type.ICard;


public interface ICardPile {

  /**
   * Returns the size of the card pile.
   * @return card pile's size.
   */
  int getSize();

  /**
   * Puts a card at top of the card pile.
   * @param newCard card to put at top of the pile.
   * @return the card pushed into the pile
   */
  ICard pushCard(ICard newCard);

  /**
   * Removes the card at top of the pile and returns it.
   * @return the top card of the pile.
   */
  ICard popCard();

  /**
   * Gets a peek of the top card of the pile, without removing it.
   * @return the top card of the pile.
   */
  ICard peekCard();

  /**
   * Shuffles the card pile.
   */
  void shuffle();

  /**
   * Returns true if the pile is empty. False otherwise.
   * @return true if pile is empty.
   */
  boolean isEmpty();

  /**
   * Merges another pile of card into this pile, emptying the first one.
   * @param otherPile the other pile of cards.
   */
  void pushCards(ICardPile otherPile);

}
