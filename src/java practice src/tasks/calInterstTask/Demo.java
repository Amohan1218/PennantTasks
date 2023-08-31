package tasks.calInterstTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	static ArrayList<Account> A = new ArrayList<>();
	static ArrayList<Transaction> T = new ArrayList<>();

	// Get Balance as on Date
	static public int getBalanceAsOnDate(Account a, LocalDate date) {
		int value = Integer.parseInt(a.getBalance());
		for (Transaction t : T) {
			if (a.getAcctNum().equals(t.getAcctNum())) {
				if (date.compareTo(a.getdOPAcct()) > 0) {
					if (t.getTransacType().equals("C")) {
						value += Integer.parseInt(t.getAmount());
					} else {
						value -= Integer.parseInt(t.getAmount());
					}
				}
			}
		}
		return value;
	}

	// Minimum balance of the month
	static int getMinBalance(Account a, int m, int yr) {
		LocalDate date = LocalDate.of(yr, m, 10);
		int value = getBalanceAsOnDate(a, date);

		int nOD = YearMonth.of(yr, m).lengthOfMonth();

		for (int i = 10; i <= nOD; i++) {
			int d = getBalanceAsOnDate(a, date);
			if (d < value) {
				value = d;
			}
		}
		return value;
	}

	// Calculation of interest using account number
	static void calInterst(String actNum, LocalDate date) {
		double value = 0;
		for (Account a : A) {
			LocalDate dOP = a.getdOPAcct();
			if (a.getAcctNum().equals(actNum)) {
				// Condition for given date is in between date of opening account and
				if (date.getMonth() == dOP.getMonth()) {
					System.out.println("Your Account Number: " + actNum + " and Your Interst: " + value);
				}
				// Condition for given date is after the dateOfOpening of an account or not
				else if (dOP.compareTo(date) > 0) {
					System.out.println("Invalid-Date, Given date is beyond the Date of opening Account");
				} else {
					LocalDate fd = date.minusMonths(6);
					// Condition for gap between given and dOP is less than 6 months
					if (dOP.compareTo(fd) >= 0) {
						// Condition for DateOfOpening of an Account is in between first 10 days of the
						// month
						if (dOP.getDayOfMonth() < 10) {

							long monthsDifference = ChronoUnit.MONTHS.between(dOP, date);

							for (int i = 1; i <= monthsDifference - 1; i++) {
								int k = getMinBalance(a, dOP.plusMonths(i).getMonthValue(),
										dOP.plusMonths(i).getYear());
								value += calInterst(k);
							}
							System.out.println("Your Account Number: " + actNum + " and Your Interst: " + value);
						}
						// Condition for DateOfOpening of an Account is after first 10 days of the month
						else {
							long monthsDifference = ChronoUnit.MONTHS.between(dOP, date);
							for (int i = 1; i <= monthsDifference - 2; i++) {
								int k = getMinBalance(a, dOP.plusMonths(i).getMonthValue(),
										dOP.plusMonths(i).getYear());
								value += calInterst(k);
							}
							System.out.println("Your Account Number: " + actNum + " and Your Interst: " + value);
						}
					}
					// Condition for gap between given and dOP is more than 6 months
					else {
						long monthsDifference = ChronoUnit.MONTHS.between(dOP, date);
						for (int i = 1; i <= monthsDifference - 1; i++) {
							int k = getMinBalance(a, dOP.plusMonths(i).getMonthValue(), dOP.plusMonths(i).getYear());
							value += calInterst(k);
						}
						System.out.println("Your Account Number: " + actNum + " and Your Interst: " + value);
					}
				}
				break;
			}
		}
	}

	// Calculation of Interest
	static double calInterst(int amt) {
		return amt * 4.5 / 100;
	}

	// Getting all accounts
	static List<Account> getAllAccounts() {
		return A;
	}

	// Getting all transactions
	static List<Transaction> getAllTransactions() {
		return T;
	}

	// Converting String date to Local Date
	static LocalDate convdateString(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(s, formatter);
		return date;
	}

	public static void main(String[] arrgs) {

		try {
			// Reading Account list
			BufferedReader ba = new BufferedReader(new FileReader(
					"C:\\Users\\mohansai.a\\eclipse-workspace\\JavaTasks\\src\\calInterstTask\\AccountList.txt"));
			String line;
			while ((line = ba.readLine()) != null) {
				String s[] = line.split(",");
				A.add(new Account(s[0], s[1], convdateString(s[2]), s[3]));
			}
			ba.close();
			// Reading Transactions List
			BufferedReader bt = new BufferedReader(new FileReader(
					"C:\\Users\\mohansai.a\\eclipse-workspace\\JavaTasks\\src\\calInterstTask\\TransactionsList.txt"));
			String line1;
			while ((line1 = bt.readLine()) != null) {
				String s[] = line1.split(",");
				T.add(new Transaction(s[0], s[1], convdateString(s[2]), s[3], s[4]));
			}
			bt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Accounts: \n--------\nActNum TOA  DateOfOpening Balance");
		for (Account a : getAllAccounts()) {
			System.out.println(a);
		}
		System.out.println("\nTransactions: \n------------\nTransID  ActN     DOTrans    TOT   Amount");
		for (Transaction t : getAllTransactions()) {
			System.out.println(t);
		}

		// Taking inputs from the User
		Scanner i = new Scanner(System.in);

		System.out.print("\n\nEnter Date: ");
		String date = i.nextLine();

		System.out.print("Enter Account Number: ");
		String acctNumber = i.nextLine();

		System.out.println();
		calInterst(acctNumber, convdateString(date));

		i.close();
	}
}