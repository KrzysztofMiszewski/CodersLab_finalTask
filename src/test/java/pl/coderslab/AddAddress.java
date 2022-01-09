package pl.coderslab;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

public class AddAddress {

    private WebDriver driver;
    private NewAddressPage newAddressPage;
    private AddressesPage addressesPage;

    @Given("an open browser with {string} AddAddressTest")
    public void openBrowser(String html) {

        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(html);
    }

    @When("i click the button 'sign in'")
    public void clickSignIn() {
        new IndexPage(driver).clickSignIn();
    }

    @And("i fill email and password fields {string} {string}")
    public void fillEmailPassword(String email, String password) {
        new SignInPage(driver).logIn(email, password);
    }


    @And("i click the button 'add address'")
    public void clickAddAddress() {
        new MyAccountPage(driver).clickAddressButton();
    }

    @And("i complete the form  {string}, {string}, {string}, {word}, {string}, {word}")
    public void fillForm(String alias, String address, String city, String postal, String country, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.addAddress(alias, address, city, postal, country, phone);
    }

    @And("i click the 'save' button")
    public void clickSave() {
        newAddressPage.save();
    }

    @Then("address should be created {string}, {string}, {string}, {word}, {string}, {word}")
    public void isAddressCreated(String alias, String address, String city, String postal, String country, String phone) {
        addressesPage = new AddressesPage(driver);
        String[] lines = addressesPage.getAddressBody().split("\\r?\\n|\\r");
//        lines = Arrays.copyOfRange(lines,1,6);
        lines[0] = addressesPage.getAliasText();
        addressesPage.deleteAddress();
//        Assert.assertEquals(alias, addressesPage.GetAliasText());
        Assert.assertArrayEquals(new String[]{alias, address, postal, city, country, phone}, lines);
    }

//    @And("delete address")
//    public void deleteAddress() {
//        addressesPage.DeleteAddress();
//    }


    @After("@AddAddressTest")
    public void closeBrowser() {
        driver.quit();
    }

}
