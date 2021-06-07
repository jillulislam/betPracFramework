package Trunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/FeatureFile.feature",
        glue = {"steps","hooks"}
)

public class RunnerTest {

}
