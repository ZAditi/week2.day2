package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//find webElement
		WebElement eleUserName = driver.findElement(By.id("username"));
		//Enter the Username
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Test1");
		driver.findElement(By.id("lastNameField")).sendKeys("Test2");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Local1");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Local2");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Department");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Desc1");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("a@a.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select State = new Select(state);
		State.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Title: "+ driver.getTitle());
		




	}

}
