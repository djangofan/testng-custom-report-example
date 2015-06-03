package qa.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.BaseTestMethod;
import org.testng.internal.TestResult;

import java.lang.reflect.Field;

/**
 * @author djangofan
 */
public class TestNameListener extends TestListenerAdapter {

    private void setTestNameInXml(ITestResult tr) {
        try {
            Field mMethod = TestResult.class.getDeclaredField("m_method");
            mMethod.setAccessible(true);
            mMethod.set(tr, tr.getMethod().clone());
            Field mMethodName = BaseTestMethod.class.getDeclaredField("m_methodName");
            mMethodName.setAccessible(true);
            mMethodName.set(tr.getMethod(), tr.getTestName());
        } catch (IllegalAccessException ex) {
            Reporter.log(ex.getLocalizedMessage(), true);
        } catch (NoSuchFieldException ex) {
            Reporter.log(ex.getLocalizedMessage(), true);
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        setTestNameInXml(tr);
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        setTestNameInXml(tr);
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        setTestNameInXml(tr);
        super.onTestSkipped(tr);
    }

}