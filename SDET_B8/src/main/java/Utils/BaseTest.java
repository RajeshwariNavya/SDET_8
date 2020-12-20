package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.LoginPage;

public class BaseTest 
{
	public Webdriver_util wLib = new Webdriver_util();
	public File_utils fLib = new File_utils();
	public Excel_utils elib = new Excel_utils();
	public Databaseconnection dbLib = new Databaseconnection();
	public static WebDriver driver;
	
	
	/*@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("====================Connect To DB========================");
		dbLib.connectToDB();
	}*/
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		System.out.println("=========launch the browser==============");
		/*Common  Data*/
		String URL  = fLib.getFileProperty("url");

		String BROWSER  = fLib.getFileProperty("browser");

		 if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	//@Parameters("browser")
		//@BeforeClass
		public void configBeforeParllelClass(String BROWSER) throws Throwable {
			System.out.println("=========launch the browser==============");
			/*Common  Data*/
			String URL  = fLib.getFileProperty("url");


			 if(BROWSER.equals("chrome")) {
			    driver = new ChromeDriver();
			 }else if(BROWSER.equals("firefox")) {
				 driver = new FirefoxDriver();
			 }else if(BROWSER.equals("ie")) {
				 driver = new InternetExplorerDriver();
			 }else {
				 driver = new ChromeDriver(); 
			 }
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
		}
		
		
		@BeforeMethod
		public void cofigBeforeMtd() throws Throwable {
			System.out.println("=======login======");
			String usn  = fLib.getFileProperty("username");
			String pwd  = fLib.getFileProperty("password");
			
			/*step 1 : login to app*/
			LoginPage log=new LoginPage(driver);
			log.Login(usn, pwd);
		}
		
		
		@AfterMethod
		public void configAfterMethode() {
			System.out.println("=======logout======");
			HomePage hp = new HomePage(driver);
			hp.SignoutApplication(driver);
			
		}
		  
		
		@AfterClass
		public void confifAfterClass() {
			System.out.println("=========close the browser==============");
			driver.quit();
		}

	/*	@AfterSuite
		public void configAsterSuite() throws Throwable {
			System.out.println("====================DissConnect To DB========================");
			dbLib.closeDb();
		}*/
	

}
