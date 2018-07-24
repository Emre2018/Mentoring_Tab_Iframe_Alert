package com.cybertek_july25mentoring;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsReview extends TestBase {

	@Test
	public void alertTest() {

		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("You successfuly clicked an alert: " + alert.getText());
		alert.accept();

		driver.findElement(By.xpath("(//button)[2]")).click();
		alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("You clicked: Cancel " + alert.getText());
		alert.dismiss();

		driver.findElement(By.xpath("(//button)[3]")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("ALERT");
		System.out.println("You clicked: ALERT " + alert.getText());
		// alert.accept();

		try {
			Alert alert1 = driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			Assert.fail("Alert was not present");
		}

		alert.accept();

	}

}
