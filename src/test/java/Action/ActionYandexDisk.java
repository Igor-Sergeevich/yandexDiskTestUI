package Action;

import Page.DiskPage;
import Page.IdYandexPage;
import Page.PassportYandexPage;
import Page.YandexPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Tests.BaseTest.getDriver;

public class ActionYandexDisk {

    public void createNewFile(String login, String password, String nameFolder){
        getDriver().navigate().to("http://yandex.ru");
        authorization(login, password);
        goToDisk();
        createFolder(nameFolder);
        openFolder(nameFolder);


    }
    public void authorization(String login, String password){
        YandexPage yandexPage = new YandexPage();
        yandexPage.enterButtonClick();

        PassportYandexPage passportYandexPage = new PassportYandexPage();
        passportYandexPage.login(login, password);
    }
    public void goToDisk(){
        YandexPage yandexPage = new YandexPage();
        yandexPage.goToProfile();

        Set<String> handlesSet = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        getDriver().switchTo().window(handlesList.get(1));
        IdYandexPage idYandexPage = new IdYandexPage();
        idYandexPage.diskClick();
    }

    public void createFolder(String name){
        DiskPage diskPage = new DiskPage();
        diskPage.createNewFolder(name);
    }

    public void openFolder(String name){
        DiskPage diskPage = new DiskPage();
        diskPage.openFile(name);
    }
}
