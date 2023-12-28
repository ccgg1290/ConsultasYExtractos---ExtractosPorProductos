package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils;

public class ReadProporties {

    public static void proporties1 (){

        //System.out.println("Proporties"+System.getProperties());
        System.out.println("\n \n \n Proporties"+System.getProperties());
        System.out.println("property username pasada por cmd: "+System.getProperty("username"));
        System.out.println("property password pasada por cmd: "+System.getProperty("password"));
        System.out.println("property sustema operativo:"+System.getProperty("os.name"));
        System.out.println("property cucumber:"+System.getProperty("cucumber.filter.tags"));
        System.out.println("property nada:"+System.getProperty("cucumber.filter.tag"));
    }
}
