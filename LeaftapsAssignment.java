package week4.day2assign;

import java.util.ArrayList;
import java.util.List;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaftapsAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//6. Click on Merge Contacts using Xpath LocatorMerge Contacts
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(list.get(1));
		Thread.sleep(2000);
		
		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		driver.switchTo().window(list.get(0));
		Thread.sleep(4000);
		
		//9. Click on Widget of To Contact
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(4000);
		
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		driver.switchTo().window(list.get(0));
		Thread.sleep(2000);
		
		//11. Click on Merge button using Xpath LocatorMerge
		driver.findElement(By.className("buttonDangerous")).click();
		
		//12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		System.out.println("merged");
		
		//13.Verify the title of the page
		String title = driver.getTitle();
		System.out.println("Title--------->" + title );
		
		
		
		

		
		
		



	}

}
