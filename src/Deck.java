import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//this started as making a deck object, but then got repurposed into just a way to separate deck creation.
//This can be moved into its own method in the main file if I needed.  
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
