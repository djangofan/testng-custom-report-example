package qa.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.Sets;
import qa.test.BaseTest;
import qa.test.Data;
import java.util.Set;
import java.util.UUID;

public class SkipTest extends BaseTest
{
    @BeforeMethod
    private void setName()
    {
        setTestName( UUID.randomUUID().toString().substring(0, 8) );
    }

    @Test( dataProvider = "dp", dataProviderClass = Data.class )
    public void testSkipException( String testName, Integer num ) {
        randomWait();
        throw new SkipException( "Testing SkipException effect on report output." );
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

}

