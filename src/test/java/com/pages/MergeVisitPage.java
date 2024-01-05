package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.SeleniumUtility;

public class MergeVisitPage extends SeleniumUtility {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public MergeVisitPage() {
		PageFactory.initElements(driver, this);
	}
	
	private By patientHyperLink(String patientName) {return By.xpath("//a[contains(text(), '"+patientName+"')]");}
	
	@FindBy(xpath = "(//h3)[2]")
	private WebElement mergeVistHeader;

	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> mergetdCheckBox;

	@FindBy(id = "mergeVisitsBtn")
	private WebElement mergeVisitsBtn;
	
	@FindBy(xpath = "//input[@class='cancel']")
	private WebElement returnOption;
	
	
	public WebElement getMergeVistHeader() {
		return mergeVistHeader;
	}

	public void setMergeVistHeader(WebElement mergeVistHeader) {
		this.mergeVistHeader = mergeVistHeader;
	}

	public List<WebElement> getMergetdCheckBox() {
		return mergetdCheckBox;
	}

	public void setMergetdCheckBox(List<WebElement> mergetdCheckBox) {
		this.mergetdCheckBox = mergetdCheckBox;
	}

	public WebElement getMergeVisitsBtn() {
		return mergeVisitsBtn;
	}

	public void setMergeVisitsBtn(WebElement mergeVisitsBtn) {
		this.mergeVisitsBtn = mergeVisitsBtn;
	}

	public WebElement getReturnOption() {
		return returnOption;
	}

	public void setReturnOption(WebElement returnOption) {
		this.returnOption = returnOption;
	}
	
	public MergeVisitPage selectAndMergeAllVisits() {
		wait.until(ExpectedConditions.textToBePresentInElement(getMergeVistHeader(), "Merge Visits"));
		for (WebElement ele : getMergetdCheckBox()) {
			if(!ele.isSelected()) {
				ele.click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(getMergeVisitsBtn())); 
		getMergeVisitsBtn().click();
		return this;
	}

}