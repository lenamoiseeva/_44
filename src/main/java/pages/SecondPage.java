
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondPage {
    WebDriver driver;

    public SecondPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void switchWindows(){
        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);
        }
    }
    public void waitElementToBeClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div[text()='Минимальная']")))).click();
    }

    public void clickElement(){
        driver.findElement(By.xpath("//div[text()='Минимальная']")).click();
    }

    public void clickButton(){
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
    }
}


