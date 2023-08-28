package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rahulshetty {
WebDriver wd;
String url="https://rahulshettyacademy.com/AutomationPractice/";
Robot rt;
@BeforeTest
public void bt1() {
	WebDriverManager.chromedriver().setup();
	wd=new ChromeDriver();
	wd.get(url);
	wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wd.manage().window().maximize();
	
}
@Test
public void radiobutton() {
	
	wd.findElement(By.xpath("//*[@value='radio1']")).click();
	wd.findElement(By.xpath("//*[@value='radio2']")).click();
	wd.findElement(By.xpath("//*[@value='radio3']")).click();
}
@Test
public void suggestionclasseg() throws AWTException {
	
	wd.manage().window().maximize();
	wd.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).sendKeys("ind");
	//wd.findElement(By.xpath("(//*[@class='ui-menu-item-wrapper'])[2]")).click();
	 rt=new Robot();
	//rt.keyPress(MenuKeyEvent.VK_DOWN);
	//rt.keyRelease(MenuKeyEvent.VK_DOWN);
	rt.keyPress(MenuKeyEvent.VK_DOWN);
	rt.keyRelease(MenuKeyEvent.VK_DOWN);
	rt.keyPress(MenuKeyEvent.VK_ENTER);
	rt.keyRelease(MenuKeyEvent.VK_ENTER);
	
}
@Test
public void test3() throws AWTException {
	wd.findElement(By.xpath("//*[@id='opentab']")).click();
	
	rt= new Robot();
	
	//rt.keyPress(MenuKeyEvent.VK_CONTROL);
	//rt.keyPress(MenuKeyEvent.VK_TAB);
	//rt.keyRelease(MenuKeyEvent.VK_TAB);
	//rt.keyRelease(MenuKeyEvent.VK_CONTROL);
	rt.keyPress(MenuKeyEvent.VK_CONTROL);
	rt.keyPress(MenuKeyEvent.VK_TAB);
	rt.keyRelease(MenuKeyEvent.VK_TAB);
	rt.keyPress(MenuKeyEvent.VK_TAB);
	rt.keyRelease(MenuKeyEvent.VK_TAB);
	rt.keyRelease(MenuKeyEvent.VK_CONTROL);
}

@Test
public void dropdown() {
	wd.findElement(By.xpath("//*[@id='dropdown-class-example']")).click();
	wd.findElement(By.xpath("//option[@value='option1']")).click();
}
}

