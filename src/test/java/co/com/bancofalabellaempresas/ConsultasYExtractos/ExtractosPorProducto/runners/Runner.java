package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.runners;

import io.cucumber.java.BeforeAll;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
