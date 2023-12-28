package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class HomePage extends  PageObject{

    public static final Target NAME_HOME = Target.the("Nombre usuario")
            .located(By.id("lbNombreUsuario"));

    public static final Target LISTADEBANCOS = Target.the("Lista de bancos")
            .located(By.id("dropMasterEmpresa"));



}

