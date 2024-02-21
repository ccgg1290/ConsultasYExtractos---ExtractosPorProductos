package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Refresh implements Task {

    public Refresh() { }

    public static Refresh thePage() {

        return Tasks.instrumented(Refresh.class);
    }

    @Override
    @Step("{0} refreshes the browser")
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.navigate().refresh();
    }
}