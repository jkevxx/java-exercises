package org.example.exercises.functional;

import java.util.*;
import java.util.stream.Collectors;


/*
 * Source: https://youtu.be/ElwZJVBCnGU
 */
public class Main {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Manzana", "frutas", 1, 2.5),
                new Product("Leche", "lácteos", 2, 1.2),
                new Product("Pan", "panadería", 5, 1.0),
                new Product("Yogur", "lácteos", 3, 1.8),
                new Product("Pera", "frutas", 4, 3.0),
                new Product("Naranja", "frutas", 6, 2.0),
                new Product("Queso", "lácteos", 2, 3.5),
                new Product("Manteca", "lácteos", 1, 2.2),
                new Product("Harina", "panadería", 3, 1.5),
                new Product("Arroz", "alimentos", 4, 1.8),
                new Product("Tomate", "frutas", 5, 1.2),
                new Product("Lechuga", "verduras", 2, 0.9),
                new Product("Pescado", "pescadería", 1, 4.0),
                new Product("Pollo", "carnes", 3, 5.0),
                new Product("Carne", "carnes", 2, 6.5)
        );

        // 1. Filtrar productos de la categoría "frutas"
        /*List<Product> frutas = products.stream()
                .filter(p -> p.getCategory().equals("frutas"))
                .collect(Collectors.toList());*/

        List<Product> fruit = products.stream()
                .filter(product -> product.getCategory().equals("frutas"))
                .toList();

//        System.out.println(fruit);
        /*System.out.printf("Fruits: %s%n%n", fruit.stream()
                .map(Product::getName)
                .toList());*/

        // 2. Calcular el precio total de los productos en "lácteos"
        double total = products.stream()
                .filter(product -> product.getCategory().equals("lácteos"))
                .mapToDouble(Product::getPrice)
                .sum();
//        System.out.printf("Total de lacteos: %.2f%n", total);

        // 3. Obtener el producto con el precio más bajo
        Product lowPrice = products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);

//        System.out.println(lowPrice);
        /*System.out.printf("Producto mas barato: %s | precio: %.2f%n%n",
                lowPrice.getName(), lowPrice.getPrice());*/

        // 4. Agrupar productos por categoría
        Map<String, List<Product>> productByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        /*System.out.println("Productos por categoria");
        System.out.println("======================");
        productByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("%n%s%n", entry.getKey().toUpperCase());
                    entry.getValue().forEach(product -> System.out.printf(
                            "  %-10s | cantidad: %2d | precio: %.2f%n",
                            product.getName(), product.getAmount(), product.getPrice()));
                });*/

        // 5. Calcular el precio promedio de los productos por categoría
        Map<String, Double> productPriceByCategory = products.parallelStream()
                .collect(
                        Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(p -> p.getPrice()))
                );

        System.out.println("Price by category: "+ productPriceByCategory);

        // 6. Obtener la categoría con el precio promedio más alto
        String moreExpensiveCategory = productPriceByCategory.entrySet().parallelStream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Not available");

        System.out.println("More expensive Category " + moreExpensiveCategory);

    }
}
