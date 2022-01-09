package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

public class ProductPage {

    Select sizeSelect;
    WebElement quantityField;
    WebElement oldPrice;
    WebElement newPrice;
    WebElement addToCart;
    WebElement proceedToCheckout;

    public ProductPage(WebDriver driver) {
        this.sizeSelect = new Select(driver.findElement(By.cssSelector("#group_1")));
        this.quantityField = driver.findElement(By.cssSelector("#quantity_wanted"));
        this.oldPrice = driver.findElement(By.cssSelector(".regular-price"));
        this.newPrice = driver.findElement(By.cssSelector(".current-price > span:nth-child(1)"));
        this.addToCart = driver.findElement(By.cssSelector("button.btn-primary"));
    }

    public boolean checkDiscount() {
        String str = oldPrice.getText().replaceAll("[^\\.0123456789]","");
        BigDecimal oldPrice = new BigDecimal(str);
        str = newPrice.getText().replaceAll("[^\\.0123456789]","");
        BigDecimal newPrice = new BigDecimal(str);
        return newPrice.compareTo(oldPrice.multiply(new BigDecimal("0.8"))) == 0;
    }

    public void addToCart(String size, String number) {
        sizeSelect.selectByVisibleText(size);
        quantityField.clear();
        quantityField.sendKeys(number);
        addToCart.click();
    }

    public void proceedToCheckout(WebDriver driver) {
        proceedToCheckout = driver.findElement(By.cssSelector("a.btn"));
        proceedToCheckout.click();
    }
}
