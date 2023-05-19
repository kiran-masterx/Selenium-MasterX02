package basicSelenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class WebDriverWaits {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://ui.cogmento.com/");
		// login into cogmento
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kiran.masterx@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
//		WebElement test = driver.findElement(By.xpath("Sample css"));
//		test.click();
//		test.isDisplayed();

//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30)) // maximum time to wait for the condition
//                .pollingEvery(Duration.ofSeconds(5)) // frequency to check for the condition
//                .ignoring(NoSuchElementException.class); // exceptions to ignore
//
//        // Define the condition to wait for
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath("//div[@class='header item']")); // element to check for
//            }
//        });
		
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header item']")));

		boolean logo = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		System.out.println(logo);

	}

}
