package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


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

    @FindBy (xpath = "//div[@class=\"listing__items\"]/div[@role=\"row\"]")
    WebElement fileElements;

    @FindBy (xpath = "//span[@class=\"Select2 listing-sort\"][1]/button")
    WebElement sortFileButton;


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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(d -> driver.findElement(By.xpath("//div[@class=\"client-listing\"]//span[contains(text(), \"" + name + "\")]")).isDisplayed());
        } catch (TimeoutException e) {

        }

    }

    public void clearBox(WebElement element){

        while (element.getAttribute("text").length()!=0) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public String nameLastFile(){
        checkSortOfDate();
        List<WebElement> listFiles = driver.findElements(By.xpath("//div[@class=\"listing__items\"]/div[@role=\"row\"]"));
        return listFiles.get(listFiles.size()-1).getText();
    }

    public int numberOfFiles(){
        List<WebElement> listFiles = driver.findElements(By.xpath("//div[@class=\"listing__items\"]/div[@role=\"row\"]"));
        return listFiles.size();
    }

    public void checkSortOfDate(){
        if(!sortFileButton.getAttribute("aria-label").equals("Сортировать по дате изменения")){
            sortFileButton.click();
            driver.findElement(By.xpath("//span[text()=\"Дате изменения\"]")).click();
        }
    }
}
