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

public class ViewPlayersStepdefs implements En {
    public ViewPlayersStepdefs() {
        Given("^I have players available", () -> {
            try {
                IDatabaseTester databaseTester = getDatabaseTester();
                databaseTester.setDataSet(getDataSet("view_players.xml"));
                databaseTester.onSetup();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        When("^I try to view all players$", () -> {
            getDriver().get(url("/players"));
        });

        Then("^I must see all players$", () -> {
            List<WebElement> rows = getDriver().findElements(By.cssSelector("#players tbody tr"));

            assertThat(rows.size(), is(4));
        });
    }
}
