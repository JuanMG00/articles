package com.radax.products;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
class ControllerTest {


    @Test
    void test1() {
        assertEquals(3, 1 + 2);
    }
    @Test
    void test2() {
        assertEquals(5, 3 + 2);
    }
    @Test
    void test3() {
        assertEquals(4, 2 + 2);
    }
    @Test
    void test4() {
        assertEquals("ma", "m" + "a");
    }

}
