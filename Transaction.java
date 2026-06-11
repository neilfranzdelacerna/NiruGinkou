package javaexercise;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private String type;
	private double amount;
	private LocalDateTime time_stamp;
	
	public Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
		this.time_stamp = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		String time = time_stamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return String.format("%s: %.2f at %s", type, amount, time);
	}

}
