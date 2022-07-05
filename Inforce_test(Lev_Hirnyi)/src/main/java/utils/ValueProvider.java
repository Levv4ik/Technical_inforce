package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValueProvider  {
    private final Properties properties;

    public ValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getUrlFromProperties(){
        return properties.getProperty("url");
    }

    public String getLoginFromProperties(){
        return properties.getProperty("login_name");
    }

    public String getPasswordFromProperties(){
        return properties.getProperty("password");
    }

    public String getInvalidLoginFromProperties(){
        return properties.getProperty("invalid_login_name");
    }

    public String getInvalidPasswordFromProperties(){
        return properties.getProperty("invalid_password");
    }


}
