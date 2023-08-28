package Automation;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
 WebDriver wd;
 @BeforeTest
 public void bt1() {
	 WebDriverManager.chromedriver().setup();
	 wd=new ChromeDriver();
	 wd.manage().window().maximize();
	 wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }
 @Test
 public void test1() {
	 wd.get("https://www.moneycontrol.com/");
	 //wd.findElement(By.xpath("(//*[@title='Personal Finance'])[2]")).click();
	 WebElement we1=wd.findElement(By.xpath("(//*[@title='Personal Finance'])[2]"));
	 Actions act=new Actions(wd);
	 act.moveToElement(we1).build().perform();
	 wd.findElement(By.xpath("//*[@title='Home Loan Calculator']")).click();
	 JavascriptExecutor js=(JavascriptExecutor)wd;
	// js.executeScript("window.scrollBy(0,1000)");
	 js.executeScript("document.getElementById('emi_table').scrollIntoView()");
	String str= wd.findElement(By.xpath("//table[@id='emi_table']/tbody/tr[14]/td[5]")).getText();
     System.out.println(str);
 }
 }
