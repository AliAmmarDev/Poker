import java.lang.*;
import java.util.*;
/**
 * Creates PokerHand
 * <p>Deals with Hands by identifiying different types of
 * hands given
 * </p>
 * @author sc16aa Ali Ammar
 */
public class PokerHand extends CardCollection{

	/**
	 * Creates empty hand
	 */
	public PokerHand(){
    super();
  }
	/**
	 * Creates a hand of 5 cards for a player.
	 * Converts given cards from string to Card
	 * @param  cards of hand
	 */
  public PokerHand (String cards){
    if(cards.isEmpty() == false){
    	String[] parts = cards.split("\\s+");
    	if(parts.length < 6){
    		for(String card : parts){
          Card tempCard = new Card(card);
          this.add(tempCard);
        }
      }
      else{
        throw new PokerException("Exceeded limit 5 cards");
      }
    }
  }
	/**
	 * Adds card to hand
	 * @param card to be added to hand
	 */
	public void add(Card card){
		if ((cards.size() < 5) && (cards.contains(card) == false)){
    	super.add(card);
		}
    else{
    	throw new PokerException("Hand is full or already contains the given card");
    }
  }
	/**
	 * Discarding card from the hand
	 * @param deck currently being used
	 */
  public void discard(Deck deck){
    if(cards.isEmpty()){
    	throw new PokerException("Empty hand");
    }
    else{
    	for(Card card : this.cards){
		    deck.add(card);
		  }
		  super.discard();
		}
	}
	/**
	 * @return String card represented by a number and letter
	 * (or 2 letters)
	 */
	public String toString(){
	  String output = "";
	  for(Card cardOut : this.cards){
	    if(output.length() != 0){
	      output += " ";
	    }
	    output += (cardOut.toString());
	  }
	  return output;
	}
	/**
	 * @return String card represented by and number and unicode symbol
	 * or letter and unicode symbol
	 */
	public String toFancyString(){
	  String output = "";
	  for(Card cardOut : this.cards){
	    if(output.length() != 0){
	      output += " ";
	    }
	    output += (cardOut.toFancyString());
	  }
	  return output;
	}
	/**
	 * <p>
	 * Creates a Hash Map and sets Rank as the key. The cards are
	 * added to the map and if two cards contain the same rank
	 * return true else return false. If Two Pairs have been found
	 * return false.
	 * </p>
	 * @return true if 2 cards contain same rank. False otherwise
	 */
	public boolean isPair(){
    if (cards.size() != 5 || isTwoPairs()){
      return false;
    }
      Map<Card.Rank,Integer> countHand = new HashMap<>();
      for(Card temp : cards){
        Card.Rank key = temp.getRank();
        if(countHand.containsKey(key)){
          countHand.put(key, countHand.get(key)+1);
        }
        else{
          countHand.put(key, 1);
        }
      }
      if(countHand.containsValue(2)){
        return true;
      }
      return false;
	}
	/**
	 * <p>
	 * Creates a Hash Map and sets Rank as the key. The cards are
	 * added to the map. A Counter is incremented when 2 cards have
	 * the same rank. If the counter equals 2 return true else
	 * return false.
	 * </p>
	 * @return true if 2 pairs are found. False otherwise
	 */
	public boolean isTwoPairs(){
	  if(cards.size() != 5){
      return false;
    }
    Map<Card.Rank,Integer> countHand = new HashMap<>();
    for(Card temp : cards){
      Card.Rank key = temp.getRank();
        if(countHand.containsKey(key)){
          countHand.put(key, countHand.get(key)+1);
        }
        else{
          countHand.put(key, 1);
        }
    }
    if(countHand.containsValue(2)){
      int pairs = 0;
      for(Integer match : countHand.values()){
        if(match == 2){
          pairs++;
        }
      }
      if(pairs == 2){
        return true;
      }
    }
    return false;
	}
	/**
	 * <p>
	 * Creates a Hash Map and sets Rank as the key. The cards are
	 * added to the map. If 3 cards contain the same rank true is
	 * returned. Else return false. If a full house is found return
	 * false
	 * </p>
	 * @return true if 3 cards contain same rank. False otherwise
	 */
	public boolean isThreeOfAKind(){
        if ((cards.size() != 5) || (isFullHouse())){
            return false;
        }
        Map<Card.Rank,Integer> countHand = new HashMap<>();
        for(Card temp : cards){
            Card.Rank key = temp.getRank();
            if(countHand.containsKey(key)){
                countHand.put(key, countHand.get(key)+1);
            }
            else{
                countHand.put(key, 1);
            }
        }
        if(countHand.containsValue(3)){
            return true;
        }
        return false;

	}
	/**
	 * <p>
	 * Creates a Hash Map and sets Rank as the key. The cards are
	 * added to the map. If 4 cards contain the same rank true is
	 * returned. Else return false.
	 * </p>
	 * @return true if 4 cards contain same rank. False otherwise
	 */
	public boolean isFourOfAKind(){
        if (cards.size() != 5){
            return false;
        }
        Map<Card.Rank,Integer> countHand = new HashMap<>();
        for(Card temp : cards){
            Card.Rank key = temp.getRank();
            if(countHand.containsKey(key)){
                countHand.put(key, countHand.get(key)+1);
            }
            else{
                countHand.put(key, 1);
            }
        }
        if(countHand.containsValue(4)){
            return true;
        }
        return false;

	}
	/**
	 * <p>
	 * Creates a Hash Map and sets Rank as the key. The cards are
	 * added to the map. If 3 cards contain the same rank and 2 cards
	 * contain the same rank true is returned. Else return false. If
	 * three of a kind is found return false.
	 * </p>
	 * @return true if 3 cards contain same rank and 2 other
	 * cards contain the same rank. False otherwise
	 */
	public boolean isFullHouse(){
        if (cards.size() != 5){
            return false;
        }
        Map<Card.Rank,Integer> countHand = new HashMap<>();
        for(Card temp : cards){
            Card.Rank key = temp.getRank();
            if(countHand.containsKey(key)){
                countHand.put(key, countHand.get(key)+1);
            }
            else{
                countHand.put(key, 1);
            }
        }
        if(countHand.containsValue(3) && countHand.containsValue(2)){
            return true;
        }
        return false;
	}

