package collectiondemos;

import java.util.*;

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
            System.out.println("5. Sort by Quantity - Desc");
            System.out.println("6. Sort by ID - Desc");

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Collections.sort(productsList, new IDComparator());
                    Music music = new Music() {
                        @Override
                        public void play() {
                            System.out.println("Ting");
                        }

                        @Override
                        public void stop() {
                            System.out.println("Tong");
                        }
                    };
                    music.play();
                    music.stop();

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
                    case 5:
                        Collections.sort(productsList, new Comparator<Product>() {
                            @Override
                            public int compare(Product o1, Product o2) {
                                return o1.getQuantity()>o2.getQuantity() ? -1 : 1;
                            }
                        });
                        break;
            case 6:
                    Comparator<Product> comparatorIdDesc = (o1,o2) -> o1.getId() > o2.getId() ? -1 : 1;
                    Collections.sort(productsList, comparatorIdDesc);
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(0);
            }
            System.out.println(productsList);
        }
    }
}
