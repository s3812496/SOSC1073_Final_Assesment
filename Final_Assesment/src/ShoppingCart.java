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

    public boolean add(Ticket ticket) {



        return false;
    }
}
