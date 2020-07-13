package utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

  private static Properties properties = null;

  public ConfigFileReader(){
    try {
      properties = new Properties();
      //ensure properties is threadsafe
      synchronized (Properties.class) {
        properties
            .load(ConfigFileReader.class.getClassLoader().getResourceAsStream("config.properties"));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    return properties == null ? null : properties.getProperty(key, "");
  }

}
