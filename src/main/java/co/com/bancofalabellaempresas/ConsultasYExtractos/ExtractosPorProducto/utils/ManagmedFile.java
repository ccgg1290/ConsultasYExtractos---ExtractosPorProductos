package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLOutput;

import static co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils.ReturnDate.returnDate;

@Slf4j
public class ManagmedFile {


    public static void moveFile(String origen, String destino) throws IOException {

     /*   System.out.println("RUTA origen:" + origen);
        System.out.println("RUTA destino:" + destino);
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino);
        System.out.println("RUTA:" + origenPath);
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            System.out.println("ERROR RUTA+" + origenPath+ex);
        }
      */


        String nameFile="EXT".concat(returnDate());

        System.out.println("archivo a buscar "+nameFile);




        System.out.println("RUTA origen:" + origen);
        System.out.println("RUTA destino:" + destino);
        File folder = new File(origen);

        File[] listaofFiles = folder.listFiles();
        for (File archivo : listaofFiles) {
            if (archivo.getName().contains(nameFile)) {
                System.out.println("nombre archivo a mover" + archivo.getName());
                String archivoAMover = origen.concat(archivo.getName());
                String rutaAMover = destino.concat(archivo.getName());
                System.out.println("nombre archivo a mover" + archivoAMover);
                System.out.println("nombre archivo a mover" + rutaAMover);
                Path origenPath = FileSystems.getDefault().getPath(archivoAMover);
                Path destinoPath = FileSystems.getDefault().getPath(rutaAMover);
                Files.move(origenPath,destinoPath, StandardCopyOption.REPLACE_EXISTING);
                log.info("Nombre archivo: " + archivo.getName());
            }

        }
















    }



}
