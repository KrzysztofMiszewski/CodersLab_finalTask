package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private final WebElement signIn;
    private final WebElement product;


    public IndexPage(WebDriver driver) {

        this.signIn = driver.findElement(By.cssSelector(".user-info > a:nth-child(1)"));
        this.product = driver.findElement(By.cssSelector("article.product-miniature:nth-child(2) > div:nth-child(1)" +
                " > a:nth-child(1) > img:nth-child(1)"));

    }

    public void clickSignIn(){
        signIn.click();
    }

    public void clickProduct() {
        product.click();
    }

}
