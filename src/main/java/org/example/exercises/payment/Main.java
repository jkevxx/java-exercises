package org.example.projects.payment;

public class Main {

	public static void main(String[] args) {
		Posnet posnet = new Posnet();
		
		Person person1 = new Person("18k21", "Kevin", "Paez", "2211169762", "kevin.paez1010@gmail.com");
		
		CreditCard card1 = new CreditCard("bank.com", "4851235", 15000, FinancialEntity.VISA, person1);
		
		System.out.println("-> Credit Card before the payment");
		System.out.println(card1);
		
		System.out.println("-> Ticket while payment...");
		Ticket ticketCreated = posnet.makePayment(card1, 10000, 1);
		System.out.println(ticketCreated);
		
		System.out.println("-> Credit Card after the payment");
		System.out.println(card1);
		
	}

}
