package com.hope.webtable;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		
		
		for (int j = 1; j <= 6; j++) {
			
			int rowCount=driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int i = 1; i <= rowCount; i++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[2]")).getText();
				
				String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[6]"))
						.getText();
				// System.out.println(salary);
				//remove $ and , and convert to interger
				int sal=0;
				String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[5]")).getText();
				
				
				// System.out.println(age);
				// int sal = Integer.parseInt(salary.replaceAll(",", ""));
				// int sal2 = Integer.parseInt(salary.replaceAll("$", ""));
				// int sal3 = Integer.parseInt(salary);
				int ag = Integer.parseInt(age);

				if (ag >= 50 &&  sal>200000) {
					String val = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[2]"))
							.getText();
					System.out.println(val);
				}
				
				
			}
			
			if(j!=6)
			{
				driver.findElement(By.linkText("Next")).click();
			}
		}
	}

}
