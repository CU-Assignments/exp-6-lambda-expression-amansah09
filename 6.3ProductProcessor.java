import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Smartphone", "Electronics", 800),
            new Product("TV", "Electronics", 1500),
            new Product("Refrigerator", "Appliances", 2000),
            new Product("Washing Machine", "Appliances", 1000),
            new Product("Microwave", "Appliances", 500),
            new Product("Sofa", "Furniture", 700),
            new Product("Dining Table", "Furniture", 1200),
            new Product("Chair", "Furniture", 150),
            new Product("Bed", "Furniture", 1800)
        );

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category, 
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.get()));

        double averagePrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage price of all products: $" + String.format("%.2f", averagePrice));
    }
}
