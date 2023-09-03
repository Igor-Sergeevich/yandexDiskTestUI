package Tests;

import Action.ActionYandexDisk;
import Page.YandexPage;
import Utils.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileCreationTest extends BaseTest {

    @AfterMethod
    public void exitAndClose(){
        Set<String> handlesSet = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        getDriver().switchTo().window(handlesList.get(0));
        YandexPage yandexPage = new YandexPage();
        yandexPage.exitAccount();
    }

    @Test
    public void checkFileCreationOnYandexDisk(){
        SoftAssert soft = new SoftAssert();
        ActionYandexDisk actionYandexDisk = new ActionYandexDisk();
        soft.assertEquals(actionYandexDisk.createNewFile(TestData.LOGIN, TestData.PASSWORD, "2", "Таблицу", "Перв"), "File created");
        soft.assertEquals(actionYandexDisk.returnNameLastFile(), "Перв");
        soft.assertAll();
    }
}
