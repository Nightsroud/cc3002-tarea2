package model.player.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

public class ComputerPlayer extends AbstractPlayer {
	
	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		int contador = 0;
		for(int i = 0; i < this.getHandSize(); i++) {
			if(!this.getHand().get(i).isPlayableOver(game.getCurrentPlayedCard()))
				contador +=1;
		if(contador == this.getHandSize())
			return new NullCard();
		}
		Random rand = new Random();
		return this.getCardFromHand(rand.nextInt(this.getHandSize()));
	}
	
	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		ArrayList<Color> col = new ArrayList<>(Arrays.asList(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW));
		Random rand = new Random();
		return col.get(rand.nextInt(col.size()));
	}
	
	@Override
	public String toString() {
		String retorno = "Computer";
		return retorno;
	}
}
