package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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
		//click on find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//click on phone option
		driver.findElement(By.linkText("Phone")).click();
		//clear country code
		driver.findElement(By.name("phoneCountryCode")).clear();
		//enter the country code
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
		//enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("5868324354");
		//click on find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//get the lead
		System.out.println(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText());
		//click on first lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//click on delete
		driver.findElement(By.linkText("Delete")).click();
		//again click on find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
		driver.findElement(By.name("phoneNumber")).sendKeys("5868324354");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//verify if there are any records to display
		String Text = driver.findElement(By.className("x-paging-info")).getText();
		if (Text.equals(Text))
		{
			System.out.println("No records to display");
		}
		else
		{
			System.out.println("Records are displayed");
		}
		driver.close();


	}

}
