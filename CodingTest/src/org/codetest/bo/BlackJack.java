package org.codetest.bo;

import org.codetest.exception.ApplicationException;
import org.codetest.vo.CardVO;

public class BlackJack {
	

	  //Dealer cards
	  private HandBO dealer;    
	  
	  // players cards.
	  private HandBO[] players;
	  private int noOfPlayers;
	  //Cards.
	  DeckBO newdeck;   

	/**
	 * @param dlr
	 * @param plr
	 */
	public BlackJack(HandBO dealer, int noOfPlayers){
	    this.dealer = dealer;
	    this.noOfPlayers = noOfPlayers;
	    players = new HandBO[noOfPlayers];
	    for(int i=0;i<noOfPlayers;i++){
	    	players[i] = new HandBO();
	    }
	    newdeck = new DeckBO();
	    newdeck.shuffleCards();
	}

 
	public HandBO getDealer() {
		return dealer;
	}


	public void setDealer(HandBO dealer) {
		this.dealer = dealer;
	}


	public HandBO[] getPlayers() {
		return players;
	}


	public void setPlayers(HandBO[] players) {
		this.players = players;
	}


	public int getNoOfPlayers() {
		return noOfPlayers;
	}


	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}


	/**
	 * Draw initial deck of cards.
	 * 
	 * @throws ApplicationException
	 */
	public void dealInitialCards() throws ApplicationException{ 
	   for(int i=0;i<noOfPlayers;i++){
		    	players[i].newCardVO(newdeck);
		}
	    dealer.newCardVO(newdeck);
	    for(int i=0;i<noOfPlayers;i++){
	    	players[i].newCardVO(newdeck);
	    }
	    dealer.newCardVO(newdeck);
	}
	
	/**
	 * @param handBO
	 * @throws ApplicationException
	 */
	public void drawCard(HandBO handBO) throws ApplicationException{
		handBO.newCardVO(newdeck);
	}
	
	
		
	/**
	 * @param cards
	 * @return
	 */
	public int handValue(HandBO cards){
	    int result = cards.getHandValue();
	    return result;
	 }

		 
	/**
	 * @param cards
	 * @param dicardCard
	 * @throws ApplicationException
	 */
	public void discard(HandBO cards, CardVO dicardCard) throws ApplicationException{
	    boolean found = false;
	    for(CardVO card:cards.cardsInHand)
	    {
	        if(dicardCard.equals(card))
	        {
	          cards.remove(card);
	          found = true;
	        }
	    }
	    if(!found)
	        throw new ApplicationException("No Card Found");
	
	}
		
	
}
