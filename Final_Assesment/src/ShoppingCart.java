import java.util.Locale;

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
        inCartTickets = new Ticket[CAPACITY];
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
    public String getCustomerName(){return customerName;}

    // Date Getter
    public String getDate(){return date;}


    // Customer name setter
    public void setCustomerName(String name) {
        customerName = name;
    }

    // Date Setter
    public void setDate(String date){
        this.date = date;
    }


    // This method validates the entry of a ticket in to the cart then returns true or false
    public boolean add(Ticket ticket) {
        // Check if ticket passed is null be looking for default name
        if (ticket.getName() == "") {
            System.out.println("Ticket invalid or already added.");
            return false;
        } else {

            // Check if index 0 is null
            if (inCartTickets[0] == null) {
                inCartTickets[0] = ticket;
                count += 1;
                return true;
            }

            // Run through array and check if ticket already exists
            for (int i = 0; i <= count - 1; i++) {

                // Compare name in the input compared to array
                if (ticket.getName().toLowerCase() == inCartTickets[i].getName().toLowerCase()) {
                    System.out.println("Ticket invalid or already added.");
                    return false;
                }

            }

            // Finding if array is full and if it is returning false
            if (count - 1 == CAPACITY) {
                System.out.println("SHOPPING CART IS FULL");
                return false;
            } else {

                inCartTickets[count] = ticket;
                count += 1; //
                return true;
            }


        }
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
        boolean recordExists = false;

        System.out.println(customerName + " - " + date);

        // Check if the shopping cart is empty and if it is print "Shopping cart is empty
        if (count == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
            return;
        }

       // DEBUG
        System.out.println(inCartTickets[0].getName() + " X " + inCartTickets[0].getQuantity() + " $" + inCartTickets[0].getPrice() + " $" + inCartTickets[0].getTotalPrice());
        System.out.println(inCartTickets[1].getName() + " X " + inCartTickets[1].getQuantity() + " $" + inCartTickets[1].getPrice() + " $" + inCartTickets[1].getTotalPrice());
       //

        // Run through all possible record and print if the name is not null
        for (int i = 0; i <= count - 1; i++) {

            if (inCartTickets[i].getName() != "") {
                System.out.println(inCartTickets[i].getName() + " X " + inCartTickets[i].getQuantity() + " $" + inCartTickets[i].getPrice() + " $" + inCartTickets[i].getTotalPrice());
            }
        }
    }
}
