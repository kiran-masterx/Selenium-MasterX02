package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://demoqa.com/alerts");

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"cto_banner_content\"]/a[2]/div/div/img")).click();
		driver.switchTo().frame("name of the frame");
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

	}

}
