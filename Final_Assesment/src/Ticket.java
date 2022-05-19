public class Ticket {
    protected String name;
    protected int price;
    protected int quantity;

    // Default constructor
    public Ticket() {
        name = "UNKNOWN";
        price = -1;
        quantity = 0;
    }

    public Ticket(String name, int price, int quantity) {
        // Checks to see if a name exists if not it does not set the name
        if (name != null) {
            this.name = name;
        }

        // Checks to see if price is 0 or greater and sets it, otherwise it throws
        // an exception
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(price + " is less than 0, price can not bee less than 0");
        }

        if (quantity >= 1) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException(quantity + " is less than 1, quantity can not be less than 1");
        }
    }


    // Checks name is valid and sets
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }


    // Returns name
    public String getName(){return this.name;}


    // Checks price is valid and sets
    public void setPrice(int price){
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(price + " is less than 0, price can not bee less than 0");
        }
    }


    // Returns price
    public int getPrice(){return this.price;}


    // Checks quantity is valid and sets
    public void setQuantity(int quantity) {
        if (quantity >= 1) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException(quantity + " is less than 1, quantity can not be less than 1");
        }
    }


    // Returns quantity
    public int getQuantity(){return this.quantity;}


    // Returns total price
    public int getTotalPrice(){return (this.price * this.quantity);}


    // Prints out the information of this object
    public String toString() {
        return (this.name + " " + this.quantity + " X $" + this.price + " = $" + getTotalPrice());
    }


}
