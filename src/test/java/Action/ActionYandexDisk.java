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
    private int initialNumberOfFiles = 0;
    private int finalNumberOfFiles = 0;

    public String createNewFile(String login, String password, String nameFolder, String typeFile, String nameFile){
        getDriver().navigate().to("http://yandex.ru");
        authorization(login, password);
        goToDisk();
        createFolder(nameFolder);
        openFolder(nameFolder);
        createFile(typeFile, nameFile);
        closeFile();
        return checkAddFile();
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
        initialNumberOfFiles = diskPage.numberOfFiles();
    }

    public void createFile(String typeFile, String name){

        DiskPage diskPage = new DiskPage();
        diskPage.createNewFile(typeFile, name);
    }

    public void closeFile(){
        String currentHandle = getDriver().getWindowHandle();
        Set<String> handlesSet = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        getDriver().switchTo().window(handlesList.get(2));
        getDriver().close();
        getDriver().switchTo().window(currentHandle);

    }
    public String checkAddFile(){
        DiskPage diskPage = new DiskPage();
        finalNumberOfFiles = diskPage.numberOfFiles();
        if (finalNumberOfFiles-initialNumberOfFiles == 1){
            return "File created";
        }else if (finalNumberOfFiles - initialNumberOfFiles == 0){
            return "File not created";
        }else return  "Changed the number of files by " + (finalNumberOfFiles - initialNumberOfFiles);
    }

    public String returnNameLastFile(){
        DiskPage diskPage = new DiskPage();
        String nameFile = diskPage.nameLastFile();
        return nameFile.substring(0, nameFile.lastIndexOf("."));

    }

}
