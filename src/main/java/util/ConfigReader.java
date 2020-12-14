package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertiesObject() throws IOException {
        FileInputStream fp = new FileInputStream("config\\config.properties");
        Properties prop = new Properties();
        prop.load(fp);

        return  prop;
    }

    public static String getUrl() throws IOException {

        return  getPropertiesObject().getProperty("url");
    }

}
