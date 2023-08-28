package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploadanddownload {
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
public void download()
{
	wd.get("https://demoqa.com/upload-download");
	wd.findElement(By.xpath("//*[@id='downloadButton']")).click();
	wd.findElement(By.xpath("//*[@id='uploadFile']")).sendKeys("C:\\Users\\user\\Downloads\\samplefile (2).jpeg");
	
	}
@Test
public void drag() {
	wd.get("https://demoqa.com/droppable");
	Actions act=new Actions(wd);
	WebElement we1=wd.findElement(By.xpath("//*[@id='draggable']"));
	WebElement we2=wd.findElement(By.xpath("//*[@id='droppable']"));
	act.dragAndDrop(we1, we2).build().perform();
}

}
