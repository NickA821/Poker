import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/** <h1> Game </h1>
 * <p>
 * A class that will work with Card.java and Hand.java to
 * simulate a game of Poker in java.
 * @author Kevin Richardson and Nicholas Buchanan
 *@since 3/18/21
 */
public class Game {

    /**<h1> Fields </h1>
     * cardDeck - an array that is filled with 52 cards.
     * playerHand - a representation of the Player's in the form of an object.
     * comhand - a representation of the Computer's in the form of an object.
     */

    private Card[] cardDeck;
    private Hand playerHand;
    private Hand comHand;

    /** <h1> game() </h1>
     * <p>
     * A constructor that initializes the fields to default values.
     *Calls the deal() method after initializing fields
     */
    public Game() {
        this.cardDeck = new Card[52];
        this.playerHand = new Hand(5);
        this.comHand = new Hand(5);
        deal();
    }



    /** <h1> displayHand </h1>
     * <p>
     * This method will print off the Player and the Computer's hand when given that hand.
     * @param targetHand - a reference to either Player and Computer's hand.
     */
    public void displayHand(Hand targetHand) {
        if(targetHand == playerHand) {
            System.out.println("\nPlayer:\n" + playerHand.toString() + "\n");
        }
        else {
            System.out.println("\nComputer:\n" + comHand.toString() + "\n");
        }
    }

    /** <h1> shuffle </h1>
     * <p>
     * This method will add in the cards into the deck. It follows
     * the normal tradition of 13 Faces and 4 Suits.
     */
    public Card shuffle() {
        Random randObj = new Random();
        int shufFace = randObj.nextInt(13);
        int shufSuit = randObj.nextInt(4);
        Card shuffleCard = new Card(Face.values()[shufFace], Suit.values()[shufSuit]);
        return shuffleCard;
    }

    /** <h1> deal() </h1>
     * <p>
     * A method that will iterate through both the Player's and
     * Computer's hand to set a card each index. It will
     * stop after the 4th index. This will update the respective
     * fields.
     */
    public void deal() {
            Hand[] dealAll = {playerHand, comHand};
        for(int h = 0; h < dealAll.length; h++) {
            for(int i = 0; i < 5; i++) {
                Card randCard = shuffle();
                dealAll[h].setCard(i, randCard);
            }
        }
    }
    /** <h1> dealOne </h1>
     * <p>
     * A method that will take one of the two Hand fields and set the
     * index that has no Cards to a random Card from the shuffle() method.
     * @param targetHand a reference to either the Player or Computer's hand.
     */
    public void dealOne(Hand targetHand) {
        for(int i = 0; i < targetHand.getCard().length; i++) {
            if(targetHand.getCard()[i] == null) {
                Card randCard = shuffle();
                targetHand.setCard(i, randCard);
            }
        }
    }

    /** <h1> printWinner() </h1>
     * <p>
     * A method that will check both Player and Computer's hand to see what
     * type of Hand both have. If the Player wins, a boolean representing
     * if the Computer won will be set to false and vice versa. If there's
     * a tie, the both hand are checked for the highest card and declares
     * who is the winner. If both hands contain the same highest card,
     * then it will check which suit is ranked higher. Furthermore, a
     * message will be printed to the console declare who won.
     */
    public void printWinner() {
        boolean comWins = false;
        if(playerHand.getHandType().ordinal() < comHand.getHandType().ordinal()) {
            comWins = false;
        }
        else if (playerHand.getHandType().ordinal() == comHand.getHandType().ordinal())
        {
            System.out.println("A tie has happened!");
            if(playerHand.getHighestCard().rank() > comHand.getHighestCard().rank()) {
                comWins = false;
            }
            else if(playerHand.getHighestCard() == comHand.getHighestCard()) {
                if(playerHand.getHighestCard().getSuit().ordinal() >
                        comHand.getHighestCard().getSuit().ordinal()) {
                    comWins = false;
                }
                else {
                    comWins = true;
                }
            }
            else {
                comWins = true;
            }

        }
        else
        {
            comWins = true;
        }
        if(comWins == false) {
            System.out.println("Player wins with a " + playerHand.getHandType());
        }
        else {
            System.out.println("Computer wins with a " + comHand.getHandType());
        }
    }

    /** <h1> go() </h1>
     * A method that will begin the game at Round 1. The player and
     * computer will be dealt 5 cards. The player will be asked how
     * many cards will they discard. If they remove a card, they will
     * be asked which index will they remove and the user can input
     * a integer. The program will set the Card with that index to null.
     * If they choose no card to discard, the program will move to Phase 2.
     * Phase 2 will deal a hand to the Player, print the Player's hand
     * toString method, and call the printWinner method.
     */
    public void go() {
        Scanner inputObject = new Scanner(System.in);
        int rounds = 3;
        System.out.println("Game begins now!");
        for (int i = 0; i < rounds; i++) {
            deal();
            displayHand(playerHand);
            System.out.println("How many cards would you like to discard?");
            int dis = inputObject.nextInt();
            for (int j = 0; j < dis; j++) {
                System.out.println("Which card would you like to discard? >");
                int cardNum = inputObject.nextInt();
                playerHand.getCard()[cardNum] = null;
                dealOne(playerHand);
            }
            displayHand(comHand);
            displayHand(playerHand);
            printWinner();
        }
    }

    /** <h1> main </h1>
     * This method will set up the game class and call the
     * go method to begin the gane.
     * @param args
     */
    public static void main(String[] args) {
        Game set = new Game();
        set.go();
    }
}

