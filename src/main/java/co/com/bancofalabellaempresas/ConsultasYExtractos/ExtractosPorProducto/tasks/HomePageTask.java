
package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.tasks;
import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.HomePage.LISTADEBANCOS;

import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions.Refresh;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class HomePageTask implements Task {

    private final List<Map<String, String>> data;
    public HomePageTask(List<Map<String, String>> data) {
        this.data = data;
    }
    public static HomePageTask selectBank(List<Map<String, String>> data) {
        return Tasks.instrumented(HomePageTask.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Refresh.thePage(),
                WaitUntil.the(LISTADEBANCOS, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("Banco")).from(LISTADEBANCOS)
        );
    }
}
