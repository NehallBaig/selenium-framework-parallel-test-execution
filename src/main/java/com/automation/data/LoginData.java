package com.automation.data;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginData")
    public static Object[][] data() {
        //return new String[][]{{"performance_glitch_user", "secret_sauce"}};
        return new String[][]{{"performance_glitch_user", "secret_sauce"}, {"standard_user", "secret_sauce"}, {"visual_user", "secret_sauce"}};
    }
}
