package model.card.type;

import controller.IController;
import model.IGameLogic;

public class ColorCard extends AbstractCard {

	public ColorCard() {
		super(Symbol.WILD, Color.NONE);
	}
	
	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return true;
	}
	
	@Override
	public boolean isFirstPlayable() {
		return false;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		this.color = game.getCurrentPlayer().selectColor(game, ctrl);
	}
	
}
