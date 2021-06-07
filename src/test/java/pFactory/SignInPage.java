package pFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-identifier-input")
    public WebElement email_field;

    @FindBy(id = "password-input")
    public WebElement password_field;

    @FindBy (xpath = "//p[@class='form-message__text']/span/span")
    WebElement invalidText;

    @FindBy(id = "submit-button")
    WebElement button_signIn;


    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickOnSubmitButton(){
        button_signIn.click();
    }

    public String getInvalidText(){
        return invalidText.getText();
    }
}
