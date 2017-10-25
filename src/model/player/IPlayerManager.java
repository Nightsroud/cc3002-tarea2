package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public interface IPlayerManager {

  /** 
   * Returns the current player
   * @return current player
   */
  IPlayer getCurrentPlayer();

  /**
   * Returns the list of players
   * @return list of players
   */
  ArrayList<IPlayer> getPlayers();

  /**
   * Inverts the direction of playing.
   */
  void invertDirection();

  /**
   * Starts the turn, assigning the new current player and the new next player.
   */
  void startTurn();

  /**
   * Skips the next player's turn
   */
  void skipPlayer();

}
