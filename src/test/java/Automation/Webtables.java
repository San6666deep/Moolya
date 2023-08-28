package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtables {
	WebDriver wd;
	@BeforeTest
	public void bt1() throws AWTException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		//wd.get(url);
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
	}
	@Test
	public void test1() {
		wd.get("https://www.moneycontrol.com/personal-finance/tools/emi-calculator.html");
		JavascriptExecutor js=(JavascriptExecutor)wd;
		//js.executeScript("window.scrollBy(0,900)");
		js.executeScript("document.getElementById('emi_table').scrollIntoView()");
		String str=wd.findElement(By.xpath("//table[@id='emi_table']/tbody/tr[5]/td[3]")).getText();
	System.out.println(str);
	}

}
