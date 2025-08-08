package com.wipro.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringNullTest {

    @Test
    public void testToUpperCase_NullString_ThrowsException() {
        String str = "Hi Guys";
        assertThrows(NullPointerException.class, () -> {
            str.toUpperCase();
        });
    }
}
