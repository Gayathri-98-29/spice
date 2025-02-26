package tes;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pag.BookingPage;

public class BookingPageTest extends BaseTest{

    @Test
    public void testBookingPage() throws InterruptedException {
        
		bookingPage.setFirstName("gayathri");
        bookingPage.setLastName("Ganga");
        bookingPage.setMobileNumber("9940584856");
        bookingPage.setEmailId("gayathri1996@gmail.com");
        //bookingPage.setCountryMenu();
        bookingPage.setTownCity("Chennai");
        //Adding passenger details
        bookingPage.setF_Name("Yaashu");
        bookingPage.setL_Name("Mani");
        bookingPage.setM_Number("9940584957");
        //bookingPage.setClickNext();
        bookingPage.setContinue();
        Thread.sleep(3000);
        Thread.sleep(6000);
        //WebDriverWait wait = new  WebDriverWait (driver, Duration.ofSeconds(40));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img"))).click();
        String str = driver.getCurrentUrl();
        AssertJUnit.assertEquals(str, "https://www.spicejet.com/booking/addons");
    }
}
