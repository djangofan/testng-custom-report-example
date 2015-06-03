package qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.test.BaseTest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AssertTests1 extends BaseTest
{
    @BeforeMethod
    private void setName(Method m)
    {
        setTestName(m.getName());
    }

    @Test
    public void noOrderSuccess() {
        randomWait();
        String[] rto1 = {"boolean", "BigInteger", "List",};
        String[] rto2 = {"List", "BigInteger", "boolean",};
        Assert.assertEqualsNoOrder(rto1, rto2);
    }


    @Test(expectedExceptions = AssertionError.class)
    public void noOrderFailure() {
        randomWait();
        String[] rto1 = {"a", "a", "b",};
        String[] rto2 = {"a", "b", "b",};
        Assert.assertEqualsNoOrder(rto1, rto2);
    }

    @Test
    public void intArray_Issue4() {
        randomWait();
        int[] intArr00 = {1};
        int[] intArr01 = {1};
        Assert.assertEquals(intArr00, intArr01);
    }

    @Test
    public void int_Integer_Arrays() {
        randomWait();
        int[] intArr = {1, 2};
        Integer[] integerArr = {1, Integer.valueOf(2)};
        Assert.assertEquals(intArr, integerArr);
        Assert.assertEquals(integerArr, intArr);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void arraysFailures_1() {
        randomWait();
        int[] intArr = {1, 2};
        long[] longArr = {1, 2};
        Assert.assertEquals(intArr, longArr);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void arraysFailures_2() {
        randomWait();
        int[] intArr = {1, 2};
        Assert.assertEquals(intArr, Long.valueOf(1));
    }

    @Test(expectedExceptions = AssertionError.class)
    public void arraysFailures_3() {
        randomWait();
        long[] longArr = {1};
        Assert.assertEquals(Long.valueOf(1), longArr);
    }

    @Test
    public void setsSuccess() {
        randomWait();
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        set1.add(1);
        set2.add(1);
        set1.add(3);
        set2.add(3);
        set1.add(2);
        set2.add(2);
        Assert.assertEquals(set1, set2);
        Assert.assertEquals(set2, set1);
    }

}

