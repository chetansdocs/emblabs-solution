package com.emblabs.assignment;

import org.junit.Assert;
import org.junit.Test;

public class MouseCheeseProblemTest {
    @Test
    public void getMaximumCheese() {
        MouseCheeseProblem mouseCheeseProblem = new MouseCheeseProblem();
        int [] input = new int[] {8, 5, 10, 100, 10, 5};
        int maxCheese = mouseCheeseProblem.getMaximumCheese(input);
        Assert.assertEquals(113, maxCheese);
    }
}