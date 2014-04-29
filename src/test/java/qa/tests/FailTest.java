package qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.Sets;
import qa.test.BaseTest;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class FailTest extends BaseTest {

    Random random = new Random();

    @BeforeMethod
    private void setName()
    {
        setTestName( UUID.randomUUID().toString().substring(0,8) );
    }

    @Test
    public void setsSuccess() {
        randomWait();
        Set<Integer> set1 = Sets.newHashSet();
        Set<Integer> set2 = Sets.newHashSet();
        set1.add(1);
        set2.add(1);
        set1.add(3);
        set2.add(3);
        set1.add(2);
        set2.add(2);
        Assert.assertEquals(set1, set2);
        Assert.assertEquals(set2, set1);
    }

    @Test( enabled = true )
    public void showFailure() {
        randomWait();
        Assert.fail();
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

