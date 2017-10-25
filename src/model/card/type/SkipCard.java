package model.card.type;

import controller.IController;
import model.IGameLogic;

public class SkipCard extends AbstractCard {

	public SkipCard(Color c) {
		super(Symbol.SKIP, c);
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.skipPlayer(ctrl);
	}
}
