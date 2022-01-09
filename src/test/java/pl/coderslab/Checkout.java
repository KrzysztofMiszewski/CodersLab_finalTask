package pl.coderslab;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Checkout {

    private WebDriver driver;
    private ProductPage productPage;
    private OrderPage3 orderPage3;

    @Given("an open browser with {string} CheckoutTest")
    public void openBrowser(String html) {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(html);
    }

    @And("a logged user {word} {word}")
    public void logUser(String email, String password) {
        new IndexPage(driver).clickSignIn();
        new SignInPage(driver).logIn(email, password);
        new MyAccountPage(driver).clickLogo();
    }

    @When("i add Hummingbird Printed Sweater {word} x {word} to shopping cart")
    public void addToCart(String size, String number) {
        new IndexPage(driver).clickProduct();
        productPage = new ProductPage(driver);
        productPage.addToCart(size, number);
    }

    @And("i proceed to checkout")
    public  void proceedToCheckout(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        productPage.proceedToCheckout(driver);
        new CartPage(driver).clickProceedToCheckout();
    }

    @And ("i pick address, pick up in-store, pay by check and agree to terms")
    public void fillOrder(){
        new OrderPage1(driver).clickAddressContinue();
        new OrderPage2(driver).clickShippingContinue();
        orderPage3 = new OrderPage3(driver);
        orderPage3.clickPBC();
        orderPage3.clickTerms();
    }

    @And ("i click order")
    public void clickOrder(){
        orderPage3.clickOrderBtn();
    }

    @Then("i make screenshot")
    public void screenshot(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
//        File destFile=new File("c:\\\\tmp\\\\CheckoutTest " + formatter.format(date) +".png");
        File destFile=new File("./Screenshots/CheckoutTest " + formatter.format(date) +".png");
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @And ("i check if order is on order list")
    public void checkOrderList(){
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        String reference = orderConfirmationPage.getReferenceNumber();
        String totalPrice = orderConfirmationPage.getTotalPrice();
        orderConfirmationPage.clickMyAccount();
        new MyAccountPage(driver).clickHistory();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        Assert.assertEquals(reference,orderHistoryPage.getOrderReference());
        Assert.assertEquals(totalPrice, orderHistoryPage.getTotalPrice());
        Assert.assertEquals("Awaiting check payment", orderHistoryPage.getStatus());
    }

    @After("@CheckoutTest")
    public void closeBrowser() {
        driver.quit();
    }

}
