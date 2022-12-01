package week4.day2assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		driver.switchTo().frame(0);
		/*
		 * //li[text()='Item 1'] WebElement sortele1 =
		 * driver.findElement(By.xpath("//li[text()='Item 1']"));
		 * action.clickAndHold(sortele1).moveByOffset(10,20).release().build().perform()
		 * ; Thread.sleep(4000); WebElement sortele2 =
		 * driver.findElement(By.xpath("//li[text()='Item 3']"));
		 * action.clickAndHold(sortele2).moveByOffset(30,40).release().build().perform()
		 * ; //driver.close();
		 */
		
		  WebElement source = driver.findElement(By.xpath("//li[text()='Item 1']"));
		  WebElement dest = driver.findElement(By.xpath("//li[text()='Item 3']"));
		  Point location=dest.getLocation();
		  
		  int x =location.getX();
		  int y= location.getY();
		  System.out.println("X :"+x+" Y: "+y);
		  
		  action.clickAndHold(source).dragAndDropBy(source, x, y).build().perform();
		  Thread.sleep(2000); System.out.println("Item moved");
		  
		

	}

}
