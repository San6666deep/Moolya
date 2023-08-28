package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo7 {
	WebDriver wd;
	@BeforeTest
	public void bt1() {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
@Test
public void test1() {
	wd.get("https://www.amazon.in/");
	WebElement we1=wd.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
	Actions act= new Actions(wd);
	act.moveToElement(we1).build().perform();
	
}
}
