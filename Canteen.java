import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Food menu and prices
        String[] food = {
            "Cheese Stick",
            "Fries",
            "Hotdog Sandwich",
            "Barbeque",
            "Chicken"
        };

        double[] price = {
            20, 30, 40, 50, 60
        };

        // Variables for tracking purchases
        int totalQuantity = 0;
        double totalAmount = 0;
        double totalDiscount = 0;

        // Display the menu
        System.out.println("====== MENU ======");

        for (int i = 0; i < food.length; i++) {
            System.out.printf("%d. %s - PHP %.2f%n", i + 1, food[i], price[i]);
        }

        String again = "Y";

        // Start the ordering process
        while (again.equalsIgnoreCase("Y")) {

            System.out.print("\nEnter item number: ");
            int item = input.nextInt();
            
            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            String student = input.next();

            // Check if the order is valid
            if (item < 1 || item > 5 || quantity < 1 || quantity > 10 ||
                (!student.equalsIgnoreCase("Y") && !student.equalsIgnoreCase("N"))) {

                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                System.out.println("Please enter your order again.");

                continue;
            }

            // Calculate the order amount
            double amount = price[item - 1] * quantity;
            double discount = 0;

            // Apply the discount
            if (student.equalsIgnoreCase("Y") && amount >= 500) {
                discount = amount * 0.15;
            } else if (student.equalsIgnoreCase("Y")) {
                discount = amount * 0.10;
            } else if (amount >= 500) {
                discount = amount * 0.05;
            }

            // Save the valid order
            totalQuantity += quantity;
            totalAmount += amount;
            totalDiscount += discount;

            // Display the order details
            System.out.printf("\nSubtotal: PHP %.2f%n", amount);
            System.out.printf("Discount: PHP %.2f%n", discount);
            System.out.printf("Order total: PHP %.2f%n", amount - discount);

            // Ask if the customer wants to order again
            while (true) {

                System.out.print("\nDo you want to order again? (Y/N): "); 
                    again = input.next();

                if (again.equalsIgnoreCase("Y") || again.equalsIgnoreCase("N")) {
                    break;
                }

                System.out.println("Please enter Y for Yes or N for No.");
            }
        }

        // Final order summary
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total quantity of items purchased: " + totalQuantity);
        System.out.printf("Total amount before deductions: PHP %.2f%n", totalAmount);
        System.out.printf("Total deduction: PHP %.2f%n", totalDiscount);
        System.out.printf("Final amount to pay: PHP %.2f%n", totalAmount - totalDiscount);

        System.out.println("\nThank you for ordering!");

        input.close();
    }
}