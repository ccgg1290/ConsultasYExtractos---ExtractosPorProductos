package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class DeleteFiles {
    public static void deleteFiles(String fileDelete) {

        File folder = new File(fileDelete);
        File[] listaofFiles = folder.listFiles();
        if (listaofFiles != null) {
            for (File archivo : listaofFiles) {
                try {
                    log.info("\n nombre de archivo: " + archivo.getName());
                    boolean estatus = archivo.delete();
                    if (!estatus) {
                        log.info("Error no se ha podido eliminar el  archivo, o no existe");
                    } else {
                        log.info("Se ha eliminado el archivo exitosamente");
                    }
                } catch (Exception e) {
                    log.info(String.valueOf(e));

                }

            }
        } else {
            log.info("El Directorio esta vacio");
        }
    }
}
