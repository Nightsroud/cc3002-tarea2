package view;

import model.IGameLogic;
import model.card.type.ICard;
import model.player.type.IPlayer;

/**
 * View of the game. It uses the console output for showing information.
 * 
 * @author eriveros
 *
 */
public class ConsoleView {

  IGameLogic game;

  /**
   * Constructor of the view. Associates a game to it.
   * 
   * @param game
   */
  public ConsoleView(IGameLogic game) {
    this.game = game;
  }

  /**
   * Updates the current status of the game.
   */
  public void updateCurrentStatus() {
    System.out.println("[Turno Actual]: " + game.getCurrentPlayer().toString());
  }

  /**
   * Shows a player's hand.
   * 
   * @param player player with the hand you need to show.
   */
  public void showPlayerHand(IPlayer player) {
    System.out.println("[Mano]:");
    int i = 0;
    for (ICard card : player.getHand()) {
      System.out.println(i + ") " + card.toString());
      i++;
    }
  }
  
  /**
   * Shows a custom message.
   * 
   * @param message custom message
   */
  public void showMessage(String message) {
    System.out.println(message);
  }

  /**
   * Shows the last card played.
   * 
   * @param player
   * @param card
   */
  public void updatePlayedCard() {
    System.out.println("[Carta Descartada]: " + game.getCurrentPlayedCard().toString());
  }

}
