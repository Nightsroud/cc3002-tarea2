package controller;

import model.card.type.Color;
import model.player.type.IPlayer;

/**
 * Interface for representing a UNO Game Controller
 * @author eriveros
 *
 */
public interface IController {
  
  /**
   * Asks for a color to a player
   * @return a color
   */
  public Color askForColor();
  
  /**
   * Asks for a card from hand to a player.
   * @param player player asked for a card.
   * @return a card from player's hand
   */
  public int AskForCardFromHand(IPlayer player);

  /**
   * Shows a random message to the view.
   * @param message message to show
   */
  public void showMessage(String message);
  
  /**
   * Plays a turn from start to end.
   */
  public void playTurn();

  /**
   * Updates the played card in the view.
   */
  void updatePlayedCard();
    
}
