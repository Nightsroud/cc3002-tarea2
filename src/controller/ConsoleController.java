package controller;

import java.util.Scanner;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.player.type.IPlayer;
import view.ConsoleView;

/**
 * A controller which use standard input from console.
 * @author eriveros
 *
 */
public class ConsoleController implements IController {

  IGameLogic game;
  ConsoleView view;
  Scanner in;

  /**
   * Controller constructor. Initializes model, view, and input method.
   * Also, it plays the card in discard pile.
   * @param game
   * @param viewand
   */
  public ConsoleController(IGameLogic game, ConsoleView view) {
    this.view = view;
    this.game = game;
    this.in = new Scanner(System.in);
    showMessage("¡Bienvenido a JavaUNO!");
    game.getCurrentPlayedCard().executeAction(game, this);
  }

  @Override
  public void playTurn() {
    game.startTurn(this);
    view.updateCurrentStatus();
    IPlayer currentPlayer = game.getCurrentPlayer();
    boolean cardPlayed = false;
    while (!cardPlayed) {
      ICard card = currentPlayer.getCardToPlay(game, this);
      cardPlayed = game.playCard(card, this);
    }
  }

  @Override
  public Color askForColor() {
    view.showMessage("Elige un color:");
    int i = 0;
    for (Color color : Color.getColors()) {
      System.out.println(""+i+") "+color.getName());
      i++;
    }
    int num = -1;
    while (num < 0 || num >= 4) {
      System.out.println("Por favor, ingresar un número entre el 0 y el 3.");
      num = in.nextInt();
    }
    return Color.getColors()[num];
  }

  @Override
  public int AskForCardFromHand(IPlayer player) {
    int num = -1;
    view.showPlayerHand(player);
    view.showMessage(""+player.getHandSize()+") Robar una carta del mazo e intentar jugarla si es posible.");
    while (num < 0 || num > player.getHandSize()) {
      view.showMessage(
          "Por favor, ingresar un número entre el 0 y el " + player.getHandSize() + ".");
      num = in.nextInt();
    }
    return num;
  }

  @Override
  public void showMessage(String message) {
    view.showMessage(message);
  }
  
  @Override
  public void updatePlayedCard() {
    view.updatePlayedCard();
  }

}
