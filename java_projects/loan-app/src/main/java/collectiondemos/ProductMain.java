package collectiondemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();

        Product product1 = new Product(1991, "Donut", 312, 311);
        Product product2 = new Product(12, "Glass", 33, 1);
        Product product3 = new Product(231, "Pizza", 2321, 32);
        Product product4 = new Product(453, "Apple", 2321, 329);

        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
        productsList.add(new Product(1918, "Boat", 818, 99));
        System.out.println(productsList);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Product Sorting Menu ====");
            System.out.println("1. Sort by ID");
            System.out.println("2. Sort by Name");
            System.out.println("3. Sort by Price");
            System.out.println("4. Sort by Quantity");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Collections.sort(productsList, new IDComparator());
                    break;
                case 2:
                    Collections.sort(productsList, new NameComparator());
                    break;
                case 3:
                    Collections.sort(productsList);
                    break;
                case 4:
                    Collections.sort(productsList, new QuantityComparator());
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(0);
            }
            System.out.println(productsList);
        }
    }
}
