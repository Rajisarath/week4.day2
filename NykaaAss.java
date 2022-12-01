package week4.day2assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAss {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		// 1. Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window handle : " + parentWindow);

		// 2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		System.out.println("brands mouseover performed");
		// driver.findElement(By.xpath("//a[text()='brands']")).click();

		// 3) Click L'Oreal Paris

		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();

		System.out.println("L'Oreal Paris is clicked");

		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String Orealtitle = driver.getTitle();
		System.out.println("Title------>" + Orealtitle);

		// 5) Click sort By and select customer top rated
		// (//div[@class='control-indicator radio '])[3]
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		System.out.println("Click sort By and select customer top rated is clicked");

		// 6) Click Category and click Hair->Click haircare->Shampoo
		// a[text()='hair']
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		System.out.println("Click Category is done");
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		System.out.println("click Hair is done");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		System.out.println("click haircare is done");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		System.out.println("click haircare-->Shampoo is done");

		// 7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		System.out.println("Click--->Concern");
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		System.out.println("Concern--->Color Protection");

		
		  //8)check whether the Filter is applied with Shampoo
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).click();
		  System.out.println("Filter is applied with Shampoo is checked");
		  
			
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		   driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
		   System.out.println("L'Oreal Paris Colour Protect Shampoo is clicked");
		
		 //  10) GO to the new window and select size as 175ml
		   //new window
		   Set<String> windowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(windowHandles);
			driver.switchTo().window(list.get(1));
			
			WebElement shampooSize  = driver.findElement(By.xpath("//select[@title='SIZE']"));
			Select select = new Select(shampooSize);
			select.selectByVisibleText("175ml");
			System.out.println(" selected size as 175ml");
			
			//11) Print the MRP of the product
			String text = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e'])[1]")).getText();
			System.out.println("MRP of the product  " +text);
			
			//12) Click on ADD to BAG
			driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
			System.out.println(" ADD to BAG is clicked");
			 
		//13) Go to Shopping Bag 
			driver.findElement(By.xpath("//span[@class='cart-count']")).click();
			System.out.println(" Shopping Bag  is clicked");
			
		//	14) Print the Grand Total amount
			driver.switchTo().frame(0);
			String text2 = driver.findElement(By.xpath("//span[text()='₹259']")).getText();
			System.out.println(" Shopping Bag  is clicked" + text2);
			
	    //15) Click Proceed
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
			System.out.println(" Click Proceed");
			
		//16) Click on Continue as Guest
			//come back from frame
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
			System.out.println("Click on Continue as Guest");
			
			
			  //17) Check if this grand total is the same in step 14//p[text()='₹259']
			  driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).
			  click(); 
			  String text3 =driver.findElement(By.xpath("//p[text()='₹259']")).getText();
			  if(text3.equals(text2)){ 
				  System.out.println("grand total is the same");
			  }else { 
				  System.out.println("grand total is the not same");
				  }
			  
			  
			  //18) Close all windows
			  driver.close();
			 

			

	}
}
