package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks;


import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.tasks.LoginTask;
import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.LoginPage;
import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.EnviromentConstants.returnUsuario;

public class Hook {


    static final Logger loggertest = LoggerFactory.getLogger(Hook.class);

    @Before
    public void initialConfiguration() throws InterruptedException {
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
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        //cerrartodoslos procesos
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }
}
