package model;

import controller.IController;
import model.card.type.ICard;
import model.player.type.IPlayer;
import model.player.IPlayerManager;
import model.card.ICardPilesManager;

public class GameLogic implements IGameLogic {
	
	protected IPlayerManager pm;
	protected ICardPilesManager cpm;
	protected int DrawWell = 0;
	
	public GameLogic(IPlayerManager playermanager, ICardPilesManager cardpilesmanager) {
		this.pm = playermanager;
		this.cpm = cardpilesmanager;
	}

	@Override
	public boolean hasEnded() {
		return this.getCurrentPlayer().getHandSize() == 0;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return this.pm.getCurrentPlayer();
	}

	@Override
	public ICard getCurrentPlayedCard() {
		return this.cpm.getCurrentPlayedCard();
	}

	@Override
	public void autoShoutUNO(IController ctrl) {
		if(!this.getCurrentPlayer().hasSaidUNO() && this.getCurrentPlayer().hasOneCard()) {
			ctrl.showMessage("UNO!");
			this.getCurrentPlayer().setSaidUNO(true);
		}
	}

	@Override
	public void startTurn(IController ctrl) {
		this.autoShoutUNO(ctrl);
		this.pm.startTurn();
	}

	@Override
	public void skipPlayer(IController ctrl) {
		this.startTurn(ctrl);;
	}

	@Override
	public void addToDrawWell(int number) {
		this.DrawWell += number;
	}

	@Override
	public void resetDrawWell() {
		this.DrawWell = 0;
	}

	@Override
	public boolean isDrawWellEmpty() {
		return this.DrawWell == 0;
	}

	@Override
	public void drawCardsFromWell(IPlayer player, IController ctrl) {
		this.cpm.addCardsToPlayer(player, DrawWell);
		ctrl.showMessage(player + " ha robado " + DrawWell+ " cartas del mazo.");
	}

	@Override
	public void invertDirection() {
		this.pm.invertDirection();
	}

	@Override
	public boolean playCard(ICard playedCard, IController ctrl) {
		if(!playedCard.isPlayableOver(this.getCurrentPlayedCard())){
			ctrl.showMessage("No puedes jugar esa carta.");
			return false;
		}
		else {
			cpm.discard(playedCard);
			this.getCurrentPlayer().removeCardFromHand(playedCard);
			playedCard.executeAction(this, ctrl);
			ctrl.updatePlayedCard();
			return true;
		}
	}

	@Override
	public ICard drawOneCard(IPlayer player) {
		return this.cpm.addCardsToPlayer(player, 1).get(0);
	}

	@Override
	public void announceWinner(IController ctrl) {
		ctrl.showMessage("EL ganador es el " + this.getCurrentPlayer());
	}

}
