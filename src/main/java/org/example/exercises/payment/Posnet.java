package org.example.projects.payment;

public class Posnet {
	public static final double CHARGEBYDUES = 0.03;
	public static final int MIN_AMOUT_DUES = 1;
	public static final int AMOUT_AMOUT_DUES = 6;

	public Posnet() {
		
	}
	
	public Ticket makePayment(CreditCard card, double amountToPay, int amountDues) {
		Ticket returnedTicket = null;
		
		if (validatedData(card, amountToPay, amountDues)) {
			double finalAmount = amountToPay + amountToPay * chargesAccordingToDues(amountDues);
			
			if(card.haveAvailableBalance(finalAmount)) {
				card.discount(finalAmount);
				String fullName = card.ownerFullName();
				double amountByDues = finalAmount / amountDues;
				
				returnedTicket = new Ticket(fullName, finalAmount, amountByDues);
			}
		}
		return returnedTicket;
	}
	
	public boolean validatedData(CreditCard card, double amountToPay, int amountDues) {
		
		boolean isCardValid = card != null;
		boolean isAmountToPayValid = amountToPay > 0;
		boolean isAmountDues = amountDues >= MIN_AMOUT_DUES && amountDues <= AMOUT_AMOUT_DUES;
		
		return isCardValid && isAmountToPayValid && isAmountDues;
	}
	
	public double chargesAccordingToDues(int amountDues) {
		
		return (amountDues - 1) * CHARGEBYDUES;
	}
	
}
