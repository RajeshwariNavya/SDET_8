package pack1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calender_Pop_up_assign2 
{
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.cleartrip.com");
	
	driver.findElement(By.name("origin")).sendKeys("Bengaluru");
    driver.findElement(By.xpath("//a[contains(text(),'Bangalore, IN - Kempegowda')]")).click();
	driver.findElement(By.id("ToTag")).sendKeys("Delhi");
	driver.findElement(By.xpath("//a[contains(text(),'New Delhi, IN -')]")).click();
	Date date=new Date();
    String a = date.toString();    //Fri Dec 11 22:30:51 IST 2020
    System.out.println(a);
    String[] arr = a.split(" ");
    String day=arr[0];
    String month=arr[1];
    String da=arr[2];
    String year=arr[5];
    
   //driver.findElement(By.xpath("//td[@data-month='11' and @data-year='2020']//a[text()='12']")).click();
   driver.findElement(By.xpath("//td[@data-month='"+month+"' and @data-year='"+year+"']//a[text()='"+da+"']")).click();

}
}
