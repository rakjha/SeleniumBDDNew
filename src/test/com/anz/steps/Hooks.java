package test.com.anz.steps;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import main.com.anz.core.BaseMethods;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Hooks {

    private static final Logger LOG = Logger.getLogger(Hooks.class);

    @Before
    public void openBrowser() {
        LOG.debug("*************************** Launching Browser ***************************");
        BaseMethods.getBrowserInstance(BaseMethods.browserName.get());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            PageSnapshot pageSnapshot = Shutterbug.shootPage(BaseMethods.WEB_DRIVER_THREAD_LOCAL.get(),
                    Capture.FULL_SCROLL, 500, true);
            scenario.attach(pageSnapshot.getBytes(), "image/png", "pageSnapshot");
            LOG.debug(scenario.getName().concat(" : ").concat(String.valueOf(scenario.getStatus())));
        }
        BaseMethods.WEB_DRIVER_THREAD_LOCAL.get().quit();
        BaseMethods.WEB_DRIVER_THREAD_LOCAL.remove();
    }
}
