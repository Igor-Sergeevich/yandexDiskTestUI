package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IdYandexPage extends BasePage{

    @FindBy(xpath = "//button[@class=\"UserID-Account\"]")
    WebElement accountButton;

    @FindBy(xpath = "//a[@class=\"ListItem MenuItem MenuItem_disk\"]")
    WebElement diskButton;

    public void diskClick(){

        accountButton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"UserWidget-Iframe\"]")));
        diskButton.click();
    }

}
