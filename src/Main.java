import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static Scanner scnr = new Scanner(System.in);
	static boolean currentlyPlaying = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while (currentlyPlaying) {
		// make and shuffle the deck
		ArrayList<Card> deck = Deck.createDeck();

		// create and deal the hands

		Hand dealer = new Hand();
		dealer.setDealer(true);
		Hand player = new Hand();
		player.setDealer(false);
		player.dealCard(deck.get(0), deck);
		dealer.dealCard(deck.get(0), deck);
		player.dealCard(deck.get(0), deck);
		dealer.dealCard(deck.get(0), deck);

		// show the hands and evaluate

		dealer.sumOfCardVal(dealer.getCards());
		player.sumOfCardVal(player.getCards());
		System.out.println(dealer.showHand(dealer));
		System.out.println(player.showHand(player));

		// player can now act on their hand
		String hit;
		do {
			System.out.println("Hit? (y/n)");
			hit = scnr.nextLine();
			if (hit.toLowerCase().contentEquals("y")) {
				player.dealCard(deck.get(0), deck);
			}
			System.out.println(player.showHand(player));
		} while (hit.contains("y") && (player.sumOfCardVal(player.getCards()) < 21));

		if (player.sumOfCardVal(player.getCards()) > 21) {
			System.out.println("Bust. You lose.");
		}

		// ending player turn starts dealer progress
		while (dealer.sumOfCardVal(dealer.getCards()) < 17) {
			dealer.dealCard(deck.get(0), deck);
		}
		
		
		winCondition(dealer, player);
		playAgain();

		}
	}
	
	public static void winCondition(Hand dealer, Hand player) {
		if (dealer.sumOfCardVal(dealer.getCards()) > player.sumOfCardVal(player.getCards())) {
			System.out.println(dealer.toString());
			System.out.println(player.toString());
			System.out.println("Dealer wins.");
		} else if (dealer.sumOfCardVal(dealer.getCards()) < player.sumOfCardVal(player.getCards())) {
			System.out.println(dealer.toString());
			System.out.println(player.toString());
			System.out.println("You win!");
		} else {
			System.out.println(dealer.toString());
			System.out.println(player.toString());
			System.out.println("Push!");
		}
	}
	
	public static void playAgain() {
		System.out.println("Another hand?");
		String playAgain = scnr.nextLine();
		if (playAgain.toLowerCase().contains("y")){
			currentlyPlaying = true;
		} else {
			currentlyPlaying = false;
		}
	}

}
