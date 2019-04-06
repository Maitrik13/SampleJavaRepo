package com.banking;

import java.io.Serializable;
import java.util.Scanner;

public class AccountInformations implements Serializable{

	public double getRateOfInterest(String accountType) {
		double interestRate = 0;
		switch (accountType) {
		case "Saving":
			interestRate = 0.5;
			break;
		case "Current":
			interestRate = 0.7;
		case "FD":
			interestRate = 1.5;
		case "RD":
			interestRate = 1.5;
		default:
			break;
		}
		return interestRate;
	}

	public String getBranchName(String accountNumber) {
		String branchName = "";

		if (accountNumber.startsWith("022")) {
			branchName = "ABC";
		} else if (accountNumber.startsWith("033")) {
			branchName = "XYZ";
		} else if (accountNumber.startsWith("044")) {
			branchName = "Maitrik Panchal Co Operative Bank";
		}
		return branchName;
	}

	public double calculateRateOfInterest(long amount, double rateOfInterest, float tennuar) {
		double interestVal = 0;

		if (tennuar <= 2) {
			interestVal = (amount * rateOfInterest * tennuar) / 100;
		} else {
			double calculateAdditionalInterest = (amount * 10) / 100;
			interestVal = ((amount * rateOfInterest * tennuar) / 100) + calculateAdditionalInterest;
		}
		return interestVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String accountHolderName;
		String accountNumber;
		long ammountValue;
		String accountType;
		float tennuar;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Account holder name : ");
		accountHolderName = scanner.next();

		System.out.println("Account number : ");
		accountNumber = scanner.next();

		System.out.println("Ammount Value : ");
		ammountValue = scanner.nextLong();

		System.out.println("Account type : ");
		accountType = scanner.next();

		System.out.println("Tennuar : ");
		tennuar = scanner.nextFloat();

		AccountInformations informations = new AccountInformations();
		String selectedBranchName = informations.getBranchName(accountNumber);
		double rateOfInterest = informations.getRateOfInterest(accountType);

		double interestValue = informations.calculateRateOfInterest(ammountValue, rateOfInterest, tennuar);

		String messageString = interestValue > 100 ? "Obtained good amount : " : "Lessed amount";
		
		
		System.out.println("Account holder name is : "+accountHolderName);
		System.out.println("Selected Branch : " + selectedBranchName);
		System.out.println("Applied interest : " + rateOfInterest);
		System.out.println("Interest Value : " + interestValue);
		System.out.println("Message : "+messageString);
		
		if(informations instanceof Serializable) {
			System.out.println("Object is valid");
		}

	}

}
