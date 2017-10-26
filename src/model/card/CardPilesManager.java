package model.card;

import java.util.ArrayList;

import model.card.type.ICard;
import model.player.type.IPlayer;

public class CardPilesManager implements ICardPilesManager {
	
	protected ICardPile deck;
	protected ICardPile discard;
	
	public CardPilesManager(ICardPile d, ICardPile dis) {
		this.deck = d;
		this.discard = dis;
		while(discard.isEmpty()) {
			ICard first = this.deck.popCard();
			if(!first.isFirstPlayable()) {
				this.deck.pushCard(first);
			}
			else
				this.discard.pushCard(first);
		}
	}

	@Override
	public void rebuildDeck() {
		if(this.deck.getSize() == 0) {
			ICard aux = this.discard.popCard();
			this.deck.pushCards(discard);
			this.discard.pushCard(aux);
		}

	}

	@Override
	public ICard drawCard() {
		this.rebuildDeck();
		return this.deck.popCard();
	}

	@Override
	public int getDrawableCardsNumber() {
		return this.deck.getSize() + this.discard.getSize() - 1;
	}

	@Override
	public ArrayList<ICard> drawCards(int cardsNumber) {
		ArrayList<ICard> cards = new ArrayList<>();
		for(int i = 0; i < cardsNumber; i++) {
			this.rebuildDeck();
			cards.add(this.deck.popCard());
		}
		return cards;
	}

	@Override
	public ICard getCurrentPlayedCard() {
		return this.discard.peekCard();
	}

	@Override
	public void discard(ICard newCard) {
		if(newCard.isDiscardable())
			this.discard.pushCard(newCard);
	}

	@Override
	public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
		ArrayList<ICard> toDraw = this.drawCards(number);
		player.addToHand(toDraw);
		return toDraw;
	}

}
