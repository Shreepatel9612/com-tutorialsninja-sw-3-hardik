package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    // create a method with the name "selectMyAccountOptions()" It has one parameter name "option" of type string and This method should click on the options of whatever name is passed as a parameter.
    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a"));
        for (WebElement element : options) {
            if (element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //  Verify the text “Register Account”
        assertVerifyText("Register Account", By.xpath("//h1[normalize-space()='Register Account']"));

    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // Verify the text “Returning Customer”
        assertVerifyText("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));

    }


    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        // Enter the First Name
        sendTextToElement(By.name("firstname"), "Hardik");

        //  Enter the Last Name
        sendTextToElement(By.name("lastname"), "Patel;");

        // Enter the Email
        sendTextToElement(By.name("email"), "shreepatel9612@gmail.com");

        //  Enter the Telephone
        sendTextToElement(By.name("telephone"), "0798674535");

        //  Enter the Password
        sendTextToElement(By.name("password"), "875634");

        // Enter the Password Confirm
        sendTextToElement(By.name("confirm"), "875634");

        // Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        //  Click on the Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        // Click on the Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //  Verify the message “Your Account Has Been Created!”
        assertVerifyText("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        //  Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        //  selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));

        // Verify the text “Account Logout”
        assertVerifyText("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));

        // Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //  Enter the Email address
        sendTextToElement(By.name("email"), "shreepatel9612@gmail.com");

        //  Enter the Last Name (There is no option for Last Name!)

        //  Enter the Password
        sendTextToElement(By.id("input-password"), "875634");

        //  Click on the Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //  Verify text “My Account”
        assertVerifyText("My Account", By.xpath("//h2[normalize-space()='My Account']"));

        // Click on the My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        // selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));

        //  Verify the text “Account Logout”
        assertVerifyText("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));

        //  Click on the Continue button
        clickOnElement(By.linkText("Continue"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}

