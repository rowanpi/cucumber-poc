package org.jembi.cucumber.example.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "org.jembi.cucumber.example.steps",
        features = {"src/test/resources/features/login.feature"}//, "src/test/resources/features/login2.feature"}
)
public class RunBSISLoginTest {
}
