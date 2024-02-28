package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.logging.Level;

public abstract class DriverSource {


    public abstract WebDriver newDriver();

    public abstract boolean takesScreenshots();

    public class MyFirefoxDriver extends DriverSource {

        @Override
        public WebDriver newDriver() {
            FirefoxOptions options = new FirefoxOptions();
            options.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.ALL));

            return new FirefoxDriver(options);
        }

        @Override
        public boolean takesScreenshots() {
            return false;
        }

    }
}
