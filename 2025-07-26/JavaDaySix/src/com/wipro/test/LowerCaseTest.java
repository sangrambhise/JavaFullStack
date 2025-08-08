package com.wipro.test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class LowerCaseTest {
    @ParameterizedTest
    @ValueSource(strings = { "hello", "world", "test", "lowercase" })
    public void testLCase(String str) {
        assertTrue(isLowerCase(str), "String should be lowercase: " + str);
    }
    private boolean isLowerCase(String str) {
        return str.equals(str.toLowerCase());
    }
}