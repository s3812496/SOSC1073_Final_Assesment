import java.util.Scanner;

public class ShoppingCart {

    // Private Variables
    private String customerName;
    private String date;
    private Ticket[] inCartTickets;
    private static final int CAPACITY = 5;
    private int count;


    // Default constructor
    public ShoppingCart() {
        customerName = "UNKNOWN";
        date = "1 MAY 2022";
        inCartTickets  = new Ticket[CAPACITY];
        count = 0;
    }

    // Constructor that defines name and date
    public ShoppingCart(String name, String date) {
        customerName = name;
        this.date = date;
        inCartTickets = new Ticket[CAPACITY];
        count = 0;
    }


    // Customer name Getter
    public String getCustomerName() {
        return customerName;
    }

    // Date Getter
    public String getDate() {
        return date;
    }


    // Customer name setter
    public void setCustomerName(String name) {
        customerName = name;
    }

    // Date Setter
    public void setDate(String date) {
        this.date = date;
    }


    // This method validates the entry of a ticket in to the cart then returns true or false
    public boolean add(Ticket ticket) {

        // Check if index 0 is null
        if (count == 0) {
            inCartTickets[0] = ticket;
            iterateCount();
            return true;
        }

        // Run through array and check if ticket already exists
        for (int i = 0; i <= count - 1; i++) {

            // Compare name in the input compared to array
            if (ticket.getName().toLowerCase().equals(inCartTickets[i].getName().toLowerCase())) {
                System.out.println("Ticket invalid or already added.");
                return false;
            }

        }

        // Finding if array is full and if it is returning false
        if (count - 1 == CAPACITY) {
            System.out.println("SHOPPING CART IS FULL");
            return false;
        }

        // If all conditions are met set variable and return true
        inCartTickets[count] = ticket;
        iterateCount();
        return true;

    }


    // This method runs through all the shopping cart entries and adds up the quantity
    public int getTotalCount() {
        int TotalCount = 0;

        // Run through a for loop and add the quantity up for all the tickets in the cart
        for (int i = 0; i <= count - 1; i++) {
            TotalCount = TotalCount + inCartTickets[i].getQuantity();
        }
        return TotalCount;
    }

    // This Method adds up the total cost of all tickets by calling the total cost method in a loop
    public int getCost(){
        int totalCost = 0;

        // for every entry call up the get price method and add it to the total
        for (int i = 0; i <= count - 1; i++){
            totalCost = totalCost + inCartTickets[i].getPrice();
        }

        return totalCost;
    }

    // This method prints the information of the shopping cart and prints "Shopping cart is empty" if no records exist
    public void printTotal(){

        int totalcost = 0;

        System.out.println(customerName + " - " + date);

        // Check if the shopping cart is empty and if it is print "Shopping cart is empty
        if (count == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
            return;
        }

        // Run through all possible record and print if the name is not null
        for (int i = 0; i <= count - 1; i++) {

            try {
                if (inCartTickets[i].getName() != null) {
                    System.out.println(inCartTickets[i].toString());
                    totalcost += inCartTickets[i].getTotalPrice();
                }
            } catch (NullPointerException e) {

            }
        }

        // Print the total cost off all the tickets.
        System.out.println("Total cost: $" + totalcost);
    }

    // Iterating count outside the method, so it will stick when it gets called next
    private void iterateCount() {
        count += 1;
    }


    // Method to remove a ticket
    public void removeTicket(String ticketName) {

        // Loop through array and check the name against the input if true remove the name and return, if false display that it was not found
        for (int i = 0; i <= count - 1; i++) {
            if (inCartTickets[i].getName().toLowerCase().equals(ticketName.toLowerCase())) {
                // remove record
                inCartTickets[i] = null;
                System.out.println("Ticket " + ticketName + " removed from the cart.");
                // When removed exit loop
                return;
            }
        }
        // Not found
        System.out.println("Ticket not found. Cart remains unchanged.");
    }

    // Method to update the quantity on a pre-existing ticket
    public void updateTicket(String ticketName) {
        Scanner scan = new Scanner(System.in);

        // Loop through and check the name against the input if true prompt the user for the new quantity if not display it was not found
        for (int i = 0; i <= count - 1; i++) {
            try {
                if (inCartTickets[i].getName().toLowerCase().equals(ticketName.toLowerCase())) {
                    // Prompt for new quantity
                    System.out.println("Please enter the new quantity:");
                    // Update the quantity
                    inCartTickets[i].setQuantity(scan.nextInt());
                    return;
                }
            } catch (NullPointerException e) {}
        }

        System.out.println("Ticket not found. Cart remains unchanged.");
    }

    // Method to checkout
    public void checkout() {

        // Print out total
        this.printTotal();

        if (count == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
        }

        // Setting all record to null
        for (int i = 0; i <= count - 1; i++) {
            inCartTickets[i] = null;
        }

        // Reset count index
        count = 0;

        // Print thank you message
        System.out.println("Thank you for shopping");

    }

}
