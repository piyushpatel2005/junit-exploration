package com.github.piyushpatel2005.nested;

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
