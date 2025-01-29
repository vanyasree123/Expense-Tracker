import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    // Constructor
    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {

    private ArrayList<Expense> expenses = new ArrayList<>();
    private double totalExpenses = 0;

    // Method to add an expense
    public void addExpense(String description, double amount) {
        Expense expense = new Expense(description, amount);
        expenses.add(expense);
        totalExpenses += amount;
    }

    // Method to display all expenses
    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("\nList of Expenses:");
            for (Expense expense : expenses) {
                System.out.println("Description: " + expense.getDescription() + ", Amount: $" + expense.getAmount());
            }
        }
    }

    // Method to display total expenses
    public void displayTotalExpenses() {
        System.out.println("\nTotal Expenses: $" + totalExpenses);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();
        int choice;

        do {
            // Display menu
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Remove  Expenses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Expense
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    expenseTracker.addExpense(description, amount);
                    break;
                case 2:
                    // View All Expenses
                    expenseTracker.displayExpenses();
                    break;
                case 3:
                    // View Total Expenses
                    expenseTracker.displayTotalExpenses();
                    break;
                case 4:
                    // Exit
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}

