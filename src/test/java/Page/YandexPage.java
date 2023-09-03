package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexPage extends BasePage {

    @FindBy(xpath = "//span[text()=\"Войти\"]/..")
    WebElement enterButton;

    @FindBy(xpath = "//span[text()=\"Войти через Яндекс ID\"]")
    WebElement enterFromIDButton;

    @FindBy(xpath = "//div[@aria-label=\"Меню профиля\"]//button")
    WebElement profileButton;

    @FindBy(xpath = "//a[@aria-label=\"Информация о профиле\"]")
    WebElement infoProfileButton;

    public void enterButtonClick() {
        enterButton.click();
        enterFromIDButton.click();
    }

    public void goToProfile(){
        profileButton.click();
        infoProfileButton.click();
    }
}
