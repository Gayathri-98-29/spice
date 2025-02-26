package tes;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.setLoginButton();
        Thread.sleep(3000);
        loginPage.setEmailRadioButton();
        loginPage.setEmail("Lokeshdharan1996@gmail.com");
        loginPage.setPassword("Lokki@0412");
        loginPage.setSubmitButton();
        String expectedValue= "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
        String actualValue = driver.getTitle();
        AssertJUnit.assertEquals(expectedValue,actualValue);

    }
}