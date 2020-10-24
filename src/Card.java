
public class Card {

	private SUIT suit;
	private CARD_VALUE rank;

	public Card() {

	}

	public Card(SUIT suit, CARD_VALUE rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public SUIT getSuit() {
		return suit;
	}

	public void setSuit(SUIT suit) {
		this.suit = suit;
	}

	public CARD_VALUE getRank() {
		return rank;
	}

	public void setRank(CARD_VALUE rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

}
