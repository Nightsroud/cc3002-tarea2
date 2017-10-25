package model.player;
import controller.ConsoleController;
import model.*;
import model.card.*;
import model.card.deck.*;
import model.player.*;
import model.player.type.*;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 * @author eriveros
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    HumanPlayer you = new HumanPlayer();
    ComputerPlayer cpu1 = new ComputerPlayer();
    ComputerPlayer cpu2 = new ComputerPlayer();
    ComputerPlayer cpu3 = new ComputerPlayer();
    ICardPile discard = new CardPiles();
    ICardPile deck = new CardPiles();
    IDeckStrategy strats = new NormalStrategy();
    deck = strats.createDeck();
    deck.shuffle();
    ICardPilesManager cardManager = new CardPilesManager(deck, discard);
    you.addToHand(cardManager.drawCards(7));
    cpu1.addToHand(cardManager.drawCards(7));
    cpu2.addToHand(cardManager.drawCards(7));
    cpu3.addToHand(cardManager.drawCards(7));
    playerBuilder.addPlayer(you);
    playerBuilder.addPlayer(cpu1);
    playerBuilder.addPlayer(cpu2);
    playerBuilder.addPlayer(cpu3);
    IPlayerManager playerManager = new PlayerManager(playerBuilder.buildPlayerList());
    IGameLogic game = new GameLogic(playerManager, cardManager);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
}
