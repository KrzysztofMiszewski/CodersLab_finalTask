package pl.coderslab;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/features/", plugin = {"pretty", "html:out.html"}, tags = "@AddAddressTest")
public class AddAddressTest {
}
