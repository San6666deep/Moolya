package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UrlDemo {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver wd=new ChromeDriver();
	wd.get("https://www.google.com/");

	}

}
