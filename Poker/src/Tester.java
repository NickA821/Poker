public class Tester {
    private Hand one;
    private Hand two;

    public Tester() {
        one = new Hand();
        two = new Hand(5);
    }

    public void makeSF(Hand hand) {
        hand.setCard(4, new Card(Face.KING, Suit.DIAMONDS));
        hand.setCard(3, new Card(Face.QUEEN, Suit.DIAMONDS));
        hand.setCard(2, new Card(Face.JACK, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.TEN, Suit.DIAMONDS));
        hand.setCard(0, new Card(Face.NINE, Suit.DIAMONDS));
    }

    public void make4K(Hand hand) {
        hand.setCard(0, new Card(Face.FIVE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.FIVE, Suit.SPADES));
        hand.setCard(2, new Card(Face.FIVE, Suit.CLUBS));
        hand.setCard(3, new Card(Face.FIVE, Suit.HEARTS));
        hand.setCard(4, new Card(Face.THREE, Suit.DIAMONDS));
    }
    public void make3K(Hand hand) {
        hand.setCard(0, new Card(Face.ACE,  Suit.SPADES));
        hand.setCard(1, new Card(Face.EIGHT, Suit.CLUBS));
        hand.setCard(2, new Card(Face.EIGHT, Suit.HEARTS));
        hand.setCard(3, new Card(Face.EIGHT, Suit.DIAMONDS));
        hand.setCard(4, new Card(Face.KING, Suit.DIAMONDS));
    }
    public void make3K2(Hand hand) {
        hand.setCard(0, new Card(Face.THREE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.THREE,  Suit.SPADES));
        hand.setCard(2, new Card(Face.THREE, Suit.CLUBS));
        hand.setCard(3, new Card(Face.FOUR, Suit.HEARTS));
        hand.setCard(4, new Card(Face.QUEEN, Suit.DIAMONDS));
    }
    public void makeFH(Hand hand) {
        hand.setCard(0, new Card(Face.THREE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.THREE,  Suit.SPADES));
        hand.setCard(2, new Card(Face.THREE, Suit.CLUBS));
        hand.setCard(3, new Card(Face.QUEEN, Suit.HEARTS));
        hand.setCard(4, new Card(Face.QUEEN, Suit.DIAMONDS));
    }
    public void makeS(Hand hand) {
        hand.setCard(0, new Card(Face.THREE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.FOUR,  Suit.SPADES));
        hand.setCard(2, new Card(Face.FIVE, Suit.CLUBS));
        hand.setCard(3, new Card(Face.SIX, Suit.HEARTS));
        hand.setCard(4, new Card(Face.SEVEN, Suit.DIAMONDS));
    }
    public void makeS2(Hand hand) {
        hand.setCard(0, new Card(Face.FIVE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.SIX,  Suit.SPADES));
        hand.setCard(2, new Card(Face.SEVEN, Suit.CLUBS));
        hand.setCard(3, new Card(Face.EIGHT, Suit.HEARTS));
        hand.setCard(4, new Card(Face.NINE, Suit.DIAMONDS));
    }

    public void make2P(Hand hand) {
        hand.setCard(0, new Card(Face.ACE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.FOUR,  Suit.SPADES));
        hand.setCard(2, new Card(Face.FOUR, Suit.CLUBS));
        hand.setCard(3, new Card(Face.TEN, Suit.HEARTS));
        hand.setCard(4, new Card(Face.TEN, Suit.DIAMONDS));
    }
    public void makeP(Hand hand) {
        hand.setCard(0, new Card(Face.ACE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.THREE,  Suit.SPADES));
        hand.setCard(2, new Card(Face.FOUR, Suit.CLUBS));
        hand.setCard(3, new Card(Face.TEN, Suit.CLUBS));
        hand.setCard(4, new Card(Face.TEN, Suit.SPADES));
    }
    public void makeH(Hand hand) {
        hand.setCard(0, new Card(Face.ACE, Suit.DIAMONDS));
        hand.setCard(1, new Card(Face.THREE,  Suit.SPADES));
        hand.setCard(2, new Card(Face.FOUR, Suit.CLUBS));
        hand.setCard(3, new Card(Face.SEVEN, Suit.CLUBS));
        hand.setCard(4, new Card(Face.TEN, Suit.SPADES));
    }

    public void go() {

        // Create a new array that holds 8 hands
        int[] holder = new int[8];
        // Loop through the array and fill it with a new hand (no parameters)
        for (int i = 0; i < holder.length; i++) {


            }


        // Call makeSF with a hand index of 0
        // Call make4K with a hand index of 1
        // Call make3K with a hand index of 2
        // Call makeFH with a hand index of 3
        // Call makeS with a hand index of 4
        // Call make2P with a hand index of 5
        // Call makeP with a hand index of 6
        // Call makeH with a hand index of 7

        // Loop through the hand array and call the sort method for the hand
        // at each index

        // Finish the following statements so that the appropriate hand type is
        // printed for each index of hand
        System.out.println("SF: ");
        System.out.println("4K: ");
        System.out.println("3K: ");
        System.out.println("FH: ");
        System.out.println("S: ");
        System.out.println("2P: ");
        System.out.println("P: ");
        System.out.println("H: ");

    }

    public static void main(String[] args) {

        // Create a new Tester object and call its go() method

    }
}

