package ModernTester;

import TestBaseFolder.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class FormTest extends TestBase {

    private Random random = new Random();

    @Test
    public void shouldFillFormWithSuccess(){
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        getDriver().findElement(By.id("inputFirstName3")).sendKeys("Adam");
        getDriver().findElement(By.id("inputLastName3")).sendKeys("Oshikoya");
        getDriver().findElement(By.id("inputEmail3")).sendKeys("Adam@email.pl");

        List<WebElement> gridRadiosSex= getDriver().findElements(By.cssSelector("[name='gridRadiosSex']"));
        int index = random.nextInt(gridRadiosSex.size());
        gridRadiosSex.get(index).click();

        getDriver().findElement(By.id("inputAge3")).sendKeys("2");

        List<WebElement> listExperience = getDriver().findElements(By.name("gridRadiosExperience"));
        int randomValue = random.nextInt(listExperience.size());
        listExperience.get(randomValue).click();

        WebElement checkBx = getDriver().findElement(By.className("form-check-input"));
        if(checkBx.isSelected())
        { checkBx.click(); }
        getDriver().findElement(By.id("gridCheckAutomationTester")).click();


        Select continents = new Select(getDriver().findElement(By.id("selectContinents")));
        continents.selectByValue("europe");

        Select SeleniumCommand = new Select(getDriver().findElement(By.id("selectSeleniumCommands")));
        SeleniumCommand.selectByValue("webelement-commands");

        File file = new File("src\\main\\resources\\file.txt");
        String paths = file.getAbsolutePath();
        WebElement chooseFile3 = getDriver().findElement(By.xpath("//input[@id=('chooseFile')]"));
        chooseFile3.sendKeys(paths);

        getDriver().findElement(By.id("additionalInformations")).sendKeys("populating the form with required informations");
        getDriver().findElement(By.xpath("//button[@type=('submit')]")).click();

        //this should be at the end of test
        WebElement msg = getDriver().findElement(By.id("validator-message"));
        assertThat(msg.getText(), equalTo("Form send with success"));
    }
}