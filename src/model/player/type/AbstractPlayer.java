package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;


public abstract class AbstractPlayer implements IPlayer {
	
	protected ArrayList<ICard> hand = new ArrayList<>();
	protected boolean UNOstatus = false;	

	@Override
	public void addToHand(ArrayList<ICard> hand) {
		this.hand.addAll(hand);
	}

	@Override
	public boolean hasWon() {
		return this.getHandSize() == 0;
	}

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		int pos = ctrl.AskForCardFromHand(this);
		if(pos >= this.getHandSize() || pos < 0)
			return new NullCard();
		else
			return this.getCardFromHand(pos);
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		return ctrl.askForColor();
	}

	@Override
	public int getHandSize() {
		return this.hand.size();
	}

	@Override
	public boolean hasOneCard() {
		return this.getHandSize() == 1;
	}

	@Override
	public ArrayList<ICard> getHand() {
		return this.hand;
	}

	@Override
	public void setSaidUNO(boolean status) {
		this.UNOstatus = status;
	}

	@Override
	public boolean hasSaidUNO() {
		return this.UNOstatus;
	}

	@Override
	public void removeCardFromHand(ICard card) {
		if(card.isDiscardable())
			this.hand.remove(card);
	}

	@Override
	public boolean needsToDrawCard(ICard currentCard) {
		return !currentCard.isDiscardable();
	}

	@Override
	public ICard getCardFromHand(int number) {
		return this.hand.get(number);
	}
	
	@Override
	public String toString() {
		String retorno = "you";
		return retorno;
	}

}
