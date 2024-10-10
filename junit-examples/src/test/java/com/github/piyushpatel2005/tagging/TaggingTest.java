package com.github.piyushpatel2005.tagging;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TaggingTest {
    @Test
    @Tag("fast")
    @Tag("web")
    void webTest1() {
        assertTrue(true);
    }

    @Test
    @Tag("fast")
    @Tag("web")
    void webTest2() {

    }

    @Test
    @Tag("api")
    void apiTest1() {

    }

    @Tag("slow")
    @Test
    void slowTest() throws InterruptedException {
        Thread.sleep(5);
    }
}
