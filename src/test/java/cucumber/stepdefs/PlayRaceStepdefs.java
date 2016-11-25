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

public class PlayRaceStepdefs implements En {
    public PlayRaceStepdefs() {
        Given("^I have (\\d+) damage$", (Integer initDamage) -> {

        });

        And("^I have \"([^\"]*)\" speed$", (String moveType) -> {

        });

        When("^I get a roll of (\\d+)$", (Integer dieRoll) -> {

        });

        Then("^I must move (\\d+) distance$", (Integer distGained) -> {

        });

        But("^I my damage changes to (\\d+)$", (Integer newDamage) -> {

        });
    }
}
