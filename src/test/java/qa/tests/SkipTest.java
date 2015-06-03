package qa.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.test.BaseTest;
import qa.test.Data;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SkipTest extends BaseTest
{
    @BeforeMethod
    private void setName(Method m)
    {
        setTestName(m.getName());
    }

    @Test( dataProvider = "dp", dataProviderClass = Data.class )
    public void testSkipException( String testName, Integer num ) {
        randomWait();
        throw new SkipException( "Testing SkipException effect on report output." );
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

