
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/feature.feature",glue = "Steps")
public class RunCukesTest extends AbstractTestNGCucumberTests{

}
