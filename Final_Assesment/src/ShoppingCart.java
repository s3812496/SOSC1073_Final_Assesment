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
}
