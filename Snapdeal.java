package week4.day2assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
//			String snapdealWindow = driver.getWindowHandle();
//			System.out.println("snapdeal window handle : " +snapdealWindow);
		
		//2.Go to Mens Fashion
		WebElement mensfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mensfashion).perform();
		System.out.println("mensfashion mouseover performed");
	
		
		//3. Go to Sports Shoes
		//(//i[@class='sd-icon sd-icon-search search-Icon grey-bbb'])[5]
        driver.findElement(By.xpath("(//a[@class='subDefaultLink'])[5]")).click();
        System.out.println("Sports Shoes window opened");
        
        //4. Get the count of the sports shoes
      //a[@class='convertToLinks sub-cat-node dp-widget-link hashAdded']
//        Thread.sleep(2000);
        List<WebElement> countshoe = driver.findElements(By.xpath("//picture[@class='picture-elem']"));
        int countshoesize = countshoe.size();
        System.out.println("no of shoes: " + countshoesize);

        
        //5. Click Training shoes
      
       driver.findElement(By.xpath("(//div[@class='sub-cat-name '])[1]")).click();
      Thread.sleep(2000);
       driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']")).click();
    //   Thread.sleep(2000);
       driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
       System.out.println("Training shoes is clicked");
        
        
        //Sort by Low to High
       
       driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();

       Thread.sleep(2000);
       driver.findElement(By.xpath("(//li[@class='search-li'])[2]")).click();
       System.out.println("Low to High is clicked");
       WebElement ele = driver.findElement(By.xpath("//div[@class='lfloat ']"));
      
	   builder.moveToElement(ele);
	   String text2 = ele.getText();
       System.out.println(text2);
       
      //7. Check if the items displayed are sorted correctly
       List<WebElement> allshoeElements = driver.findElements(By.xpath("//div[@class='product-desc-rating ']//div[@class='product-price-row clearfix']"));
	   //List<Integer> list = new ArrayList<Integer>();
	   int size = allshoeElements.size();
	   System.out.println("size of all shoes"+size);
	   List<Integer> list = new ArrayList<Integer>();
	   
	 
	   
	   boolean sorted = true;
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i)<=list.get(i+1))
				sorted = true;
			else
			{
				sorted = false;
				break;
			}
		}
		if(sorted)
			System.out.println("Price is Sorted");
		else
			System.out.println("Price is not sorted");
		//8.Select the price range (900-1200)
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("1200");
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1800");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		System.out.println("price range (1200-1800) is viewed");
		
		//9.Filter with color yellow
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@for='Color_s-Yellow']/span)[1]")).click();
		System.out.println(" color yellow shoe is viewed");
		
		
		//10.verify the all applied filters 
		//p[text()='Force 10 By Liberty Yellow Sports Shoes']
		String text = driver.findElement(By.xpath("//a[text()=' Yellow']")).getText();
		System.out.println(text);
		
		
		//11. Mouse Hover on first resulting Training shoes
		WebElement Trainingshoe = driver.findElement(By.xpath("(//img[contains(@class,'product-image ')])[1]"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(Trainingshoe).perform();
		System.out.println("Trainingshoe mouseover performed");
		
		//12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		
		//13. Print the cost and the discount percentage 
		//span[@class='lfloat product-price']
		String text1 = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		System.out.println("cost:" + text1);
		//div[@class='product-discount']/span
		String text3 = driver.findElement(By.xpath("//div[@class='product-discount']/span")).getText();
		System.out.println("discount percentage:"+text3);
		
		//14. Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/quick.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(2000);
		driver.close(); 

		


}

}
