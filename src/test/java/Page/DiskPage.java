package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class DiskPage extends BasePage{

    @FindBy (xpath = "//span[text()=\"Создать\"]/..")
    WebElement createButton;

    @FindBy (xpath = "//span[text()=\"Папку\"]/..")
    WebElement folderButton;

    @FindBy (xpath = "//input[@text=\"Новая папка\"]")
    WebElement nameFolderBox;

    @FindBy (xpath = "//h2[contains(text(),\"Укажите название\")]/..//input")
    WebElement nameFileBox;

    @FindBy (xpath = "//span[text()=\"Сохранить\"]/..")
    WebElement saveButton;

    @FindBy (xpath = "//h2[contains(text(),\"Укажите название\")]/..//span[text()=\"Создать\"]/..")
    WebElement createDocButton;


    public void createNewFolder(String name){
        createButton.click();
        folderButton.click();
        nameFolderBox.click();
        clearBox(nameFileBox);
        nameFileBox.sendKeys(name);
        saveButton.click();
    }

    public void openFile(String name){
        WebElement file = driver.findElement(By.xpath("//div[@class=\"client-listing\"]//span[text()=\"" + name + "\"]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(file).perform();

    }
    public void createNewFile(String type, String name){
        createButton.click();
        WebElement typeFile = driver.findElement(By.xpath("//span[text()=\"" + type + "\"]"));
        typeFile.click();
        clearBox(nameFileBox);
        nameFileBox.sendKeys(name);
        createDocButton.click();

    }

    public void clearBox(WebElement element){

        while (element.getAttribute("text").length()!=0) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}
