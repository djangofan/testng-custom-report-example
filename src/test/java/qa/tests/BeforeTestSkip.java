package qa.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.test.BaseTest;
import java.lang.reflect.Method;

public class BeforeTestSkip extends BaseTest
{
    @BeforeMethod
    private void setName(Method m)
    {
        setTestName(m.getName());
    }

    @BeforeMethod
    public void setUp()
    {
        throw new SkipException( "SkipException thrown in setUp method." );
    }

    @Test(expectedExceptions = AssertionError.class)
    public void arraysFailures_3() {
        randomWait();
        long[] longArr = {1};
        Assert.assertEquals(Long.valueOf(1), longArr);
    }

}

