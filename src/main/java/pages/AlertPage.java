package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By alertTab = By.linkText("Alert with Textbox");
    private final By alertButton = By.cssSelector("button[onclick='promptbox()']");
    private final By resultText = By.id("demo1");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Open the 'Alert with Textbox' tab")
    public void openAlertTab() {
        driver.findElement(alertTab).click();
    }

    @Step("Trigger the prompt alert")
    public void triggerAlert() {
        driver.findElement(alertButton).click();
    }

    @Step("Handle alert with input: {input}")
    public void handleAlert(String input) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(input);
        alert.accept();
    }

    @Step("Get result text from page")
    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
