package org.codetest.vo;

public class CardVO {

	/*
	 * A card can belong to one of the below declared Suit.
	 */
    public final static int SPADES = 0;     
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
          
    /*
     * Defining constants for A,J,Q,K.
     */
    public final static int ACE = 14;          
    public final static int JACK = 11;       
    public final static int QUEEN = 12;       
    public final static int KING = 13;
                            
    //represents the suit the card is of.
    private final int suitType;   
          
    //represents the value of the card.
    private final int cardValue;  
    
    private int tempCardValue;
                             
    public int getTempCardValue() {
		return tempCardValue;
	}


	public void setTempCardValue(int tempCardValue) {
		this.tempCardValue = tempCardValue;
	}


	public CardVO(int cardValue, int suitType) {//Create a card with a specified value and suit type.
        this.cardValue = cardValue;
        this.suitType = suitType;
        switch ( cardValue ) {
	        case 11:  setTempCardValue(10);
	        case 12:  setTempCardValue(10);
	        case 13:  setTempCardValue(10);
	        case 14:  setTempCardValue(10);
	        default: setTempCardValue(cardValue);
        }
    }
        
   
    public int getSuitType() {//returns the suitType
		return suitType;
	}


	public int getCardValue() {//returns the cardValue
		return cardValue;
	}


	public String getSuitAsString() {//Returns the suitType if invalid, returns InvalidSuit.
        switch ( suitType ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "invalidSuit";
        }
    }
    
    public String getValueAsString() {//Returns the cardValue if invalid, returns invalidCardValue.
        switch ( cardValue ) {
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default: return "invalidCardValue";
        }
    }
    
    public String toString() {//Returns the string representation of CardValue and Suit Type.
        return getValueAsString() + " of " + getSuitAsString();
    }

} 