package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExtractosPorProducto {


    public static final Target CONSULTASYEXTRACTOS = Target.the("Consultas y extractos")
            .located(By.linkText("Consultas y Extractos"));


    public static final Target EXTRACTOPORPRODUCTO = Target.the("Extracto por producto")
            .located(By.linkText("Extracto por Producto"));


    public static final Target TITULO_EXTRACTO_POR_PRODUCTO = Target.the("Cliente Empresarial")
            .located(By.id("lblMasterTitulo"));


    public static final Target LISTA_TIPO_PRODUCTO = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_ddlTipoProducto"));

    public static final Target LISTA_NOMBRE_PRODUCTO = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_ddlNombreProducto"));

    public static final Target LISTA_ANO_EXTRACTO = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_ddlAnioExtracto"));

    public static final Target LISTA_MES_EXTRACTO = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_ddlMesExtracto"));

    public static final Target BTN_MOSTRAR_DATOS = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_btMostrarDatos"));


    //ASERCIONES


    //Debe seleccionar el tipo de producto a consultar
    //Se ha presentado un error, por favor validar con el siguiente ID: 74397973
    public static final Target MSG_ALERTA = Target.the("Cliente Empresarial")
            .located(By.id("lblMasterAlerta"));


    public static final Target EXTRACTO_PDF = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_dpDisplayPDF"));

    public static final Target BTN_DESCARGAR_EXTRACTO = Target.the("Cliente Empresarial")
            .located(By.id("cphCuerpo_btDescargar"));






}
