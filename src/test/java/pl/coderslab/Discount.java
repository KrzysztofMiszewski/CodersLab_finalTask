package pl.coderslab;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.IndexPage;
import pl.coderslab.pages.ProductPage;

public class Discount {

    private WebDriver driver;

    @Given("i am on product page {word}")
    public void productPage(String html) {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(html);
        new IndexPage(driver).clickProduct();
    }

    @Then("discount is correctly displayed")
    public void discountTest() {
        Assert.assertTrue(new ProductPage(driver).checkDiscount());
    }

    @After("@DiscountTest")
    public void closeBrowser() {
        driver.quit();
    }
}
