package app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import app.PageObject;

public class MainPage extends PageObject {
	
	public MainPage(org.openqa.selenium.WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.CSS, using = "#coll-create_a_book > a")
	public WebElement CreateBook;
	
	@FindBy(how = How.XPATH, using = "//button/span[text()='Start book creator']")
	public WebElement StartBookCreator;
	
	@FindBy(how = How.CSS, using = "#mw-content-text > form")
	public WebElement StartBookCreatorFrame;	
	
	@FindBy(how = How.CSS, using = "#mw-content-text p strong a")
	public WebElement DownloadLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='siteNotice']/div/div/div/div/a[text()='disable']")
	public WebElement DisableCreateBook;
	
	@FindBy(how = How.XPATH, using = "//div[@id='coll-book_creator_box']/a[2]")
	public WebElement ShowBook;
	
	@FindBy(how = How.ID, using = "searchInput")
	public WebElement SearchField;
	
	@FindBy(how = How.XPATH, using = "//h1[text()='Selenium']")
	public WebElement SeleniumHeading;
	
	@FindBy(how = How.XPATH, using = "//h1[text()='JScript']")
	public WebElement JScriptHeading;
	
	@FindBy(how = How.ID, using = "coll-add_article")
	public WebElement AddArticleToBook;
	
	@FindBy(how = How.ID, using = "firstHeading")
	public WebElement MainHeading;
	
	@FindBy(how = How.ID, using = "titleInput")
	public WebElement TitleField;
	
	@FindBy(how = How.ID, using = "subtitleInput")
	public WebElement SubtitleField;
	
	@FindBy(how = How.ID, using = "downloadButton")
	public WebElement DownloadButton;
	
	@FindBy(how = How.ID, using = "formatSelect")
	public WebElement FormatSelect;
}