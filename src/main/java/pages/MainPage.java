package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'lg-menu__list')]")
    public WebElement MainMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMainMenu (String menuItem) {
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath("//*[contains(text(),'" +menuItem+ "')]")));
        action.perform();
    }

    public void selectSubMenu (String subMenuItem) {
        MainMenu.findElement(By.xpath("//*[contains(text(),'" +subMenuItem+ "')]")).click();
    }
}