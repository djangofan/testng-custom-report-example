package qa.test;

import org.testng.ITest;

public abstract class BaseTest implements ITest
{

    private String testName;

    @Override
    public String getTestName()
    {
        return this.testName;
    }

    public void setTestName( String tn )
    {
        this.testName = tn;
    }

}
