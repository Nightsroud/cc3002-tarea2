package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerListBuilder implements IPlayerListBuilder {
	
	protected ArrayList<IPlayer> players = new ArrayList<>();
	
	public PlayerListBuilder() {
		this.players.clear();
	}
	
	@Override
	public void addPlayer(IPlayer player) {
		this.players.add(player);
	}

	@Override
	public ArrayList<IPlayer> buildPlayerList() {
		return this.players;
	}

}
