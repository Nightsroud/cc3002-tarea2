package model.card.type;

import controller.IController;
import model.IGameLogic;

public class Plus2Card extends AbstractCard {

	public Plus2Card(Color c) {
		super(Symbol.DRAW_TWO, c);
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.skipPlayer(ctrl);
		game.addToDrawWell(2);
		game.getCurrentPlayer().setSaidUNO(false);
		game.drawCardsFromWell(game.getCurrentPlayer(), ctrl);
		game.resetDrawWell();
	}

}
