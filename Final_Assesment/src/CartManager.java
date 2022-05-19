import java.util.Scanner;

public class CartManager {

    public static void main(String[] args) {
        // Variables to pass through to constructor
        String name;
        int price;
        int quantity;
        Scanner scan = new Scanner(System.in);

        System.out.println("********** Stage 1 **********");
        System.out.println("Enter the name of the ticket:");
        name = scan.nextLine();
        System.out.println("Enter the ticket price:");
        price = scan.nextInt();
        System.out.println("Enter the quantity:");
        quantity = scan.nextInt();

        try {
            Ticket stage1_ticket = new Ticket(name, price, quantity);
            System.out.println(stage1_ticket);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        // Variables to use in stage 2

        String customerName;
        String date;
        scan = new Scanner(System.in);

        // Stage 2, Using the Shopping cart
        System.out.println("********** Stage 2 **********");

        System.out.println("Enter the name of the customer:");
        customerName = scan.nextLine();

        System.out.println("Enter the current date:");
        date = scan.nextLine();

        // Set name and date and initialize object
        ShoppingCart cart = new ShoppingCart(customerName, date);

        cart.printTotal();

        // Call up method for stage 2 to prompt user to enter data.
        cart.add(stage2());
        cart.add(stage2());
        cart.printTotal();

    }

    private static Ticket stage2() {
        String name;
        int price;
        int quantity;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the ticket:");
        name = scan.nextLine();
        System.out.println("Enter the ticket price:");
        price = scan.nextInt();
        System.out.println("Enter the quantity:");
        quantity = scan.nextInt();

        return new Ticket(name, price, quantity);
    }
}
