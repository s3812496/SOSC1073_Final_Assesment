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
        if (ticket.getName() == "UNKNOWN") {
            System.out.println("Ticket invalid or already added.");
            return false;
        } else {

            // Run through array and check if ticket already exists
            for (int i = 0; i <= inCartTickets.length; i++) {

                // Compare name in the input compared to array
                if (ticket.getName().toLowerCase() == inCartTickets[i].getName().toLowerCase()) {
                    System.out.println("Ticket invalid or already added.");
                    return false;
                } else {

                    // Finding if array is full and if it is returning false
                    if (inCartTickets[inCartTickets.length].getName() != null) {
                        System.out.println("SHOPPING CART IS FULL");
                        return false;
                    } else {

                        // Find the first null entry and place the record in it
                        for (i = 0; i <= inCartTickets.length; i++) {

                            // Using IF statement to find the first empty
                            if (inCartTickets[i].getName() == null) {
                                inCartTickets[i] = ticket;
                                return true;
                            }
                        }
                    }
                }
            }


        }
        return false;
        }

        // This method runs through all the shopping cart entries and adds up the quantity
        public int getTotalCount() {
            int TotalCount = 0;

            // Run through a for loop and add the quantity up for all the tickets in the cart
            for (int i = 0; i <= inCartTickets.length; i++) {
                TotalCount = TotalCount + inCartTickets[i].getQuantity();
            }

        return TotalCount;
    }

    // This Method adds up the total cost of all tickets by calling the total cost method in a loop
    public int getCost(){
        int totalCost = 0;

        // for every entry call up the get price method and add it to the total
        for (int i = 0; i <= inCartTickets.length; i++){
            totalCost = totalCost + inCartTickets[i].getPrice();
        }

        return totalCost;
    }

    // This method prints the information of the shopping cart and prints "Shopping cart is empty" if no records exist
    public void printTotal(){
        
    }
}
