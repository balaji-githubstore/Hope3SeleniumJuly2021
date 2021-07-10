package com.hope.webtable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		 int noOfRows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		 System.out.println(noOfRows);
		
		for(int i=1;i<=noOfRows;i++)
		{
			String name=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(name);
		}
			
//		for(int i=1;i<=noOfRows;i++)
//		{
//			String name=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
//			System.out.println(name);
//			
//			if(name.trim().equals("Brenden Wagner"))
//			{
//				driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]")).click();
//				break;
//			}
//		}
		
		//for loop for page 
			//for for row iteration
			//click on next
	
		

	}

}
