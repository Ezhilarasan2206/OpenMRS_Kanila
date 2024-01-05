package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.SeleniumUtility;

public class VitalsPage extends SeleniumUtility {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public VitalsPage() {
		PageFactory.initElements(driver, this);
	}
	
	private By patientHyperLink(String patientName) {return By.xpath("//a[contains(text(), '"+patientName+"')]");}
	
	@FindBy(id = "height")
	private WebElement hightTextField;

	@FindBy(id = "next-button")
	private WebElement nextButton;

	@FindBy(id = "prev-button")
	private WebElement prevButton;

	@FindBy(id = "weight")
	private WebElement weightTextField;

	@FindBy(xpath = "//li/span[text() = 'Height (cm)']")
	private WebElement heightOption;

	@FindBy(xpath = "//li/span[text() = 'Weight (kg)']")
	private WebElement weightOption;
	
	@FindBy(xpath = "//span[@id = 'calculated-bmi']")
	private WebElement calculatedBMI;
	
	@FindBy(xpath = "//li/span[text() = '(Calculated) BMI']")
	private WebElement bmiCalculationOption;
	
	@FindBy(xpath = "//li/span[text() = 'Confirm']")
	private WebElement confirmOption;
	
	@FindBy(css = "#dataCanvas>div>p")
	private WebElement confirmedDetails;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(id = "save-form")
	private WebElement saveFormHyperLink;
	
	@FindBy(xpath = "//a[text()= ' End Visit']")
	private WebElement endVisitOption;
	
	@FindBy(xpath = "//div[@id='end-visit-dialog']//button[@class='confirm right']")
	private WebElement confirmEndVisit;
	
	
	
	public WebElement getConfirmEndVisit() {
		return confirmEndVisit;
	}

	public void setConfirmEndVisit(WebElement confirmEndVisit) {
		this.confirmEndVisit = confirmEndVisit;
	}

	public WebElement getEndVisitOption() {
		return endVisitOption;
	}

	public void setEndVisitOption(WebElement endVisitOption) {
		this.endVisitOption = endVisitOption;
	}

	public WebElement getSaveFormHyperLink() {
		return saveFormHyperLink;
	}

	public void setSaveFormHyperLink(WebElement saveFormHyperLink) {
		this.saveFormHyperLink = saveFormHyperLink;
	}

	public WebElement getHightTextField() {
		return hightTextField;
	}

	public void setHightTextField(WebElement hightTextField) {
		this.hightTextField = hightTextField;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public void setNextButton(WebElement nextButton) {
		this.nextButton = nextButton;
	}

	public WebElement getPrevButton() {
		return prevButton;
	}

	public void setPrevButton(WebElement prevButton) {
		this.prevButton = prevButton;
	}

	public WebElement getWeightTextField() {
		return weightTextField;
	}

	public void setWeightTextField(WebElement weightTextField) {
		this.weightTextField = weightTextField;
	}

	public WebElement getHeightOption() {
		return heightOption;
	}

	public void setHeightOption(WebElement heightOption) {
		this.heightOption = heightOption;
	}

	public WebElement getWeightOption() {
		return weightOption;
	}

	public void setWeightOption(WebElement weightOption) {
		this.weightOption = weightOption;
	}

	public WebElement getCalculatedBMI() {
		return calculatedBMI;
	}

	public void setCalculatedBMI(WebElement calculatedBMI) {
		this.calculatedBMI = calculatedBMI;
	}

	public WebElement getBmiCalculationOption() {
		return bmiCalculationOption;
	}

	public void setBmiCalculationOption(WebElement bmiCalculationOption) {
		this.bmiCalculationOption = bmiCalculationOption;
	}

	public WebElement getConfirmOption() {
		return confirmOption;
	}

	public void setConfirmOption(WebElement confirmOption) {
		this.confirmOption = confirmOption;
	}

	public WebElement getConfirmedDetails() {
		return confirmedDetails;
	}

	public void setConfirmedDetails(WebElement confirmedDetails) {
		this.confirmedDetails = confirmedDetails;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
	public VitalsPage ProvideVitalDetails() throws IOException, Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/span[text() = 'Height (cm)']")));
		getHeightOption().click();
		getHightTextField().sendKeys(getProperty("HeightInCm", "Data"));
		getWeightOption().click();
		getWeightTextField().sendKeys(getProperty("WeightInKg", "Data"));
		getCalculatedBMI().click();
		verifyCalculatedBMIValue(getProperty("HeightInCm", "Data"), getProperty("WeightInKg", "Data"));
		return this;
	}
	
	private void verifyCalculatedBMIValue(String weightinKg, String heightInCm) {
		double heightInM = Double.parseDouble(heightInCm) / 100;
		double ans = Double.parseDouble(weightinKg) / (heightInM * heightInM);
		DecimalFormat df = new DecimalFormat("#.#");
		assertEquals(getCalculatedBMI().getText(), df.format(ans).toString());
		System.out.println("Calculated BMI Value: "+df.format(ans));
	}
	
	public void saveTheVitalDetails() {
		getSaveFormHyperLink().click();
		wait.until(ExpectedConditions.elementToBeClickable(getSaveButton()));
		getSaveButton().click();
	}
	
	public VitalsPage completeTheVisitOfVital() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()= ' End Visit']")));
		 getEndVisitOption().click();
		 wait.until(ExpectedConditions.elementToBeClickable(getConfirmEndVisit()));
		 getConfirmEndVisit().click();
		return this;
	}
		
}
