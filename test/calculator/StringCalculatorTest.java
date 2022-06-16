package calculator;

import exceptions.NegativesAreNotAllowed;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringCalculatorTest {
    @Test
    public void step1TestEmptyString() {
        String nums = "";
        Assert.assertEquals(0, StringCalculator.add(nums));
    }

    @Test
    public void step1TestStringWithOneDigit() {
        String nums = "1";
        Assert.assertEquals(1, StringCalculator.add(nums));
    }

    @Test
    public void step1TestStringWithTwoDigits() {
        String nums = "1, 2";
        Assert.assertEquals(3, StringCalculator.add(nums));
    }

    @Test
    public void step2TestStringWithTenSingleDigitNumbers() {
        String nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
        Assert.assertEquals(45, StringCalculator.add(nums));
    }

    @Test
    public void step2TestStringWithTenTwoDigitNumbers() {
        String nums = "10, 11, 12, 13, 14, 15, 16, 17, 18, 19";
        Assert.assertEquals(145, StringCalculator.add(nums));
    }

    @Test
    public void step3TestStringWithNumbersDelimitedByNewLine1() {
        String nums = "1\\n2,3";
        Assert.assertEquals(6, StringCalculator.add(nums));
    }

    @Test
    public void step3TestStringWithNumbersDelimitedByNewLine2() {
        String nums = "1\\n2,3\\n4\\n\\n5";
        Assert.assertEquals(15, StringCalculator.add(nums));
    }

    @Test
    public void step4TestStringWithNumbersWithDifferentDelimiters() {
        String nums = "//;\\n1;2";
        Assert.assertEquals(3, StringCalculator.add(nums));
    }

    @Test
    public void step4TestStringWithNumbersAndOtherSymbols() {
        String nums = "1**as 2//>3,n45";
        Assert.assertEquals(51, StringCalculator.add(nums));
    }

    @Test
    public void step5TestRetrieveNumsFromStringMethod() {
        String nums = "--2,nk44, 5,fwe(*)$# --55, 6df0";
        List<Integer> result = StringCalculator.retrieveNumbersFromString(nums);
        List<Integer> expected = List.of(-2, 44, 5, -55, 6, 0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void step5TestNegativeValuesToStringMethod() {
        List<Integer> list = List.of(-2, 44, 5, -55, 6, 0, -1, 4, -99);
        String expected = "-2, -55, -1, -99";
        Assert.assertEquals(expected, StringCalculator.negativeValuesToString(list));
    }

    @Test(expected = NegativesAreNotAllowed.class)
    public void step5TestStringWithNegatives() {
        String nums = "--2,nk44, 5,fwe(*)$# --55, 6df0";
        int sum = StringCalculator.add(nums);
    }

    @Test
    public void step6TestStringWithNumbersBiggestThan1000() {
        String nums = "10000, 2544, 334534, 4234, 5123, 65234, 7543, 8234, 91432";
        Assert.assertEquals(0, StringCalculator.add(nums));
    }

    @Test
    public void step6TestStringWithNumbersSmallerAndBiggerThan1000() {
        String nums = "1000, 100, 334534, 500, 8234, 91432, 400";
        Assert.assertEquals(2000, StringCalculator.add(nums));
    }
}