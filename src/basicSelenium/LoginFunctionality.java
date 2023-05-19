package basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionality {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://ui.cogmento.com/");
		
		//Give User Name
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kiran.masterx@gmail.com");
		//sendKeys() method is used to give the text / values on the UI input box. 
		
		//Give Password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		//Click on login button
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		//click() method is used to click on any web element
		
		//isDisplayed() method: 
		Thread.sleep(5000);
		boolean logo = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		System.out.println("The logo is : " + logo);
		
		//We will get NoSuchElementException when our locator is not located in the web page at the time of running the script
		
		//isEnabled() method:
		boolean calenderIcon = driver.findElement(By.xpath("//i[@class='calendar icon']")).isEnabled();
		System.out.println("The calender icon is: " + calenderIcon);
		
		//isSelected():
		driver.findElement(By.xpath("//i[@class='calendar icon']")).click();
		Thread.sleep(5000);
		boolean checkBox = driver.findElement(By.xpath("//input[@name='calendar']")).isSelected();
		System.out.println("Checkbox is selected or not : " + checkBox);
	}

}
