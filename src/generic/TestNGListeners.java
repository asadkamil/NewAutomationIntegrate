package generic;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class TestNGListeners implements ITestListener, ISuiteListener
{
	@Override
	public void onFinish(ISuite suite) {
		System.out.println(suite.getName()+"--->> Suite Finished....");
	}

	@Override
	public void onStart(ISuite suite) {

		System.out.println(suite.getName()+"--->>Suite Started.....");
	}

	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName()+"-->>Block Finished....",true);
	}

	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName()+"-->>Block started...",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("one or the other testMethods failed");
	}

	@Override
	public void onTestFailure(ITestResult testMethod) {
		Reporter.log(testMethod.getName()+"--->>test Method failed....",true);
	}

	@Override
	public void onTestSkipped(ITestResult testMethod) {
		Reporter.log(testMethod.getName()+"---->> testMethod SKIPPED....",true);
	}

	@Override
	public void onTestStart(ITestResult testMethod) {
		Reporter.log(testMethod.getName()+"--->>testMethod Started....",true);
	}

	@Override
	public void onTestSuccess(ITestResult testMethod) {
		Reporter.log(testMethod.getName()+"---->>testMethod Passed....",true);
	}
}