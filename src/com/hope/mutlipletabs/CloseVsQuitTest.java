package com.hope.mutlipletabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuitTest {
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		driver.get("https://www.online.citibank.co.in/");
		
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		
		Thread.sleep(5000);
		
//		driver.close(); //close the current tab or current session
		driver.quit(); // close all the tabs/session created and also it will kill the process
	}
}
