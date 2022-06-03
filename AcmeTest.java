package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		//Enter username
		driver.findElement(By.name("email")).sendKeys("kumar.testleaf@gmail.com");
		//Enter Password
		driver.findElement(By.name("password")).sendKeys("leaf@12");
		//Click on login button
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		//Get the Title
		System.out.println(driver.getTitle());
		//Click on logout
		driver.findElement(By.linkText("Log Out")).click();
		//Close the browser
		driver.close();
		
	}

}
