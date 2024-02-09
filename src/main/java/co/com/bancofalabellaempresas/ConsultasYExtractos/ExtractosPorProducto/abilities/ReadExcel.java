package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.abilities;

import co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.models.LibroExcel;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReadExcel implements Ability {
    File archivo;
    String rutaarchivo;
    List<LibroExcel> libroExcel;

    public ReadExcel(String rutaarchivo) {
        this.rutaarchivo = rutaarchivo;
    }

    public static ReadExcel downloadedInPath(String archivo) throws IOException {
        return new ReadExcel(archivo);
    }
    public static ReadExcel asExcel(Actor actor) {
        return actor.abilityTo(ReadExcel.class);
    }
    public List<LibroExcel> getText() throws IOException {
        archivo = new File("PruebaExcel.xlsx");
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder
                .settings()
//		        .sheetIndex(0) 		  // Indice de hoja
                .sheetName("Personas") // Nombre de hoja
//				.skip(3)				  // Salto de filas
//				.limit(6)			  // Limite de registros
                .trimCellValue(true)   // Eliminar espacios en blanco
                .password("1234")      // Contrasenia del archivo
                .build();
        libroExcel = Poiji.fromExcel(archivo, LibroExcel.class);
        //libroExcel.forEach(System.out::println);
        return libroExcel;
    }

}
/* ****** Esta es la Forma de implemntar la Ability
theActorInTheSpotlight().whoCan(ReadExcel.downloadedInPath("PruebaExcel.xlsx"));
List<LibroExcel> libro1 = ReadExcel.asExcel(theActorInTheSpotlight()).getText();
libro1.forEach(System.out::println);



*/