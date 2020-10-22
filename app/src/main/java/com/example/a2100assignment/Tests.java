package com.example.a2100assignment;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void testApproximate() {
        String a = "approximately";
        String b = "approxinatly";
        assertTrue("\'" + a + "\' and \'" + b + "\' should be approximately equal to each other", Car.approximateEqual(a,b));
        String c = "differences";
        String d = "fdifrecesfn";
        assertFalse("\'" + c + "\' and \'" + d + "\' should be approximately equal to each other", Car.approximateEqual(c,d));
    }
}
