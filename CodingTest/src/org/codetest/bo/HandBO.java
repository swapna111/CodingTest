package org.codetest.bo;

import java.util.ArrayList;
import java.util.List;

import org.codetest.exception.ApplicationException;
import org.codetest.vo.CardVO;

public class HandBO {

	  protected List<CardVO> cardsInHand;
	  protected int cardsValue,count;  
	  private boolean isBusted = false;
	  
	  

	  
	  public boolean isBusted() {
		return isBusted;
	}



	public void setBusted(boolean isBusted) {
		this.isBusted = isBusted;
	}



	public HandBO()
	  {
	    cardsInHand = new ArrayList<CardVO>(2);
	    cardsValue=0;
	    count =0;
	  }


	
	/**
	 * @param newCardVO
	 */
	public void flipAceValue()
	  {
		for(CardVO card: cardsInHand)
	      if( card.getCardValue()==14)
	      {
	           cardsValue -= 10;           
	      }
	  }
	
	
	
	  /**
	   * Draw a new card to the hand.
	   * 
	   * @param currentdeck
	   * @return
	   * @throws ApplicationException
	   */
	public CardVO newCardVO(DeckBO currentdeck) throws ApplicationException
	  {
	     CardVO result;
	     result = currentdeck.getCard();
	     cardsInHand.add(result);  
	     cardsValue+=result.getTempCardValue(); 
	     /*flipAceValue(result);*/
	     count++;
	     return result;
	  }
	
	
	
	/**
	 * Returns the total cards Value.
	 * @return
	 */
	public int getHandValue()
	  {
	    return cardsValue;
	  }
	
	
		

	/**
	 * @param crd
	 */
	public void remove(CardVO crd)
	  {
	     cardsInHand.remove(crd);
	  }
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	  {
	    String result="";
	    
	    for(CardVO card: cardsInHand){
	    	if(card.getCardValue() == 11){
	    		result += "CardVO"+": "+card.getCardValue()+"\n";
	    	}
	    }
	    return result;
	  }
}
