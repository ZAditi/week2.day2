package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("a@a.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click on first lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Get the first name
		String name = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		//Get on Duplicate lead button
		driver.findElement(By.linkText("Duplicate Lead")).click();
		//Get the Title
		String verify = driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText();
		if(verify.contains("Duplicate Lead")) {
			System.out.println("Title is matched as Duplicate Lead");
		}
		else
		{
			System.out.println("Title is unique");
		}
		//Click on Submit button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//Get First name
		String duplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		//Compare the first name of original lead and duplicated lead
		if(name.equals(duplicateName)) {
			System.out.println("Duplicated lead name is same as captured name");
		}
		else
			System.out.println("Duplicated lead name is not same as captured name");
		//close the browser
		driver.close();

	}

}
