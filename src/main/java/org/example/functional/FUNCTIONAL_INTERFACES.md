# Functional Interfaces in Java

Functional interfaces are the foundation of Lambda expressions in Java (introduced in Java 8). A functional interface is an interface that contains **exactly one abstract method**.

Below is a summary of the four core functional interfaces demonstrated in this project.

## Summary Table

| Interface | Method Signature | Argument | Returns | Purpose | Reference File |
| :--- | :--- | :---: | :---: | :--- | :--- |
| **Consumer<T>** | `void accept(T t)` | Yes (1) | `void` | Performs an action on an object (side effects). | [ConsumerInterface.java](./ConsumerInterface.java) |
| **Supplier<T>** | `T get()` | No | Yes | Provides/Generates a value (lazy evaluation). | [SupplierInterface.java](./SupplierInterface.java) |
| **Function<T, R>** | `R apply(T t)` | Yes (1) | Yes (R) | Transforms one object into another. | [FunctionInterface.java](./FunctionInterface.java) |
| **Predicate<T>** | `boolean test(T t)` | Yes (1) | `boolean` | Tests a condition (filtering/validation). | [PredicateInterface.java](./PredicateInterface.java) |

---

## Detailed Breakdown

### 1. Consumer<T>
- **Purpose**: Used when you want to "consume" an object. It takes an input and does something with it without returning anything.
- **Typical Use Cases**: Logging, printing to console, updating a database, or modifying the internal state of an object.
- **Composition**: Can be chained using `.andThen(Consumer)`.
- **See**: `ConsumerInterface.java` for examples like `BASIC_LOGGER` and `DETAILED_LOGGER`.

### 2. Supplier<T>
- **Purpose**: Used when you need to retrieve or generate a value without providing any input.
- **Typical Use Cases**: Lazy initialization, generating random numbers, providing timestamps, or supplying default values/error messages only when needed.
- **Key Advantage**: It allows for "lazy evaluation," meaning the code inside the supplier is only executed when `.get()` is called.
- **See**: `SupplierInterface.java` for examples like `TIMESTAMPED_ERROR`.

### 3. Function<T, R>
- **Purpose**: Acts as a bridge or transformer. It takes an input of type `T` and produces a result of type `R`.
- **Typical Use Cases**: Mapping one object to another (e.g., `Person` to `Employee`), converting types (e.g., `String` to `Integer`), or extracting specific fields.
- **Composition**: Can be chained using `.andThen(Function)` or `.compose(Function)`.
- **See**: `FunctionInterface.java` for examples of generating employee IDs based on person data.

### 4. Predicate<T>
- **Purpose**: Represents a boolean-valued function of one argument. It "tests" if an object meets a certain criteria.
- **Typical Use Cases**: Filtering collections (Streams), input validation, or conditional logic.
- **Composition**: Supports logical operations like `.and(Predicate)`, `.or(Predicate)`, and `.negate()`.
- **See**: `PredicateInterface.java` for examples like `HAS_VALID_EMAIL` and `IS_ADMIN`.

---

## Choosing the Right Interface
- If you need to **test** something: Use **Predicate**.
- If you need to **transform** something: Use **Function**.
- If you need to **produce** something from nothing: Use **Supplier**.
- If you need to **do** something with an object: Use **Consumer**.
