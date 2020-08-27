import java.util.*;
/**
 * Creates a deck of 52 cards
 * <p>
 * Will initialise a deck of cards for a game.
 * </p>
 * @author sc16aa Ali Ammar
 */
public class Deck extends CardCollection{
	/**
 	*Creates an object of type Deck containing 52 cards
 	*/
	public Deck(){
		super();
		for (Card.Suit suit : Card.Suit.values()){
			for (Card.Rank cardRank : Card.Rank.values()){
      	Card card = new Card(cardRank, suit);
        this.add(card);
			}
		}
	}
		/**
		 * Deals a card from deck
		 * @return a card taken out from the deck
		 */
    public Card deal(){
    	if(this.cards.isEmpty()){
          throw new PokerException("Empty deck\n");
      }
      else{
          Card removeCard = this.cards.get(0);
          this.cards.remove(removeCard);
          return removeCard;
      }
    }
		/**
		 * Shuffles whole deck of cards
		 */
    public void shuffle(){
        Collections.shuffle(this.cards);
    }
}
