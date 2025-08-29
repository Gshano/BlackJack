package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {

    private BlackjackGame game;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("\nHouse holds:");
        // Display house cards (hide first card if not revealed)
        for (int i = 0; i < game.getHouseCards().getCards().size(); i++) {
            Card card = game.getHouseCards().getCards().get(i);
            if (i == 0 && !card.isFaceUp()) {
                System.out.println("?");
            } else {
                System.out.println(card);
            }
        }

        System.out.println("\nYou hold:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println(card);
        }
    }

    @Override
    public boolean hitMe() {
        System.out.print("Another card? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }

    @Override
    public void gameOver() {
        game.getHouseCards().getCards().get(0).setFaceUp(true); // Reveal house's hidden card

        System.out.println("Game over");
        display(); // Show final cards

        int playerScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());

        System.out.println("Your score: " + playerScore + ", House score: " + houseScore);

        if (playerScore > 21) {
            System.out.println("The House wins.");
        } else if (houseScore > 21) {
            System.out.println("You win.");
        } else if (playerScore > houseScore) {
            System.out.println("You win.");
        } else if (playerScore < houseScore) {
            System.out.println("The House wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }
}
