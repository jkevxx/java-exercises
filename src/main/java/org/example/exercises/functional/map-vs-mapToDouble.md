# `mapToDouble()` vs `map()`

In this exercise, using `mapToDouble()` is a good approach because you want to calculate a numeric total.

```java
double total = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .mapToDouble(Product::getPrice)
        .sum();
```

## Why Use `mapToDouble()` Here?

`Product::getPrice` returns a `double`.

When you want to work with primitive numeric values like `double`, `int`, or `long`, Java streams provide specialized methods:

| Method | Result Stream | Common Use |
|---|---|---|
| `mapToDouble()` | `DoubleStream` | Prices, averages, decimal totals |
| `mapToInt()` | `IntStream` | Counts, quantities, integer totals |
| `mapToLong()` | `LongStream` | Large integer values |

`DoubleStream` has numeric methods like:

```java
.sum()
.average()
.min()
.max()
```

That is why this works directly:

```java
.mapToDouble(Product::getPrice)
.sum();
```

## Do You Really Need `mapToDouble()`?

For this exercise, yes, it is the better option if your goal is to calculate the total price.

You could use `map()`, but it would be less direct:

```java
double total = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .map(Product::getPrice)
        .reduce(0.0, Double::sum);
```

This works, but it creates a `Stream<Double>` instead of a `DoubleStream`.

The `mapToDouble()` version is clearer for numeric calculations:

```java
double total = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .mapToDouble(Product::getPrice)
        .sum();
```

## When To Use `map()`

Use `map()` when you want to transform each element into another object or value, but you are not mainly doing primitive numeric calculations.

Example: get product names.

```java
List<String> names = products.stream()
        .map(Product::getName)
        .toList();
```

Example: get product categories.

```java
List<String> categories = products.stream()
        .map(Product::getCategory)
        .toList();
```

Example: create a custom text description.

```java
List<String> descriptions = products.stream()
        .map(product -> product.getName() + " - $" + product.getPrice())
        .toList();
```

## When To Use `mapToDouble()`

Use `mapToDouble()` when each product needs to become a `double` and you want to calculate something numeric.

Example: total price.

```java
double total = products.stream()
        .mapToDouble(Product::getPrice)
        .sum();
```

Example: average price.

```java
double average = products.stream()
        .mapToDouble(Product::getPrice)
        .average()
        .orElse(0.0);
```

Example: highest price.

```java
double maxPrice = products.stream()
        .mapToDouble(Product::getPrice)
        .max()
        .orElse(0.0);
```

## Rule Of Thumb

Use `map()` when transforming objects into other objects.

Use `mapToDouble()` when transforming objects into `double` values for numeric operations like `sum`, `average`, `min`, or `max`.

For this exercise, this is the best version:

```java
double total = products.stream()
        .filter(product -> product.getCategory().equals("frutas"))
        .mapToDouble(Product::getPrice)
        .sum();
```
