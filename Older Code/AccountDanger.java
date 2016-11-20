
public class AccountDanger implements Runnable {
	private class Account {
		private int balance = 50;
		public int getBalance() {
			return balance;
		}
		public void withdraw(int amount) {
			balance = balance - amount;
		}
	}

	private Account acct = new Account();
	public static void main (String [] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Fred");
		two.setName("Lucy");
		two.start();
		one.start();
		
	}
	public void run() {
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}
	private synchronized void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName()
			+ " is going to withdraw");

			try {

				Thread.sleep(1000);
			} catch(InterruptedException ex) { }

				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName()
				+ " completes the withdrawal - saldo: " + acct.getBalance());
		} else {
			System.out.println("Not enough in account for "
			+ Thread.currentThread().getName()
			+ " to withdraw " + acct.getBalance());
		}
	}
}