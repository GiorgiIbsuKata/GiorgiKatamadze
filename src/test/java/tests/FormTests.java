package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FormPage;

@Epic("UI Tests")
@Feature("Form Submission")
@Listeners({AllureTestNg.class})
public class FormTests {
    WebDriver driver;
    FormPage formPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        formPage = new FormPage(driver);
    }

    @Test(description = "Fill and submit the form")
    @Story("User fills form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user can fill and submit the form successfully")
    public void fillFormTest() {
        formPage.enterFirstName("TestName");
        formPage.enterLastName("TestLastName");
        formPage.enterEmail("Test@gmail.com");
        formPage.selectGenderMale();
        formPage.enterMobile("1234512345");
        formPage.selectDateOfBirth();
        formPage.enterSubject();
        formPage.selectSports();
        formPage.enterAddress("123 Tbilisi Test");
        formPage.selectState();
        formPage.selectCity();
        formPage.submitForm();

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
    public void tearDown() {
        driver.quit();
    }
}
