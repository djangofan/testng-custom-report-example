package qa.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.test.BaseTest;
import java.util.UUID;

public class BeforeTestSkip extends BaseTest
{
    @BeforeMethod
    private void setName()
    {
        setTestName( UUID.randomUUID().toString().substring(0,8) );
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

