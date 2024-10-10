# Nested Tests

Nested tests are written using the `@Nested` annotation in JUnit 5. They allow you to group related tests together within a test class. This can help you organize your tests and improve readability.

## Lifecycle Methods in Nested Tests

Nested classes can have their own Lifecycle methods, such as `@BeforeAll`, `@AfterAll`, `@BeforeEach`, and 
`@AfterEach`. These methods are executed before or after the tests in the nested class. Below is an example of nested tests with lifecycle methods.

```java
import org.junit.jupiter.api.*;

public class NestedLifeCycleMethodsTest {
     @BeforeAll
     static void beforeAllOuter() {
         System.out.println("Before all outer");
     }

     @AfterAll
     static void afterAllOuter() {
         System.out.println("After all outer");
     }

     @BeforeEach
     void beforeEachOuter() {
         System.out.println("Before each outer");
     }

     @AfterEach
     void afterEachOuter() {
         System.out.println("After each outer");
     }

     @Test
     void test1() {
         System.out.println("Test 1");
     }

     @Test
     void test2() {
         System.out.println("Test 2");
     }

     @Nested
     class NestedTest {
         @BeforeEach
         void beforeEachInner() {
             System.out.println("Before each for NestedTest");
         }

         @AfterEach
         void afterEachInner() {
             System.out.println("After each for NestedTest");
         }

         @Test
         void test3() {
             System.out.println("Nested: Test 3");
         }

         @Test
         void test4() {
             System.out.println("Nested: Test 4");
         }
     }

     @Nested
     class NestedTest2 {
         @BeforeEach
         void beforeEachInner() {
             System.out.println("Before each for NestedTest2");
         }

         @AfterEach
         void afterEachInner() {
             System.out.println("After each for NestedTest2");
         }

         @Test
         void test5() {
             System.out.println("Nested2: Test 5");
         }

         @Test
         void test6() {
             System.out.println("Nested2: Test 6");
         }
     }
}
```

As you would see from the output that `BeforeAll` and `AfterAll` methods are executed only once for the outer class. 
`BeforeEach` and `AfterEach` methods are executed before and after each test method in the outer class as well as 
inner nested tests. Similarly, `BeforeEach` and `AfterEach` methods are executed before and after each test method in 
the 
nested classes.

```output
Before all outer
Before each outer
Test 1
After each outer
Before each outer
Test 2
After each outer
Before each outer
Before each for NestedTest2
Nested2: Test 5
After each for NestedTest2
After each outer
Before each outer
Before each for NestedTest2
Nested2: Test 6
After each for NestedTest2
After each outer
Before each outer
Before each for NestedTest
Nested: Test 3
After each for NestedTest
After each outer
Before each outer
Before each for NestedTest
Nested: Test 4
After each for NestedTest
After each outer
After all outer
```

## Practical Use case

Nested tests can be used to test related scenarios together. For example, if we have builder pattern to design our 
`Pizza` object, we can write nested tests to test the different scenarios of building a `Pizza` object.

```java