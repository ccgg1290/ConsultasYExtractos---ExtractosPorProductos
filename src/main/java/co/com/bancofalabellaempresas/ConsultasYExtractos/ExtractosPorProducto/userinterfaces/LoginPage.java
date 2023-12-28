package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
//import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


@DefaultUrl("page:webdriver.base.url")
//@DefaultUrl("https://www.google.com")
public class LoginPage extends  PageObject{

    public static final Target CLIENTE_EMPRESARIAL = Target.the("Cliente Empresarial")
            .located(By.id("tbGrupoEmpresarial"));
    public static final Target TIPO_DE_IDENTIFICACION = Target.the("Tipo de identificacion")
            .located(By.name("ddlTipoID"));
    public static final Target NUMERO_DE_IDENTIFICACION = Target.the("Numero de identificacion")
            .located(By.name("tbNumeroID"));
    public static final Target CLAVE_PERSONAL = Target.the("Clave personal")
            .located(By.name("tbClavePersonal"));
    public static final Target CLAVE_TOKEN = Target.the("Clave token")
            .located(By.name("tbToken"));
    //boton para Enviar fomrlario
    public static final Target BTN_SIGIN = Target.the("button ingresar")
            .located(By.name("btInrgesar"));
   // @FindBy(id= "lbNombreUsuario")
   // public static WebElementFacade NAME_HOME;





}

