package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
//import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.serenitybdd.core.Serenity.getDriver;

public class WindowsManager implements Task {
  // public class GetWindowFB  {

  private final WebDriver driver;
  public WindowsManager(WebDriver driver) {
    this.driver = driver;
  }

  public static WindowsManager changeWindow(WebDriver driver) {
    return Tasks.instrumented(WindowsManager.class, driver);
  }
  public static Actor.ErrorHandlingMode actorChangeWindow(WebDriver driver) {


    getDriver().switchTo().frame("frame name");
    //String oldTab = driver.getWindowHandle();
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    //System.out.println("navegadoes"+newTab.size());
    driver.close();
    driver.switchTo().window(newTab.get(1));
    newTab.remove(newTab.get(0));
    //System.out.println("navegadoes"+newTab.size());
    return null;
  }
  @Step("{0} select focus to new window")
  @Override
  public <T extends Actor> void performAs(T actor) {
    OnStage.theActorInTheSpotlight().attemptsTo(actorChangeWindow(driver));
  }
}
