import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	public static ArrayList<Card> createDeck() {

		ArrayList<Card> deck = new ArrayList<Card>();

		for (SUIT suit : SUIT.values()) {
			for (CARD_VALUE rank : CARD_VALUE.values()) {

				deck.add(new Card(suit, rank));
			}
		}

		Collections.shuffle(deck);
		return deck;
	}
	
}
