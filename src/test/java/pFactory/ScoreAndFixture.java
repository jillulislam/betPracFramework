package pFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ScoreAndFixture {

        public WebDriver driver;

        public ScoreAndFixture(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath = "//span[@class='sp-c-fixture__team-name-wrap']")
        public List<WebElement> teams;


        @FindBy(xpath = "//button[@id='bbccookies-continue-button']/span")
        WebElement yes;

        @FindBy(id = "orb-search-q")
        WebElement searchBox;

        @FindBy(xpath = "//button[@class='se-searchbox__submit']")
        WebElement search;


        public void clickOnYes(){
            yes.click();
        }

        public void enterSportsInTheSearchBox(){
            searchBox.sendKeys("Sports");
        }

        public void clickOnSearch(){
            search.click();
        }

}
