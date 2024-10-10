package com.github.piyushpatel2005;

import org.junit.jupiter.api.*;

public class LifeCycleTests {
    @BeforeAll
    static void setUp() {
        System.out.println("BeforeAll Method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach Method");
    }

    @Test
    void testA() {
        System.out.println("Testing A");
    }

    @Test
    void testB() {
        System.out.println("Testing B");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach Method");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("AfterAll Method");
    }
}
