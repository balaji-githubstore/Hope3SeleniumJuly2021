package com.hope.hdfc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/"); 
		
		driver.switchTo().frame("login_page");
		
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("test123");
		
		driver.findElement(By.xpath("//img[contains(@src,'continue')]")).click();
		
		
		driver.switchTo().defaultContent(); //come to main html after handling element in the frame
		
	
		
		
		
		

	}

}
