package model.card.deck;

import model.card.*;
import model.card.type.Color;
import model.card.type.Symbol;
import java.util.ArrayList;
import java.util.Arrays;

public class NormalDeckFactory implements IDeckFactory {
	
	@Override
	public ICardPile buildDeck() {
		ArrayList<Symbol> num = new ArrayList<>(Arrays.asList(Symbol.ZERO, Symbol.ONE, Symbol.TWO, Symbol.THREE, Symbol.FOUR, Symbol.FIVE, Symbol.SIX, Symbol.SEVEN, Symbol.EIGHT, Symbol.NINE));
		ArrayList<Symbol> sym = new ArrayList<>(Arrays.asList(Symbol.INVERT, Symbol.SKIP, Symbol.DRAW_TWO));
		ArrayList<Symbol> wild = new ArrayList<>(Arrays.asList(Symbol.WILD_DRAW_FOUR, Symbol.WILD));
		Color[] col = Color.getColors();
		CardPiles deck = new CardPiles();
		NumericCardFactory N = new NumericCardFactory();
		SymbolCardFactory S = new SymbolCardFactory();
		WildCardFactory W = new WildCardFactory();
		for(int i = 0; i<num.size();i++) {
			for(int j = 0; j< col.length; j++) {
				if(num.get(i).equals(Symbol.ZERO)) {
					deck.pushCard(N.buildCard(num.get(i), col[j]));;
				}
				else {
				deck.pushCard(N.buildCard(num.get(i), col[j]));
				deck.pushCard(N.buildCard(num.get(i), col[j]));
				}
			}
		}
		for(int i = 0; i < wild.size(); i++) {
			for(int j = 0; j < 4; j++) {
				deck.pushCard(W.buildCard(wild.get(i), Color.NONE));
			}
		}
		for(int i = 0; i < sym.size(); i++) {
			for(int j = 0; j < col.length; j++) {
				deck.pushCard(S.buildCard(sym.get(i), col[j]));
				deck.pushCard(S.buildCard(sym.get(i), col[j]));
			}
		}
		return deck;
	}

}
