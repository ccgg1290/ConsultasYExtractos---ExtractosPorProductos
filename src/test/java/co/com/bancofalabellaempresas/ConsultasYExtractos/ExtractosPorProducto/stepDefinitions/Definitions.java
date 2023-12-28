package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.stepDefinitions;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Definitions {


    @Given("Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto")
    public void QueElClienteSeEncuentraEnElModuloDeConsultasYExtractosEnElSubmoduloExtractoPorProducto() throws InterruptedException  {

    }

    @And("^Selecciona el tipo de producto (.*)$")
    public void SeleccionaElTipoDeProductoCuenta(String cuenta) throws InterruptedException{
        System.out.println("implementar when"+cuenta);
    }
    @When("No seleccione ningun producto")
    public void NoSeleccioneNingunProducto() throws InterruptedException{
        System.out.println("implementar when");
    }
    @Then("Los botones año y mes del extracto deberian estar inabilitados")
    public void LosBotonesAñoYMesDelExtractoDeberianEstarInabilitados() throws InterruptedException{
        System.out.println("implementar then");
    }
    @And("^Al dar click en boton Mostrar datos deberia verse el (.*)$")
    public void AlDarClickEnBotonMostrarDatosDeberiaVerseElMensajeDeError(String MensajeDeError) throws InterruptedException{
        System.out.println("implementar when: "+ MensajeDeError);
    }





}

