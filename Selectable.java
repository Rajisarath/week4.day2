package week4.day2assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	//	Actions builder  = new Actions(driver);
		
		
		
		driver.switchTo().frame(0);
		
		driver.executeScript("document.body.style.zoom='50%'", "");
		
	//	Thread.sleep(2000);
		WebElement selectable1 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement selectable2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement selectable3 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement selectable4= driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		Actions ac  = new Actions(driver);
		ac.clickAndHold(selectable1).clickAndHold(selectable4).clickAndHold(selectable3).clickAndHold(selectable2).release().perform();
		
	}
}
