package com.hope.medibuddy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Medibuddy {

	public static void main(String[] args) throws InterruptedException {
		
		//class --> ChromeDriver
		//non-static method --> get(string url)
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //30,40,50
		
		//implicit wait 30s
		driver.get("https://www.medibuddy.in/"); //wait until the page load complete
		
		driver.findElement(By.id("wzrk-cancel")).click();  //findelement takes only 500ms to check the element
		driver.findElement(By.linkText("Signup")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("balaji");
		driver.findElement(By.name("phone")).sendKeys("98989889987");
		driver.findElement(By.name("username")).sendKeys("hh@gmail.com");
		driver.findElement(By.name("password")).sendKeys("hh@123");
		
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//span[text()='Show password']")).click();
		
		//driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("//input[@ng-model='logInUser.isChecked']")).click();
		
		driver.findElement(By.name("employeeId")).sendKeys("45644");
		
//		WebElement ele= driver.findElement(By.xpath("//select[@ng-model='date.year']"));
//		Select selectYear=new Select(ele);
		
		Select selectYear=new Select(driver.findElement(By.xpath("//select[@ng-model='date.year']")));
		selectYear.selectByVisibleText("1992");		
		
		Select selectMonth=new Select(driver.findElement(By.xpath("//select[@ng-model='date.month']")));
		//selectMonth.selectByVisibleText("07");
		selectMonth.selectByValue("string:08");
		
		
		//driver.findElement(By.xpath("//span[@class='cursor-pointer smdTxt light-bold']")).click();
		driver.findElement(By.xpath("//span[text()='Female']")).click();
		
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		
//		WebDriverWait wait=new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.alertIsPresent());
//		
//		driver.switchTo().alert().accept();
		
	}
}





