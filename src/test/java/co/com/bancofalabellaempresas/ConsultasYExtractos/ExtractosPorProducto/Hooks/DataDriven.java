package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.Hooks;

import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom(value="testdata/user.csv")
public class DataDriven {


    public static String nombre;
    public static String apellido;
}
