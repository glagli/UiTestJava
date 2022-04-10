package lesson6_7;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

@Story("Информация о студентах")
public class AutomationPractiseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {

        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Feature("Создание анкеты студента")
    void createRegFormTest() {
        driver.get("https://demoqa.com/automation-practice-form/");

        new lesson6_7.PracticeFormPage(driver)
                .InputFirstName("Test")
                .InputLastName("Test")
                .InputUserEmail("Test@test.ru")
                .InputGender("Other") // Male Female Other
                .InputMobile("9104442135")
                .InputDateOfBirth("February","1992" , "28")
                .InputSubjects("Moscow")
                .InputHobbies("Sports") // Sports Reading Music
                .InputHobbies("Reading") // Sports Reading Music
                .InputCurrentAddress("test")
                .ClickButtonSubmit()
                .CheckCreateForm();
    }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера", log.getMessage());
        }
        driver.quit();
    }
}


