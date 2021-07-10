package com.hope.jcpenny;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JCTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.jcpenney.com/");
		driver.findElement(By.xpath("//input[@id='searchInputId']"))
				.sendKeys("Arizona Mens Stretch Straight Relaxed Fit Jean");
		driver.findElement(By.xpath("//button[@data-automation-id='searchIconBlock']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='btnText'][1]")).click();
		driver.findElement(By.xpath("//button[@class='_3WJin _1TqXA _3maik']")).click();

		
		Select sizes = new Select(driver.findElement(By.xpath("//select[@name='size']")));
		sizes.selectByVisibleText("26W X 36L");

		Select quan = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		quan.selectByVisibleText("2");

		driver.findElement(By.xpath("//p[@data-automation-id='addToCart']")).click();
		Thread.sleep(5000);
		boolean msg = driver.getPageSource().contains("2 Items Added");
		System.out.println(msg);
		// driver.quit();

		String actualValue1 = driver
				.findElement(By.xpath("//div[@data-automation-id='at-panel-added-item-count-block']")).getText();
		System.out.println(actualValue1);

		driver.findElement(By.xpath("//button[text()='View Cart & Checkout']")).click();
		
		Select selectqty = new Select(
				driver.findElement(By.xpath("//select[@data-automation-id='at-select-quantity']")));

		String actualValue2 = selectqty.getFirstSelectedOption().getAttribute("value");
		System.out.println(actualValue2);

		String actualValue3 = selectqty.getFirstSelectedOption().getText();
		System.out.println(actualValue3);

	}

}
