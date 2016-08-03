package app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;;

public abstract class PageObject {
	
	private WebDriver _driver;
	
	public void WaitForElement(String element, int timeout) {
		WebDriverWait wait = new WebDriverWait(_driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(GetBy(element)));
	}
	
	public void WaitForAlertPresent() {
		WebDriverWait wait = new WebDriverWait(_driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	private By GetBy(String fieldName) {
	    try {
	        return new Annotations(this.getClass().getDeclaredField(fieldName)).buildBy();
	    } catch (NoSuchFieldException e) { return null; }
	}
	
	public PageObject(WebDriver driver) {
		_driver = driver;
	}
	
	public WebDriver WebDriver() {
		return _driver;
	}
		
	public void WaitFor(int timeout) {
		_driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public void Maximize() {
		_driver.manage().window().maximize();
	}
	
	public void Close() {
		_driver.close();
	}
	
	public String Title() {
		return _driver.getTitle();
	}
	
	public Select Select(WebElement element) {
		return new Select(element);
	}
}
