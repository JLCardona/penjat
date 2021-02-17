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
        for (int i = 0;i<paraulaEndevinada.length;i++) {
            paraulaEndevinada[i] = null ;
        }
        intents = num;
        intentsInicials = num;
    }

    public String imprimir() {
        String aux = "";
        for (int i = 0;i<paraulaEndevinada.length;i++) {
            if (paraulaEndevinada[i] == null){
                aux = aux + "_";
            }
            else{
                aux = aux + paraulaEndevinada[i];
            }
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
        return ("Et queden " + String.valueOf(intents) + " vides de " + String.valueOf(intentsInicials));
    }

    public boolean hasGuanyat() {
        boolean guanyat = true;
        for (int i = 0;(i<paraulaEndevinada.length) && (guanyat);i++) {
            if (paraulaEndevinada[i] == null) {
                return false;
            }
            if (paraulaEndevinada[i].charAt(0) != paraulaSecreta[i]) {
                guanyat = false;
            }
        }
        return guanyat;
    }
}