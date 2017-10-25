package model.card;

import model.card.type.ICard;
import java.util.Stack;
import java.util.Collections;

public class CardPiles implements ICardPile {
	
	protected Stack<ICard> pile = new Stack<>();
	

	@Override
	public int getSize() {
		return pile.size();
	}

	@Override
	public ICard pushCard(ICard newCard) {
		return this.pile.push(newCard);
	}

	@Override
	public ICard popCard() {
		return this.pile.pop();
	}

	@Override
	public ICard peekCard() {
		return this.pile.peek();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(this.pile);
	}

	@Override
	public boolean isEmpty() {
		return this.pile.isEmpty();
	}

	@Override
	public void pushCards(ICardPile otherPile) {
		for(int i = 0; i < otherPile.getSize(); i++) {
			ICard aux = otherPile.popCard();
			this.pushCard(aux);
		}
		this.shuffle();
	}

}
