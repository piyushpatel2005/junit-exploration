package com.github.piyushpatel2005.assertions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {
    @Test
    void testBooleansWithoutMessage() {
        assertTrue(true);
        assertFalse(false);
        int value = 6;
        // supplier is used to avoid unnecessary computation
        assertTrue(Assertion.greaterThanFive(value));
        assertTrue("bar".equals("bar")); // not ideal, use assertEquals
    }

    @Test
    void testBooleansWithMessage() {
        assertTrue(true, "This should pass");
        assertFalse(false, "This should pass");
        int value = 6;
        // supplier with message
        assertTrue(Assertion.greaterThanFive(value), String.format("%d is not greater than 5", value));
        assertTrue("bar".equals("bar"), "This should pass"); // not ideal, use assertEquals
    }

    @Test
    void testStrings() {
        assertEquals("foo", "foo");
        assertNotEquals("foo", "bar");
        assertSame("foo", "foo");
//        assertSame(new String("foo"), new String("foo"));
    }

    @Test
    void testPrimitives() {
        assertEquals(1, 1);
        assertEquals(1.2, 1.2);
        assertEquals(1, 1.0);
        assertNotEquals(1.0, 0.99);
        assertEquals('a', 'a');
        assertNotEquals('a', 'A', "Lowercase a is not equal to uppercase A");
        assertEquals('a', 97);
    }

    @Test
    void testNull() {
        assertNull(null);
        assertNotNull(new String("Hello"));
        assertNull(null, "This should be null");
    }

    @Test
    void testAssertSame() {
        String str = "foo";
        String str2 = str;
        assertSame(str, str2, "Strings are same");
        String str3 = new String("foo");
        assertNotSame(str, str3, "Strings are not same");
    }

    @Test
    void testArrays() {
        int[] nums = {1,2,3};
        int[] nums2 = {1,2,3};
        assertArrayEquals(nums, nums2);
        assertNotSame(nums, nums2, "Two arrays are equal"); // not same object
        nums2 = new int[]{2,3,1};
//        assertArrayEquals(nums, nums2); // checks orders too
    }

    @Test
    void testIterables() {
        Iterable<String> list1 = List.of("foo", "bar");
        Iterable<String> list2 = List.of("foo", "bar");
        assertIterableEquals(list1, list2, "Two lists are equal");
    }

    @Test
    void testAssertAll() {
        assertAll(
                () -> assertTrue(true),
                () -> assertFalse(false),
                () -> assertEquals("foo", "foo")
        );
        assertAll(
                () -> assertTrue(true, "This should pass"),
                () -> assertFalse(false, "This should pass"),
                () -> assertEquals("foo", "foo", "This should pass")
        );
    }

    @Test
    void testThrows() {
        assertThrows(ArithmeticException.class, () -> Assertion.divide(2,0));
        assertDoesNotThrow(() -> Assertion.divide(4,2));
        assertThrowsExactly(ArithmeticException.class, () -> Assertion.divide(2,0));
        assertThrows(RuntimeException.class, () -> Assertion.divide(2,0));
//        assertThrowsExactly(RuntimeException.class, () -> Assertion.divide(2,0)); // fail
    }

//    @Test
//    void futureFeature() {
//        fail("Not implemented");
//    }

    @Disabled
    @Test
    void disabledTest() {
        fail("This test is disabled");
    }
}
