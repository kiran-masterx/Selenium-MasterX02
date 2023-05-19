package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		// Get the window handles
		// Switch back to the original tab
		String originalHandle = driver.getWindowHandle();
//		Set<String> windowHandles = driver.getWindowHandles();
//
//		// Switch to the new tab
//		for (String handle : windowHandles) {
//		    driver.switchTo().window(handle);
//		}
//		try {
//			String title = driver.findElement(By.xpath("/html/body/text()")).getText();
//			System.out.println(title);
//		}catch(Exception e) {
//			
//		}
		Alert alert = driver.switchTo().alert();
//		// Accept the window message (clicking OK or Yes)
//		alert.accept();
//
//		// Dismiss the window message (clicking Cancel or No)
//		alert.dismiss();

		// Get the text of the window message
		String messageText = alert.getText();

		

		driver.switchTo().window(originalHandle);
		String title1 = driver.getCurrentUrl();
		System.out.println(title1);


	}

}
