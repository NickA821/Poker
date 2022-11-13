import java.util.Arrays;



/** <h1> Hand </h1>
 * The Hand class will change the cards in the user's hand, can detect what type of Hand it is,
 * and will sort the cards in the hand by ascending order.
 * <p>
 * Hand file will modify the hand and determine what the Hand represents.
 *@author Kevin Richardson and Nicholas Buchanan
 *@version 1.0
 *@since 03/18/20
 */
public class Hand {

    /** <h1> Enum </h1>
     * WinHand will label all possible hands and distribute points to each label. This is refer to as
     * rank.
     * <p>
     * The WinHand provide a label for what type of Hand is Highest from descending order.
     *@version 1.0
     *@since 03/18/20
     */

    enum WinHand {ROYALFLUSH, STRAIGHTFLUSH, FOURKIND, FULLHOUSE, FLUSH, STRAIGHT, THREEKIND, TWOPAIR, PAIR, HIGH}
    private Card[] cards;

    /** <h1> Hand </h1>
     *
     * @param numCards - is a integer that represent how large the card array
     * should be.
     * <p>
     * This is a constructor that will create the card array based on the
     * parameter given.
     */
    public Hand(int numCards) {
        this.cards = new Card[numCards];
    }

    /** <h1> Hand </h1>
     * <p>
     * A constructor that will call the other constructor with 5 since we
     * will play with only 5 cards.
     */
    public Hand() {
        this(5);
    }

    /**
     * <h1> setCard </h1>
     * <p>
     * this method will use the index to set the position for where the parameter
     * card will go.
     * @param index - a integer that will index through the array.
     * @param replaceCard - a object of the class Card which will be placed into
     * the array.
     */
    public void setCard(int index, Card replaceCard) {
        this.cards[index] = replaceCard;
    }

    /** <h1> getHandType </h1>
     * <p>
     * this method will determine what type of Hand the user has and will return
     * the best representation of the user's hand. Each hand type is placed from
     * worst to best. If no other hand fits the user's current series of cards
     * then it will default to High Card win.
     * @return winningHand is a object of the enumeration.
     */
    public WinHand getHandType() {
        WinHand winningHand = WinHand.HIGH;
        if(pair() == true) {
            winningHand = WinHand.PAIR;
        }
        if(twoPair() == true) {
            winningHand = WinHand.TWOPAIR;
        }
        if(threeOfAKind() == true) {
            winningHand = WinHand.THREEKIND;
        }
        if(flush() == true) {
            winningHand = WinHand.FLUSH;
        }
        if(straight() == true) {
            winningHand = WinHand.STRAIGHT;
        }
        if(fullHouse() == true) {
            winningHand = WinHand.FULLHOUSE;
        }
        if(fourOfAKind() == true) {
            winningHand = WinHand.FOURKIND;
        }
        if(straightFlush() == true) {
            winningHand = WinHand.STRAIGHTFLUSH;
        }
        if(royalFlush() == true) {
            winningHand = WinHand.ROYALFLUSH;
        }
        return winningHand;
    }

    /**<h1> getCard() </h1>
     * <p>
     * returns the user's Cards array.
     * @return cards - An array holding every card.
     */
    public Card[] getCard() {
        return cards;
    }

    //Helper Methods of getHandType()

