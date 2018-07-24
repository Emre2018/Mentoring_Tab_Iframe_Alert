package com.cybertek_july25mentoring;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TabsWindowsReview extends TestBase {

	@Test
	public void switchToTabs() {
		
		driver.navigate().to("http://demo.guru99.com/popup.php");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		String mainWindow = driver.getWindowHandle();
		System.out.println("MAIN WINDOW: " + mainWindow);
		Set<String> windowHandles = driver.getWindowHandles();
		// go through the list of all handles, if we find one that is not equal to the
		// current, we will switch to it
		
		for(String str : windowHandles) {
			if(!mainWindow.equals(str)) {
				driver.switchTo().window(str);
			}	
		}
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.linkText("Click Here")).click();
		driver.switchTo().window(mainWindow);
		
		
	}

}
