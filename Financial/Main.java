package Financial;
import java.util.Scanner;
import Financial.FinancialManager;
import Financial.Store;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        FinancialManager manager = new FinancialManager(1004.81);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your financial manage system!");
        System.out.println("--------------------");
        System.out.println("1. add income");
        System.out.println("2. add expenses");
        System.out.println("3. check today's expenses");
        System.out.println("4. check lastmonth's expenses");
        System.out.println("5. Show all transaction records");
        System.out.println("6. Current total balance");
        System.out.println("7. quit System");
        System.out.print("Please choose your operation(choose a number)：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter income amount: ");
                double income = scanner.nextDouble();
                System.out.print("Enter note: ");
                String incomeNote = scanner.next();
                manager.addMoney(income, incomeNote);
                System.out.println("Income added successfully!");
                break;

            case 2:
                System.out.print("Enter expense amount: ");
                double expense = scanner.nextDouble();
                System.out.print("Enter category (e.g., Entertainment, Food, etc.): ");
                String category = scanner.next();
                System.out.print("Enter note: ");
                String expenseNote = scanner.next();
                manager.reduceMoney(expense, expenseNote, category);
                System.out.println("Expense recorded successfully!");
                break;

            case 3:
                double todayTotal = manager.getTotalDailyMoney();
                System.out.printf("Today's total expenses: %.2f\n", todayTotal);
                break;

            case 4:
                double lastMonthTotal = manager.getTotalMonthlyMoney();
                System.out.printf("Last month's total expenses: %.2f\n", lastMonthTotal);
                break;

            case 5:
                System.out.println("=== All Transactions ===");
                if (manager.transactions.size() == 0) {
                    System.out.println("No records found!");
                } else {
                    for (Store transaction : manager.transactions) {
                        System.out.println(transaction);
                    }
                }
                break;

            case 6:
                System.out.println("Current balance: " + manager.totalMoney);
                break;

            case 7:
                System.out.println("System exited!");
                break;

            default:
                System.out.println("Invalid choice, please try again!");
        }

    }
}



