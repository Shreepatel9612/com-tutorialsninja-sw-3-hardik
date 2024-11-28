package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1.1 create a method with the name "selectMenu()" It has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        // 1.2 This method should click on the menu whatever name is passed as a parameter
        clickOnElement(By.linkText(menu));
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //  1.1 Mouse hover on the “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        // 1.2 call the selectMenu() method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");

        // 1.3 Verify the text ‘Desktops’
        assertVerifyText("Desktops", By.xpath("//h2[normalize-space()='Desktops']"));

    }


    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // Mouse hover on the “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.linkText("Laptops & Notebooks"));

        // call selectMenu() method and pass the menu = “Show AllLaptops & Notebooks” */
        selectMenu("Show AllLaptops & Notebooks");

        // Verify the text ‘Laptops & Notebooks’
        assertVerifyText("Laptops & Notebooks", By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));

    }


    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //  Mouse hover on the “Components” Tab and click
        mouseHoverAndClick(By.linkText("Components"));

        //  call the selectMenu() method and pass the menu = “Show AllComponents”
        selectMenu("Show AllComponents");

        // Verify the text ‘Components'
        assertVerifyText("Components", By.tagName("h2"));

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
