/** Card
 * You must comment all fields and methods in this file.
 * @author William Kreahling, Nicholas Buchanan, Kevin Richardson
 * @since 3/16/21
 */
/** <h1> Fields of Card </h1>
 *
 * rank - is the how highly valued the card is.
 * points - is how much the card is worth mostly based on position enum except for
 * the last 3
 * Suit - Enum listing tokens for the different card suits
 * Face - Enum listing different tokens for each cards face.
 */

enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
enum Face {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    private int rank;
    private int points;

    /** <h1> Face() </h1>
     * <p>
     * A constructor for the Face enumeration which call two other methods to
     * distribute the rank and points for each enum type.
     */
    private Face() {
        rankDistribute();
        pointDistribute();
    }

    /** <h1> pointDistribute() </h1>
     * <p>
     * Distribute the points for each enum type. Everything except Jack, Queen,
     * and King get points based on their position.
     * These exceptional ones get 10 points versus any point of 1 through 10.
     */
    public void pointDistribute() {
        String front = this.name();
        int index = this.ordinal();
        if(front != "JACK" && front != "QUEEN"
                && front != "KING") {
            points = index + 1;
        }
        else {
            points = 10;
        }
    }

    /** <h1> rankDistribute() </h1>
     * <p>
     * This method will update the rank field to line with every enum type's position.
     * It means Ace will be 1 since it is 0th position.
     */
    public void rankDistribute() {
        int index = this.ordinal();
        rank = index + 1;
    }

    /** <h1> getRank() </h1>
     * <p>
     * This method will return the value of the field, rank.
     * @return rank contains the value of rank is not to be confused with points.
     */
    public int getRank() {
        return rank;
    }

    /** <h1> getRank() </h1>
     * <p>
     * This method return the value of the field, points.
     * @return points contains the value of a card from 1 to 10.
     */
    public int getPoints() {
        return points;
    }
}

/** <h1> Card </h1>
 * <p>
 * The Card class represents one card that has two fields.
 * name - Represents the name of the card
 * suit - Represents the suit of the card
 */
public class Card {
    private Face name;
    private Suit suit;

    /** <h1> Card Constructor </h1>
     * The default constructor for the Card which will set fields the values
     * asked in the parameters.
     * @param name a object of the Face enum.
     * @param suit a object of the Suit enum.
     */
    public Card(Face name, Suit suit) {
        this.name = name;
        this.suit = suit;
    }

    /** <h1> getName() </h1>
     * <p>
     * This method will return the name field.
     * @return name - a object of the Face enum.
     */
    public Face getName() {
        return name;
    }

    /** <h1> getSuit </h1>
     * <p>
     * This method will return the suit field.
     * @return suit - a object of the Suit enum.
     */
    public Suit getSuit() {
        return suit;
    }

    /** <h1> rank() </h1>
     * <p>
     * This method will call the getRank method from the Face enum to obtain
     * the rank of the Face value.
     * @return a integer representing the rank of a Face enum.
     *
     * <p>
     * This method will get the points of the Face enum.
     * @return a integer that represents the points of a given Face num.
     */
    public int rank() {
        return name.getRank();
    }

    /** <h1> value </h1>
     * <p>
     * This method will return the ordinal of the name field + 1
     * @return name.ordinal() + 1
     */
    public int value() {
        return name.ordinal() + 1;
    }

    /** <h1> toString() </h1>
     * <p>
     * This method return the string format of the fields that is used in this class.
     * @return a string that formats the field name and suit into string that is readable.
     */
    public String toString() {
        return String.format("%5s of %s", name.toString(), suit.toString());
    }

    /**
     * Compare the ranks of two cards.
     * @return a value less than 0 if the rank of 'this' card is less than the one passed in, 0 if
     * the ranks of the cards are equal and a value greater than 0 if the rank of 'this' card is
     * greater than the rank of the one passed in.
     *
     * Note: This method works ONLY if another Card object is passed in as a parameter.
     */
    public int compareTo(Object other) {
        return this.name.getRank() - ((Card)other).name.getRank();
    }


    //Tester function to compare cards
    public static void main(String args[]) {

        Card one = new Card(Face.QUEEN, Suit.HEARTS);
        Card two = new Card(Face.JACK, Suit.DIAMONDS);

        if (one.compareTo(two) < 0) {
            System.out.println(one + "\n\tis less than than\n" + two);
        } else if (one.compareTo(two) > 0) {
            System.out.println(one + "\n\tis greater than\n" + two);
        } else {
            System.out.println(one + "\nand\n" + two + "\nARE EQUAL");;
        }
    }
}

