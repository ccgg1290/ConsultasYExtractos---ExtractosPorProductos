
package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces.HomePage.LISTADEBANCOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ExtractosPorProductoTask implements Task {

    private final List<Map<String, String>> data;
    public ExtractosPorProductoTask(List<Map<String, String>> data) {
        this.data = data;
    }
    public static ExtractosPorProductoTask selectBank(List<Map<String, String>> data) {
        return Tasks.instrumented(ExtractosPorProductoTask.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTADEBANCOS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("Banco")).from(LISTADEBANCOS)
        );
    }
}
