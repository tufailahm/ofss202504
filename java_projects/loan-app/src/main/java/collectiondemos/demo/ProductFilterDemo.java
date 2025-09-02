package collectiondemos.demo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductFilterDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 55000, 5),
            new Product(2, "Mobile", 25000, 15),
            new Product(3, "Tablet", 15000, 8),
            new Product(4, "Headphones", 2000, 50),
            new Product(5, "Smartwatch", 12000, 20)
        );

        // Predicate for price greater than 10,000
        Predicate<Product> pricePredicate = p -> p.getPrice() > 10000;

        // Predicate for quantity greater than 10
        Predicate<Product> quantityPredicate = p -> p.getQuantity() > 10;

        // Combine predicates using AND
        List<Product> filteredProducts = products.stream()
                .filter(pricePredicate.and(quantityPredicate))
                .collect(Collectors.toList());

        System.out.println("Products with price > 10000 AND quantity > 10:");
        filteredProducts.forEach(System.out::println);

        // Combine predicates using OR
        List<Product> orFilteredProducts = products.stream()
                .filter(pricePredicate.or(quantityPredicate))
                .collect(Collectors.toList());

        System.out.println("\nProducts with price > 10000 OR quantity > 10:");
        orFilteredProducts.forEach(System.out::println);

        // Negate predicate
        List<Product> negatedProducts = products.stream()
                .filter(pricePredicate.negate())
                .collect(Collectors.toList());

        System.out.println("\nProducts with price <= 10000:");
        negatedProducts.forEach(System.out::println);
    }
}
