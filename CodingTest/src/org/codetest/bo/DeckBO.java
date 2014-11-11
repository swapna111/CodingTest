package org.codetest.bo;

import org.codetest.exception.ApplicationException;
import org.codetest.vo.CardVO;

public class DeckBO {

    /**
     * A deck contains 52 cards. the array holds all the 52 cards. This array ignores Jokers.
     */
    private CardVO[] cardsVO = new CardVO[52];

    /**
     * Tracks the noOfCardsUsed in this deck.  
     */
    private int noOfCardsUsed;

    
    /**
     * The constructor initializes the CardVO array with 13 cards each of Heart, Club, Diamond and Spade suits.
     */
    public DeckBO() {
    	int count = 0; //tracks the no.of cards created.
        for ( int suit = 0; suit <= 3; suit++ ) { // the suit constant value is defined in the CardVO
            for ( int value = 1; value <= 13; value++ ) {
                cardsVO[count] = new CardVO(value,suit);
                count++;
            }
        }
        noOfCardsUsed = 0;
    }


    /**
     * returns the noOfCards that are not used in this deck.
     */
    public int availableCards() {
        return cardsVO.length - noOfCardsUsed;
    }

    
    /**
     * Suffels the cards i.e, moves the cards in the array to the random poistion generated from the Math.random()*(cardVal+1) value.
     */
    public void shuffleCards() {
        for ( int cardVal = cardsVO.length-1; cardVal > 0; cardVal-- ) {
            int val = (int)(Math.random()*(cardVal+1));
            CardVO temp = cardsVO[cardVal];
            cardsVO[cardVal] = cardsVO[val];
            cardsVO[val] = temp;
        }
        noOfCardsUsed = 0;
    }
    
    
    public CardVO getCard() throws ApplicationException {
        if (noOfCardsUsed == cardsVO.length)
            throw new ApplicationException("The deck is empty.");
        return cardsVO[++noOfCardsUsed - 1];
    }


}
