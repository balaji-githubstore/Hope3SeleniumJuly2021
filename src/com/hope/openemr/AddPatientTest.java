package com.hope.openemr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPatientTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select lang = new Select(driver.findElement(By.name("languageChoice")));
		lang.selectByVisibleText("English (Standard)");
		driver.findElement(By.xpath("//button[1]")).click();

		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//div[text()='Patient/Client']"));
		action.moveToElement(target).perform();
		driver.findElement(By.xpath("(//div[@class='menuLabel'])[5]")).click();

//		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'dynamic_finder.php')]")));
		driver.switchTo().frame("fin");
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();

		// pat
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/b/openemr/interface/new/new.php']")));
		Select prefix = new Select(driver.findElement(By.xpath("//select[@id='form_title']")));
		prefix.selectByVisibleText("Ms.");
		driver.findElement(By.id("form_fname")).sendKeys("samara");
		driver.findElement(By.id("form_lname")).sendKeys("wills");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-05-24");
		Select gender = new Select(driver.findElement(By.id("form_sex")));
		gender.selectByVisibleText("Female");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();

//		  driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[7]")));
		driver.switchTo().frame("modalframe");
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());

		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		
		//print the added patient detail
		//Medical Record Dashboard - Samara Wills

	}

}
