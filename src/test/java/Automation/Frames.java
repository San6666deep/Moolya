package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver wd;

	@BeforeTest
	public void bt1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		Thread.sleep(2000);
		//wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
		//Thread.sleep(3000);
		}
@Test
public void test1() {
	wd.get("https://demoqa.com/frames");
	
	JavascriptExecutor js=(JavascriptExecutor)wd;
	js.executeScript("document.getElementById('frame2').scrollIntoView()");
	
	List<WebElement> frames= wd.findElements(By.tagName("iframe"));
	System.out.println(frames.size());
	
	for(int i=0;i<frames.size();i++) {
		String names=frames.get(i).getAttribute("id");
		System.out.println(names);
	}
	
	//wd.switchTo().frame("frame2");
	//js.executeScript("window.scrollBy(0,100)");
	 
	//wd.switchTo().frame("frame1");
	wd.findElement(By.xpath("//iframe[@id='frame1']")).getText();
	
}
 

}
