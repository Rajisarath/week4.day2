package week4.day2assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("(//div[@id='resizable']/div[3])"));
		action.clickAndHold(resize).moveByOffset(30, 40).release().build().perform();
		
        driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.close();

		 
	}
}
