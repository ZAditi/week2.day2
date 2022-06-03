package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click on this image to go home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		driver.navigate().back();
		//Am I Broken Image?
		boolean enabled = driver.findElement(By.xpath("//div/label[text()='Am I Broken Image?']/following-sibling::img")).isEnabled();
		if (enabled==true)
			System.out.println("Image is broken");
		else
			System.out.println("Image is not broken");
		//click on the link using keyboard /mouse
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();

	}

}
