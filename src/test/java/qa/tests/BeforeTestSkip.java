package qa.tests; /**
 * Created by austenjt on 4/27/2014.
 */

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.Sets;

import java.util.Random;
import java.util.Set;

public class BeforeTestSkip {

    Random random = new Random();

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

    private void randomWait() {
        try {
            // Sleep a random length of time from 0.5s-3s
            Thread.sleep( random.nextInt(2500) + 500 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}

