package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG implements ITestListener{
	
	BaseClass base = new BaseClass();

	public void onTestStart(ITestResult result) {
		System.out.println("test result on start");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test result on success");
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			base.getScreenShots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test result on skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
