package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassportYandexPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"passp-field-login\"]")
    WebElement loginBox;

    @FindBy(xpath = "//button[@id=\"passp:sign-in\"]")
    WebElement enterButton;

    @FindBy(xpath = "//input[@id=\"passp-field-passwd\"]")
    WebElement passwordBox;


    public void login(String login, String password) {

        loginBox.sendKeys(login);
        enterButton.click();
        passwordBox.sendKeys(password);
        enterButton.click();

    }
}
