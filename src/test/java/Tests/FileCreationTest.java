package Tests;

import Action.ActionYandexDisk;
import Utils.TestData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FileCreationTest extends BaseTest {


    @Test
    public void checkFileCreationOnYandexDisk(){
        SoftAssert soft = new SoftAssert();
        ActionYandexDisk actionYandexDisk = new ActionYandexDisk();
        soft.assertEquals(actionYandexDisk.createNewFile(TestData.LOGIN, TestData.PASSWORD, "2", "Таблицу", "Перв"), "File created");
        soft.assertEquals(actionYandexDisk.returnNameLastFile(), "Перв");
        soft.assertAll();
    }
}
