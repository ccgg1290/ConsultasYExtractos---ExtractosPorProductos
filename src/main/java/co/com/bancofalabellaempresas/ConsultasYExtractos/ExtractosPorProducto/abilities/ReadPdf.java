package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.abilities;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.hssf.record.PageBreakRecord;

import java.io.IOException;
import java.sql.SQLOutput;

public class ReadPdf implements Ability {
    private String pdfText;
    private final String filePath;
    PdfReader pdfReader;
    public ReadPdf(String filePath) throws IOException {
        this.filePath = filePath;
        this.pdfReader = new PdfReader(filePath);
    }
    public static ReadPdf downloadedInPath(String filePath) throws IOException {
        return new ReadPdf(filePath);
    }
    public static ReadPdf as(Actor actor) {
        return actor.abilityTo(ReadPdf.class);
    }
    public String getTextComplete() throws IOException {

        int pagesNumber = pdfReader.getNumberOfPages();
        StringBuilder pdfText = new StringBuilder();
        for (int i = 1; i <= pagesNumber; i++) {
            pdfText.append(PdfTextExtractor.getTextFromPage(pdfReader, i));
        }
        return pdfText.toString();
    }

    public boolean findText(String cadena) throws IOException {
        boolean valorencontrado = false;
        int pagesNumber = pdfReader.getNumberOfPages();

        for (int i = 1; i <= pagesNumber; i++) {
            pdfText = PdfTextExtractor.getTextFromPage(pdfReader, i);

            System.out.println("HOJA  " + i + ": \n" + pdfText);
            if(pdfText.contains(cadena)){
                valorencontrado=true;
                break;
            };
        }
        return valorencontrado;
    }



}

/* Esta es la forma de implementar la habilidad
String statementFilePath = String.format("%s%s", downloadFolder, fileName);
        System.out.println("ruta archivo" + statementFilePath);

        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));
        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();
        System.out.println(pdfText);



 */