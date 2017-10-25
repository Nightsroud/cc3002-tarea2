package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NullCard extends AbstractCard {

	public NullCard() {
		super(null, null);
	}
	
	@Override
	public boolean isFirstPlayable() {
		return false;
	}
	
	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return true;
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		ICard card = game.drawOneCard(game.getCurrentPlayer());
		game.getCurrentPlayer().setSaidUNO(false);
		game.playCard(card, ctrl);
	}
	
	@Override
	public boolean isDiscardable() {
		return false;
	}
}
