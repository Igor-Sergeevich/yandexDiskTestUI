package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiskPage extends BasePage{

    @FindBy (xpath = "//span[text()=\"Создать\"]/..")
    WebElement createButton;

    @FindBy (xpath = "//span[text()=\"Папку\"]/..")
    WebElement folderButton;

    @FindBy (xpath = "//input[@text=\"Новая папка\"]")
    WebElement nameFolderBox;

    @FindBy (xpath = "//span[text()=\"Сохранить\"]/..")
    WebElement saveButton;


    public void createNewFolder(String name){
        createButton.click();
        folderButton.click();
        nameFolderBox.clear();
        nameFolderBox.sendKeys(name);
        saveButton.click();
    }
}
