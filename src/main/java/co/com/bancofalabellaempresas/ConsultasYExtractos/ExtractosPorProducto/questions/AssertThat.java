

package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.questions.TextContent.of;

public class AssertThat {
    public static Question<String> theTextOfTheElementIs(Target target) {
        return actor -> of(target).answeredBy(actor);
    }
    public static Question<Boolean> theElementIsPresent(Target target) {
        return target::isVisibleFor;
    }

}
