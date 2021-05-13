package TestCaseFolder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FeaturedPriceTest extends TestBase{

    @Test
    @DisplayName("Get the prices of the home featured product | assignment One")
    void getPriceElement(){
        getDriver().get("http://automationpractice.com/index.php");

        //just decided to try it both ways
        String cssSelector = "ul[id='homefeatured'] li div > span[class='price product-price']";
        //String xpath = "//ul[@id=('homefeatured')] //span[@class=('price product-price')]";
        List<WebElement>  productprices = getDriver().findElements(By.cssSelector(cssSelector));
        for(WebElement wEl: productprices){
            System.out.println(wEl.getText());
        }
    }

    @Test
    @DisplayName("Navigate to modern tester css")
    void ModernTesterCss(){
        getDriver().get("https://seleniumui.moderntester.pl/css-diner-develop/index.html");
    }

    @Test
    @DisplayName("Navigate to modern tester css")
    void ModernTesterXpath(){
        getDriver().get("https://seleniumui.moderntester.pl/xpath-diner/index.html");
    }

}
