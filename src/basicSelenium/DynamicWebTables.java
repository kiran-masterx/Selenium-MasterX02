package basicSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTables {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demo.guru99.com/test/web-table-element.php#");

		// Fetch all the details of company names
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));

		System.out.println("The total companies in the lists are : " + rows.size());

//		for (WebElement totalData : rows) {
//			System.out.println(totalData.getText());
//		}

//		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td[1]"));
//
//		for (int i = 1; i < rows.size(); i++) {
//			System.out.println(companyNames.get(i).getText());
//		}

		// Get the companies whose current price is greater than or equal to 750

		for (int i = 1; i < rows.size(); i++) {
			WebElement currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[" + i + "]//td[4]"));
			String price = currentPrice.getText();
			double p = Double.parseDouble(price);
			if (p >= 750) {
				WebElement companies = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[" + i + "]//td[1]//a"));
				System.out.println("The companies with price more than 750 : " + companies.getText() +  " and the price is : " + price);
			}
		}

	}

}
