package Automation;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demoqa {
	WebDriver wd;

	@BeforeTest
	public void bt1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		Thread.sleep(2000);
		//wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		//Thread.sleep(3000);
		}
	@Test
	public void test1() {
		wd.get("https://demoqa.com/text-box");
		wd.findElement(By.id("userName")).sendKeys("sandeep");
		//wd.findElement(By.xpath("//*[@id='userName']")).sendKeys("sandeep");
		wd.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("abcdefg@gmail.com");
		wd.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("9/11 Newyork USA");
		wd.findElement(By.xpath("//*[@id='permanentAddress']")).sendKeys("9/11 Newyork USA");
		wd.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
}
	@Test
	public void test2() {
		wd.get("https://demoqa.com/checkbox");
		wd.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();
		wd.findElement(By.xpath("(//*[@class='rct-icon rct-icon-expand-close'])[1]")).click();
		wd.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[3]")).click();
		
}
	@Test
	public void test3() {
		wd.get("https://demoqa.com/radio-button");
		wd.findElement(By.xpath("(//*[@class='custom-control-label'])[1]")).click();
	}
	@Test
	public void test4() throws InterruptedException {
		wd.get("https://demoqa.com/webtables");
		wd.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		//wd.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Rakesh");
		//wd.findElement(By.xpath("//*[@id='lastName']")).sendKeys("moolya");
		//wd.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
		//wd.findElement(By.xpath("(//*[@aria-hidden='true'])[11]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@type='button'])[5]")).click();
	}
	@Test
	public void test5() {
		wd.get("https://demoqa.com/buttons");
		WebElement we1=wd.findElement(By.xpath("//*[@id='doubleClickBtn']"));
		Actions act=new Actions(wd);
		act.doubleClick(we1).build().perform();
		WebElement we2=wd.findElement(By.xpath("(//*[@id='rightClickBtn'])"));
		act.contextClick(we2).build().perform();
	    //WebElement we3=wd.findElement(By.xpath("(//*[@id='cMwVw'])"));
		//act.click(we3).build().perform();
		wd.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
		
	}
	 @Test
	public void test6() {
		wd.get("https://demoqa.com/");
		String str= wd.getTitle();
		System.out.println(str);
		Assert.assertEquals(str, "DEMOQA");
		System.out.println("Assertion passed");
	 }
	 @Test
	 public void test7() throws InterruptedException {
		 wd.get("https://demoqa.com/alerts");
		 wd.findElement(By.xpath("//*[@id='alertButton']")).click();
		 Thread.sleep(5000);
		 Alert alt=wd.switchTo().alert();
		 alt.accept();
		 
	 }
	 @Test
	 public void test8() throws InterruptedException {
		 wd.get("https://demoqa.com/alerts");
		 wd.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
		 Thread.sleep(6000);
		 Alert alt=wd.switchTo().alert();
		 String name=alt.getText();//used to get the info of the alert
		 System.out.println(name);
		 alt.accept(); 
	 }
	 @Test
	 public void test9() throws InterruptedException {
		 wd.get("https://demoqa.com/alerts");
		 wd.findElement(By.xpath("//*[@id='confirmButton']")).click();
		 Thread.sleep(6000);
		 Alert alt=wd.switchTo().alert();
		 alt.dismiss();
		 
	 }
	 @Test
	 public void test10() throws InterruptedException {
		 wd.get("https://demoqa.com/alerts");
		 Thread.sleep(2000);
		 JavascriptExecutor js=(JavascriptExecutor)wd;
		 js.executeScript("document.getElementById('promtButton').scrollIntoView()");
		 wd.findElement(By.xpath("(//*[@class='btn btn-primary'])[4]")).click();
		 Thread.sleep(2000);
		 Alert alt=wd.switchTo().alert();
		 alt.sendKeys("sandeep");
		 alt.accept();
		 
	 }
	 @Test
	 public void test11() throws InterruptedException {
		 wd.get("https://demoqa.com/browser-windows");
		String pw=wd.getWindowHandle();
		System.out.println(pw);
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("document.getElementById('windowButton').scrollIntoView()");
		//Thread.sleep(2000);
		WebElement we= wd.findElement(By.xpath("//*[@id='windowButton']"));
		//we.click();
		for(int i=0;i<3;i++)
		{
			we.click();
		}
		Set<String>Allwindows=wd.getWindowHandles();
		System.out.println(Allwindows);
		System.out.println(Allwindows.size());//gives no.of windows
		String sa="";
		for(String handle:Allwindows)
		{
			wd.switchTo().window(handle);
			wd.get("https://www.google.com/");
		}
		wd.switchTo().window(pw);
		wd.get("https://demoqa.com/browser-windows");
		//wd.close();//parent window gets closed
		wd.switchTo().window(sa);//driver will go the last opened window by default
		wd.get("https://www.amazon.in");
		System.out.println(sa);//since sa is empty so the windowid won't get printed
		}

	
}
