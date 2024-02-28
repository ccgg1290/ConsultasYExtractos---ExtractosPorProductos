package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks;


import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.runners.Runner;
import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.tasks.LoginTask;
import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.LoginPage;
import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebdriverManager;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Driver;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.DeleteFiles.deleteFiles;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.EnviromentConstants.returnUsuario;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.ManagmedFile.moveFile;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.ReturnDate.returnDate;
import static net.serenitybdd.core.Serenity.getDriver;


public class Hook {


    WebDriver driver;
    private EnvironmentVariables environmentVariables;
    public static String downloadFolder;
    public static String downloadFolderCopyPaste;
    public static String fileNamePdf;
    public static String fileNameExcel;
    static final Logger loggertest = LoggerFactory.getLogger(Hook.class);

    @Before
    public void initialConfiguration() throws InterruptedException, IOException {

        //System.out.println(DataDriven.nombre);
        //System.out.println(DataDriven.apellido);




        System.out.println("variables " + downloadFolder + fileNameExcel+fileNamePdf);
        // downloadFolder="C:\\sers\\ccgualterosg\\Documents";
        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);
        System.out.println("directorio descarga"+downloadFolder);
        fileNamePdf = environmentVariables.optionalProperty("statements.fileNamePdf")
                .orElseThrow(IllegalArgumentException::new);
        fileNameExcel = environmentVariables.optionalProperty("statements.fileNameExcel")
                .orElseThrow(IllegalArgumentException::new);
        downloadFolderCopyPaste = environmentVariables.optionalProperty("download.filesFolderCopyPaste")
                .orElseThrow(IllegalArgumentException::new);
        System.out.println("directorio a copiar"+downloadFolderCopyPaste);

        //System.out.println(environmentVariables.getProperties());

        System.out.println("environment mandada por " +"linea de comandos" + environmentVariables.getProperty("environment"));



        environmentVariables.setProperty("edge.preferences.download.default_directory", downloadFolderCopyPaste);





        System.out.println("variables seteadas\n directorio de descarga" + downloadFolder + "\nnombre archivo excel "+fileNameExcel+"\narchivo pdf"+fileNamePdf+" \n archivo a pegar"+downloadFolderCopyPaste);
        deleteFiles(downloadFolderCopyPaste);
        //mvn clean verify -D usuario="cristian"
        Properties propiedades = System.getProperties();

        System.out.println("preferences "+System.getProperty("chrome_preferences.download.default_directory"));
        System.out.println("Estas son las propiedades "+propiedades.get("webdriver.base.url"));
        System.out.println("Estas son la propiedades "+propiedades.get("webdriver.driver"));
        System.out.println("Estas son la propiedades "+propiedades.get("usuario"));

        System.out.println("directorio por defecto: "+System.getProperty("chrome_preferences.download.default_directory"));
        System.out.println("preferences firefox "+System.getProperty("disable-popup-blocking"));
        System.out.println("preferences firefox "+System.setProperty("disable-popup-blocking",""));
        System.out.println("preferences firefox"+System.getProperty("browser.download.dir"));
       // System.setProperty("chrome_preferences.download.default_directory",downloadFolder);
        System.out.println("directorio por defecto: "+System.getProperty("chrome_preferences.download.default_directory"));





       //WebDriver driver=getDriver();




        OnStage.setTheStage(new OnlineCast());


        List<Map<String, String>> newdata = returnUsuario();
        loggertest.info("****** INICIO LOGIN ******");
        //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));

        OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                Open.browserOn().the(LoginPage.class));
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
               // changeWindow(getDriver()),
              //  HomePageTask.selectBank(newdata)
        );
        //Thread.sleep(10000);
        //System.out.println("nombre de usuario: "+NAME_HOME.getText());
        //assertEquals(NAME_HOME.getText(), "Dayana Andrea Rojas Alba");

        loggertest.info("****** FIN LOGIN ******");

    }
    @After
    public static void CloseDriver() throws IOException, InterruptedException {


        //cerrar navegador
        //SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        //cerrartodoslos procesos
    //    KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }
}
