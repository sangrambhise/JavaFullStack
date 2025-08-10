package com.wipro.test;
import org.junit.Test;
import com.wipro.clienttest.Calculator;
import static org.junit.Assert.*;

public class CalcTest {
 @Test
 public void addPositive() {
     Calculator calc = new Calculator();
     int sum = calc.add(2, 3);
     assertTrue(sum == 5);
 }

 @Test
 public void addNegative() {
     Calculator calc = new Calculator();
     int sum = calc.add(2, 3);
     assertFalse(sum == 6);
 }
}
