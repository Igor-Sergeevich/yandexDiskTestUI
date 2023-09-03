package Tests;

import Action.ActionYandexDisk;
import Utils.TestData;
import org.testng.annotations.Test;

public class FileCreationTest extends BaseTest {

    @Test
    public void checkFileCreationOnYandexDisk(){
        ActionYandexDisk actionYandexDisk = new ActionYandexDisk();
        actionYandexDisk.createNewFile(TestData.LOGIN, TestData.PASSWORD, "2", "Таблицу", "Таб1");
    }
}
