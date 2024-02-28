package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;

public class SwitctTo {



        public static Performable switchto(String departure, Actor theUser) {
            String currentHandle = BrowseTheWeb.as(theUser).getDriver().getWindowHandle();
            return Task.where("{0} chooses #departure as a departure station",
                    Switch.toWindow(getNewWindowHandle(theUser, currentHandle))

            );
        }

        private static String getNewWindowHandle(Actor actor, String currentWindowHandle){
            for (String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    return windowHandle;
                }
            }
            return null;
        }



}
