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

    @Test
    public void step2TestStringWithTenSingleDigitNumbers(){
        String nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
        Assert.assertEquals(45, StringCalculator.add(nums));
    }

    @Test
    public void step2TestStringWithTenTwoDigitNumbers(){
        String nums = "10, 11, 12, 13, 14, 15, 16, 17, 18, 19";
        Assert.assertEquals(145, StringCalculator.add(nums));
    }

    @Test
    public void step3TestStringWithNumbersDelimitedByNewLine1(){
        String nums = "1\\n2,3";
        Assert.assertEquals(6, StringCalculator.add(nums));
    }

    @Test
    public void step3TestStringWithNumbersDelimitedByNewLine2(){
        String nums = "1\\n2,3\\n4\\n\\n5";
        Assert.assertEquals(15, StringCalculator.add(nums));
    }
}