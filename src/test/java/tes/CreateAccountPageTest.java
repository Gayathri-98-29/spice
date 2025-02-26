package tes;


	
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import pag.CreateAccountPage;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	
	
	
	
	
	
	
	
	
	
	import org.testng.annotations.Test;

	import java.util.Set;

	public class CreateAccountPageTest extends BaseTest {

	    @Test
	    public void CreateAcc() throws InterruptedException {
	        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
	      
	        createAccountPage.setClickingSignupButton();
	        //Storing the current window handel
	        String mainWindowHandel = driver.getWindowHandle();
	        //Switching to the new window
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String windowHandel : allWindows){
	            if (!windowHandel.equals(mainWindowHandel)){
	                driver.switchTo().window(windowHandel);
	                createAccountPage.setSelectDropDown();
	                createAccountPage.setFirstNameField("gayathri");
	                createAccountPage.setLastNameField("Gan");
	                createAccountPage.setDobField();
	                Thread.sleep(3000);
	                //Selecting month
	                WebElement dd = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	                Select select = new Select(dd);
	                select.selectByVisibleText("December");
	                Thread.sleep(3000);
	                //Selecting Year
	                WebElement dd1 = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	                Select select1 = new Select(dd1);
	                select1.selectByVisibleText("1997");
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//div[text()='4']")).click();
	                createAccountPage.setMobileNumberField("9940584856");
	                Thread.sleep(2000);
	                createAccountPage.setEmailField("gayathri1997@gmail.com");
	                createAccountPage.setCPasswordField("gayathri@0412");
	                createAccountPage.setNewPasswordField("gayathri@0412");
	                createAccountPage.setClickingCheckBox();
	                createAccountPage.setSubmitButton();
	                String str = driver.findElement(By.xpath("//label[text()='OTP Verification']")).getText();
	                System.out.println(str);
	                AssertJUnit.assertEquals(str,"OTP Verification");
	                driver.close();
	                driver.switchTo().window(mainWindowHandel);

	            }
	        }

	    }


	}
	
	

