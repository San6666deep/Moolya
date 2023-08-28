package Automation;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	WebDriver wd;
	Robot rt;
	Actions act;
	
	@BeforeTest
	
	public void bt1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    wd=new ChromeDriver();
	    wd.get("https://www.ajio.com/");
	    wd.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}
	
	@Test
	
	public void homepage() throws InterruptedException {
		act= new Actions(wd);
		WebElement we1=wd.findElement(By.xpath("//*[@class=' alignTag'])[1]"));
		act.moveToElement(we1).build().perform();
		WebElement we2=wd.findElement(By.xpath("//*[@class='catg inactive-text'])[1]\")"));
		act.moveToElement(we2).build().perform();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='third-level'])[3]/div/a")).click();
		
	}
	 
	@Test
	public void accessories() throws InterruptedException {
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='rilrtl-list '])[2]/li[2]/div/div")).click();
		wd.findElement(By.xpath("//*[@class='rilrtl-list '])[3]/li/div/div")).click();
		wd.findElement(By.xpath("//*[@class='imgHolder'])[2]")).click();
		
		}
	
	@Test
	 public void selecteditem() throws InterruptedException {
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='ic-pdp-add-cart']")).click();
		
	}

}
