package Action;

import Page.PassportYandexPage;
import Page.YandexPage;

import static Tests.BaseTest.getDriver;

public class ActionYandexDisk {

    public void createNewFile(String login, String password){
        getDriver().navigate().to("http://yandex.ru");
        YandexPage yandexPage = new YandexPage();
        yandexPage.enterButtonClick();
        PassportYandexPage passportYandexPage = new PassportYandexPage();
        passportYandexPage.login(login, password);
    }
}
