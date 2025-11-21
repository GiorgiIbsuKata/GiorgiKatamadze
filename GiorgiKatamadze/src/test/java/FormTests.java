import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class FormTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    @Test
    public void fillForm() {
        driver.findElement(By.id("firstName")).sendKeys("TestName");
        driver.findElement(By.id("lastName")).sendKeys("TestLastName");
        driver.findElement(By.id("userEmail")).sendKeys("Test@gmail.com");

        driver.findElement(By.xpath("//label[text()='Male']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("1234512345");

        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.className("react-datepicker__month-select")).sendKeys("November");
        driver.findElement(By.className("react-datepicker__year-select")).sendKeys("2025");
        driver.findElement(By.xpath("//div[text()='21']")).click();

        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys("\n");

        driver.findElement(By.xpath("//label[text()='Sports']")).click();

        driver.findElement(By.id("currentAddress")).sendKeys("123 Tbilisi Test");

        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();

        driver.findElement(By.id("submit")).click();

        WebElement modal = driver.findElement(By.className("modal-content"));

        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='TestName TestLastName']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Test@gmail.com']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Male']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='1234512345']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='21 November,2025']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Maths']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Sports']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='123 Tbilisi Test']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='NCR Delhi']")).isDisplayed());
    }

    @AfterClass
    public void done() {
        driver.quit();
    }
}
