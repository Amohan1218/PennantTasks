package InnerClasses;

interface Transaction {
	void deposit(double amt);

	void withdraw(double amt);
}

class AuditAccount {
	double balance = 5000;

	void auditTrasaction() {
		Transaction t = new Transaction() {
			public void deposit(double amt) {
				balance += amt;
				System.out.println("Balance after deposit: " + balance);
			}

			public void withdraw(double amt) {
				if (balance > amt) {
					balance -= amt;
					System.out.println("Balance after withdrawn: " + balance);
				} else {
					System.out.println("InsufficientFunds");
				}
			}
		};
		t.deposit(5000);
		t.withdraw(8000);
		t.withdraw(3000);
	}

	public static void main(String[] args) {
		AuditAccount a = new AuditAccount();
		a.auditTrasaction();
	}
}