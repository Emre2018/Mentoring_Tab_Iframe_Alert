package com.cybertek_july25mentoring;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeReview extends TestBase {
	
	//@Test
	public void iframeByWebElement() {
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("new text by WEBELEMENT");
		
		driver.switchTo().defaultContent();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

	}
	
	//@Test
	public void iframeById() {
		driver.get("http://the-internet.herokuapp.com/iframe");
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("new text by ID");

		driver.switchTo().defaultContent();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

	}
	
	@Test
	public void iframeByIndex() {
		driver.get("http://the-internet.herokuapp.com/iframe");
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("new text by INDEX");

		driver.switchTo().parentFrame();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

	}
	
	
	
	
	

}
