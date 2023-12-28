package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils;

import jdk.dynalink.beans.StaticClass;
import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class EnviromentConstants {
    public static List<Map<String, String>> data = new ArrayList<>();;
    public static Map<String, String> USER = new HashMap<>();

    //******** LISTAS DE MAPAS ******
    public static List<Map<String, String>> returnUsuario(){
        USER.put("NameUser","Dayana Andrea Rojas Alba");
        USER.put("ClienteEmpresarial","23534");
        USER.put("TipoDeIdentificación","Cédula de Ciudadanía");
        USER.put("NúmeroDeIdentificación","1049653008");
        //USER.put("NúmeroDeIdentificación","1014224787");
        USER.put("ClavePersonal", "976431");
        USER.put("ClaveToken","123456789");
        USER.put("Banco","FALABELLA DE COLOMBIA S.A");
        //USER.put("Banco","VILMA MARTINEZ");
        //USER.put("Banco","ABC BUSINESS SOLUTIONS SAS");
        data.add(USER);
        //System.out.println(data.get(0).get("NameUser"));
        //System.out.println(data.get(0).get("NúmeroDeIdentificación"));
        return data;
    }

   // ****** MAPAS******
    /*public static Map<String, String> returnUsuario1(){
        USER.put("NameUser","Dayana Andrea Rojas Alba");
        USER.put("ClienteEmpresarial","23534");
        USER.put("TipoDeIdentificación","Cédula de Ciudadanía");
        USER.put("NúmeroDeIdentificación","1049653008");
        USER.put("ClavePersonal", "976431");
        USER.put("ClaveToken","123456789");
        USER.put("Banco","ABC BUSINESS SOLUTIONS SAS");
        return  USER;

    }*/

    /*
    // ********* LISTAS **************
    public static void returnUsuario(){

        //listas
        USUARIO.add(NAMEUSER);
        USUARIO.add(CLIENTEEMPRESARIAL);
        USUARIO.add(TIPODEIDENTIFICACION);
        USUARIO.add(CLAVEPERSONAL);
        USUARIO.add(CLAVETOKEN);
        USUARIO.add(BANCO);
        for (String str :  USUARIO) {
            System.out.println("for: "+str);
        }

        USER.forEach((k,v)-> System.out.println("clave: "+k+" valor: "+v));


    }*/
}
