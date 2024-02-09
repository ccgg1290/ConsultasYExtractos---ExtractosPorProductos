package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ExtractosPorProducto.feature",
        glue = {"co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks",
                "co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Definitions"},
        tags = "@DescargarPdf",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
