package javaexercise;
import java.util.Map;
import java.util.HashMap;

public class BankAccountManager implements Bank{
	Map<Integer, BankAccount> accounts;
	int id;
	
	public BankAccountManager() {
		accounts = new HashMap<>();
		id = 0;
	}
	
	@Override
	public int addAccount(BankAccount account) {
		accounts.put(id, account);
		return id++;
	}
	
	@Override
	public BankAccount getAccount(int id) {
		if (accounts.containsKey(id)) {
			return accounts.get(id);
		} else {
			System.out.println("Account with ID " + id + " does not exist.");
			return null;
		}
	}
	
	public void listAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts available.");
		} else {
			System.out.println("Accounts:");
			for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
				BankAccount acc = entry.getValue();
				String name = "Unknown";
				if (acc instanceof SavingsAccount) {
                    SavingsAccount sa = (SavingsAccount) acc;
                    name = sa.getOwnerName();
				System.out.println("Account ID: " + entry.getKey() + " Account Name: " + sa.getOwnerName() + ", Balance: " + entry.getValue().getBalance());
				}
			}
		}
	}
}
