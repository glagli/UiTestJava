package lesson6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver = new ChromeDriver();
    }

    @Test
    void createRegFormTest() {
        driver.get("https://demoqa.com/automation-practice-form/");

        new PracticeFormPage(driver)
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
        driver.quit();
    }
}


