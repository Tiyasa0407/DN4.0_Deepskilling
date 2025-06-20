import java.util.*;

// Step 2: Product class with attributes
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class EcommerceSearch {

    // Step 3a: Linear Search (O(n) Time Complexity)
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Step 3b: Binary Search (O(log n) Time Complexity) - requires sorted array
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Step 1: Print Asymptotic Notation Explanation
    public static void explainAsymptoticNotation() {
        System.out.println("Step 1: Asymptotic Notation");
        System.out.println("Big O notation expresses the worst-case time complexity of algorithms.");
        System.out.println("Linear Search: O(n) - checks each item.");
        System.out.println("Binary Search: O(log n) - halves the search space each step (requires sorted data).");
        System.out.println("Best Case: O(1) for both if the item is found immediately.");
        System.out.println("\n");
    }

    // Step 4: Analysis
    public static void compareAlgorithms() {
        System.out.println("\n Step 4: Time Complexity Analysis ");
        System.out.println("Linear Search: Time Complexity O(n)");
        System.out.println("Binary Search: Time Complexity O(log n)");
        System.out.println("Use Binary Search for large, sorted datasets for faster performance.");
        System.out.println("Use Linear Search for small or unsorted data.\n");
    }

    public static void main(String[] args) {
        explainAsymptoticNotation();

        // Step 2: Setup products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Desk", "Furniture"),
            new Product(105, "Phone", "Electronics")
        };

        String searchTarget = "Keyboard";

        // Step 3: Linear Search
        System.out.println("Performing Linear Search...");
        Product linearResult = linearSearch(products, searchTarget);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Product not found"));

        // Sort the array for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Step 3: Binary Search
        System.out.println("\nPerforming Binary Search...");
        Product binaryResult = binarySearch(products, searchTarget);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Product not found"));

        compareAlgorithms();
    }
}
