package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Select the languages that you know?
		String[] language= {"Java","VB","C++"};
		for(int i=0;i<language.length;i++) {
			if(language[i].equals("Java")) {
				driver.findElement(By.xpath("//input[1]")).click();
			}
			else if(language[i].equals("VB")) {
				driver.findElement(By.xpath("//input[2]")).click();
			}
			else if (language[i].equals("SQL")) {
				driver.findElement(By.xpath("//input[3]")).click();
			}
			else if(language[i].equals("C")) {
				driver.findElement(By.xpath("//input[4]")).click();
			}
			else if(language[i].equals("C++")) {
				driver.findElement(By.xpath("//input[5]")).click();
				//Confirm Selenium is checked
				boolean selected = driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium is checked')]/following-sibling::input")).isSelected();
				if(selected==true) {
					System.out.println("Selenium is checked");
				}
				else
				{
					System.out.println("Selenium is not checked");
				}
				//DeSelect only checked
				boolean DeSelect= driver.findElement(By.xpath("//label[contains(text(),'DeSelect only checked')]/following-sibling::input[2]")).isSelected();
				if(DeSelect==true)
				{
					driver.findElement(By.xpath("//label[contains(text(),'DeSelect only checked')]/following-sibling::input[2]")).click();
				}
				else
				{
					driver.findElement(By.xpath("//label[contains(text(),'DeSelect only checked')]/following-sibling::input[1]")).click();
				}
				//Select all below checkboxes
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[1]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[2]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[3]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[4]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[5]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input[6]")).click();
			}
		}
	}
}


