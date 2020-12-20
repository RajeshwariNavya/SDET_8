package pack1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender_pop_up 
{
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		Actions act=new Actions(driver);
		act.moveByOffset(0, 10).click().perform();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Bengaluru, India']")));
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Delhi, India']")));
		driver.findElement(By.xpath("//p[text()='Delhi, India']")).click();
		Date date =new Date();
		String a = date.toString();
		//System.out.println(a);    //Fri Dec 11 22:30:51 IST 2020
		String [] b=a.split(" ");
	     String day = b[0];
	     String month = b[1];
	     String da = b[2];
	     String year = b[5];
		
		driver.findElement(By.xpath("//div[@aria-label='"+day+" " +month+" " +da+" "+year+"']")).click();
		
		
		
	}

}
