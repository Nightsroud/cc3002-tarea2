package model;

import controller.IController;
import model.card.type.ICard;
import model.player.type.IPlayer;

/**
 * Represents the complete game logic.
 * @author eriveros
 *
 */
public interface IGameLogic {

  /**
   * Returns true if the game has ended. False otherwise.
   * @return true if game has ended.
   */
  boolean hasEnded();

  /**
   * Returns the current player.
   * @return current player
   */
  IPlayer getCurrentPlayer();

  /**
   * Returns the current played card.
   * @return current played card
   */
  ICard getCurrentPlayedCard();

  /**
   * Allows to autoshout UNO if a player has only one card.
   * @param ctrl
   */
  void autoShoutUNO(IController ctrl);

  /**
   * Prepares the turn to be initiated, changing the actual player, shouting UNO automatically,
   * assigning cards to players if the Draw Well is not empty
   * @param ctrl Controller used by the game.
   */
  void startTurn(IController ctrl);

  /**
   * Skips the next player's turn.
   */
  void skipPlayer(IController ctrl);

  /**
   * Adds cards to the draw well.
   * @param number
   */
  void addToDrawWell(int number);

  /**
   * Sets the number of cards in the draw well to zero.
   */
  void resetDrawWell();

  /**
   * Returns true if the draw well is empty.
   * @return true if the draw well is empty.
   */
  boolean isDrawWellEmpty();

  /**
   * Draws cards from well and announces it to the controller.
   * @param player player which is drawing the cards
   * @param ctrl controller used by the game.
   */
  void drawCardsFromWell(IPlayer player, IController ctrl);

  /**
   * Inverts the direction of the game
   */
  void invertDirection();

  /**
   * Plays a card, executing its action and putting it in the discard pile.
   * @param playedCard card played by the player.
   * @param ctrl controller of the game
   * @return true if the card was played.
   */
  boolean playCard(ICard playedCard, IController ctrl);

  /**
   * Draws one card from the deck. Also sets some state variables.
   * @param player
   */
  ICard drawOneCard(IPlayer player);

  /**
   * Announces the winner of the game, if there's any.
   * @param ctrl Controller of the game.
   */
  void announceWinner(IController ctrl);

}
