import java.util.ArrayList;
import java.util.Scanner;

public class FinanceTrackerApp {

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== PERSONAL FINANCE TRACKER ======");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Calculate Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Clear buffer

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> updateTransaction();
                case 4 -> deleteTransaction();
                case 5 -> calculateBalance();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


    public static void addTransaction() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Type (INCOME/EXPENSE): ");
        String type = sc.nextLine();

        double amount;
        while (true) {
            System.out.print("Enter Amount (>0): ");
            amount = sc.nextDouble();
            sc.nextLine();
            if (amount > 0) break;
            System.out.println("Amount must be positive. Try again.");
        }

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        try {
            Transaction t = new Transaction(id, type, amount, description, date);
            transactions.add(t);
            System.out.println("Transaction Added Successfully!");
        } catch (Exception e) {
            System.out.println("Error Adding Transaction: " + e.getMessage());
        }
    }


    public static void viewTransactions() {
        System.out.println("\n====== ALL TRANSACTIONS ======");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println("----------------------------");
            System.out.println("ID: " + t.getId());
            System.out.println("Type: " + t.getType());
            System.out.println("Amount: " + t.getAmount());
            System.out.println("Description: " + t.getDescription());
            System.out.println("Date: " + t.getDate());
        }
    }


    public static void updateTransaction() {
        System.out.print("Enter Transaction ID to Update: ");
        String id = sc.nextLine();

        Transaction t = findTransaction(id);

        if (t == null) {
            System.out.println("Transaction not found!");
            return;
        }

        System.out.print("Enter New Type (INCOME/EXPENSE): ");
        t.setType(sc.nextLine());

        double amount;
        while (true) {
            System.out.print("Enter New Amount (>0): ");
            amount = sc.nextDouble();
            sc.nextLine();
            if (amount > 0) break;
            System.out.println("Amount must be positive!");
        }
        t.setAmount(amount);

        System.out.print("Enter New Description: ");
        t.setDescription(sc.nextLine());

        System.out.print("Enter New Date (YYYY-MM-DD): ");
        t.setDate(sc.nextLine());

        System.out.println("Transaction Updated Successfully!");
    }


    public static void deleteTransaction() {
        System.out.print("Enter Transaction ID to Delete: ");
        String id = sc.nextLine();

        Transaction t = findTransaction(id);

        if (t != null) {
            transactions.remove(t);
            System.out.println("Transaction Deleted Successfully!");
        } else {
            System.out.println("Transaction Not Found!");
        }
    }


    public static void calculateBalance() {
        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("INCOME")) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }

        double balance = income - expense;

        System.out.println("\n====== BALANCE ======");
        System.out.println("Total Income: " + income);
        System.out.println("Total Expense: " + expense);
        System.out.println("Current Balance: " + balance);
    }


    private static Transaction findTransaction(String id) {
        for (Transaction t : transactions) {
            if (t.getId().equals(id))
                return t;
        }
        return null;
    }
}
