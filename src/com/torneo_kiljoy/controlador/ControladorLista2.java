/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.controlador;

import com.torneo_kiljoy.modelo.Participante;

/**
 *
 * @author LAURA MELISSA
 */
public class ControladorLista2 {

    public static final int NUMERO_PARTICIPANTES = 5;
    private Participante[] participantes;
    private int contParicipantes = 0;

    public ControladorLista2() {
        participantes = new Participante[NUMERO_PARTICIPANTES];
        inicializarParticipante();
    }

    public Participante[] getParticipantes() {
        return participantes;
    }
    
    private void inicializarParticipante(){
        participantes[0] = new Participante("Laura Melissa", "Pinkfrost", (byte)19, (long)45621574);
        contParicipantes++;
    }

    public String adicionarParticipante(Participante part) {
        if (contParicipantes < NUMERO_PARTICIPANTES) {
            participantes[contParicipantes] = part;
            contParicipantes++;
            return "Participante adicionado";
        } else {
            return "No se pueden adicionar más participantes";
        }
    }

}
