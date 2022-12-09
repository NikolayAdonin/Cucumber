import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import static io.cucumber.core.options.Constants.*;

/*
// @RunWith
// Класса для запуска тестов
@RunWith(Cucumber.class)
// @CucumberOptions
// Опции для запуска сценариев
@CucumberOptions(
        // Список папок с feature файлами - фичи/сценарии
        features = {"src/test/resources/features"},
        // Спиcок пакетов с steps файлами - шаги
        glue = {"steps", "hooks"}
)
*/
/*
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps, hooks")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
 */

public class RunCucumberTest {
}