package javaexercise;

public class Main {

	public static void main(String[] args) {
		BankAccount acc1 = new SavingsAccount("Test0");
		SavingsAccount sa = (SavingsAccount) acc1;
		System.out.println("Account Owner: " + sa.getOwnerName() + "\n");
		
		double amount = 1000.125;
		acc1.deposit(amount);
		System.out.printf("Amount deposited: %.2f%n", amount);
		System.out.println("Current balance: " + acc1.getBalance()+ "\n");
		
		amount = 0;
		acc1.deposit(amount);
		System.out.printf("Amount deposited: %.2f%n", amount);
		System.out.println();
		
		amount = -500;
		acc1.deposit(amount);
		System.out.printf("Amount deposited: %.2f%n", amount);
		System.out.println();
		
		amount = 500;
		acc1.withdraw(amount);
		System.out.printf("Amount withdrawn: %.2f%n", amount);
		System.out.println("Current balance: " + acc1.getBalance());
		System.out.println();
		
		amount = 1500;
		acc1.withdraw(amount);
		System.out.printf("Amount withdrawn: %.2f%n", amount);
		System.out.println();
		
		amount = -100;
		acc1.withdraw(amount);
		System.out.printf("Amount withdrawn: %.2f%n", amount);
		System.out.println();
		
		acc1.freezeAccount();
		amount = 11500;
		acc1.deposit(amount);
		System.out.println();
		
		amount = 100;
		acc1.unfreezeAccount();
		acc1.withdraw(amount);
		System.out.printf("Amount withdrawn: %.2f%n", amount);
		System.out.println("Current balance: " + acc1.getBalance());
		System.out.println();
		
		acc1.getTransactionHistory();
		for (Transaction t : acc1.getTransactionHistory()) {
			System.out.println(t);
		}
		System.out.println();
		
		BankAccountManager accM1 = new BankAccountManager();
		int assignedID = accM1.addAccount(acc1);
		System.out.println("Account added successfully with ID: " + assignedID);
		System.out.println();
		
		assignedID = accM1.addAccount(new SavingsAccount("Test1"));
		System.out.println("Account added successfully with ID: " + assignedID);
		System.out.println();
		
		accM1.listAccounts();

	}

}
