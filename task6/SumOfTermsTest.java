package ru.vsu.cs.aslanovrenat.oldtasks.task6;

import org.junit.Test;

import org.junit.Assert;

public class SumOfTermsTest {
    @Test
    public void testGetDetails() {
        //assume we have some expected results for known n, e, x
        int n = 10;
        double e = 0.01;
        double x = 5;

        //expected results, for example
        double expectedSumN = 74.203211;
        double expectedSumE = 74.177562;
        double expectedSumE10 = 74.200899;

        SumOfTerms result = SumOfTerms.getDetails(n, e, x);

        //compare results
        Assert.assertEquals(expectedSumN, result.sumN, 0.0001);
        Assert.assertEquals(expectedSumE, result.sumE, 0.0001);
        Assert.assertEquals(expectedSumE10, result.sumE10, 0.0001);
    }

}