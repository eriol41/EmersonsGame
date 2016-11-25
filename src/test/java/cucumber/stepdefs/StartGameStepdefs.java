package cucumber.stepdefs;

import cucumber.api.java8.En;
import org.dbunit.IDatabaseTester;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.odde.emersonsgame.data.support.Databases.getDataSet;
import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDrivers.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartGameStepdefs implements En {
    public StartGameStepdefs() {
        Given("^I have players registered$", () -> {
            try {
                IDatabaseTester databaseTester = getDatabaseTester();
                databaseTester.setDataSet(getDataSet("start_game.xml"));
                databaseTester.onSetup();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        When("^I try to click the start button$", () -> {
            getDriver().get(url("/start"));
            WebElement element = getDriver().findElement(By.id("btnStart"));
            
            // Now submit the form. WebDriver will find the form for us from the element
            element.click();
        });

        Then("^It must start the game$", () -> {
            List<WebElement> rows = getDriver().findElements(By.cssSelector("#players tbody tr"));

            assertThat(rows.size(), is(4));
        });
    }
}
