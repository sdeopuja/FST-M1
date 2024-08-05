package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
/*@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity1"
)*/

/*@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity2"
)*/

//@CucumberOptions(
//        features = "Features",
//        glue = {"stepDefinitions"},
//        tags = "@activity3"
//)

/*
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity4"
)*/

/*@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity5"
)*/

/*
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity6"
)
*/

/*
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty"},
        monochrome = true
)
*/
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"html: test-reports"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}
