package org.example.exercises.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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

        // 2. Calcular el precio total de los productos en "lácteos"
        double total = products.stream()
                .filter(product -> product.getCategory().equals("lácteos"))
                .mapToDouble(Product::getPrice)
                .sum();
//        System.out.println("Total: " + total);

        // 3. Obtener el producto con el precio más bajo
        Product lowPrice = products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);

        System.out.println(lowPrice);
    }
}
