package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexPage extends BasePage {

    @FindBy(xpath = "//span[text()=\"Войти\"]/..")
    WebElement enterButton;

    @FindBy(xpath = "//span[text()=\"Войти через Яндекс ID\"]")
    WebElement enterFromIDButton;


    public void enterButtonClick() {
        enterButton.click();
        enterFromIDButton.click();
    }
}
