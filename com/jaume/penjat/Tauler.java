package com.jaume.penjat;

public class Tauler {
    private char[] paraulaSecreta;
    private int intents;
    private String[] paraulaEndevinada;
    private int intentsInicials;

    public Tauler(){

    }
    public void inicialitzarPartida(String paraula, int num){
        paraulaSecreta = paraula.toCharArray();
        paraulaEndevinada = new String[getParaulaSecreta().length];
        for (int i = 0;i>paraulaEndevinada.length;i++) {
            paraulaEndevinada[i] = "_";
        }
        intents = num;
        intentsInicials = num;
    }

    public String imprimir() {
        String aux = "";
        for (int i = 0;i>paraulaEndevinada.length;i++) {
            aux = aux + paraulaEndevinada[i];
        }
        return aux;
    }

    public char[] getParaulaSecreta(){
        return paraulaSecreta;
    }
    public int getIntents(){
        return intents;
    }
    public String verificar(String lletra){

        if(lletra.length() != 1){
            return "Lletra incorrecte";
        }
        else {
            boolean trobada = false;
            for (int i = 0; i < paraulaSecreta.length; i++){
                if (paraulaSecreta[i] == lletra.charAt(0)) {
                    paraulaEndevinada[i] = lletra;
                    trobada = true;
                }
            }
            if (!trobada) {
                intents--;
            }
            return "";
        }


    }
    public String[] getPalabraEndevinada(){
        return paraulaEndevinada;
    }

    public String imprimirVides(){
        if (intents == 1){
            return imprimirVidesSingular();
        }
        else {
            return imprimirVidesPlural();
        }
    }

    private String imprimirVidesSingular(){
        return ("Et queda 1 vida de " + String.valueOf(intentsInicials));
    }

    private String imprimirVidesPlural() {
        return ("Et queden " + String.valueOf(intents) + " de " + String.valueOf(intentsInicials));
    }
}