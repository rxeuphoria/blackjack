import java.util.ArrayList;

public class Hand {

	private boolean dealer;
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Hand(ArrayList<Card> cards, boolean dealer) {
		super();
		this.dealer = dealer;
		this.cards = cards;
	}

	public Hand() {

	}

	public void dealCard(Card card, ArrayList<Card> deck) {
		this.cards.add(card);
		deck.remove(0);

	}

	public int sumOfCardVal(ArrayList<Card> cards) {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getRank().getNumValue();
		}
		return sum;
	}

	// dealers always stay at 17+
	public String showHand(Hand hand) {
		if (dealer) {
			return ("The dealer shows " + cards.get(1));
		} else {
			System.out.println("Current card value: " + hand.sumOfCardVal(hand.getCards()));
			return "Your cards are: " + hand.getCards().toString();

		}

	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Dealer " + dealer + " : " + cards;
	}

}
