package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //  Mouse hover on the Desktops Tab. and click
        mouseHoverAndClick(By.linkText("Desktops"));

        // Click on “Show AllDesktops”
        clickOnElement(By.linkText("Show AllDesktops"));

        //  Select Sort By position "Name: Z to A"
        selectFromDropDown(By.id("input-sort"), "Name (Z - A)");
        //decending

        //  Retrieve all product names into a list
        List<WebElement> productElements = driver.findElements(By.xpath("//h4[@class='product-name']/a"));
        List<String> actualProductNames = new ArrayList<>();

        for (WebElement element : productElements) {
            actualProductNames.add(element.getText());
        }
        //  Create a copy of the list and sort it in descending order
        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Collections.reverseOrder());

        // Verify that the actual order matches the expected order
        Assert.assertEquals(actualProductNames, expectedProductNames);

    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // Mouse hover on the Currency Dropdown and click
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Currency']"));

        //  Mouse hover on the £Pound Sterling and click
        mouseHoverAndClick(By.name("GBP"));

        //  Mouse hover on the Desktops Tab.
        mouseHoverAndClick(By.linkText("Desktops"));

        //  Click on the “Show AllDesktops”
        clickOnElement(By.linkText("Show AllDesktops"));

        //  Select the Sort By position "Name: A to Z"
        selectFromDropDown(By.id("input-sort"), "Name (A - Z)");

        //  Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));

        // Verify the Text "HP LP3065"
        assertVerifyText("HP LP3065", By.xpath("//h1[normalize-space()='HP LP3065']"));

        // Select Delivery Date "2024-11-27"
        sendTextToElement(By.id("input-option225"), "2024-11-27");

        // .Enter Qty "1” using Select class.
        WebElement quantityField = driver.findElement(By.id("input-quantity"));
        quantityField.clear();
        quantityField.sendKeys("1");

        //  Click on the “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        Thread.sleep(2000);

        //  Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        assertVerifyText("Success: You have added HP LP3065 to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //  Click on the link “shopping cart” displayed in a success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // Verify the text "Shopping Cart"
        assertVerifyText("Shopping Cart  (1.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        //  Verify the Product name "HP LP3065"
        assertVerifyText("HP LP3065", By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));

        //  Verify the Delivery Date "2024-11-27"
        assertVerifyText("Delivery Date:2024-11-27", By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)"));

        //  Verify the Model "Product21"
        assertVerifyText("Product 21", By.xpath("//td[normalize-space()='Product 21']"));

        //  Verify the Todat "£74.73
        assertVerifyText("£74.73", By.xpath("//tbody//tr//td[6]"));

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}