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

        Ticket stage1_ticket = new Ticket(name, price, quantity);

        System.out.println(stage1_ticket);
    }
}
