package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerManager implements IPlayerManager {
	
	protected ArrayList<IPlayer> players;
	protected int turno = 0;
	protected Direction dir = Direction.CLOCKWISE;
	
	public PlayerManager(ArrayList<IPlayer> p) {
		this.players = p; 
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return this.getPlayers().get(turno);
	}

	@Override
	public ArrayList<IPlayer> getPlayers() {
		return this.players;
	}

	@Override
	public void invertDirection() {
		if(this.dir == Direction.CLOCKWISE)
			this.dir = Direction.COUNTERCLOCKWISE;
		else
			this.dir = Direction.CLOCKWISE;
	}

	@Override
	public void startTurn() {
		if(dir == Direction.COUNTERCLOCKWISE && this.turno == this.getPlayers().size() - 1)
			this.turno = 0;
		else if(dir == Direction.CLOCKWISE && this.turno == 0)
			this.turno = this.getPlayers().size() - 1;
		else
			this.turno +=dir.getValue();
	}

	@Override
	public void skipPlayer() {
		this.startTurn();
	}
}
