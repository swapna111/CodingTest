package org.codetest.processor;

import org.codetest.bo.BlackJack;
import org.codetest.bo.HandBO;
import org.codetest.exception.ApplicationException;

public class BlackJackProcessor {

	public static void main(String[] args) throws ApplicationException {

		if(args.length!=1){
			throw new ApplicationException(" Please pass the no of players between 1 to 6 as an Argument");
		}
		int noOfPlayers = 0;
		try{
			noOfPlayers = Integer.parseInt(args[0]);
		}catch(Exception e){
			throw new ApplicationException(" Please pass the no of players between 1 to 6 as a numeric value");
		}
		
		if(noOfPlayers<1 && noOfPlayers>6){
			throw new ApplicationException(" Please pass the no of players ranging 1 to 6");
		}
		
		HandBO dealer = new HandBO();
		BlackJack blackJack = new BlackJack(dealer, noOfPlayers);
		
		blackJack.dealInitialCards();
		
		for(int i=0;i<noOfPlayers;i++){
			drawCard(blackJack,blackJack.getPlayers()[i]);
		}
		
		drawCard(blackJack,blackJack.getDealer());
		
		//At this point all the players have a cardValue > 17.
		int dealrVal = dealer.getHandValue();
		System.out.println("Dealer Value: "+dealrVal);
		if(dealer.isBusted()){
			System.out.println("Dealer busted ");
			for(int i=0;i<noOfPlayers;i++){
				System.out.println(" Player ["+i+"] cards count: "+blackJack.getPlayers()[i].getHandValue());
				if(!blackJack.getPlayers()[i].isBusted()){
					System.out.println(" Player ["+i+"] has won");
				}else{
					System.out.println(" Player ["+i+"] BUSTED.");
				}
			}
		}else{
			for(int i=0;i<noOfPlayers;i++){
				System.out.println(" Player ["+i+"] cards count: "+blackJack.getPlayers()[i].getHandValue());
				if(blackJack.getPlayers()[i].isBusted()){
					System.out.println(" Player ["+i+"] BUSTED.");
				}else if(dealrVal< blackJack.getPlayers()[i].getHandValue()){
					System.out.println(" Player ["+i+"] has won");
				}
			}
		}
		
	}
	
	/**
	 * This is a recursive method...
	 * 
	 * @param blackJack
	 * @param handBO
	 * @throws ApplicationException
	 */
	private static void drawCard(BlackJack blackJack,HandBO handBO) throws ApplicationException{
		if(handBO.getHandValue()<17){
			blackJack.drawCard(handBO);
			drawCard(blackJack, handBO);
		}else if(handBO.getHandValue()>21){
			handBO.flipAceValue();
			if(handBO.getHandValue()<17){
				drawCard(blackJack, handBO);
			}else{
				handBO.setBusted(true);
			}
		}
	}

}
