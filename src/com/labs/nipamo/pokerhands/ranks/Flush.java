package com.labs.nipamo.pokerhands.ranks;

import com.labs.nipamo.pokerhands.Hand;
import com.labs.nipamo.pokerhands.enums.Face;
import com.labs.nipamo.pokerhands.enums.Rank;
import com.labs.nipamo.pokerhands.enums.Suit;

public class Flush implements IRank {
	private Face score;
	private Suit suit1;
	private Suit suit2;
	private Suit suit3;
	private Suit suit4;
	private Suit suit5;
	
	@Override
	public boolean isRank(Hand h) {
		h.setRank(Rank.FLUSH);

		suit1 = h.getCard(0).getSuit();
		suit2 = h.getCard(1).getSuit();
		suit3 = h.getCard(2).getSuit();
		suit4 = h.getCard(3).getSuit();
		suit5 = h.getCard(4).getSuit();

		int first = suit1.ordinal();
		if (suit2.ordinal() == first + 1 &&
			suit3.ordinal() == first + 2 &&
			suit4.ordinal() == first + 3 &&
			suit5.ordinal() == first + 4)
			return true;
				
		return false;
	}
	
	@Override
	public void setScore(Hand h) {		
		score = h.getCard(0).getFace();
		
		for (int i = 0; i < 5; i++) {
			if (score.compareTo(h.getCard(i).getFace()) < 0)
				score = h.getCard(i).getFace();
		}
		
		h.setScore(score);
	}
}