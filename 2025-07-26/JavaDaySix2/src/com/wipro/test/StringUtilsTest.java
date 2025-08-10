package com.wipro.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @Test
    public void testIsUpperCase() {
        assertTrue(StringUtils.isUpperCase("HELLO"));
        assertFalse(StringUtils.isUpperCase("Hello"));
    }
}
