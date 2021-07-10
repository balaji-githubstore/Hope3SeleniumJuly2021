package com.hope.openemr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.get("https://demo.openemr.io/b/openemr");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		
		String att=driver.findElement(By.id("authUser")).getAttribute("placeholder");
		System.out.println(att);
		
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		
		Select lang = new Select(driver.findElement(By.name("languageChoice")));
		lang.selectByVisibleText("English (Indian)");
		
		String att1=lang.getFirstSelectedOption().getAttribute("value");
		System.out.println(att1);
	
		String text=lang.getFirstSelectedOption().getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//make sure we are in proper page
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Logout']")));
		
		System.out.println("The title is :" + driver.getTitle());
		
		//mousehover activity to make logout visible
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@title='Current user']"))).perform();
		
	
		driver.findElement(By.xpath("//li[text()='Logout']")).click();
		
		

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
		
		//make sure we are in proper page
		System.out.println(driver.getTitle());

		//driver.findElement(By.id("form_DOB")).sendKeys("2021-05-15");
	}

}
