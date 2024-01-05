package com.teststeps;

import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.pages.MergeVisitPage;
import com.pages.PatientDetailsPage;
import com.pages.RegisterPage;
import com.pages.VitalsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class TestSteps extends SeleniumUtility {
	static ExtentTest test;
	static ExtentReports report;
	LoginPage l = null;
	AdminPage a = null;
	RegisterPage r = null;
	PatientDetailsPage p = null;
	VitalsPage v = null;
	MergeVisitPage m = null;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Knila");
	}

	@BeforeClass
	public void beforeClass() throws Throwable {
		launchBrowser("Chrome");
		test.log(LogStatus.PASS, "Chrome Browser", "Browser lauched successfully");
		openApp(getProperty("url", "System"));
		test.log(LogStatus.PASS, "Application Launch", "Navigated to the specified URL");
	}

	@org.testng.annotations.Test(priority = 0)
	public void VerifyUserDasboardPageIsRedirected() throws IOException, Throwable {
		l = new LoginPage();
		l.LoginWithTheUserToOpenMrsPage(getProperty("username", "System"), getProperty("password", "System"),
				"Pharmacy");
		test.log(LogStatus.PASS, "Successfully logged in with the user: " + getProperty("username", "System"));
		a = new AdminPage();
		a.verifyTheDashboardPage("Pharmacy");
		test.log(LogStatus.PASS, "Dashboard page has been verified successfully.");
	}

	@org.testng.annotations.Test(priority = 1)
	public void RegisterAPatient() throws Throwable, Throwable {
		r = new RegisterPage();
		a.NavigateToRegisterAPatientPage(true);
		test.log(LogStatus.PASS, "Navigate to Patient Register Page", "Successfully navigetd to patient register page");
		r.ProvideDemographicDetals();
		test.log(LogStatus.PASS, "Provideing User details", "New patient details has been added successfully");
	}

	@org.testng.annotations.Test(priority = 2)
	public void VerifyTheDetailsBeforeConfirmationAndClickConfirm() throws IOException, Throwable {
		r.VerifyUserDetailsInConfirmPage();
		test.log(LogStatus.PASS, "Navigate to Patient Register Page", "Successfully navigetd to patient register page");
		r.clickConfirmOption();
		test.log(LogStatus.PASS, "Provideing User details", "New patient details has been added successfully");
	}

	@org.testng.annotations.Test(priority = 3)
	private void VerifyThePatientGenderAndAge() throws ParseException, IOException, Throwable {
		p = new PatientDetailsPage();
		p.VerifyThePatientDetailsAfterConfirmation();
	}
	
	@org.testng.annotations.Test(priority = 4)
	private void StartAndConfirmTheVisit() {
		p.ClickStartVisitAndConfirmTheVisit();
	}
	
	@org.testng.annotations.Test(priority = 5)
	private void ClickTheAttachamentAndUploadTheFile() {
		p.ClickAttachmentAndUploadTheFile("");
	}
	
	@org.testng.annotations.Test(priority = 6)
	private void VerifyAttachedMessage() {
		p.VerifyTheAttachedMessage("The attachment was successfully uploaded.");
	}
	
	@org.testng.annotations.Test(priority = 7)
	private void RedirectToPatientPage() throws IOException, Throwable {
		p.NavigateToPatientPage();
	}
	
	@org.testng.annotations.Test(priority = 8)
	private void VerifyTheAttachedAttachmentInPatientPage() throws IOException, Throwable {
		p.VerifyAttachmentsInPatientPage();
	}

	@org.testng.annotations.Test(priority = 9)
	private void VerifyRecentVisitsDates() throws ParseException {
		p.verifyTheRecentVisitDetails();
	}
	
	@org.testng.annotations.Test(priority = 10)
	private void ClickEndAndStartTheNewVisit() throws ParseException {
		p.ClickEndVisit();
	}
	
	@org.testng.annotations.Test(priority = 11)
	private void CaptureVitals(){
		p.ClickStartVisitAndConfirmTheVisit();
	}
	
	@org.testng.annotations.Test(priority = 12)
	private void provideAndVerifyBMIValues() throws IOException, Throwable {
		v.ProvideVitalDetails();
	}
	
	@org.testng.annotations.Test(priority = 13)
	private void CompleteAndNavigateToPatientDetailspage() {
		v.saveTheVitalDetails();
		v.completeTheVisitOfVital();
	}
	
	@org.testng.annotations.Test(priority = 14)
	private void navigateToPatientDetailsPage() throws IOException, Throwable {
		p.NavigateToPatientPage();
	}
	
	@org.testng.annotations.Test(priority = 15)
	private void veriftVitalDetailsinPatientPage() throws IOException, Throwable {
		p.verifyTheVitalDetailsInPatientPage();
	}
	
	@org.testng.annotations.Test(priority = 16)
	private void navigateToMergeVisitPage() {
		p.clickMergeVisitOption();
	}
	
	@org.testng.annotations.Test(priority = 17)
	private void mergeAllNewAndExistingVisits() throws IOException, Throwable {
		m.selectAndMergeAllVisits();
		navigateToPatientDetailsPage();
	}
	
	
	
	@AfterMethod
	public void after(ITestResult r) throws Throwable {
		if (r.getStartMillis() == ITestResult.FAILURE) {
			screenShot();
			test.log(LogStatus.FAIL, r.getThrowable().fillInStackTrace());
		}
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
}
