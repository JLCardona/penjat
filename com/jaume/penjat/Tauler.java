package com.jaume.penjat;

public class Tauler {
    private char[] paraulaSecreta;
    private int intents;
    private String[] paraulaEndevinada;

    public Tauler(){

    }
    public void inicialitzarPartida(String paraula, int num){
        paraulaSecreta = paraula.toCharArray();
        paraulaEndevinada = new String[getParaulaSecreta().length];
        intents = num;
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
            String aux = "";
            for (int i = 0;i>paraulaEndevinada.length;i++) {
                if (paraulaEndevinada[i] != null) {
                    aux = aux + paraulaEndevinada[i];
                }
                else {
                    aux =aux + "_";
                }
            }
            return aux;
        }


    }
    public String[] getPalabraEndevinada(){
        return paraulaEndevinada;
    }
}