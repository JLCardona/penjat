package com.jaume.penjat;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Util {

    /**
     * Ficam una cadena de caracters (string).
     * @param enunciat Cadena de caracters (string).
     * @return Valor.
     */
    public static String makeQuestion(String enunciat){
        String valor = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
            System.out.print(enunciat+"  : ");
            valor = br.readLine();
        } catch (IOException ex) {
            System.out.println("Error");
        }
        return valor;
        }

    /**
     * Ficam un boolea.
     * @param cadena Cadena de caracters (string).
     * @return Booela (true or false).
     */
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
