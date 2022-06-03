package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Navigate to home page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
		//Find where am supposed to go without clicking me?
		System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
		//Verify am I broken?
		String brokenLink = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		if (brokenLink.contains(brokenLink))
		{
			System.out.println("Link is broken");
		}
		else
			System.out.println("Link is working fine");
		//Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		driver.navigate().back();
		//How many links are available in this page?
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Links on the page: " + links.size());

	}


}
