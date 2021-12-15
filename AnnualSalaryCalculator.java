import java.util.Scanner; // for user to input

public class AnnualSalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object
        // ---- Scanner object has to e outside the loop
        while (true) {
            double annulSalary, annualTaxDeduction, monthlyTaxDeduction, monthlyRate, dailyRate, netPay, hourlyRate,
                    taxDeduction, taxExcess; // Tax_deduction variable
            // declaring all variables

            while (true) {
                // user has to type in a number
                Scanner innerScanner = new Scanner(System.in);
                System.out.print("Your Annual Salary			: ");
                try {
                    annulSalary = innerScanner.nextDouble();
                    break;
                } catch (Exception ex) {
                    System.out.println("You type something else than a number. Try again.");
                }
            }
            if (annulSalary < 250000) {
                taxDeduction = 0;
            } else if (annulSalary >= 250000 && annulSalary < 400000) {
                taxDeduction = annulSalary - 150000 * 0.20;
            } else if (annulSalary >= 400000 && annulSalary < 800000) {
                taxExcess = annulSalary - 400000;
                taxDeduction = 0.25 * taxExcess + 30000;
            } else if (annulSalary >= 800000 && annulSalary < 2000000) {
                taxExcess = annulSalary - 1800000;
                taxDeduction = 0.30 * taxExcess + 130000;
            } else if (annulSalary >= 2000000 && annulSalary < 8000000) {
                taxExcess = annulSalary - 6000000;
                taxDeduction = 0.32 * taxExcess + 490000;
            } else {
                taxExcess = annulSalary - 8000000;
                taxDeduction = 0.35 * taxExcess + 2410000;
            }

            monthlyRate = annulSalary / 12;
            dailyRate = monthlyRate / 22; // formula of annual salary greater than 250000
            hourlyRate = dailyRate / 8;
            annualTaxDeduction = taxDeduction;
            monthlyTaxDeduction = annualTaxDeduction / 12;
            netPay = monthlyRate - monthlyTaxDeduction;

            System.out.println("Your Monthly Rate			: " + String.format("%.2f", monthlyRate));
            System.out.println("Your Daily Rate				: " + String.format("%.2f", dailyRate));
            System.out.println("Your Hourly Rate			: " + String.format("%.2f", hourlyRate)); // to output the
                                                                                                      // data
            System.out.println("Your Annual Tax Deduction	: " + String.format("%.2f", annualTaxDeduction));
            System.out.println("Monthly Tax Deduction		: " + String.format("%.2f", monthlyTaxDeduction));
            System.out.println("Net Pay					    : " + String.format("%.2f", netPay));
            System.out.println("Redo? If not then type no. ");

            String redo = scanner.next();
            // take a string using .next()
            // yes or somthing else
            if (redo.equalsIgnoreCase("no")) {
                break;
            }
        }
        System.out.println("Program is closed!");
        scanner.close();
    }
}