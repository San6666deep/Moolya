package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		wd.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
		wd.findElement(By.xpath("//*//*[@type='submit']")).click();
		Thread.sleep(3000);
		wd.close();
		//JavascriptExecutor js=(JavascriptExecutor)wd;
		//js.executeScript("");
		}

}
