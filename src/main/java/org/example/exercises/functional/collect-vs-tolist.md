# `collect(Collectors.toList())` vs `toList()`

In `Main.java`, both examples filter the products whose category is `"frutas"` and return a `List<Product>`.

```java
List<Product> frutas = products.stream()
        .filter(p -> p.getCategory().equals("frutas"))
        .collect(Collectors.toList());

List<Product> fruit = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .toList();
```

## Main Differences

| Feature | `.collect(Collectors.toList())` | `.toList()` |
|---|---|---|
| Java version | Java 8+ | Java 16+ |
| Result list | Usually mutable | Unmodifiable |
| Can add/remove items? | Usually yes | No |
| Syntax | More verbose | Shorter |
| Flexibility | More flexible with other collectors | Only creates a list |

## Mutability Example

```java
frutas.add(new Product("Banana", "frutas", 1, 2.0));
```

This usually works because `collect(Collectors.toList())` normally returns a mutable list.

```java
fruit.add(new Product("Banana", "frutas", 1, 2.0));
```

This throws `UnsupportedOperationException` because `toList()` returns an unmodifiable list.

## When To Use Each One

Use `.toList()` when you only need to read, print, or return the result:

```java
List<Product> fruit = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .toList();
```

Use `.collect(Collectors.toList())` when you need a list that you can modify afterward:

```java
List<Product> frutas = products.stream()
        .filter(p -> p.getCategory().equals("frutas"))
        .collect(Collectors.toList());
```

For the current example in `Main.java`, `.toList()` is a good choice because the result is only printed.
