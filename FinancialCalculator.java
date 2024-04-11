package financial_calculators;
import java.util.Scanner;
import java.text.DecimalFormat;

public class FinancialCalculator {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // Ask the user which calculator they want to use.
        System.out.println("Which calculator would you like to use?");
        System.out.println("1. A Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("3. Present Value Calculator");
        int choice = scanner.nextInt();

        // Start the calculator the user wants to use.
        switch (choice) {
            case 1:
                mortgageCalculator();
                break;
            case 2:
                futureValue();
                break;
            case 3:
                presentValue();
                break;
        }
        
        // Close the scanner.
        scanner.close();
    }

    // Create the mortgage calculator.
    public static void mortgageCalculator() {
        // Tell user to enter the principal.
        System.out.println("");
        System.out.print("Input the principal: ");
        double principal = scanner.nextDouble();

        // Tell user to enter the interest rate.
        System.out.print("Input the interest rate: ");
        double interestRate = scanner.nextDouble();

        // Tell user to enter the loan length in years.
        System.out.print("Input the loan length in years: ");
        int loanLength = scanner.nextInt();

        // Calculate the monthly interest rate.
        double monthlyInterestRate = interestRate / 1200;

        // Convert years to months.
        int totalMonths = loanLength * 12;

        // Calculate the monthly payment.
        double monthlyPayment = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, - totalMonths));

        // Calculate the total interest
        double totalInterest = monthlyPayment * totalMonths - principal;

        // Print out the information.
        System.out.println("");
        System.out.println("Monthly Payment: $" + df.format(monthlyPayment));
        System.out.println("Total Interest Paid: $" + df.format(totalInterest));

        // Close the scanner.
        scanner.close();
    }

    // Create the future value calculator.
    public static void futureValue() {
        // Tell user to enter the deposit.
        System.out.println("");
        System.out.print("Input the deposit: ");
        double deposit = scanner.nextDouble();

        // Tell user to enter the interest rate.
        System.out.print("Input the interest rate: ");
        double interestRate = scanner.nextDouble();

        // Tell user to enter the length in years.
        System.out.print("Input the length in years: ");
        int totalLength = scanner.nextInt();

        // Calculate the monthly interest rate.
        double monthlyInterestRate = interestRate / 1200;

        // Convert years to months.
        int totalMonths = totalLength * 12;

        // Calculate future value.
        double futureValue = deposit * Math.pow(1 + monthlyInterestRate, totalMonths);

        // Calcuate total interest.
        double totalInterest = futureValue - deposit;

        // Print out the information.
        System.out.println("");
        System.out.println("Future Value: $" + df.format(futureValue));
        System.out.println("Total Interest Earned: $" + df.format(totalInterest));

        // Close the scanner.
        scanner.close();
    }

    // Create the present value calculator.
    public static void presentValue() {
        // Tell user to enter the monthly payout.
        System.out.println("");
        System.out.print("Input the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        // Tell the user to enter the expected interest rate.
        System.out.print("Input the expected interest rate: ");
        double expectedRate = scanner.nextDouble();

        // Tell the user to enter the years to pay out.
        System.out.print("Input the years to pay out: ");
        int payOutYears = scanner.nextInt();

        // Calculate the monthly interest rate.
        double monthlyInterestRate = expectedRate / 1200;

        // Convert years to months.
        int totalMonths = payOutYears * 12;

        // Calculate the present value.
        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRate, - totalMonths)) / monthlyInterestRate;

        // Print out the information.
        System.out.println("");
        System.out.println("Present Value: $" + df.format(presentValue));

        // Close the scanner.
        scanner.close();
    }
}
