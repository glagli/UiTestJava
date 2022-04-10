package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homework {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String BASE_URL = "https://demoqa.com/automation-practice-form/";

    @BeforeAll
    static void registerDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // отключает логирование
        System.setProperty("webdriver.chrome.silentOutput", "true"); // отключает логирование
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF); // отключает логирование
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(BASE_URL);
    }

    @Test
    void StudentRegistration() throws InterruptedException {

        By dateBirth = By.id("dateOfBirthInput");
        By month = By.className("react-datepicker__month-select");
        By year = By.className("react-datepicker__year-select");


        By firstName = By.id("firstName");
        By lastName = By.id("lastName");
        By userEmail = By.id("userEmail");
        By gender = By.xpath("//label[contains(text(),'Female')]");
        By mobile = By.id("userNumber");
        By inputSubjects = By.id("subjectsInput");
        By hobbies = By.xpath("//label[contains(text(),'Sports')]");
        By currentAddress = By.id("currentAddress");
        By buttonSubmit = By.id("submit");
        By resultTitle = By.id("example-modal-sizes-title-lg");


        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(userEmail).sendKeys("Test@test.ru");
        driver.findElement(gender).click();
        driver.findElement(mobile).sendKeys("9104442135");

        driver.findElement(dateBirth).click();
        Select monthSelect = new Select(driver.findElement(month));
        monthSelect.selectByVisibleText("February");
        Select yearSelect = new Select(driver.findElement(year));
        yearSelect.selectByVisibleText("1992");
        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day--009"));
        day.click();
        driver.findElement(inputSubjects).sendKeys("Moscow");
        driver.findElement(hobbies).click();
        driver.findElement(currentAddress).sendKeys("test");
        driver.findElement(buttonSubmit).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(resultTitle));
        Assertions.assertEquals("Thanks for submitting the form", driver.findElement(resultTitle).getText());
    }

    @AfterEach
    void rearDown() {
        driver.quit();
    }
}
