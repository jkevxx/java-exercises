package org.example.projects.payment;

public class CreditCard {
	private String bankEntity;
	private String cardNumber;
	private double balance;
	private FinancialEntity financialEntity;
	private Person owner;
	
	public CreditCard(String bankEntity, String cardNumber, double balance, FinancialEntity financialEntity,
			Person owner) {
		this.bankEntity = bankEntity;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.financialEntity = financialEntity;
		this.owner = owner;
	}
	
	public boolean haveAvailableBalance(double amount) {
		return balance >= amount;
	}
	
	public void discount(double amount) {
		this.balance -= amount;
	}
	
	public String ownerFullName() {
		return owner.fullName();
	}

	public String getBankEntity() {
		return bankEntity;
	}

	public void setBankEntity(String bankEntity) {
		this.bankEntity = bankEntity;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public FinancialEntity getFinancialEntity() {
		return financialEntity;
	}

	public void setFinancialEntity(FinancialEntity financialEntity) {
		this.financialEntity = financialEntity;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	
	@Override
	public String toString() {
		return "CreditCard [bankEntity=" + bankEntity + ", cardNumber=" + cardNumber + ", balance=" + balance
				+ ", financialEntity=" + financialEntity + ", owner=" + owner + "]";
	}
	
}
