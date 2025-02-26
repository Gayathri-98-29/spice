package tes;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pag.BookingPage;
import pag.CheckInPage;
import pag.CreateAccountPage;
import pag.FlightStatusPage;
import pag.FlightTrip;
import pag.LoginPage;
import pag.ManageBookingPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

   public static WebDriver driver;
   public BookingPage bookingPage;
   public CreateAccountPage createAccountPage;
  public FlightTrip flightTrip;
  public LoginPage loginPage;
   public CheckInPage checkInPage;
  public FlightStatusPage flightStatusPage;
  public ManageBookingPage manageBookingPage;
  
   
@BeforeMethod
  
   
	   @Parameters("browser")
	    public void setUp(@Optional("chrome") String browser, ITestContext context) {
	        // Retrieve global test context if needed
	   WebDriverManager.chromedriver().setup();
	   ChromeOptions options =new ChromeOptions();
  	 options.addArguments("--remote-allow-origins=*");
	    WebDriver  driver = new ChromeDriver(options);
	   
       if(browser.equalsIgnoreCase("chrome")) {
          ChromeOptions options1 = new ChromeOptions();
          options.addArguments("--disable-notification");
          driver = new ChromeDriver();
      } 
else if(browser.equalsIgnoreCase("firefox")){
       FirefoxOptions options2 = new FirefoxOptions();
        options.addArguments("--disable-notification");
      
           driver = new FirefoxDriver(options2);
       
       driver.get("https://www.spicejet.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       bookingPage = new BookingPage(driver);
       createAccountPage = new CreateAccountPage(driver);
      flightTrip = new FlightTrip(driver);
     loginPage = new LoginPage(driver);
      checkInPage = new CheckInPage(driver);
      flightStatusPage = new FlightStatusPage(driver);
      manageBookingPage = new ManageBookingPage(driver);
   }
}
   @AfterMethod

    public void tearDown(){
	   // Quit the WebDriver instance after the test
     
   }

   public static String takeScreenshots(String testCaseName){
       TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
       File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

       File destinationFile = new File("Screenshots/"+ testCaseName + ".png");
       try {
           FileUtils.copyFile(srcFile,destinationFile);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       String path = "<img src = " + destinationFile.getAbsolutePath() + "width = 200px height = 200px/>";
       Reporter.log(path);
       return destinationFile.getAbsolutePath();
   }

}