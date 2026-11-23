package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {


        public static void captureScreenshot(WebDriver driver, String testName) {

            try {

                String folder = "screenshots";

                Files.createDirectories(Paths.get(folder));

                String timestamp = LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")
                );

                File source = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                File destination = new File(
                        folder + "/" + testName + "_" +
                                timestamp + ".png"
                );

                Files.copy(source.toPath(), destination.toPath());

                System.out.println(
                        "Screenshot saved: " + destination.getAbsolutePath()
                );

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }




