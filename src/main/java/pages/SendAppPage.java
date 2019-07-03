package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SendAppPage {

    @FindBy(name = "insured0_surname")
    public WebElement insured_surname;
    @FindBy(name = "insured0_name")
    public WebElement insured_name;
    @FindBy(name = "insured0_birthDate")
    public WebElement insured_birthDate;
    @FindBy(name = "surname")
    public WebElement surname;
    @FindBy(name = "name")
    public WebElement name;
    @FindBy(name = "birthDate")
    public WebElement birthDate;
    @FindBy(name = "middlename")
    public WebElement middlename;
    @FindBy(name = "passport_series")
    public WebElement passport_series;
    @FindBy(name = "passport_number")
    public WebElement passport_number;
    @FindBy(name = "issueDate")
    public WebElement issueDate;
    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "Фамилия застрахованного":
                fillField(insured_surname, value);
                break;
            case "Имя застрахованного":
                fillField(insured_name, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insured_birthDate, value);
                break;
            case "Фамилия":
                fillField(surname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                break;
            case "Отчество":
                fillField(middlename, value);
                break;
            case "Серия паспорта":
                fillField(passport_series, value);
                break;
            case "Номер паспорта":
                fillField(passport_number, value);
                break;
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия застрахованного":
                return insured_surname.getAttribute("value");
            case  "Имя застрахованного":
                return insured_name.getAttribute("value");
            case  "Дата рождения застрахованного":
                return insured_birthDate.getAttribute("value");
            case  "Фамилия":
                return surname.getAttribute("value");
            case  "Имя":
                return name.getAttribute("value");
            case  "Отчество":
                return middlename.getAttribute("value");
            case  "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия паспорта":
                return passport_series.getAttribute("value");
            case "Номер паспорта":
                return passport_number.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }



    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


    @FindBy(xpath = "//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public WebElement checkErrorMessage;
}
