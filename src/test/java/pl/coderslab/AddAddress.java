package pl.coderslab;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.util.Arrays;

public class AddAddress {

    private WebDriver driver;
    private NewAddressPage newAddressPage;
    private AddressesPage addressesPage;

    @Given("an open browser with {string}")
    public void OpenBrowser(String html) {

        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(html);
    }

    @When("i click the button 'sign in'")
    public void ClickSignIn() {
        new IndexPage(driver).ClickSignIn();
    }

    @And("i fill email and password fields {string} {string}")
    public void FillEmailPassword(String email, String password) {
        new SignInPage(driver).LogIn(email, password);
    }


    @And("i click the button 'add address'")
    public void ClickAddAddress() {
        new MyAccountPage(driver).ClickAddressButton();
    }

    @And("i complete the form  {string}, {string}, {string}, {word}, {string}, {word}")
    public void FillForm(String alias, String address, String city, String postal, String country, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.AddAddress(alias, address, city, postal, country, phone);
    }

    @And("i click the 'save' button")
    public void ClickSave() {
        newAddressPage.Save();
    }

    @Then("address should be created {string}, {string}, {string}, {word}, {string}, {word}")
    public void IsAddressCreated(String alias, String address, String city, String postal, String country, String phone) {
        addressesPage = new AddressesPage(driver);
        String[] lines = addressesPage.GetAddressBody().split("\\r?\\n|\\r");
        lines = Arrays.copyOfRange(lines,1,6);
        //System.out.println(Arrays.toString(lines));
        Assert.assertEquals(alias, addressesPage.GetAliasText());
        Assert.assertArrayEquals(new String[]{address, postal, city, country, phone}, lines);
    }

//    @And("delete address")
//    public void DeleteAddress() {
//        addressesPage.DeleteAddress();
//    }

//    @And("close browser")
//    public void closeBrowser() {
//        driver.quit();
//    }

    @After
    public void CloseBrowser() {
        try {
            addressesPage.DeleteAddress();
        } catch (Exception e) {
        }
        driver.quit();
    }

}
