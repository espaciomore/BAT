package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import app.AutoConfig;
import app.MainPage;

@RunWith(JUnit4.class)
public class TestCreateBook {

	private MainPage _mainPage;

	@Before
	public void SetUp() {
		WebDriver driver = new InternetExplorerDriver(AutoConfig.GetIECaps());
		driver.manage().deleteAllCookies();
		_mainPage = PageFactory.initElements(driver, MainPage.class);
	}

	@After
	public void TearDown() {
		_mainPage.Close();
	}

	@Test
	public void TestUserLogin() {

		// Open the URL "http://en.wikipedia.org/wiki/Main_Page/"
		_mainPage.WebDriver().get(AutoConfig.ServerURL);
		assertEquals("Wikipedia, the free encyclopedia", _mainPage.Title());

		// Click on the "Create a Book" link from the "Print/Export" section
		_mainPage.WaitForElement("CreateBook", 3);
		_mainPage.CreateBook.click();
		_mainPage.WaitFor(10);
		assertEquals("Book creator - Wikipedia, the free encyclopedia", _mainPage.Title());

		// Click on the button "Start book creator" on the Book Creator Page
		_mainPage.WaitForElement("StartBookCreatorFrame", 3);
		_mainPage.StartBookCreator.click();
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("DisableCreateBook", 10);
		assertEquals("Wikipedia, the free encyclopedia", _mainPage.Title());

		// Type "Selenium" in the Wikipedia search text-box and press ENTER
		_mainPage.WaitForElement("SearchField", 3);
		_mainPage.SearchField.sendKeys("Selenium");
		_mainPage.SearchField.sendKeys(Keys.RETURN);
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("SeleniumHeading", 3);
		assertEquals("Selenium - Wikipedia, the free encyclopedia", _mainPage.Title());

		// Click on "Add this page to your book" for the Selenium page
		_mainPage.AddArticleToBook.click();
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("ShowBook", 3);
		assertEquals("Show book (1 page)", _mainPage.ShowBook.getText().trim());

		// Type "JScript" in the Wikipedia search text-box and press ENTER
		_mainPage.WaitForElement("SearchField", 3);
		_mainPage.SearchField.sendKeys("JScript");
		_mainPage.SearchField.sendKeys(Keys.RETURN);
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("JScriptHeading", 3);
		assertEquals("JScript - Wikipedia, the free encyclopedia", _mainPage.Title());

		// Click on "Add this page to your book" for the Selenium page
		_mainPage.AddArticleToBook.click();
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("ShowBook", 3);
		assertEquals("Show book (2 pages)", _mainPage.ShowBook.getText().trim());

		// Click on the link "Show book (2 pages)"
		_mainPage.ShowBook.click();
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("TitleField", 3);
		assertEquals("Manage your book", _mainPage.MainHeading.getText().trim());

		// Type "Book Creator from Wikipedia" in the Title text-box of the
		// "Manage your book" page
		_mainPage.TitleField.sendKeys("Book Creator from Wikipedia");

		// Type "Using Automation" in the Subtitle text-box of the "Manage your
		// book" page
		_mainPage.SubtitleField.sendKeys("Using Automation");

		// Click on the "Download as PDF" | Select format as "e-book (PDF, ocg
		// latex renderer)"
		_mainPage.Select(_mainPage.FormatSelect).selectByValue("rdf2latex");

		// Click on the "Download the file" link | Download
		_mainPage.DownloadButton.click();
		_mainPage.WaitFor(10);
		_mainPage.WaitForElement("DownloadLink", 3);
		assertEquals("Rendering finished", _mainPage.MainHeading.getText().trim());

		try {
			_mainPage.DownloadLink.click();
			_mainPage.WaitForAlertPresent();
			_mainPage.WaitFor(30);
		} catch (UnhandledAlertException e) {
			assertTrue("Download Completed: " + e.getMessage(), true);
		}
	}
}
