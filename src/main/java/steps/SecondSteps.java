package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SecondSteps extends BaseSteps{

    @Step("Выполнено нажатие на кнопку Оформить онлайн")
    public void stepSendButton() {
        new SecondPage(driver).SendButton.click();
    }

    @Step("Выполнен переход на страницу выбора полиса")
    public void stepSwitchWindows() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

    }

    @Step ("Выполнено нажатие на поле Минимальная")
    public void stepClickElement(){
        driver.findElement(By.xpath("//div[text()='Минимальная']")).click();
    }

    @Step ("Выполнено нажатие на кнопку Оформить")
    public void stepClickButton(){
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
    }
}
