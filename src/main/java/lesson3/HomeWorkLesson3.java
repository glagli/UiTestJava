package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HomeWorkLesson3 {

    public static void DateBirth(WebDriver driver, String birthMonth, String birthYear, String birthDay) {
        WebElement dateBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateBirth.click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        month.click();

        WebElement monthValue = driver.findElement(By.cssSelector(String.format(".react-datepicker__month-select [value='%s']", birthMonth)));
        monthValue.click();

        WebElement year = driver.findElement(By.cssSelector(String.format(".react-datepicker__year-select [value='%s']", birthYear)));
        year.click();

        WebElement day = driver.findElement(By.cssSelector(String.format(".react-datepicker__day--0%s", birthDay)));
        day.click();

    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // отключает логирование
        System.setProperty("webdriver.chrome.silentOutput", "true"); // отключает логирование
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF); // отключает логирование

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://demoqa.com/automation-practice-form/");

            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("Test");

            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Test");

            WebElement email = driver.findElement(By.id("userEmail"));
            email.sendKeys("Test@test.ru");

            WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
            gender.click();

            WebElement mobile = driver.findElement(By.id("userNumber"));
            mobile.sendKeys("9104442135");

            DateBirth(driver, "4", "1992", "01");

            WebElement inputSubjects = driver.findElement(By.id("subjectsInput"));
            inputSubjects.sendKeys("Moscow");

            WebElement hobbies = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
            hobbies.click();

            WebElement currentAddress = driver.findElement(By.id("currentAddress"));
            currentAddress.sendKeys("test");

            WebElement buttonSubmit = driver.findElement(By.id("submit"));
            buttonSubmit.click();

            WebElement resultTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
            String result = resultTitle.getText();

            Assertions.assertEquals("Thanks for submitting the form",result);

        } finally {
            Thread.sleep(5000);
            driver.quit();
        }

    }
}
