package lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BaseView {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userNumber")
    public WebElement mobile;

    @FindBy(id = "subjectsInput")
    public WebElement inputSubjects;

    @FindBy(xpath = "//label[contains(text(),'Sports')]")
    public WebElement hobbies;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "submit")
    public WebElement buttonSubmit;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement month;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement year;

    @FindBy(css = ".react-datepicker__day--009")
    public WebElement day;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement resultTitle;


    public PracticeFormPage InputFirstName(String name) {
        firstName.sendKeys(name);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputLastName(String last) {
        lastName.sendKeys(last);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputUserEmail(String email) {
        userEmail.sendKeys(email);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputGender(String gen) {
        By gender = By.xpath(String.format("//label[contains(text(),'%s')]", gen));
        driver.findElement(gender).click();
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputMobile(String mob) {
        mobile.sendKeys(mob);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputDateOfBirth(String mon, String ye, String dy) {
        dateBirth.click();
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText(mon);
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText(ye);
        By day = By.cssSelector(String.format(".react-datepicker__day--0%s",dy));
        driver.findElement(day).click();
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputSubjects(String city) {
        inputSubjects.sendKeys(city);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputHobbies(String hob) {
        By hobbies = By.xpath(String.format("//label[contains(text(),'%s')]",hob));
        driver.findElement(hobbies).click();
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage InputCurrentAddress(String add) {
        currentAddress.sendKeys(add);
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage ClickButtonSubmit() {
        buttonSubmit.click();
        return new PracticeFormPage(driver);
    }

    public PracticeFormPage CheckCreateForm() {
        webDriverWait.until(ExpectedConditions.visibilityOf(resultTitle));
        Assertions.assertEquals("Thanks for submitting the form", resultTitle.getText());
        return new PracticeFormPage(driver);
    }
}
