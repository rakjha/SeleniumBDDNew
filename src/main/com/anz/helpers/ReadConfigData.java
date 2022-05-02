package main.com.anz.helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigData {

    public static Properties loadConfigFile() {

        Properties configData = null;
        String folderName = System.getProperty("user.dir") + "//src//main//resources//profiles";
        String env_name = System.getProperty("prop.name");

        try {
            if (env_name == null || env_name.equalsIgnoreCase("Testing")) {
                FileInputStream configFile = new FileInputStream(folderName + "/Config_Testing" + ".properties");
                configData = new Properties();
                configData.load(configFile);

            } else if (env_name.equalsIgnoreCase("Prod")) {
                FileInputStream configFile = new FileInputStream(folderName + "/Config_Prod" + ".properties");
                configData = new Properties();
                configData.load(configFile);

            }

        } catch (Exception e) {
            System.out.println("Error in initializing properties files");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return configData;
    }
}
