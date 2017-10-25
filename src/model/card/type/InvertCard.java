package model.card.type;

import controller.IController;
import model.IGameLogic;

public class InvertCard extends AbstractCard {

	public InvertCard(Color c) {
		super(Symbol.INVERT, c);
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.invertDirection();
	}

}
