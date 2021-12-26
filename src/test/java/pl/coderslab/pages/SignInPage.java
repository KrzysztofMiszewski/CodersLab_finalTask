package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private final WebElement signIn;
    private final WebElement emailField;
    private final WebElement passwordField;


    public SignInPage(WebDriver driver) {

        this.emailField = driver.findElement(By.cssSelector("div.form-group:nth-child(2) > div:nth-child(2) > input:nth-child(1)"));
        this.passwordField = driver.findElement(By.cssSelector(".js-child-focus"));
        this.signIn = driver.findElement(By.id("submit-login"));
    }

    public void LogIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signIn.click();
    }
}
