package calculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void step1TestEmptyString() {
        String nums = "";
        Assert.assertEquals(0, StringCalculator.add(nums));
    }

    @Test
    public void step1TestStringWithOneDigit(){
        String nums = "1";
        Assert.assertEquals(1, StringCalculator.add(nums));
    }

    @Test
    public void step1TestStringWithTwoDigits(){
        String nums = "1, 2";
        Assert.assertEquals(3, StringCalculator.add(nums));
    }
}