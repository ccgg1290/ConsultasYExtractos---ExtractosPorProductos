package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Definitions;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions.RobotJava.descargarPDF;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions.AssertThat.theElementIsPresent;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions.IsPresentFile.isPresentFile;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks.Hook.*;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions.ReturnFiles.returnNameFiles;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.ExtractosPorProducto.*;

import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.abilities.ReadPdf;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.ManagmedFile.moveFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionsDescargarPDF extends PageComponent {


    @Given("Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto")
    public void queElClienteSeEncuentraEnElModuloDeConsultasYExtractosEnElSubmoduloExtractoPorProducto() throws InterruptedException, IOException {

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CONSULTASYEXTRACTOS, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(CONSULTASYEXTRACTOS),
                WaitUntil.the(EXTRACTOPORPRODUCTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(EXTRACTOPORPRODUCTO)

        );




        theActorInTheSpotlight().should(
                seeThat("El titulo ",
                        theTextOfTheElementIs(TITULO_EXTRACTO_POR_PRODUCTO),
                        equalTo("Extractos por Producto")
                )
        );



    }

    @And("^Selecciona el tipo de producto (.*)$")
    public void seleccionaElTipoDeProducto(String cuenta) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_TIPO_PRODUCTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(cuenta).from(LISTA_TIPO_PRODUCTO)

        );
    }

    @And("^Selecciona el producto (.*)$")
    public void seleccionaElProducto(String producto) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_NOMBRE_PRODUCTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(producto).from(LISTA_NOMBRE_PRODUCTO)
        );
    }

    @And("^Selecciona el ano del extracto(.*)$")
    public void seleccionaElAnoDelExtracto(String ano) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_ANO_EXTRACTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(ano).from(LISTA_ANO_EXTRACTO)
        );
    }

    @And("^Selecciona el mes del extracto (.*)$")
    public void seleccionaElMesDelExtracto(String mes) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_MES_EXTRACTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(mes).from(LISTA_MES_EXTRACTO)
        );
    }

    @And("Da click al boton Mostrar Datos")
    public void leDaClickAlBotonMostrarDatos() throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_MOSTRAR_DATOS, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MOSTRAR_DATOS),
                WaitUntil.the(EXTRACTO_PDF, isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("Deberia ver el extracto en la pantalla")
    public void deberiaVerElExtractoEnLaPantalla() throws InterruptedException {

        theActorInTheSpotlight().should(
                seeThat("El extracto esta presente",
                        theElementIsPresent(EXTRACTO_PDF),
                        equalTo(true)
                )
        );
    }


    @And("Al darle click en el boton descargar deberia descargarse el extracto")
    public void alDarleClickEnElBotonDescargarDeberiaDescargarseElExtracto() throws InterruptedException, IOException {

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_DESCARGAR_EXTRACTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_DESCARGAR_EXTRACTO)
                //descargarPDF()


               // Ensure.that(isPresentFile(1,downloadFolder)).isEqualTo(true)
        );

        Thread.sleep(5000);
        moveFile(downloadFolder,downloadFolderCopyPaste);
        assertTrue("No se descargo correctamente", isPresentFile(1,downloadFolderCopyPaste));

       // String statementFilePath = String.format("%s%s", downloadFolder, fileNamePdf);
        //recupera nombre de archivos descargados
        List<String> files= returnNameFiles(downloadFolderCopyPaste);
        //concatena la ruta del directorio con el nombre del archivo
        String statementFilePath = String.format("%s%s%s", downloadFolderCopyPaste,"\\", files.get(0));
        System.out.println("ruta archivo" + statementFilePath);

        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));
        //recupera el pdf completo
        String pdfTextComplete = ReadPdf.as(theActorInTheSpotlight()).getTextComplete();
        //System.out.println(pdfTextComplete);
        // retorna true si encuentra la cadena en el archivo
        boolean findText = ReadPdf.as(theActorInTheSpotlight()).findText("116060084657");
        assertTrue("No se Encontro La cadena Buscada",findText);


    }


}