    /** <h1> getPair() </h1>
     * <p>
     * This method will find a pair of cards and determine which is the highest
     * then it will return the highest card. It will be asked if this is its first time
     * being called and if so will look for the largest pair. If not, it will kept the
     * smallest pair.
     * @return firstPair - a integer that contains the rank of the pairs.
     */
    public int getPair(boolean isPair) {
        int firstPair = 0;

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (cards[i].rank() == cards[j].rank() && i != j) {
                    if (!isPair || firstPair == 0 ) {
                        if (getThreeKind() == 0 && getFourKind() == 0) {
                            firstPair = cards[i].rank();
                        }

                    }
                    else {
                        if (cards[i].rank() < firstPair) {
                            firstPair = cards[i].rank();
                        }
                    }
                }
            }
        }
        return firstPair;
    }

    /** <h1> getThreeKind() </h1>
     * <p>
     * This method will find three cards that share the same rank and return
     * that rank.
     * @return trio - a integer that contains the rank of a three of a kind.
     */
    public int getThreeKind() {
        int trio = 0;
        float cnt = 0.0f;
        for (int i = 0; i < this.cards.length; i++) {
            for (int j = 0; j < this.cards.length; j++) {
                for (int k = 0; k < this.cards.length; k++) {
                    if (cards[i].rank() == cards[j].rank() && cards[i].rank() == cards[k].rank()) {
                        cnt += 1;
                        if (i != j && j != k && i != k && getFourKind() == 0) {
                            trio = cards[i].rank();
                        }
                    }
                }
            }
        }
        return trio;
    }

    /** <h1> getFourKind </h1>
     * <p>
     * This method will find four cards with all the same rank and return the rank
     * of those cards.
     * @return a integer that either 0 when no pair is found or the rank of the card when cards are found.
     */
    public int getFourKind() {
        int fourKind = 0;
        for (int i = 0; i < this.cards.length; i++) {
            for (int j = 0; j < this.cards.length; j++) {
                for (int k = 0; k < this.cards.length; k++) {
                    for (int f = 0; f < this.cards.length; f++) {
                        if (cards[i].rank() == cards[j].rank() && cards[i].rank() == cards[k].rank() && cards[i].rank()
                                == cards[f].rank()) {
                            if (i != j && i != k & i != f && j != k && j != f && k != f) {
                                fourKind = cards[i].rank();
                            }
                        }
                    }
                }
            }
        }
        return fourKind;
    }

    /** <h1> getHighestCard() </h1>
     * <p>
     * This method will find the highest rank card and return that value.
     *
     * @return a integer that represent the rank of card that is the highest in the Hand.
     */
    public Card getHighestCard() {
        int highVal = cards[0].rank();
        Card high = cards[0];
        int initVal;
        for (initVal = 1; initVal < cards.length; initVal++) {
            if (cards[initVal].rank() > highVal) {
                highVal = cards[initVal].rank();
                high = cards[initVal];
            }
        }
        return high;
    }

    /** <h1> royalFlush </h1>
     * <p>
     * The royalFlush method holds access to an array that contains the rank integers
     * required to earn this type of win. Using two for loops, the card array will
     * be asked if it has the ranks of 1, 10, 11, 12, and 13. If it find that the first
     * card of the field array, card equals the first card of the deckArr array then it
     * add up a total called count. Count is added by .20 so when all 5 cards are checked and
     * are equal to each other, it will equal 1. Finally, when this happens the program
     * knows the hand is a royalFlush/
     * @return isFlush - a boolean that will only prove true when 1,10,11,12, and 13 are
     * in the card array.
     */
    public boolean royalFlush() {
        boolean isFlush = false;
        int[] deckArr = {Face.ACE.getRank(), Face.TEN.getRank(), Face.JACK.getRank(), Face.QUEEN.getRank(),
                Face.KING.getRank()};
        float count = 0.0f;
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (cards[i].getSuit() == cards[j].getSuit() && cards[j].rank() == deckArr[j]) {
                    if (i != j) {
                        count += .20;
                    }
                    else if (count == 1.0) {
                        isFlush = true;
                    }
                }
            }
        }
        return isFlush;
    }

    /** <h1> straightFlush </h1>
     * <p>
     * This method will check to see if the previous card and the current card are equal to
     * each other when they are added by 1 and their suit are equivalent. Each time this
     * occurs, the variable overVal will be increased .25 because after 4 tests. This will
     * mean if everything test was a success it will equal 1, and then a straightFlush has
     * happened. So, isFlush is set true and returned.
     * @return isFlush - a boolean that will only check when a straight flush has happened.
     */
    public boolean straightFlush() {
        boolean isFlush = false;
        float overVal = 0.0f;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getSuit() == cards[i - 1].getSuit() && cards[i].rank() == (cards[i - 1].rank() + 1)) {
                overVal += .25;
            }
        }
        if (overVal == 1.0f) {
            isFlush = true;
        }
        return isFlush;
    }
    /** <h1> straight() </h1>
     * This method will check if a previous card when added by 1 will equal the next card. If
     * it happens, a counter will go by .25 and when it reaches 1. The programs know the hand
     * is a series so it has found the hand to be a straight Hand.
     *
     * @return isStraight - a boolean that determines whether or not the hand is a straight win.
     */
    public boolean straight() {
        boolean isStraight = false;
        float overVal = 0.0f;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].rank() == cards[i - 1].rank() + 1) {
                overVal += .25;
                if (overVal == 1.0 && !royalFlush() && !straightFlush()) {
                    isStraight = true;
                }
            }
        }
        return isStraight;
    }

    /** <h1> flush </h1>
     * <p>
     * A method that will check to see if the previous card is a different suit than the next one.
     * It will add up by .25 in the overVal local variable and when this variable = 1.0, then
     * the hand is flush.
     * @return flush - a boolean that determines whether or not the hand is a flush win.
     */
    public boolean flush() {
        boolean isFlush = false;
        float overVal = 0.0f;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getSuit() == cards[i - 1].getSuit()) {
                overVal += .25;
                if (overVal == 1.0 && !straightFlush()) {
                    isFlush = true;
                }
            }
        }
        return isFlush;
    }

    /** <h1> fourOfAKind </h1>
     * <p>
     * A method that will check to see if the getFourKind method got something other than a 0.
     * If so, the program knows the hand is a four of a kind and will return true because of it.
     * @return isFourKind - a boolean that means the hand has a four of a kind.
     */
    public boolean fourOfAKind() {
        boolean isFourKind = false;
        if (getFourKind() != 0) {
            isFourKind = true;
        }
        return isFourKind;
    }

    /** <h1> threeOfAKind </h1>
     * <p>
     * A method that will check to see if the getThreeKind found something that is not 0. If so,
     * the program will set a boolean to true and return that boolean.
     * @return threeKind - a boolean that let the program know a three of a kind is in the hand.
     */
    public boolean threeOfAKind() {
        boolean isThreeKind = false;
        if (getThreeKind() != 0) {
            isThreeKind = true;
        }
        return isThreeKind;
    }

    /** <h1> pair </h1>
     * <p>
     * A method that will check to see if the getPair method has found something that is not 0.
     * If so, then a boolean named pair is set to true and will return that boolean.
     * @return pair - a boolean that tells the program a pair was found in the card array.
     */
    public boolean pair() {
        boolean isPair = false;
        if (getPair(isPair) != 0) {
            isPair = true;
        }
        return isPair;
    }

    /** <h1> twoPair </h1>
     * <p>
     * A method go through two stages. One of them is calling the pair method to see
     * if there is a pair in the hand and to set it a variable.
     * If there is no pair, isTwoPair is set false and returns it. If there is a pair,
     * it will call the pair method again except a parameter of true is used instead of false.
     * This boolean tells the pair method get the lowest pair and return it. If there is a lower
     * pair and a higher pair then the isTwoPair variable is set to true and returned.
     * @return isTwoPair - a boolean that inform the program two pairs were found.
     */
    public boolean twoPair() {
        boolean isPair = false;
        boolean isTwoPair = false;
        int highPair = getPair(isPair);
        if (highPair != 0) {
            isPair = true;

            int lowestPair = getPair(isPair);
            if (lowestPair != 0) {

                if (highPair != lowestPair) {
                    isTwoPair = true;
                }
            }
        }
        return isTwoPair;
    }

    /** <h1> fullHouse </h1>
     * <p>
     * A method that will ask if a three of a kind is true then it will iterate through
     * the card array. When iterating through, it will ask if the previous card matches the current
     * card and the rank of the card is not part of the three of a kind.
     * @return isHouse - a boolean that returns if a full house is in the hand.
     */
    public boolean fullHouse() {
        boolean isHouse = false;

        if (getThreeKind() !=0) {
            for (int i = 1; i < cards.length; i++) {
                if (cards[i].rank() == cards[i - 1].rank() && cards[i].rank() != getThreeKind()) {
                    isHouse = true;
                }
            }
        }
        return isHouse;
    }

    /** <h1> toString </h1>
     * <p>
     * A method that will print off the object's information into a String
     * format.
     */
    public String toString() {
        String stringOutput = "";
        for (int i = 0; i < cards.length; i++) {
            stringOutput = (stringOutput + i + ": " + cards[i].getName().toString() + " of " +
                    cards[i].getSuit().toString() + "\n");
        }
        return stringOutput;
    }







    /**
     * This method will sort a hand into ascending order. Will only work in Java 8 or higher.
     * It makes the assumption that you have an array of N Cards named 'cards'; cards
     * is a field within this class.
     */
    public void sort() {
        Arrays.sort(cards, (Card u1, Card u2) -> u1.compareTo(u2));
    }

    //Testing method for Hand.java
    public static void main(String[] args) {
        Card test1 = new Card(Face.QUEEN, Suit.DIAMONDS);
        Card test2 = new Card(Face.FIVE, Suit.SPADES);
        Card test3 = new Card(Face.FIVE, Suit.CLUBS);
        Card test4 = new Card(Face.FIVE, Suit.HEARTS);
        Card test5 = new Card(Face.FIVE, Suit.DIAMONDS);
        Hand mainTest = new Hand(5);
        mainTest.cards[0] = test1;
        mainTest.cards[1] = test2;
        mainTest.cards[2] = test3;
        mainTest.cards[3] = test4;
        mainTest.cards[4] = test5;
        mainTest.sort();
        System.out.println("Highest card: " + mainTest.getHighestCard());
        System.out.println("Pair: " + mainTest.getPair(false));
        System.out.println("Three of a kind rank: " + mainTest.getThreeKind());
        System.out.println("Three of a kind boolean: " + mainTest.threeOfAKind());
        System.out.println("Four of a kind boolean: " + mainTest.fourOfAKind());
        System.out.println("Four of a kind rank: " + mainTest.getFourKind());
        System.out.println("Straight: " + mainTest.straight());
        System.out.println("Flush: " + mainTest.flush());
        System.out.println("Royal flush: " + mainTest.royalFlush());
        System.out.println("Straight flush: " + mainTest.straightFlush());
        System.out.println("Two pair: " + mainTest.twoPair());
        System.out.println("Full house: " + mainTest.fullHouse());
        System.out.println(Arrays.toString(Face.values()));

        System.out.println("----");
    }
}

