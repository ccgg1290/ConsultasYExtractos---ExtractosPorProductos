package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.interactions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateFieldEmpty {

    public static List<Map<String, String>> validateFieldEmpty(List<Map<String, String>> data){

        List<Map<String, String>> data1=data;
        String value=data1.get(0).get("TipoDeIdentificación");
        System.out.println("valor tipo de identificacin: "+value);
        if (value==null){
            System.out.println("La opcion del dropdown viene vacia");
            Map<String, String> colors = new HashMap<>();
            colors.put("TipoDeIdentificación", "-- SELECCIONE --");
            System.out.println(colors);
            data1.get(0).put("TipoDeIdentificación1", "-- SELECCIONE --");
        }
        else{
            System.out.println("El valor no venia vacio y es: "+value);
        }
        return data1;


    }
}

