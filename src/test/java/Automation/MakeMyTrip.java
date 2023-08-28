package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	WebDriver wd;
	 Robot rt;
	 WebDriverWait wait;
	 
	 @BeforeTest
	 public void bt1() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe" );
		 wd=new ChromeDriver();
		 wd.manage().window().maximize();
		// wd.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);  //it will wait for the specified time for all the elements to load
		 Thread.sleep(3000);
		 
		 
	 }
	  
	 @Test (priority = 0)
	 public void flights() throws AWTException, InterruptedException {
		 
		 rt=new Robot();
		 wd.get("https://www.makemytrip.com/flights/");
		 rt.keyPress(MenuKeyEvent.VK_F5);
		// Thread.sleep(3000);
		 
		// wd.findElement(By.xpath("//*[@class='makeFlex hrtlCenter column active']")).click();
		 //wd.findElement(By.xpath("//*[@class='wewidgeticon we_close']")).click();
		 //Thread.sleep(2000);
		// wd.findElement(By.xpath("//*[@class='wewidgeticon we_close']")).click();
		// Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(wd, 50);
		// WebElement we2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='wewidgeticon we_close']")));
		 //we2.click();
		 //wd.findElement(By.xpath("//*[@class='wewidgeticon we_close']")).click();
		 
		  
		//  WebElement we3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='wewidgeticon we_close']")));
		  //we3.click();
		
		
		WebElement we=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='tabsCircle appendRight5'])[1]"))); //explicit wait
		//wd.findElement(By.xpath("(//*[@class='tabsCircle appendRight5'])[1]")).click();
		we.click();
		Thread.sleep(3000);  //it will wait for particular time after that line of code it is specified
		 
		 wd.findElement(By.xpath("//*[@id='fromCity']")).sendKeys("Bengaluru");
		 Thread.sleep(3000);
		 rt.keyPress(MenuKeyEvent.VK_DOWN);
		 rt.keyRelease(MenuKeyEvent.VK_DOWN);
		 rt.keyPress(MenuKeyEvent.VK_ENTER);
		 rt.keyRelease(MenuKeyEvent.VK_ENTER);
		 wd.findElement(By.xpath("//*[@id='toCity']")).sendKeys("Dub");
		 Thread.sleep(3000);
		 rt.keyPress(MenuKeyEvent.VK_DOWN);
		 rt.keyRelease(MenuKeyEvent.VK_DOWN);
		 rt.keyPress(MenuKeyEvent.VK_ENTER);
		 rt.keyRelease(MenuKeyEvent.VK_ENTER);
		 wd.findElement(By.xpath("(//*[@class='lbl_input appendBottom10'])[3]")).click();
		 Thread.sleep(3000);
		 wd.findElement(By.xpath("(//*[@class='DayPicker-Month'])[1]/div[3]/div[4]/div[6]")).click();
		 wd.findElement(By.xpath("//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		 Thread.sleep(10000);
		
		 }
	 
	 @Test (enabled=false)
	 public void popup() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(wd, 10);  //specifying the webdriver wd to wait for 10 seconds
		WebElement we2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button buttonSecondry buttonBig fontSize12 relative']")));
		we2.click();
		// wd.findElement(By.xpath("//*[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();
		wd.findElement(By.xpath("(//*[@class='appendRight8'])[1]")).click();
		wd.findElement(By.xpath("(//*[@class='button corp-btn latoBlack buttonPrimary fontSize13  '])[1]")).click();
		 
		
	 }
	 

}
