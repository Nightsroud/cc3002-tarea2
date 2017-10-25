package model.card.type;

import controller.IController;
import model.IGameLogic;

public abstract class AbstractCard implements ICard {
	
	protected Symbol symbol;
	protected Color color;
	
	public AbstractCard (Symbol s, Color c) {
		this.symbol = s;
		this.color = c;
	}
	
	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return (this.getColor().equals(otherCard.getColor())) || (this.getSymbol().equals(otherCard.getSymbol()));
	}

	@Override
	public boolean isFirstPlayable() {
		return true;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Symbol getSymbol() {
		return this.symbol;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
	}

	@Override
	public boolean isDiscardable() {
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append(this.symbol.getName());
		retorno.append(' ');
		retorno.append(this.color.getName());
		return retorno.toString();
	}

}
