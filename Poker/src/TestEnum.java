import java.util.Arrays;
public class TestEnum {
    enum card {spade, club, heart, diamond};



    public static void main(String[] args) {
        card[] arr = card.values();
        System.out.println(card.values()[1]);


    }
}
