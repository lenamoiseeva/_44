import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    @Test
    @Ignore
    public void Autotest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sberbank.ru/ru/person");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath("//*[contains(text(),'Страхование')]")));
        action.perform();
        driver.findElement(By.xpath("//*[contains(text(),'Путешествия и покупки')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить онлайн')]")).click();


        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);
        }
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement
                (By.xpath("//*[contains(text(),'Минимальная')]")))).click();

        driver.findElement(By.xpath("//div[text()='Минимальная']")).click();
        driver.findElement(By.xpath("//[contains(text(),'Оформить')]")).click();

        driver.findElement(By.name("insured0_surname")).sendKeys("PETROV");
        driver.findElement(By.name("insured0_name")).sendKeys("MAXIM");
        driver.findElement(By.name("insured0_birthDate")).click();
        driver.findElement(By.name("insured0_birthDate")).sendKeys("12.12.1986");

        driver.findElement(By.name("surname")).sendKeys("Петров");
        driver.findElement(By.name("name")).sendKeys("Максим");
        driver.findElement(By.name("middlename")).sendKeys("Петрович");
        driver.findElement(By.name("birthDate")).click();
        driver.findElement(By.name("birthDate")).sendKeys("12.12.1986");
        driver.findElement(By.cssSelector("input[class='b-radio-field-entity ng-pristine ng-untouched ng-valid']")).click();

        driver.findElement(By.name("passport_series")).click();
        driver.findElement(By.name("passport_series")).sendKeys("9710");
        driver.findElement(By.name("passport_number")).click();
        driver.findElement(By.name("passport_number")).sendKeys("144773");
        driver.findElement(By.name("issueDate")).click();
        driver.findElement(By.name("issueDate")).sendKeys("20.12.2006");
        driver.findElement(By.name("issuePlace")).click();
        driver.findElement(By.name("issuePlace")).sendKeys("УВД Филевсий парк г. Москвы");

        assertEquals("PETROV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("MAXIM", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("12.12.1986", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Максим", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("12.12.1986", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("9710", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("144773", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("УВД Филевсий парк г. Москвы", driver.findElement(By.name("issuePlace")).getAttribute("value"));


        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();

        driver.findElement(By.xpath("//*[contains(text(),'Заполнены не все обязательные поля')]")).click();
    }

}