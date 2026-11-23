package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {



        public static Properties prop;

        public static void loadProperties() {

            prop = new Properties();

            try {

                InputStream fis = ConfigReader.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

                if (fis == null) {
                    throw new RuntimeException(
                            "config.properties file not found in resources folder"
                    );
                }

                prop.load(fis);

                fis.close();

                System.out.println(
                        "Properties file loaded successfully"
                );

            } catch (IOException e) {

                throw new RuntimeException(
                        "Unable to load config.properties", e
                );
            }
        }

        public static String getProperty(String key) {

            return prop.getProperty(key);
        }
    }



