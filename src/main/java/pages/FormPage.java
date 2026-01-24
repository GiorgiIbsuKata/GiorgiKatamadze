package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By maleGender = By.xpath("//label[text()='Male']");
    private final By mobile = By.id("userNumber");
    private final By dobInput = By.id("dateOfBirthInput");
    private final By monthSelect = By.className("react-datepicker__month-select");
    private final By yearSelect = By.className("react-datepicker__year-select");
    private final By day21 = By.xpath("//div[text()='21']");
    private final By subjects = By.id("subjectsInput");
    private final By sports = By.xpath("//label[text()='Sports']");
    private final By address = By.id("currentAddress");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By submit = By.id("submit");

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Enter first name: {fName}")
    public void enterFirstName(String fName) {
        WebElement element = driver.findElement(firstName);
        scrollToElement(element);
        driver.findElement(firstName).sendKeys(fName);
    }

    @Step("Enter last name: {lName}")
    public void enterLastName(String lName) {
        WebElement element = driver.findElement(lastName);
        scrollToElement(element);
        driver.findElement(lastName).sendKeys(lName);
    }

    @Step("Enter email: {mail}")
    public void enterEmail(String mail) {
        WebElement element = driver.findElement(email);
        scrollToElement(element);
        driver.findElement(email).sendKeys(mail);
    }

    @Step("Select gender Male")
    public void selectGenderMale() {
        WebElement element = driver.findElement(maleGender);
        scrollToElement(element);
        driver.findElement(maleGender).click();
    }

    @Step("Enter mobile number: {phone}")
    public void enterMobile(String phone) {
        WebElement element = driver.findElement(mobile);
        scrollToElement(element);
        driver.findElement(mobile).sendKeys(phone);
    }

    @Step("Select date of birth 21 November 2025")
    public void selectDateOfBirth() {
        WebElement element = driver.findElement(dobInput);
        scrollToElement(element);
        driver.findElement(dobInput).click();
        driver.findElement(monthSelect).sendKeys("November");
        driver.findElement(yearSelect).sendKeys("2025");
        driver.findElement(day21).click();
    }

    @Step("Enter subject Maths")
    public void enterSubject() {
        WebElement element = driver.findElement(subjects);
        scrollToElement(element);
        driver.findElement(subjects).sendKeys("Maths");
        driver.findElement(subjects).sendKeys(Keys.ENTER);
    }

    @Step("Select hobby Sports")
    public void selectSports() {
        WebElement element = driver.findElement(sports);
        scrollToElement(element);
        driver.findElement(sports).click();
    }


    @Step("Enter address: {addr}")
    public void enterAddress(String addr) {
        WebElement element = driver.findElement(address);
        scrollToElement(element);
        driver.findElement(address).sendKeys(addr);
    }

    @Step("Select state NCR")
    public void selectState() {
        WebElement element = driver.findElement(state);
        scrollToElement(element);
        driver.findElement(state).click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
    }

    @Step("Select city Delhi")
    public void selectCity() {
        WebElement element = driver.findElement(city);
        scrollToElement(element);
        driver.findElement(city).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
    }

    @Step("Submit form")
    public void submitForm() {
        WebElement element = driver.findElement(submit);
        scrollToElement(element);
        driver.findElement(submit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
    }

    @Step("Scroll to element")
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element
        );
    }
}
