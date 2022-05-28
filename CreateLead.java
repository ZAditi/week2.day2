package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//Launch browser
		ChromeDriver driver = new ChromeDriver();
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize the window
		driver.manage().window().maximize();
		//find webElement
		WebElement eleUserName = driver.findElement(By.id("username"));
		//Enter the Username
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Navigate to Leads
		driver.findElement(By.linkText("Leads")).click();
		//				//Navigate to Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter Mandatory details
		//Enter CompanyName Field
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		//Enter FirstName Field
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		//Enter LastName Field
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Testing");
		//Select Source
		WebElement ele = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd= new Select(ele);
		dd.selectByValue("LEAD_CONFERENCE");
		//dd.selectByVisibleText("Conference");
		//dd.selectByIndex(2);
		//Enter FirstName(Local) Field
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("TT");
		//Department Field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation");
		// Enter Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Testing via Automation");
		//Enter your email in the E-mail address Field
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("a@a.com");
		//Select State/Province as NewYork
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state =new Select(eleState);
		state.selectByVisibleText("New York");
		//Click on Create Lead button
		driver.findElement(By.name("submitButton")).click();
		//Get the Title of Resulting Page
		System.out.println("Title of the page is "+ driver.getTitle());


	}

}
