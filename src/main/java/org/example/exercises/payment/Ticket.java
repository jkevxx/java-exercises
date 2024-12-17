package org.example.projects.payment;

public class Ticket {
	
	private String nameLastName;
	private double totalAmount;
	private double amountByDues;
	
	public Ticket(String nameLastName, double totalAmount, double amountByDues) {
		this.nameLastName = nameLastName;
		this.totalAmount = totalAmount;
		this.amountByDues = amountByDues;
	}

	public String getNameLastName() {
		return nameLastName;
	}

	public void setNameLastName(String nameLastName) {
		this.nameLastName = nameLastName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getAmountByCharge() {
		return amountByDues;
	}

	public void setAmountByCharge(double amountByDues) {
		this.amountByDues = amountByDues;
	}

	@Override
	public String toString() {
		return "Ticket [nameLastName=" + nameLastName + ", totalAmount=" + totalAmount + ", amountByDues="
				+ amountByDues + "]";
	}
	
}