	/**
	 * <p>
	 * Creates a Hash Map and sets Suit as the key. The cards are
	 * added to the map. If 5 cards contain the same suit true is
	 * returned. Else return false.
	 * </p>
	 * @return true if 5 cards contain same suit. False otherwise
	 */
	public boolean isFlush(){
      if (cards.size() != 5){
          return false;
      }
      Map<Card.Suit,Integer> countHand = new HashMap<>();
      for(Card temp : cards){
          Card.Suit key = temp.getSuit();
          if(countHand.containsKey(key)){
              countHand.put(key, countHand.get(key)+1);
          }
          else{
              countHand.put(key, 1);
          }
      }
      if(countHand.containsValue(5)){
          return true;
      }
      return false;
    }
		/**
		 * <p>
		 * An array is made and 5 cards are added to it. The array is sorted
		 * in ascending order. If the difference between the value of the ranks
		 * is 1 a counter increments. If the counter is 4 return true. For a
		 * high ace, if the first card is an Ace, second is 10, third is J,
		 * fourth is Q and fifth is K return true.
		 * </p>
		 @return true if the cards are in ascending order of +1 or the
		 * hand contains the cards ACE,10,J,Q,K
		 */
    public boolean isStraight(){
        if (cards.size() != 5){
            return false;
        }
        int[] hand = new int[5];
        int i = 0;
        for(Card temp : cards){
          hand[i] = temp.getRank().ordinal();
          i++;
        }
        Arrays.sort(hand);
        boolean bool = false;
        int k = 0;
        for(i=0;i<4;i++){
          if(hand[i] == hand[i+1] -1){
            k++;
          }
          if(hand[0] == 0 && hand[1] == 9 && hand[2] == 10 && hand[3] == 11 &&  hand[4] == 12){
          	return true;
          }
        }
        if(k == 4){
	      	return true;
        }
       	return false;
    }
}
