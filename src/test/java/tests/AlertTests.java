package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertPage;

@Epic("UI Tests")
@Feature("Alert Handling")
@Listeners({AllureTestNg.class})
public class AlertTests {
    WebDriver driver;
    AlertPage alertPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        alertPage = new AlertPage(driver);
    }

    @Test(description = "Handle prompt alert and verify input")
    @Story("User interacts with alert textbox")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that user input in alert textbox is reflected correctly on the page")
    public void handleAlertTest() {
        String inputText = "Test Test";
        alertPage.openAlertTab();
        alertPage.triggerAlert();
        alertPage.handleAlert(inputText);
        Assert.assertTrue(alertPage.getResultText().contains(inputText));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
