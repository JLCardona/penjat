package com.jaume.penjat;

public class Tauler {
    char[] paraulaSecreta;
    int intents;
    String[] paraulaEndevinada;

    public Tauler(){

    }
    public void inicialitzarPartida(String paraula, int num){

    }
    public char[] getParaulaSecreta(){
        return paraulaSecreta;
    }
    public int getIntents(){
        return intents;
    }
    public String verificar(String lletra){
        for (int i = 0; i < paraulaSecreta.length(); i++){

        }
        if(lletra.length() != 1){
            return "Lletra incorrecte";
        }
        else {
            return "Lletra correcte";
        }


    }
    public String[] getPalabraEndevinada(){
        return paraulaEndevinada;
    }
}