package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Gmail {
	WebDriver wd;
	String url="https://www.google.com/";
	Robot rt;
	@BeforeTest
	public void bt1() throws AWTException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get(url);
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		rt=new Robot();
		
	}
	@Test
	public void test1() {
		Actions act= new Actions(wd);
	    //WebElement we1=wd.findElement(By.linkText("Gmail"));
		WebElement we2=wd.findElement(By.partialLinkText("il"));
		act.click(we2).build().perform();
	}
	@Test
	public void test2() throws AWTException {
		Actions act= new Actions(wd);
		WebElement we1=wd.findElement(By.xpath("(//*[@class='gb_y'])[1]"));
		act.contextClick(we1).build().perform();
		
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyRelease(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyRelease(MenuKeyEvent.VK_DOWN);
		rt.keyPress(KeyEvent.VK_ENTER);
		//rt.keyPress(MenuKeyEvent.VK_ENTER);
        //rt.keyRelease(MenuKeyEvent.VK_ENTER);
		
	} 

}
