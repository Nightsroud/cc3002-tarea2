
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
    HumanPlayer jugador1 = new HumanPlayer();
    ComputerPlayer jugador2 = new ComputerPlayer();
    ComputerPlayer jugador3 = new ComputerPlayer();
    ComputerPlayer jugador4 = new ComputerPlayer();
    ICardPile discard = new CardPiles();
    ICardPile deck = new CardPiles();
    IDeckStrategy strats = new NormalStrategy();
    deck = strats.createDeck();
    deck.shuffle();
    ICardPilesManager cardManager = new CardPilesManager(deck, discard);
    jugador1.addToHand(cardManager.drawCards(7));
    jugador2.addToHand(cardManager.drawCards(7));
    jugador3.addToHand(cardManager.drawCards(7));
    jugador4.addToHand(cardManager.drawCards(7));
    playerBuilder.addPlayer(jugador1);
    playerBuilder.addPlayer(jugador2);
    playerBuilder.addPlayer(jugador3);
    playerBuilder.addPlayer(jugador4);
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
