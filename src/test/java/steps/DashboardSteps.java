package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps {
    @Then("verify the following tabs on dashboard")
    public void verify_the_following_tabs_on_dashboard(DataTable dataTable) {

        List<String> expectedtabs = dataTable.asList();

        DashBoardPage dash = new DashBoardPage();
        List<String> actualtabs = new ArrayList<>();
        for(WebElement elem: dash.dashboardtabs){
            actualtabs.add(elem.getText());
        }

        System.out.println(expectedtabs);
        System.out.println(actualtabs);
        Assert.assertTrue(expectedtabs.equals(actualtabs));
        System.out.println("My test case is passed");

    }
}
