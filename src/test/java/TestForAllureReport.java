import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.SecondSteps;
import steps.SendAppSteps;
import org.junit.Test;
import java.util.HashMap;

public class TestForAllureReport extends BaseSteps{

    @Test
    @Title("Страхование путешественников")
    public void Test() {

        MainSteps mainSteps = new MainSteps();
        SecondSteps secondSteps = new SecondSteps();
        SendAppSteps sendAppSteps = new SendAppSteps();

        mainSteps.stepTransferToSberbank();
        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия и покупки");

        secondSteps.stepSendButton();
        secondSteps.stepSwitchWindows();
        secondSteps.stepClickElement();
        secondSteps.stepClickButton();


        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного", "PETROV");
        testData.put("Имя застрахованного", "MAXIM");
        testData.put("Дата рождения застрахованного", "12.12.1986");
        testData.put("Фамилия", "Петров");
        testData.put("Имя", "Максим");
        testData.put("Отчество", "Петрович");
        testData.put("Дата рождения", "12.12.1986");
        testData.put("Серия паспорта", "9710");
        testData.put("Номер паспорта", "144773");
        testData.put("Дата выдачи", "20.12.2006");
        testData.put("Кем выдан", "УВД Филевсий парк г. Москвы");

        sendAppSteps.stepFillFields(testData);
        sendAppSteps.stepCheckFillFields(testData);
        sendAppSteps.stepClickButton();
        sendAppSteps.stepCheckErrorMessage();

    }

}
