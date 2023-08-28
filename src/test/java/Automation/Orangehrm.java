package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orangehrm {
	WebDriver wd;
	//Robot rt;
	@BeforeTest
	public void bt1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		}
	
	@Test(priority = 0)
	public void login() throws InterruptedException {
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		wd.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
		wd.findElement(By.xpath("//*//*[@type='submit']")).click();
		
	}
	@Test (priority = 1)
	public void admin() throws AWTException, InterruptedException {
		Thread.sleep(3000);
	    Robot rt=new Robot();
		//wd.findElement(By.linkText("Admin"));
		wd.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@placeholder='Type for hints...']")).sendKeys("John Smith");
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyRelease(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		rt.keyRelease(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyRelease(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		rt.keyRelease(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-icon bi-trash'])[3]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[8]")).click();
		
	}
	
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
		//Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
	}
	
	
	
	@AfterTest
	public void te2() {
		//wd.close();
		}
	}
	
	
	
	
