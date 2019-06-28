import org.junit.Test;
import pages.MainPage;
import pages.SecondPage;
import pages.SendAppPage;
import static org.junit.Assert.assertEquals;

public class MyRefactoringTest extends BaseTest {
    @Test
    public void NewAutoTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия и покупки");
        mainPage.clickButton("Оформить онлайн");

        SecondPage SecondPage = new SecondPage(driver);
        SecondPage.switchWindows();
        SecondPage.waitElementToBeClickable();
        SecondPage.clickElement();
        SecondPage.clickButton();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного", "PETROV");
        sendAppPage.fillField("Имя застрахованного", "MAXIM");
        sendAppPage.fillField("Дата рождения застрахованного", "12.12.1986");
        sendAppPage.fillField("Фамилия", "Петров");
        sendAppPage.fillField("Имя", "Максим");
        sendAppPage.fillField("Отчество", "Петрович");
        sendAppPage.fillField("Дата рождения", "12.12.1986");
        sendAppPage.fillField("Серия паспорта", "9710");
        sendAppPage.fillField("Номер паспорта", "144773");
        sendAppPage.fillField("Дата выдачи", "20.12.2006");
        sendAppPage.fillField("Кем выдан", "УВД Филевсий парк г. Москвы");

        assertEquals("PETROV", sendAppPage.insured_surname.getAttribute( "value" ));
        assertEquals( "MAXIM", sendAppPage.insured_name.getAttribute( "value" ) );
        assertEquals( "12.12.1986", sendAppPage.insured_birthDate.getAttribute( "value" ) );
        assertEquals( "Петров", sendAppPage.surname.getAttribute( "value" ) );
        assertEquals( "Максим", sendAppPage.name.getAttribute( "value" ) );
        assertEquals( "Петрович", sendAppPage.middlename.getAttribute( "value" ) );
        assertEquals( "12.12.1986", sendAppPage.birthDate.getAttribute( "value" ) );
        assertEquals( "9710", sendAppPage.passport_series.getAttribute( "value" ) );
        assertEquals( "144773", sendAppPage.passport_number.getAttribute( "value" ) );
        assertEquals( "20.12.2006", sendAppPage.issueDate.getAttribute( "value" ) );
        assertEquals( "УВД Филевсий парк г. Москвы", sendAppPage.issuePlace.getAttribute( "value" ) );

        sendAppPage.sendButton.click();
        assertEquals("Заполнены не все обязательные поля", sendAppPage.checkErrorMessage.getText());


    }

}
