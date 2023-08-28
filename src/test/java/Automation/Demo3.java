package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(5000);
		wd.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
		wd.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
		wd.findElement(By.xpath("//*[@class='fa fa-2x fa-sign-in']")).click();
		Thread.sleep(6000);
		wd.findElement(By.xpath("//*[@class='icon-2x icon-signout']")).click();
		wd.close();
		}
}
