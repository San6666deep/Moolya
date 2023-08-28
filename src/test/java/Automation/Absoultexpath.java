package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Absoultexpath {
	WebDriver wd;
	
@BeforeTest
public void bt() {
	WebDriverManager.chromedriver().setup();
	wd=new ChromeDriver();
	wd.manage().window().maximize();
	wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
public void test1() {
	wd.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
}
}
