package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions;



import ch.qos.logback.classic.Logger;
import lombok.SneakyThrows;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Keys;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.*;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.ExtractosPorProducto.BTN_MOSTRAR_DATOS;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.ILoggerFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Slf4j
public class RobotJava extends PageObject implements Task {

    public static RobotJava descargarPDF() {
        return Tasks.instrumented(RobotJava.class);
    }

    @SneakyThrows
    @Step("-------------- Guardar Pdf --------------")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Thread.sleep(5000);

   /*
        try {



            Robot robot = null;
            robot = new Robot();

            log.info("****Descarga PDF DESDE EL BOTON*****");
            log.info("mouse Move");
            robot.mouseMove(490, 450);
            String filelocation=("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\src\\test\\resources\\archivos\\pruebaBotondescargarExtracto");
            StringSelection filepath=new StringSelection(filelocation);Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
            log.info("Press Space");
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            log.info("Press CONTROL V");
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            log.info("Press Enter");
*/










            //upload("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\\\src\\\\test\\resources\\archivos\\pruebaBotondescargarExtracto").to(find(chooseFile));
            //System.out.println("Despues");
            System.out.println("ya vamos a dar enter");
        //OnStage.theActorInTheSpotlight().attemptsTo((Performable) Hit.the(Keys.ENTER));
           // OnStage.theActorInTheSpotlight().attemptsTo(Hit.the(Keys.ENTER).into(BTN_MOSTRAR_DATOS));

/*
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(5000);
            log.info("****Descarga PDF DESDE EL ICONO*****");
            String filelocationi=("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\src\\test\\resources\\archivos\\pruebaiconoExtracto");
            StringSelection filepathi=new StringSelection(filelocationi);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathi, null);
            log.info("mouse Move");
            robot.mouseMove( 760, 160);
            log.info("click al icono descargar");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(8000);
            log.info("Press Space");
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            log.info("Press CONTROL V");
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            log.info("Press Enter");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


        } catch (AWTException | InterruptedException ex ) {
            throw new RuntimeException(ex);
        }
*/
    }


}