package steps;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    @Step ("Переход на сайт сбербанка")
    public void stepTransferToSberbank (){
        driver.get(baseUrl);
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu(menuItem);
    }

    @Step("Выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem) {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectSubMenu(menuItem);
    }
}

