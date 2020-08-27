import java.util.*;

/**
 * Simulates output of poker game
 * <p>
 * Allows user to specify number of decks on command line.
 * These decks are shuffled randomly and each hand is displayed.
 * probabilities of game statistics are then provided.
 * </p>
 * @author sc16aa Ali Ammar
 */


public class PokerStats{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Amount of Decks");
        int decks = input.nextInt();

        List<Deck>  amountOfDecks = new ArrayList<>();
        int i;
        for(i = 0;i<decks;i++){
            Deck deck = new Deck();
            amountOfDecks.add(deck);
            deck.shuffle();
        }

        int hand = 5;
        int hands = 10;
        int deals = 0;
        int flush = 0;
        int fourOfAKind = 0;
        int threeOfAKind = 0;
        int pair = 0;
        int twoPairs = 0;
        int fullHouse = 0;
        int straight = 0;
        for(Deck tempDeck : amountOfDecks){
            for(int j=0;j<hands;j++){
                PokerHand tempHand = new PokerHand();
                for(int k=0;k<hand;k++){
                    tempHand.add(tempDeck.deal());
                    deals++;
                    if(tempHand.size() == 5){
                        if(tempHand.isFlush()){
                            flush++;
                        }
                        if(tempHand.isFourOfAKind()){
                            fourOfAKind++;
                        }
                        if(tempHand.isPair()){
                            pair++;
                        }
                        if(tempHand.isTwoPairs()){
                            twoPairs++;
                        }
                        if(tempHand.isThreeOfAKind()){
                            threeOfAKind++;
                        }
                        if(tempHand.isFullHouse()){
                            fullHouse++;
                        }
                        if(tempHand.isStraight()){
                            straight++;
                        }
                    }
                }
                System.out.println(tempHand.toFancyString());
            }
            System.out.println();
        }
        System.out.println(fullHouse);
        double pflush = (double) flush/decks*10;
        double pfourOfAKind = (double) fourOfAKind/decks*10;
        double ppair = (double) pair/decks*10;
        double ptwoPairs = (double) twoPairs/decks*10;
        double pthreeOfAKind = (double) threeOfAKind/decks*10;
        double pfullHouse = (double) fullHouse/decks*10;
        double pstraight = (double) straight/decks*10;

        System.out.println(deals +  " Deals Made");
        System.out.printf("P(Flush)\t\t = %.3f%c\n", pflush,37);
        System.out.printf("P(Four of a Kind)\t = %.3f%c\n", pfourOfAKind,37);
        System.out.printf("P(Pair)\t\t\t = %.3f%c\n", ppair,37);
        System.out.printf("P(Two Pairs)\t\t = %.3f%c\n", ptwoPairs,37);
        System.out.printf("P(Three of a kind)\t = %.3f%c\n", pthreeOfAKind,37);
        System.out.printf("P(Full House)\t\t = %.3f%c\n", pfullHouse,37);
        System.out.printf("P(Straight)\t\t = %.3f%c\n", pstraight,37);

    }
}
