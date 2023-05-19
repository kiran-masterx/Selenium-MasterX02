package basicSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		String currentURL1 = driver.getCurrentUrl();
		System.out.println(currentURL1);
		// Windows
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();

		Set <String> childWindows = driver.getWindowHandles();
		
		//Switching on child window
		for (String handle : childWindows) {
			driver.switchTo().window(handle);
		}

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		String title = driver.getTitle();
		System.out.println(title);
		
		String heading = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(heading);
		

		
		//Switching back to parent / main window
		driver.switchTo().window(parentWindow);
		String title1 = driver.getTitle();
		System.out.println(title1);

		driver.quit();
	}

}
