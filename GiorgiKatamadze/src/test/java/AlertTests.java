import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void handleAlert() {
        driver.findElement(By.linkText("Alert with Textbox")).click();

        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String inputText = "Test Test";
        alert.sendKeys(inputText);

        alert.accept();

        String resultText = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue(resultText.contains(inputText));
    }

    @AfterClass
    public void done() {
        driver.quit();
    }
}
