import com.automation.core.DriverManager;
import com.automation.utils.Utility;
import org.testng.annotations.Test;

import java.io.IOException;

public class DriverManagerTest {

    @Test
    public void test() throws IOException {
        DriverManager.getDriver().get(Utility.getUrl());
        DriverManager.closeDriver();
    }

}
