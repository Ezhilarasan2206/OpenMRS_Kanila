package com.pages;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class PatientDetailsPage extends SeleniumUtility {
	static ExtentTest test;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public PatientDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(), 'Start Visit')]")
	private WebElement btnstartVisit;

	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	private WebElement btnStartVisitConfirm;

	@FindBy(xpath = "//a[@id='attachments.attachments.visitActions.default']")
	private WebElement btnAttachment;

	@FindBy(xpath = "//textarea[@placeholder='Enter a caption']")
	private WebElement txtCaption;

	@FindBy(xpath = "//button[text()='Upload file']")
	private WebElement btnUpload;

	@FindBy(xpath = "//p[text()='The attachment was successfully uploaded.']")
	private WebElement verifySuccessfulMessage;

	@FindBy(xpath = "//h3[text() = 'ATTACHMENTS']/parent::div/following-sibling::div//div[@ng-if='active']")
	private List<WebElement> verifyAttachment;

	@FindBy(xpath = "//div[text()='Attachment Upload']//preceding-sibling::a")
	private WebElement verifyLastEntry;

	@FindBy(xpath = "(//div[contains(text(),'End Visit')])[2]")
	private WebElement btnEndVisit;
	
	@FindBy(xpath = "//div[contains(text(),'Merge Visits')]")
	private WebElement mergeVisitsOption;

	@FindBy(xpath = "(//button[text()='Yes'])[2]")
	private WebElement btnConfirmEndVisit;

	@FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
	private WebElement btnDeletepatient;

	@FindBy(xpath = "//input[@id='delete-reason']")
	private WebElement txtReasonForDelete;

	@FindBy(xpath = "(//button[text()='Confirm'])[4]")
	private WebElement btnConfirmReason;

	@FindBy(xpath = "//a[text()='Patient has been deleted successfully']")
	private WebElement verifyDeleteMessage;

	@FindBy(xpath = "//em[text() = 'Patient ID']/following-sibling::span")
	private WebElement patientId;

	@FindBy(className = "gender-age col-auto")
	private WebElement genderAndYearsOfAgeText;
	
	@FindBy(id = "visit-documents-dropzone")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//h3[text() = 'Recent Visits']/parent::div/following-sibling::div//ul/li/a")
	private List<WebElement> recentVisitsDetails;
	
	@FindBy(xpath = "//h3[text() = 'VITALS']/parent::div/following-sibling::div//section[@id='vitals']//p//span[@class='value']")
	private List<WebElement> vitalHeightAndWeight;
	
	@FindBy(xpath = "//h3[text() = 'VITALS']/parent::div/following-sibling::div//section[@id='vitals']//p/ancestor::fieldset/following-sibling::fieldset//span[@id='calculated-bmi']")
	private WebElement vitalCalculatedBmiValue;
	
	@FindBy(xpath = "//a[@id='referenceapplication.realTime.vitals']")
	private WebElement captureVitalOption;
	
	
	
	public List<WebElement> getVitalHeightAndWeight() {
		return vitalHeightAndWeight;
	}

	public void setVitalHeightAndWeight(List<WebElement> vitalHeightAndWeight) {
		this.vitalHeightAndWeight = vitalHeightAndWeight;
	}

	public WebElement getVitalCalculatedBmiValue() {
		return vitalCalculatedBmiValue;
	}

	public void setVitalCalculatedBmiValue(WebElement vitalCalculatedBmiValue) {
		this.vitalCalculatedBmiValue = vitalCalculatedBmiValue;
	}

	public WebElement getCaptureVitalOption() {
		return captureVitalOption;
	}

	public void setCaptureVitalOption(WebElement captureVitalOption) {
		this.captureVitalOption = captureVitalOption;
	}

	public List<WebElement> getRecentVisitsDetails() {
		return recentVisitsDetails;
	}

	public void setRecentVisitsDetails(List<WebElement> recentVisitsDetails) {
		this.recentVisitsDetails = recentVisitsDetails;
	}

	private By patientHyperLink(String patientName) {return By.xpath("//a[contains(text(), '"+patientName+"')]");}

	public WebElement getPatientId() {
		return patientId;
	}

	public void setPatientId(WebElement patientId) {
		this.patientId = patientId;
	}

	public WebElement getGenderAndYearsOfAgeText() {
		return genderAndYearsOfAgeText;
	}

	public void setGenderAndYearsOfAgeText(WebElement genderAndYearsOfAgeText) {
		this.genderAndYearsOfAgeText = genderAndYearsOfAgeText;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(WebElement fileUpload) {
		this.fileUpload = fileUpload;
	}

	public WebElement getBtnstartVisit() {
		return btnstartVisit;
	}

	public void setBtnstartVisit(WebElement btnstartVisit) {
		this.btnstartVisit = btnstartVisit;
	}

	public WebElement getBtnStartVisitConfirm() {
		return btnStartVisitConfirm;
	}

	public void setBtnStartVisitConfirm(WebElement btnStartVisitConfirm) {
		this.btnStartVisitConfirm = btnStartVisitConfirm;
	}

	public WebElement getMergeVisitsOption() {
		return mergeVisitsOption;
	}

	public void setMergeVisitsOption(WebElement mergeVisitsOption) {
		this.mergeVisitsOption = mergeVisitsOption;
	}

	public WebElement getBtnAttachment() {
		return btnAttachment;
	}

	public void setBtnAttachment(WebElement btnAttachment) {
		this.btnAttachment = btnAttachment;
	}

	public WebElement getTxtCaption() {
		return txtCaption;
	}

	public void setTxtCaption(WebElement txtCaption) {
		this.txtCaption = txtCaption;
	}

	public WebElement getBtnUpload() {
		return btnUpload;
	}

	public void setBtnUpload(WebElement btnUpload) {
		this.btnUpload = btnUpload;
	}

	public WebElement getVerifySuccessfulMessage() {
		return verifySuccessfulMessage;
	}

	public void setVerifySuccessfulMessage(WebElement verifySuccessfulMessage) {
		this.verifySuccessfulMessage = verifySuccessfulMessage;
	}

	public List<WebElement> getVerifyAttachment() {
		return verifyAttachment;
	}

	public void setVerifyAttachment(List<WebElement> verifyAttachment) {
		this.verifyAttachment = verifyAttachment;
	}

	public WebElement getVerifyLastEntry() {
		return verifyLastEntry;
	}

	public void setVerifyLastEntry(WebElement verifyLastEntry) {
		this.verifyLastEntry = verifyLastEntry;
	}

	public WebElement getBtnEndVisit() {
		return btnEndVisit;
	}

	public void setBtnEndVisit(WebElement btnEndVisit) {
		this.btnEndVisit = btnEndVisit;
	}

	public WebElement getBtnConfirmEndVisit() {
		return btnConfirmEndVisit;
	}

	public void setBtnConfirmEndVisit(WebElement btnConfirmEndVisit) {
		this.btnConfirmEndVisit = btnConfirmEndVisit;
	}

	public WebElement getBtnDeletepatient() {
		return btnDeletepatient;
	}

	public void setBtnDeletepatient(WebElement btnDeletepatient) {
		this.btnDeletepatient = btnDeletepatient;
	}

	public WebElement getTxtReasonForDelete() {
		return txtReasonForDelete;
	}

	public void setTxtReasonForDelete(WebElement txtReasonForDelete) {
		this.txtReasonForDelete = txtReasonForDelete;
	}

	public WebElement getBtnConfirmReason() {
		return btnConfirmReason;
	}

	public void setBtnConfirmReason(WebElement btnConfirmReason) {
		this.btnConfirmReason = btnConfirmReason;
	}

	public WebElement getVerifyDeleteMessage() {
		return verifyDeleteMessage;
	}

		

	public PatientDetailsPage VerifyThePatientDetailsAfterConfirmation() throws ParseException, IOException, Throwable {
		Assert.assertTrue(getPatientId().getText().length()>1);
		test.log(LogStatus.INFO, "Patient Id: "+getPatientId().getText());
		String expectedStartDate = getProperty("Year", "Data")+"-"+ getProperty("Month", "Data")+"-"+getProperty("Date", "Data");
		SimpleDateFormat format = new SimpleDateFormat("dd.MMM.yyyy");
		LocalDate date1 = LocalDate.parse(expectedStartDate);
		LocalDate date2 = LocalDate.now();
		Period period = date1.until(date2);
		Assert.assertEquals(getGenderAndYearsOfAgeText().getText().trim(), period.getYears()+" year(s) ( "+format.parse(expectedStartDate)+" )");
		return this;
	}
	
	public void ClickStartVisitAndConfirmTheVisit() {
		clickButton(getBtnstartVisit());
		wait.until(ExpectedConditions.elementToBeClickable(getBtnStartVisitConfirm()));
		clickButton(getBtnStartVisitConfirm());
	}
	
	public PatientDetailsPage ClickAttachmentAndUploadTheFile(String filePath) {
		wait.until(ExpectedConditions.elementToBeClickable(getBtnAttachment()));
		getBtnAttachment().click();
		getFileUpload().sendKeys(filePath);
		wait.until(ExpectedConditions.elementToBeClickable(getTxtCaption()));
		getTxtCaption().sendKeys("File Upload");
		wait.until(ExpectedConditions.elementToBeClickable(getBtnUpload()));
		getBtnUpload().click();
		return this;
	}
	
	public void VerifyTheAttachedMessage(String successfullMessage) {
		wait.until(ExpectedConditions.textToBePresentInElement(getVerifySuccessfulMessage(), successfullMessage));
	}
	
	public void NavigateToPatientPage() throws IOException, Throwable {
		patientHyperLink(getProperty("FirstName", "Data")+" "+getProperty("Lastname", "Data"));
	}
	
	public void VerifyAttachmentsInPatientPage() throws IOException, Throwable {
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(patientHyperLink(getProperty("FirstName", "Data")+" "+getProperty("Lastname", "Data")))));
		Assert.assertTrue(getVerifyAttachment().size()>0, "Attachemnt dosnot attachet successfylly.\n Please find the count of attachment: "+getVerifyAttachment().size());
	}
	
	public PatientDetailsPage verifyTheRecentVisitDetails() throws ParseException {
		Assert.assertTrue(getRecentVisitsDetails().size()>0, "There is no entry for todays date");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
		for (WebElement ele : getRecentVisitsDetails()) {
			Assert.assertEquals(ele.getText().trim(), currentDate);
		}
		return this;
	}
	
	public void ClickEndVisit() {
		Assert.assertTrue(getBtnEndVisit().isDisplayed());
		getBtnEndVisit().click();
		wait.until(ExpectedConditions.elementToBeClickable(getBtnConfirmEndVisit()));
		getBtnConfirmEndVisit().click();
	}
	
	public void SelectCaptureVisitOption() {
		wait.until(ExpectedConditions.elementToBeClickable(getCaptureVitalOption()));
		getCaptureVitalOption().click();
	}
	
	public PatientDetailsPage verifyTheVitalDetailsInPatientPage() throws IOException, Throwable {
		Assert.assertEquals(getVitalHeightAndWeight().get(0).getText(), getProperty("HeightInCm", "Data"));
		Assert.assertEquals(getVitalHeightAndWeight().get(1).getText(), getProperty("WeightInKg", "Data"));
		double hight = Double.parseDouble(getProperty("HeightInCm", "Data"))/100;
		double ans = Double.parseDouble(getProperty("WeightInKg", "Data")) / (hight * hight);
		DecimalFormat df = new DecimalFormat("#.#");
		Assert.assertEquals(getVitalCalculatedBmiValue().getText(), getProperty("WeightInKg", "Data"));
		return this;
	}
	
	public PatientDetailsPage clickMergeVisitOption() {
		getMergeVisitsOption().click();
		return this;
	}

}