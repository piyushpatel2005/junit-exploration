package com.github.piyushpatel2005.assertions;

import com.github.piyushpatel2005.assertions.Assertion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {
    @Test
    void testBooleans() {
        assertTrue(true);
        assertFalse(false);
        int value = 6;
        assertTrue(Assertion.greaterThanFive(value), String.format("%d is not greater than 5", value));
        assertTrue("bar".equals("bar")); // not ideal, use assertEquals
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
        assertNotEquals('a', 'A');
        assertEquals('a', 97);
    }

    @Test
    void testNull() {
        assertNull(null);
        assertNotNull(new String("Hello"));
    }

    @Test
    void testArrays() {
        int[] nums = {1,2,3};
        int[] nums2 = {1,2,3};
        assertArrayEquals(nums, nums2);
        assertNotSame(nums, nums2); // not same object
        nums2 = new int[]{2,3,1};
//        assertArrayEquals(nums, nums2); // checks orders too
    }

    @Test
    void testThrows() {
        assertThrows(ArithmeticException.class, () -> Assertion.divide(2,0));
        assertDoesNotThrow(() -> Assertion.divide(4,2));
    }

//    @Test
//    void futureFeature() {
//        fail("Not implemented");
//    }
}
