package model.card.type;

import controller.IController;
import model.IGameLogic;

public class Plus4Card extends AbstractCard {

	public Plus4Card() {
		super(Symbol.WILD_DRAW_FOUR, Color.NONE);
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
		game.skipPlayer(ctrl);
		game.addToDrawWell(4);
		game.getCurrentPlayer().setSaidUNO(false);
		game.drawCardsFromWell(game.getCurrentPlayer(), ctrl);
		game.resetDrawWell();
	}
	
}
