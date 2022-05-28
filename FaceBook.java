package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://en-gb.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Test");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test");
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("2123456789");
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("zdfsgdzcsc");
	WebElement Day = driver.findElement(By.id("day"));
	Select day = new Select(Day);
	day.selectByValue("5");
	WebElement Month = driver.findElement(By.id("month"));
	Select month= new Select(Month);
	month.selectByIndex(5);
	WebElement Year = driver.findElement(By.id("year"));
	Select year= new Select(Year);
	year.selectByVisibleText("1970");
	driver.findElement(By.xpath("//input[@name='sex']")).click();

	}

}
