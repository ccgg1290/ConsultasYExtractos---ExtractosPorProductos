package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
//import net.thucydides.core.annotations.Step;


public class IsEqualToTheText implements Task {
  public static IsEqualToTheText validateAssert() {
    return Tasks.instrumented(IsEqualToTheText.class);
  }
  public static Actor.ErrorHandlingMode elementHasTheText() {
      //WebDriver=getDriver;
      //String asercion = driver.findElement(By.id("lbNombreUsuario")).getText();
      //assertEquals(asercion, "Los datos ingresados no son válidos.");
      return null;
  }
  @Step("{0} Validate assert")
  @Override
  public <T extends Actor> void performAs(T actor) {
          OnStage.theActorInTheSpotlight().attemptsTo(elementHasTheText());
  }
}
