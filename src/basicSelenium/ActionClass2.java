package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://ui.cogmento.com/");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kiran.masterx@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		WebElement calenderIcon = driver.findElement(By.xpath("//i[@class='calendar icon']"));
		WebElement panel = driver.findElement(By.xpath("//div[@id='main-nav']"));
		
		Actions action = new Actions (driver);
		//MoveToElement
		action.moveToElement(calenderIcon).build().perform();
		action.moveToElement(panel, 5, 50).build().perform();
		//Move by offset
		action.moveByOffset(30, 50).contextClick().build().perform();

	}

}
