package com.hope.mutlipletabs;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.online.citibank.co.in/");

		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		System.out.println(driver.getTitle());

		String parent = driver.getWindowHandle();
		System.out.println(parent);
		System.out.println("-----------------------------------");

		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			System.out.println(win);
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());
			String title = driver.getTitle();
			if (title.trim().equals("Citibank India")) {
				break;
			}
		}

		// driver.findElement(By.linkText("Travel")).click();
		driver.findElement(By.id("User_Id")).sendKeys("bala");
		// fill the form
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(parent);
//		windows = driver.getWindowHandles();
//		
//		for (String win : windows) {
//			System.out.println(win);
//			driver.switchTo().window(win);
//			System.out.println(driver.getTitle());
//			String title = driver.getTitle();
//			if (title.trim().equals("Citi India - Credit Cards, Personal & Home Loans, Investment, Wealth Management & Banking")) {
//				break;
//			}
//		}
		
		System.out.println(driver.getTitle());
	}
}
