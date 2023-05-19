package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//li[@name='A']"));
		WebElement destination = driver.findElement(By.xpath("//ul[@id='sortable']/child::li[5]"));
		
		//clickAndHold(), dragAndDrop(), release(), build(), perform()
		action.clickAndHold(source).dragAndDrop(source, destination).release().build().perform();
		
		WebElement seleniumHeading = driver.findElement(By.xpath("//h1/child::a[contains(text(),'Selenium')]"));
		//contextClick() (Right click)
		action.contextClick().build().perform();
		action.contextClick(seleniumHeading).build().perform();
		
		//doubleClick()
		action.doubleClick(seleniumHeading).build().perform();
		
		driver.navigate().back();
		driver.findElement(By.xpath("//div[contains(@id,'post-body')]")).click();
		driver.navigate().refresh();
		//dragAndDropBy()
		Thread.sleep(3000);
		action.clickAndHold(source).dragAndDropBy(source, 80, 80).release().build().perform();
//		
		//moveToElement();
		action.moveToElement(seleniumHeading).build().perform();
//		
//		
		
	}

}
