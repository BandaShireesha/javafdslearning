public class shoppingCartFixed {
    public static void main(string[] args) {
    try {
        int quantity = Integer.parseInt("abc");
        double price = 100.0;
        double price = quantity * price;
        System.out.println("Total: " + total);
    }catch (NumberFormatException e) {
         System.out.println(" Invalid quantity entered. please enter a number.");
         System.out.println(" using default quantity: 1");
         double total = 100.0; //Failback vaiue
         System.out.println("Total: " + total);
    }
    System.out.println("checkout completed successfully!");
    }
}