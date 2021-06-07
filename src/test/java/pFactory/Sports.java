package pFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sports {

    public WebDriver driver;

    public Sports(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//main[@id='main-content']/descendant::div[contains(@class,'PromoPortrait')]/div/div/a")
    List <WebElement> articles;

    public void printFirstAndLastArticleHeadLines(){
       String firstHeadLine =  articles.get(0).getText();
       String lastHeadLine = articles.get(articles.size()-1).getText();
       System.out.println("First headline :"+firstHeadLine);
       System.out.println("Last headline :"+lastHeadLine);
    }
}
