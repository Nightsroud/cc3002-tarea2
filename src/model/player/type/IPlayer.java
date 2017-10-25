package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

/**
 * Interface of a UNO game player.
 * 
 * @author eriveros
 *
 */
public interface IPlayer {

  /**
   * Adds the array of cards to the hand of the player.
   */
  void addToHand(ArrayList<ICard> hand);

  /**
   * Returns true if the player has won.
   * 
   * @return true if player has won.
   */
  boolean hasWon();

  /**
   * Gets a card to play in this turn and returns it.
   * 
   * @param game actual game logic
   * @param ctrl actual controller
   * @return a card for playing.
   */
  ICard getCardToPlay(IGameLogic game, IController ctrl);

  /**
   * Returns a color selected when a color change card is played.
   * 
   * @param game actual game logic
   * @param ctrl actual controller
   * @return a color selected by the player
   */
  Color selectColor(IGameLogic game, IController ctrl);

  /**
   * Returns the number of cards in the hand of the player.
   * 
   * @return number of cards in hand.
   */
  public int getHandSize();

  /**
   * Returns true if the player has only one card in hand.
   * 
   * @return
   */
  public boolean hasOneCard();

  /**
   * Returns an array with the cards in hand of the player
   * 
   * @return
   */
  public ArrayList<ICard> getHand();

  /**
   * Sets the player's UNO shouting status.
   * 
   * @param status new status of UNO shouting.
   */
  public void setSaidUNO(boolean status);

  /**
   * Returns true if the player has already said UNO.
   * 
   * @return true if the player has already said UNO.
   */
  public boolean hasSaidUNO();

  /**
   * Removes the specified card from the player's hand
   * 
   * @param card card to remove from player's hand.
   */
  void removeCardFromHand(ICard card);

  /**
   * Returns true if the player needs to draw a card.
   * 
   * @param current card card in play now.
   * @return true if the player needs to draw a card.
   */
  boolean needsToDrawCard(ICard currentCard);

  /**
   * Returns the number card from the hand of the player, or a NullCard if the card doesn't exist.
   * 
   * @param number number of card in hand
   * @return the number card from the player's hand. NullCard if it doesn't exist.
   */
  ICard getCardFromHand(int number);

}
