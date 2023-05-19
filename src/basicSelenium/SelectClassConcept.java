package basicSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		// clicking on create new account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// selectByVisibleText();
		Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		day.selectByVisibleText("25");

		// selectByValue();
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByValue("1");

		// selectByIndex();
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByIndex(25);

		// getOptions();
		Select totalYears = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		List<WebElement> years = totalYears.getOptions();
		for (int i = 0; i < years.size(); i++) {
			System.out.println(years.get(i).getText());
		}
		//getText(): it is used to get the text of web elements from the web page. 
		
		//Selecting an element from a dropdown without select class
		driver.findElement(By.xpath("//select[@id='year']")).click();
		driver.findElement(By.xpath("//option[text()='2010']")).click();
	}

}
