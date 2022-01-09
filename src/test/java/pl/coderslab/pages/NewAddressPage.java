package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {


    private final WebElement aliasField;
    private final WebElement addressField;
    private final WebElement postalField;
    private final WebElement cityField;
    private final Select countrySelect;
    private final WebElement phoneField;
    private final WebElement saveButton;


    public NewAddressPage(WebDriver driver) {

        this.aliasField = driver.findElement(By.cssSelector("div.form-group:nth-child(5) > div:nth-child(2) > input:nth-child(1)"));
        this.addressField = driver.findElement(By.cssSelector("div.form-group:nth-child(10) > div:nth-child(2) > input:nth-child(1)"));
        this.postalField = driver.findElement(By.cssSelector("div.form-group:nth-child(12) > div:nth-child(2) > input:nth-child(1)"));
        this.cityField = driver.findElement(By.cssSelector("div.form-group:nth-child(13) > div:nth-child(2) > input:nth-child(1)"));
        this.countrySelect = new Select(driver.findElement(By.cssSelector("select.form-control")));
        this.phoneField = driver.findElement(By.cssSelector("div.form-group:nth-child(15) > div:nth-child(2) > input:nth-child(1)"));
        this.saveButton = driver.findElement(By.cssSelector("button.btn"));
    }

    public void addAddress(String alias, String address, String postal, String city, String country, String phone) {

        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        postalField.sendKeys(postal);
        cityField.sendKeys(city);
        countrySelect.selectByVisibleText(country);
        phoneField.sendKeys(phone);

    }

    public void save(){
        saveButton.click();
    }

}
