package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='yes']")).click();
		//find default selected radio button
		boolean Unchecked = driver.findElement(By.xpath("//input[@name='news' and @value='0']")).isSelected();
		boolean Checked = driver.findElement(By.xpath("//input[@name='news' and @value='1']")).isSelected();
		if(Unchecked==true) {
			System.out.println("Unchecked is selected");
		}
		else
		{
			System.out.println("Checked is selected");
		}
		//Find the age group
		int age=19;
		boolean ageSelect = driver.findElement(By.xpath("//input[@name='age' and @value='1']")).isSelected();
		System.out.println(ageSelect);
		if(age<=20) {
			driver.findElement(By.xpath("//input[@name='age' and @value='0']")).click();
		}
		else if(age>=20 && age<=40) {
			System.out.println("Age group already selected");
		}
		else
			driver.findElement(By.xpath("//input[@name='age' and @value='2']")).click();
		driver.close();
	}

}
