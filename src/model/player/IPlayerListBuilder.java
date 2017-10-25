package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;


public interface IPlayerListBuilder {

  /**
   * Adds a player to the list of players.
   * @param player player to be added.
   */
  void addPlayer(IPlayer player);

  /**
   * Returns the list of players and resets the object;
   * @return list of players
   */
  ArrayList<IPlayer> buildPlayerList();

}
