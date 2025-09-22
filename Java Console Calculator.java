import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // Method for addition
    public static double add(double[] numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum;
    }

    // Method for subtraction
    public static double subtract(double[] numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    // Method for multiplication
    public static double multiply(double[] numbers) {
        double result = 1;
        for (double n : numbers) {
            result *= n;
        }
        return result;
    }

    // Method for division
    public static double divide(double[] numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                System.out.println("⚠️ Error: Cannot divide by zero!");
                return Double.NaN;
            }
            result /= numbers[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Java Console Calculator =====");

        while (running) {
            try {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                if (choice == 5) {
                    running = false;
                    System.out.println("Exiting Calculator... Goodbye!");
                    break;
                }

                if (choice < 1 || choice > 5) {
                    System.out.println("⚠️ Invalid choice! Try again.");
                    continue;
                }

                System.out.print("Enter how many numbers you want to calculate: ");
                int count = sc.nextInt();

                if (count < 2) {
                    System.out.println("⚠️ Please enter at least 2 numbers.");
                    continue;
                }

                double[] numbers = new double[count];
                for (int i = 0; i < count; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    numbers[i] = sc.nextDouble();
                }

                double result = 0;

                switch (choice) {
                    case 1:
                        result = add(numbers);
                        break;
                    case 2:
                        result = subtract(numbers);
                        break;
                    case 3:
                        result = multiply(numbers);
                        break;
                    case 4:
                        result = divide(numbers);
                        break;
                }

                if (!Double.isNaN(result)) {
                    System.out.printf("✅ Result: %.2f%n", result);
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter numbers only.");
                sc.nextLine(); // clear buffer
            }
        }

        sc.close();
    }
}
