package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://demoqa.com/alerts");

		// simple alerts
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		Alert simpleAlert = driver.switchTo().alert();
		Select select = new Select (driver.findElement(By.xpath("")));
		Actions action = new Actions (driver);
		
		// Getting the alert message
		String simpleAlertMsg = simpleAlert.getText();
		
		System.out.println(simpleAlertMsg);
		// Accepting the alert
		simpleAlert.accept();

		// Promt alerts
		WebElement element = driver.findElement(By.xpath("//button[@id='promtButton']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
//		driver.findElement(By.xpath("//button[@id='promtButton']")).click();

		// Switching on specific alert / alert that is open at that instance
		Alert promtAlert = driver.switchTo().alert();

		// Getting the alert message
		String promtAlertMsg = promtAlert.getText();
		System.out.println(promtAlertMsg);
		Thread.sleep(2000);

		// Sending text to alert
		promtAlert.sendKeys("Test User");
		Thread.sleep(2000);
		// Rejecting the alert
		promtAlert.dismiss();
		
		//Confirmation Alerts
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();

		// Switching on specific alert / alert that is open at that instance
		Alert confAlert = driver.switchTo().alert();

		// Getting the alert message
		String confAlertMsg = confAlert.getText();
		System.out.println(confAlertMsg);
		Thread.sleep(2000);

		// Accepting the alert
		confAlert.accept();
		

	}

}
