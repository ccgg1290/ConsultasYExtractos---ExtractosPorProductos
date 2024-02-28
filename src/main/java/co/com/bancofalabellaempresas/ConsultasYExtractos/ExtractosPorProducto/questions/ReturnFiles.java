package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.questions;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReturnFiles {


  public static List<String> returnNameFiles(String ruta) {

      List<String> lista =new ArrayList<>();
      File folder=new File(ruta);
      File[] listaofFiles=folder.listFiles();

      for (File archivo:listaofFiles){
          log.info("Nombre archivo retornado: "+archivo.getName());
          lista.add(archivo.getName());

      }
      log.info("Numero de archivos retornados= "+listaofFiles.length);
      return lista;

  }

}
