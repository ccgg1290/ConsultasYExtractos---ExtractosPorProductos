package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import static net.serenitybdd.core.Serenity.getDriver;

public class SplitString {

    public static String splitString(By Elemento, String valorCortar){
        WebDriver driver=getDriver();
        String text;
        text = driver.findElement(Elemento).getText();
        if(text.contains(valorCortar)) {
            text = text.substring(0, text.lastIndexOf(":") + 1);
        }else {
            text = driver.findElement(Elemento).getText();
        }

        return text;
    }



}
