package com.jaume.penjat;

public class Tauler {
    private char[] paraulaSecreta;
    private int intents;
    private String[] paraulaEndevinada;
    private int intentsInicials;

    public Tauler(){

    }

    /**
     * Inicialitzam la partida amb la paraula secreta i juntament amb els intents per endevinar-la.
     * @param paraula Paraula amb la que jugarem.
     * @param num Numero de intents.
     */
    public void inicialitzarPartida(String paraula, int num){
        paraulaSecreta = paraula.toCharArray();
        paraulaEndevinada = new String[getParaulaSecreta().length];
        for (int i = 0;i<paraulaEndevinada.length;i++) {
            paraulaEndevinada[i] = null ;
        }
        intents = num;
        intentsInicials = num;
    }

    /**
     * Imprimim la paraula secreta mostrant les lletres encertades (_o_), en cas de no encertar no es mostrarà res (___).
     * @return Lletres endevinades o res (null).
     */
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

    /**
     * Agafam la paraula secreta.
     * @return Paraula secreta.
     */
    public char[] getParaulaSecreta(){
        return paraulaSecreta;
    }

    /**
     * Agafam els intents.
     * @return Intents.
     */
    public int getIntents(){
        return intents;
    }

    /**
     * Verificam si el jugador a encertat o no la lletra i també que hagi possat tot sol 1 lletra i no més a la vegada.
     * @param lletra Lletres de la paraula secreta.
     * @return Missatge de "lletra incorrecta" en cas de posar més de 1 lletra a la vegada. En cas de encertar la lletra
     * canvía el "null"(___) de la/es posició/ns de aquella lletra dins la paraula secreta per la lletra encertada (_o_).
     * En cas de no encertar la lletra se restarà 1 intent al jugador i la paraula secreta seguirà igual (___).
     */
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

    /**
     * Agafam la paraula endevinada.
     * @return Paraula endevinada.
     */
    public String[] getPalabraEndevinada(){
        return paraulaEndevinada;
    }

    /**
     * Imprimim les vides que té el jugador.
     * @return Intents de manera singular o plural (1 vida o més).
     */
    public String imprimirVides(){
        if (intents == 1){
            return imprimirVidesSingular();
        }
        else {
            return imprimirVidesPlural();
        }
    }

    /**
     * Imprimim les vides (intents) que té el jugador de manera singular.
     * @return Missatge en singular de que el jugador té 1 vida del total de vides inicials.
     */
    private String imprimirVidesSingular(){
        return ("Et queda 1 vida de " + String.valueOf(intentsInicials));
    }

    /**
     * Imprimim les vides (intents) que té el jugador de manera plural.
     * @return Missatge en plural de que el jugador té X vides del total de vides inicials.
     */
    private String imprimirVidesPlural() {
        return ("Et queden " + String.valueOf(intents) + " vides de " + String.valueOf(intentsInicials));
    }

    /**
     * Quan la paraula secreta sigui totalment endevinada el jugador haurà guanyat el joc.
     * @return Boolea guanyat com vertader (true) en cas de que la paraula endevinada sigui la mateixa que la secreta,
     * si no el jugador encara no haurà sortit voctoriòs i se retornarà el boolea guanyat com fals (false).
     */
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