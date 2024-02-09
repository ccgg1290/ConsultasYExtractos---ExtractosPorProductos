package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Definitions;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.ExtractosPorProducto.*;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.ExtractosPorProducto.LISTA_TIPO_PRODUCTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class DefinitionNoSeIngresaronDatos {

    @Given("Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto_")
    public void QueElClienteSeEncuentraEnElModuloDeConsultasYExtractosEnElSubmoduloExtractoPorProducto() throws InterruptedException  {

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
    @And("^Selecciona el tipo de producto_ (.*)$")
    public void SeleccionaElTipoDeProductoCuenta(String cuenta) throws InterruptedException{

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_TIPO_PRODUCTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(cuenta).from(LISTA_TIPO_PRODUCTO)

        );
    }
    @And("^Selecciona el producto_ (.*)$")
    public void seleccionaElProducto(String producto) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_NOMBRE_PRODUCTO, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(producto).from(LISTA_NOMBRE_PRODUCTO)
        );
    }

    @When("Da click al boton Mostrar Datos_")
    public void leDaClickAlBotonMostrarDatos() throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_MOSTRAR_DATOS, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MOSTRAR_DATOS)
              //  WaitUntil.the(EXTRACTO_PDF, isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );
    }

    @And("^Deberia verse el error_ (.*)$")
    public void AlDarClickEnBotonMostrarDatosDeberiaVerseElError(String MensajeDeError) throws InterruptedException{
        //
        System.out.println("El valor recuperado es:"+MensajeDeError);
        theActorInTheSpotlight().should(
                seeThat("Un mensaje de error que dice: ",
                        theTextOfTheElementIs(MSG_ALERTA),
                        equalTo(MensajeDeError)
                )
        );

    }





}

