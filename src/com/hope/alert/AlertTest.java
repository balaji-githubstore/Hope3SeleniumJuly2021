package com.hope.alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		driver.get("http://www.echoecho.com/javascript4.htm"); 
		
//		Thread.sleep(2000);
//		driver.findElement(By.name("B1")).click();
		
		Thread.sleep(2000);
		
		String actualAlertText= driver.switchTo().alert().getText();
		System.out.println(actualAlertText);
		
		driver.switchTo().alert().accept();
		
	}

}
